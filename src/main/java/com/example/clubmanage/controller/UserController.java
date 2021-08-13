package com.example.clubmanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.clubmanage.bean.Club;
import com.example.clubmanage.bean.Student;
import com.example.clubmanage.bean.User;
import com.example.clubmanage.dao.UserMapper;
import com.example.clubmanage.service.inter.ClubService;
import com.example.clubmanage.service.inter.LoginService;
import com.example.clubmanage.service.inter.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private ClubService clubService;



    //    进入首页
    @RequestMapping("joinIndex")
    public String joinIndexController(){
        return "forward:/index.jsp";
    }
//    进入登录页面
    @RequestMapping("joinLogin")
    public String joinloginController(){
        return "user/login";
    }
//    进入注册页面
    @RequestMapping("joinRegist")
    public String joinRegistController(){
        return "user/regist";
    }
//    进入用户信息修改页面
    @RequestMapping("joinMemberInfo")
    public String joinMemberinfoController(){
        return "user/memberInfo";
    }





    //登录
    @RequestMapping("Login")
    public String loginController(String username, String userpass, Model model, HttpSession httpSession){
        List<User> login = loginService.login(username);
        if (login.size()!= 0) {
            User user = login.get(0);
            if (user != null && user.getUserPass() != null && user.getUserPass().equals(userpass)) {
                model.addAttribute("user", user);
                httpSession.setAttribute("user", user);
                return "forward:/index.jsp";
            } else {
                model.addAttribute("error1", "loginerror");
                System.out.println("loginDao 登录失败");
                return "user/login";
            }
        } else {
            model.addAttribute("error1", "loginerror");
            System.out.println("loginDao 登录失败");
            return "user/login";
        }
    }
    //android端登录
    @RequestMapping(value = "AndroidLogin", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String androidloginController(String username, String userpass){
        List<User> login = loginService.login(username);
        JSONObject json = new JSONObject();
        if (login.size()!= 0) {
            User user = login.get(0);
            json.put("user",user);
            if (user != null && user.getUserPass() != null && user.getUserPass().equals(userpass)) {
                json.put("res", "success");
                json.put("username", username);
                json.put("msg", "登录成功");
            } else {
                json.put("res", "fail");
                json.put("username", null);
                json.put("msg", "密码错误");
            }
        } else {
            json.put("res", "fail");
            json.put("username", null);
            json.put("msg", "此用户不存在");
        }
        return json.toJSONString();
    }
        //    退出登录
        @RequestMapping("loginOut")
        public String loginOutController(HttpSession httpSession){
            httpSession.removeAttribute("user");
        return "forward:/index.jsp";
        }
        //用户名是否存在校验
        @RequestMapping("getName")
        @ResponseBody
        public Boolean getNameController(String username){
            List<User> login = loginService.login(username);
            System.out.println(login.size());
            boolean existsUsername = false;
            if (login.size() != 0){
                existsUsername = true;
            return existsUsername;}
            else {
                return existsUsername;}
            }
    //学号是否存在校验
    @RequestMapping("CheckStuid")
    @ResponseBody
    public Boolean CheckStuidController(String studentid){
        List<Student> students = managerService.selectAllStudentByStudentid(studentid);
        boolean existsUsername = false;
        if (students.size() != 0){
            existsUsername = true;
            return existsUsername;}
        else {
            return existsUsername;}
    }


        //用户名是否更改校验
    @RequestMapping("memberInfoGetName")
    @ResponseBody
    public int memberInfoGetNameController(String username, HttpSession httpSession){
        User attribute = (User)httpSession.getAttribute("user");
        if (!username.equals(attribute.getUserName())) {
            List<User> login = loginService.login(username);
            if (login.size() != 0) {
                return 1;
            } else {
                return 2;
            }
        }
        return 3;
    }


//    用户学号是否更改校验
    @RequestMapping("memberInfoGetStudentId")
    @ResponseBody
    public int memberInfoGetStudentIdController(String studentid, HttpSession httpSession){
        User attribute = (User)httpSession.getAttribute("user");
        if (!studentid.equals(attribute.getStudentId())) {
            List<User> login = loginService.studentid(studentid);
            System.out.println(login.size());
            if (login.size() != 0) {
                return 1;
            } else {
                return 2;
            }
        }
        return 3;
    }
        //用户注册
        @RequestMapping("Regist")
        public String registContraller(User user,String rePass){
            if (rePass.equals(user.getUserPass())){
                int count = loginService.regist(user);
                if (count>0){
                     return "user/login";
                 }
                else {
                    return "error/error";
                 }
            }
            else {
                return "error/error";
            }
        }
    //安卓端用户注册
    @RequestMapping(value = "AndroidRegist", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String androidregistContraller(User user){
        JSONObject json = new JSONObject();
        List<Student> students = managerService.selectAllStudentByStudentid(user.getStudentId());
        if (students.size()>0) {
            List<User> users = loginService.login(user.getUserName());
            if (users.size() > 0) {
                //如果用户为空
                //这里应该返回的是json数据,注册成功与否
                json.put("res", "fail");
                json.put("username", user.getUserName());
                json.put("msg", "注册失败");
            } else {
                int count = loginService.regist(user);
                if (count > 0) {
                    //如果用户不为空
                    //这里应该返回的是json数据,注册成功与否
                    json.put("res", "success");
                    json.put("username", user.getUserName());
                    json.put("msg", "注册成功");
                } else {
                    //如果用户为空
                    //这里应该返回的是json数据,注册成功与否
                    json.put("res", "fail");
                    json.put("username", user.getUserName());
                    json.put("msg", "注册失败");
                }
            }
        }else {
            //如果学号为空
            //这里应该返回的是json数据,注册成功与否
            json.put("res", "isnull");
            json.put("username", user.getUserName());
            json.put("msg", "学号不存在，请联系老师");
        }
        return json.toJSONString();
    }

        //用户信息修改
        @RequestMapping("MemberInfoUpdate")
        public String memberInfoUpdate(User user, @RequestParam("header") MultipartFile file,
                                       Model model, HttpSession httpSession) {
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
                httpSession.setAttribute("user",user1);
            }else {
                model.addAttribute("upd","但信息更新失败");
            }
            return "user/memberInfo";
        }
//        安卓端修改用户信息
        @RequestMapping(value = "AndroidUpdateUser", produces = {"application/json;charset=UTF-8"})
        @ResponseBody
        public String androidUpdateUserController(User user){
            JSONObject jsonObject = new JSONObject();
            int update = loginService.updateUsenById(user);
            if (update>0){
                jsonObject.put("result","success");
            }else {
                jsonObject.put("result","fail");
            }
            return jsonObject.toJSONString();
        }
        //        安卓端查询用户信息通过用户名
        @RequestMapping(value = "AndroidSelectByNameUser", produces = {"application/json;charset=UTF-8"})
        @ResponseBody
        public String androidSelectByNameUserController(String username){
            JSONObject jsonObject = new JSONObject();
            List<User> login = loginService.login(username);
            if (login.size()>0){
                jsonObject.put("result","success");
                jsonObject.put("user",login.get(0));
            }else {
                jsonObject.put("result","fail");
            }
            return jsonObject.toJSONString();
        }
//进入社团管理界面
        @RequestMapping("clubManage")
        public String clubManageController(){
        return "club/community_info";
        }
//        进入管理员管理界面
        @RequestMapping("systermManage")
        public String systermManageController(){
            return "common/admin";
        }

    //        进入后台管理界面并查找指定社团
    @RequestMapping("SystermManageSelectClub")
    public String SystermManageSelectClubController(HttpSession httpSession,String clubname){
        httpSession.setAttribute("clubname1",clubname);
        return "common/admin";
    }
    //        进入后台管理界面并查找指定新闻
    @RequestMapping("SystermManageSelectNotice")
    public String SystermManageSelectNoticeController(HttpSession httpSession,String noticename){
        httpSession.setAttribute("noticename1",noticename);
        return "common/admin";
    }
    //        进入后台管理界面并查找指定活动
    @RequestMapping("SystermManageSelectActivity")
    public String SystermManageSelectActivityController(HttpSession httpSession,String activityname){
        httpSession.setAttribute("activityname1",activityname);
        return "common/admin";
    }
//    点击用户名进入用户信息界面
    @RequestMapping("JoinUserInfo")
    public String JoinUserInfoController(String username,Model model){
        List<User> login = loginService.login(username);
        User user = login.get(0);
        model.addAttribute("userinfo",user);
        return "user/userInfo";
    }
    //    通过社团名进入社团管理员信息界面
    @RequestMapping("JoinUserInfoByClubName")
    public String JoinUserInfoByClubNameController(String clubname,Model model){
        List<Club> clubs = clubService.selectOneclub(clubname);
        List<User> login = loginService.login(clubs.get(0).getClubManager());
        User user = login.get(0);
        model.addAttribute("userinfo",user);
        return "user/userInfo";
    }
    //        安卓端查询社长用户信息通过社团名
    @RequestMapping(value = "AndroidSelectUserByClubName", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String androidSelectUserByClubNameController(String clubname){
        JSONObject jsonObject = new JSONObject();
        List<Club> clubs = clubService.selectOneclub(clubname);
        List<User> login = loginService.login(clubs.get(0).getClubManager());
        if (login.size()>0){
            User user = login.get(0);
            jsonObject.put("result","success");
            jsonObject.put("user",user);
        }else {
            jsonObject.put("result","fail");
        }
        return jsonObject.toJSONString();
    }
}

