package com.example.clubmanage.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.clubmanage.bean.ClubCreat;
import com.example.clubmanage.bean.Student;
import com.example.clubmanage.bean.User;
import com.example.clubmanage.dao.UserMapper;
import com.example.clubmanage.service.LoginServiceImpl;
import com.example.clubmanage.service.inter.LoginService;
import com.example.clubmanage.service.inter.ManagerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MemberController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private UserMapper userMapper;


//管理员权限修改
    @RequestMapping("ManagerAdd")
    public String managerAddController(User user, Model model){
        int i = loginService.update(user);
        if (i>0){
            model.addAttribute("rs","success");
        }else {
            model.addAttribute("rs","fail");
        }
        return "manager/manager_add";
    }
//    更新密码
    @RequestMapping("UpdatePassword")
    public String updatePasswordController(User user, String oldpass, String userpass2,HttpSession httpSession,Model model){
        User user1 = (User)httpSession.getAttribute("user");
//        user.setUserName(user1.getUserName());
//        user.setStudentId(user1.getStudentId());
//        user.setManageId(user1.getManageId());
        List<User> userList = loginService.login(user1.getUserName());
        if (oldpass.equals(userList.get(0).getUserPass())){
            if (userpass2.equals(user.getUserPass())) {
                user1.setUserPass(user.getUserPass());
                int i = loginService.update(user1);
                if (i > 0) {
                    model.addAttribute("msg", "success");

                } else {
                    model.addAttribute("msg", "fail");
                }
            }else {
                model.addAttribute("msg","notsame");
            }
        }else {
            model.addAttribute("msg","wrong");
        }

        return "manager/manager_update";
    }

//    查询所有用户
    @RequestMapping("QueryAll")
    public String queryAllController(Integer startnum,Model model){
        PageHelper.startPage(startnum,2);
        List<User> users = managerService.selectAll();

        PageInfo<User> userPageInfo = new PageInfo<>(users);
        model.addAttribute("userpage",userPageInfo);
        model.addAttribute("users",users);
        model.addAttribute("loginsize","a");
        return "manager/member_list";
    }
//    进入修改指定用户信息页面
    @RequestMapping("JoinUpdateOne")
    public String joinUpdatOneController(String username,Model model){
        List<User> login = loginService.login(username);
        User user = login.get(0);
        model.addAttribute("user1",user);
        return "manager/userUpdate";
    }
    //查找指定用户
    @RequestMapping("SelectOneUser")
    public String SelectOneUserController(String username, Model model){
        List<User> login = loginService.login(username);
            model.addAttribute("users",login);
            if (login.size()<1){
                model.addAttribute("msg","当前用户不存在");

            }
            model.addAttribute("msg1","user");

            return "manager/member_list";

    }
    //管理员修改用户信息
    @RequestMapping("UpdateUserOne")
    public String updateUserOne(User user, @RequestParam("header") MultipartFile file,
                                   Model model) {
        try {
            file.transferTo(new File("E:\\clubmanage\\src\\main\\webapp\\static\\images\\header\\" + file.getOriginalFilename()));
            model.addAttribute("msg","头像上传成功");
            user.setUserImagepath("/static/images/header/" + file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("msg","头像上传失败");
        }
        int i = loginService.update(user);
        if (i > 0){
            model.addAttribute("upd","且信息更新成功");
            List<User> login = loginService.login(user.getUserName());
            User user1 = login.get(0);
            model.addAttribute("user1",user1);
        }else {
            model.addAttribute("upd","但信息更新失败");
        }
        return "manager/userUpdate";
    }

//    删除指定用户
    @RequestMapping("DelectOneUser")
    public String delectOneUserController(String username, Model model,int startnum){
        int i = managerService.deleteOne(username);
        if (i<1){
            model.addAttribute("msg","删除失败");
        }else {
            model.addAttribute("msg","删除成功");
        }
        PageHelper.startPage(startnum,2);
        List<User> users = managerService.selectAll();

        PageInfo<User> userPageInfo = new PageInfo<>(users);
        model.addAttribute("userpage",userPageInfo);
        model.addAttribute("users",users);
        model.addAttribute("loginsize","a");
        return "manager/member_list";
    }
    //管理员导入本校学生
    @RequestMapping("StudentAdd")
    @ResponseBody
    public List<Student> userClubCreatController( @RequestParam("student") MultipartFile file) {
//        try {
//            file.transferTo(new File("E:\\clubmanage\\src\\main\\webapp\\static\\images\\header\\" + file.getOriginalFilename()));
//            model.addAttribute("msg","success");
//            clubCreat.setClubImagepath("/static/images/header/" + file.getOriginalFilename());
//        } catch (IOException e) {
//            e.printStackTrace();
//            model.addAttribute("msg","fail");
//        }
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        List<Student> students = null;
        try {

            students = ExcelImportUtil.importExcel(file.getInputStream(), Student.class, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
//    把导入学生存入数据库
    @RequestMapping("StudentIntoSql")
    @ResponseBody
    public String studentIntoSqlController(@RequestBody String studentdate){
        System.out.println(studentdate);
        List<Student> students = JSONObject.parseArray(studentdate, Student.class);
        int j= 0,m=0;
        for (Student student:students) {
            int i = managerService.insertStudent(student);
            j=j+i;
            m++;
        }
        if (j == m){
            return "全部存入成功";
        }else {
            return "部分存入成功";
        }
    }
//    查询所有已导入学生
    @RequestMapping("SeleceAllStudent")
    public String selectAllStudentController(Model model){
        List<Student> students = managerService.selectAllStudent();
        model.addAttribute("students",students);
        return "manager/student_list";
    }
    //    按照年级查询所有已导入学生
    @RequestMapping("SeleceAllStudentByGrade")
    public String selectAllStudentByGradeController(Model model,String grade){
        List<Student> students = managerService.selectAllStudentByGrade(grade);
        model.addAttribute("students",students);
        return "manager/student_list";
    }
    //    按照年级删除指定已导入学生
    @RequestMapping("DeleteAllStudentByGrade")
    public String deleteAllStudentByGradeController(Model model,String grade){
        int i = managerService.deleteAllStudentByGrade(grade);
        if (i>0){
            model.addAttribute("msg","删除成功");
        }else {
            model.addAttribute("msg","删除失败，请重新尝试");

        }
        List<Student> students = managerService.selectAllStudent();
        model.addAttribute("students",students);
        return "manager/student_list";
    }
}
