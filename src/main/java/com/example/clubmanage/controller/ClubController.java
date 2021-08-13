package com.example.clubmanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.clubmanage.bean.*;
import com.example.clubmanage.dao.ClubMapper;
import com.example.clubmanage.dao.UserMapper;
import com.example.clubmanage.service.inter.ClubService;
import com.example.clubmanage.service.inter.LoginService;
import com.example.clubmanage.service.inter.ManagerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class ClubController {
    @Autowired
    private ClubService clubService;
    @Autowired
    private ClubMapper clubMapper;
    @Autowired
    private LoginService loginService;

    //    查询所有社团到管理员界面
    @RequestMapping("QueryAllClub")
    public String QueryAllClubController(Integer startnum, Model model) {
        PageHelper.startPage(startnum, 2);
        List<Club> clubs = clubService.selectAllclub();

        PageInfo<Club> clubPageInfo = new PageInfo<>(clubs);
        model.addAttribute("clubpage", clubPageInfo);
        model.addAttribute("clubs", clubs);
        model.addAttribute("loginsize","a");
        return "club/club_list";
    }

    //查找指定社团
    @RequestMapping("SelectOneClub")
    public String SelectOneClubController(String clubname, Model model){
        List<Club> clubs = clubService.selectOneclub(clubname);
        model.addAttribute("clubs",clubs);
        if (clubs.size()<1){
            model.addAttribute("msg","当前社团不存在");

        }
        model.addAttribute("msg1","club");
        return "club/club_list";
    }
    //安卓端查找指定社团
    @RequestMapping(value = "AndroidSelectOneClub", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Club> androidSelectOneClubController(String clubname){
        List<Club> clubs = clubService.selectOneclub(clubname);
        return clubs;
    }
    //    删除指定社团
    @RequestMapping("DeleteClubOne")
    public String DeleteClubOneController(String clubname, Model model,int startnum){
        int i = clubService.deleteOneClub(clubname);
        if (i<1){
            model.addAttribute("msg","删除失败");
        }else {
            model.addAttribute("msg","删除成功");
        }
        PageHelper.startPage(startnum, 2);
        List<Club> clubs = clubService.selectAllclub();

        PageInfo<Club> clubPageInfo = new PageInfo<>(clubs);
        model.addAttribute("clubpage", clubPageInfo);
        model.addAttribute("clubs", clubs);
        model.addAttribute("loginsize","a");
        return "club/club_list";
    }


    //    查询所有社团创建申请
    @RequestMapping("QueryAllClubCreat")
    public String QueryAllClubCreatController(Integer startnum, Model model) {
        PageHelper.startPage(startnum, 2);
        List<ClubCreat> clubCreats = clubService.selectAllClubCreat();

        PageInfo<ClubCreat> clubcreatPageInfo = new PageInfo<>(clubCreats);
        model.addAttribute("clubcreatpage", clubcreatPageInfo);
        model.addAttribute("clubcreats", clubCreats);
        model.addAttribute("loginsize","a");
        return "club/club_creatauditing";
    }

    //查找指定社团创建申请
    @RequestMapping("SelectOneClubCreat")
    public String SelectOneClubCreatController(String clubcreatname, Model model){
        List<ClubCreat> clubCreats = clubService.selectOneClubCreat(clubcreatname);
        model.addAttribute("clubcreats",clubCreats);
        if (clubCreats.size()<1){
            model.addAttribute("msg","当前社团创建申请不存在");

        }
        model.addAttribute("msg1","clubcreat");
        return "club/club_creatauditing";

    }

//    社团申请创建请求审核
    @RequestMapping("DoClubCreatAuditing")
    public String doClubCreatAuditingController(int auditing,String clubcreatname,Model model){
        List<ClubCreat> clubCreats = clubService.selectOneClubCreat(clubcreatname);
        ClubCreat clubCreat = clubCreats.get(0);
        clubCreat.setClubCreatstate(auditing);
        int i = clubService.updateOneClubCreat(clubcreatname, clubCreat);
        model.addAttribute("msg","审核已完成");
        if (auditing==2){
            Club club = new Club();
            club.setClubName(clubCreat.getClubName());
            club.setClubManager(clubCreat.getClubManager());
            club.setClubCreatdate(clubCreat.getApplicationDate());
            club.setManagerNum(1);
            club.setClubClass(clubCreat.getClubClass());
            club.setClubTenet(clubCreat.getClubTenet());
            club.setClubIntroduction(clubCreat.getClubIntroduction());
            club.setClubImagepath(clubCreat.getClubImagepath());
            int i1 = clubService.insertOneClub(club);
            if (i1>0){
                String clubManager = clubCreat.getClubManager();
                List<User> users = loginService.login(clubManager);
                User user = users.get(0);
                user.setManageId(String.valueOf(1));
                user.setJoinedClub(clubCreat.getClubName());
                int update = loginService.update(user);
            }
        }
        PageHelper.startPage(1, 2);
        List<ClubCreat> clubCreats2 = clubService.selectAllClubCreat();

        PageInfo<ClubCreat> clubcreatPageInfo = new PageInfo<>(clubCreats2);
        model.addAttribute("clubcreatpage", clubcreatPageInfo);
        model.addAttribute("clubcreats", clubCreats2);
        model.addAttribute("loginsize","a");
        return "club/club_creatauditing";
    }

    //    查询所有社团到用户界面
    @RequestMapping("UserQueryAllClub")
    public String userQueryAllClubController(Integer startnum, Model model,HttpSession httpSession) {
        PageHelper.startPage(startnum, 2);
        List<Club> clubs = clubService.selectAllclub();

        PageInfo<Club> clubPageInfo = new PageInfo<>(clubs);
        model.addAttribute("clubpage", clubPageInfo);
        model.addAttribute("clubs", clubs);
        model.addAttribute("loginsize","a");
        User user = (User) httpSession.getAttribute("user");
        List<ClubJoin> clubJoins = clubService.selectOneClubJoinByUserNameAndState(user.getUserName(), 1);
        List<String> clubnamejoin = clubJoins.stream().map(clubJoin -> clubJoin.getClubName()).collect(Collectors.toList());
        List<ClubJoin> clubIn = clubService.selectOneClubJoinByUserNameAndState(user.getUserName(), 2);
        List<String> clubnamein = clubIn.stream().map(clubJoin -> clubJoin.getClubName()).collect(Collectors.toList());
        model.addAttribute("clubnamejoin",clubnamejoin);
        model.addAttribute("clubnamein",clubnamein);
        return "userpage/user_club_list";
    }
//    安卓端查询所有社团
    @RequestMapping(value = "AndroidSelectAllClub", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Club> androidSelectAllClubController(){
        List<Club> clubs = clubService.selectAllclub();
        return clubs;
    }

    //查找指定社团到用户界面
    @RequestMapping("UserSelectOneClub")
    public String userSelectOneClubController(String clubname, Model model, HttpSession httpSession){
        List<Club> clubs = clubService.selectOneclub(clubname);
        model.addAttribute("clubs",clubs);
        if (clubs.size()<1){
            model.addAttribute("msg","当前社团不存在");

        }
        model.addAttribute("msg1","club");
        httpSession.removeAttribute("clubname1");
        return "userpage/user_club_list";

    }

//    普通用户申请加入社团
    @RequestMapping("UserJoinOneClub")
    public String userJoinOneClubController(String username,String clubname,Model model){
        List<User> users = loginService.login(username);
        User user = users.get(0);
        List<Club> clubs = clubService.selectOneclub(clubname);
        Club club = clubs.get(0);
//        建立一个新的社团加入表对象
        ClubJoin clubJoin = new ClubJoin();
        clubJoin.setClubName(club.getClubName());
        clubJoin.setClubmanagerName(club.getClubManager());
        clubJoin.setUserjoinName(user.getUserName());
        clubJoin.setJoinedClub(user.getJoinedClub());
        clubJoin.setJoinDate(new Date());
        System.out.println(clubJoin.toString());
        int i = clubService.insertOneClubJoin(clubJoin);
        if (i<0){
            model.addAttribute("msg","申请失败");
        }else {
            model.addAttribute("msg","申请成功");
        }
        model.addAttribute("msg1","club");
        return "userpage/user_club_list";
    }
    //    安卓端用户申请加入社团
    @RequestMapping(value = "AndroidUserJoinOneClub", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String androidUserJoinOneClubController(String username,String clubname){
        JSONObject json = new JSONObject();
        List<User> users = loginService.login(username);
        User user = users.get(0);
        List<Club> clubs = clubService.selectOneclub(clubname);
        Club club = clubs.get(0);
//        建立一个新的社团加入表对象
        ClubJoin clubJoin = new ClubJoin();
        clubJoin.setClubName(club.getClubName());
        clubJoin.setClubmanagerName(club.getClubManager());
        clubJoin.setUserjoinName(user.getUserName());
        clubJoin.setJoinedClub(user.getJoinedClub());
        clubJoin.setJoinDate(new Date());
        System.out.println(clubJoin.toString());
        int i = clubService.insertOneClubJoin(clubJoin);
        if (i<0){
            json.put("msg","fail");
        }else {
            json.put("msg","success");

        }
        return json.toJSONString();
    }

//    按照用户名查找社团加入表到用户界面
    @RequestMapping("SelectOneClubJoin")
    public String selectOneClubJoinController(String username,Integer startnum, Model model){
        PageHelper.startPage(startnum, 2);
        List<ClubJoin> clubJoins = clubService.selectOneClubJoin(username);
        PageInfo<ClubJoin> clubjoinPageInfo = new PageInfo<>(clubJoins);
        model.addAttribute("clubjoinpage", clubjoinPageInfo);
        model.addAttribute("clubjoins", clubJoins);
        model.addAttribute("loginsize","a");
        return "userpage/user_clubjoin_list";
    }
//按照用户名和社团名删除指定社团加入申请
    @RequestMapping("DeleteOneClubJoin")
    public String deleteOneClubJoinController(String username,String clubname, Model model,int startnum){
        int i = clubService.deleteOneClubJoin(username, clubname);
        if (i<1){
            model.addAttribute("msg","取消失败");
        }else {
            model.addAttribute("msg","取消成功");
        }
        PageHelper.startPage(startnum, 2);
        List<ClubJoin> clubjoins = clubService.selectOneClubJoin(username);
        PageInfo<ClubJoin> clubjoinPageInfo = new PageInfo<>(clubjoins);
        model.addAttribute("clubjoinpage", clubjoinPageInfo);
        model.addAttribute("clubjoins", clubjoins);
        model.addAttribute("loginsize","a");
        return "userpage/user_clubjoin_list";
    }

    //    按照社长名查找社团加入表到社长界面
    @RequestMapping("SelectOneClubJoinByClubManager")
    public String selectOneClubJoinByClubManagerController(String clubmanagername,Integer startnum, Model model){
        PageHelper.startPage(startnum, 2);
        List<ClubJoin> clubJoins = clubService.selectOneClubJoinByClubmanager(clubmanagername);
        PageInfo<ClubJoin> clubjoinPageInfo = new PageInfo<>(clubJoins);
        model.addAttribute("clubjoinpage", clubjoinPageInfo);
        model.addAttribute("clubjoins", clubJoins);
        model.addAttribute("loginsize","a");
        return "president/president_clubjoin_list";
    }

//    根据社团类别查找社团并分页显示到首页
    @RequestMapping("SelectClubByClubClass")
    @ResponseBody
    public List<Club> selectClubByClubClassController(int clubClass,Model model){
        PageHelper.startPage(1, 4);
        List<Club> clubs1 = clubService.selectClubByClass(clubClass);
        model.addAttribute("clubs1",clubs1);
        return clubs1;
    }
    //用户添加社团创建表
    @RequestMapping("UserClubCreat")
    public String userClubCreatController(ClubCreat clubCreat, @RequestParam("header") MultipartFile file,
                                   Model model, HttpSession httpSession) {
        try {
            file.transferTo(new File("E:\\clubmanage\\src\\main\\webapp\\static\\images\\header\\" + file.getOriginalFilename()));
            model.addAttribute("msg","success");
            clubCreat.setClubImagepath("/static/images/header/" + file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("msg","fail");
        }
        User user= (User)httpSession.getAttribute("user");
        String userName = user.getUserName();
        clubCreat.setClubManager(userName);
        clubCreat.setApplicationDate(new Date());
        int i = clubService.addClubCreatTable(clubCreat);
        if (i > 0){
            model.addAttribute("clubmsg","success");
        }else {
            model.addAttribute("clubmsg","fail");
        }
        return "club/club_add";
    }
//    校验社团创建社团名是否可用
    @RequestMapping("ClubCreatNameIs")
    @ResponseBody
    public int clubCreatNameIsController(String clubname){
        List<Club> clubs = clubService.selectOneclub(clubname);
        if (clubs.size() != 0) {
            return 1;
        } else {
            return 2;
        }
    }
//    根据用户名查询社团创建是否存在及其状态
    @RequestMapping("SelectClubCreatByusername")
    @ResponseBody
    public ClubCreat selectClubCreatByusernameController(HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        List<ClubCreat> clubCreats = clubService.selectOneClubCreatByManagername(user.getUserName());
        ClubCreat clubCreat = clubCreats.get(0);
        return clubCreat;
    }
    //    社团申请加入请求审核
    @RequestMapping("DoClubJoinAuditing")
    public String doClubJoinAuditingController(int auditing, int clubjoinid,Model model,HttpSession httpSession){
//        通过id查询到社团加入表指定数据
        ClubJoin clubJoin = clubService.selectOneClubJoinById(clubjoinid);
        clubJoin.setClubjoinState(auditing);
        int i = clubService.updateOneClubJoin(clubJoin);
        model.addAttribute("msg","审核已完成");
        if (auditing==2){
            ClubMember clubMember = new ClubMember();
            clubMember.setClubName(clubJoin.getClubName());
            clubMember.setClubmemberName(clubJoin.getUserjoinName());
            List<User> login = loginService.login(clubJoin.getUserjoinName());
            User user1 = login.get(0);
            clubMember.setMemberStuid(user1.getStudentId());
            clubMember.setMemberPhone(user1.getPhone());
            int i2 = clubService.addOneClubMember(clubMember);
            if (i2>0){
                if (user1.getJoinedClub()==null) {
                    user1.setJoinedClub(clubJoin.getClubName());
                }else {
                    user1.setJoinedClub(user1.getJoinedClub()+"，" + clubJoin.getClubName());
                }
                int update = loginService.update(user1);
            }
        }
        User user = (User) httpSession.getAttribute("user");
        PageHelper.startPage(1, 2);
        List<ClubJoin> clubJoins = clubService.selectOneClubJoinByClubmanager(user.getUserName());
        PageInfo<ClubJoin> clubjoinPageInfo = new PageInfo<>(clubJoins);
        model.addAttribute("clubjoinpage", clubjoinPageInfo);
        model.addAttribute("clubjoins", clubJoins);
        model.addAttribute("loginsize","a");
        return "president/president_clubjoin_list";
    }
//    管理员进入社团修改界面
    @RequestMapping("JoinUpdateClubOne")
    public String joinUpdateClubOneController(int clubid,Model model){
        Club club = clubService.selectClubById(clubid);
        model.addAttribute("club",club);
        return "club/clubupdate_list";
    }
//    管理员修改社团
    @RequestMapping("UpdateClub")
    public String UpdateClubController(Model model,Club club){
        int i = clubService.updateClubById(club);
        if (i>0){
            model.addAttribute("msg","修改成功");
        }else {
            model.addAttribute("msg","修改失败");
        }
        Club club1 = clubService.selectClubById(club.getClubId());
        model.addAttribute("club",club1);
        return "club/clubupdate_list";
    }
//    社长查询当前社团成员
    @RequestMapping("SelectClubMemberByClubName")
    public String selectClubMemberByClubNameController(String clubmanagername,Integer startnum, Model model){
        List<Club> clubs = clubService.selectClubByManager(clubmanagername);
        Club club = clubs.get(0);
        PageHelper.startPage(startnum, 2);
        List<ClubMember> clubMembers = clubService.selectClubMemberByClubneme(club.getClubName());
        PageInfo<ClubMember> clubMemberPageInfo = new PageInfo<>(clubMembers);
        model.addAttribute("clubmembers",clubMembers);
        model.addAttribute("clubMemberPage", clubMemberPageInfo);
        model.addAttribute("loginsize","a");
        return "president/clubmember_list";
    }
//    普通用户已加入的社团
    @RequestMapping("SelectUserJoinedClub")
    public String selectUserJoinedClubController(String username,Model model){
        List<ClubMember> clubMembers = clubService.selectClubMemberByClubMemberneme(username);
        List<Club> list = new ArrayList<Club>();
        for (int i=0;i<clubMembers.size();i++){
            List<Club> clubs = clubService.selectOneclub(clubMembers.get(i).getClubName());
            for (int j = 0;j<clubs.size();j++){
                list.add(clubs.get(j));
            }
        }
        model.addAttribute("clubs",list);
        return "userpage/user_joinedclub";
    }

}
