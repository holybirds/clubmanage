package com.example.clubmanage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.clubmanage.bean.*;
import com.example.clubmanage.dao.ActivityMapper;
import com.example.clubmanage.service.inter.ActivityService;
import com.example.clubmanage.service.inter.ClubService;
import com.example.clubmanage.service.inter.LoginService;
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
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ActivityController {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private LoginService loginService;
    @Autowired
    private ClubService clubService;



    //    查询所有活动
    @RequestMapping("QueryAllActivity")
    public String QueryAllActivityController(Integer startnum, Model model) {
        PageHelper.startPage(startnum, 2);
        List<Activity> activitys = activityService.selectAllActivity();

        PageInfo<Activity> activityPageInfo = new PageInfo<>(activitys);
        model.addAttribute("activitypage", activityPageInfo);
        model.addAttribute("activitys", activitys);
        model.addAttribute("loginsize","a");
        return "activity/activity_list";
    }
    //    安卓端查询所有社团活动
    @RequestMapping(value = "AndroidSelectAllActivity", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Activity> androidSelectAllActivityController(){
        List<Activity> activities = activityService.selectAllActivity();
        return activities;
    }

    //查找指定活动
    @RequestMapping("SelectOneActivity")
    public String SelectOneActivityController(String activityname, Model model){
        List<Activity> activitys = activityService.selectOneActivity(activityname);
        model.addAttribute("activitys",activitys);
        if (activitys.size()<1){
            model.addAttribute("msg","当前活动不存在");
        }
        model.addAttribute("msg1","activity");
        return "activity/activity_list";

    }
    //安卓端查找指定活动
    @RequestMapping(value = "AndroidSelectOneActivity", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Activity> androidSelectOneActivityController(String activityname){
        List<Activity> activitys = activityService.selectOneActivity(activityname);
        return activitys;
    }
    //    删除指定活动
    @RequestMapping("DeleteActivityOne")
    public String DeleteActivityOneController(String activityname, Model model,int startnum){
        int i = activityService.deleteOneActivity(activityname);
        if (i<1){
            model.addAttribute("msg","删除失败");
        }else {
            model.addAttribute("msg","删除成功");
        }
        PageHelper.startPage(startnum, 2);
        List<Activity> activitys = activityService.selectAllActivity();

        PageInfo<Activity> activityPageInfo = new PageInfo<>(activitys);
        model.addAttribute("activitypage", activityPageInfo);
        model.addAttribute("activitys", activitys);
        model.addAttribute("loginsize","a");
        return "activity/activity_list";
    }

    //    查询所有活动到用户界面
    @RequestMapping("UserQueryAllActivity")
    public String userQueryAllClubController(Integer startnum, Model model) {
        PageHelper.startPage(startnum, 2);
        List<Activity> activitys = activityService.selectAllActivity();

        PageInfo<Activity> activityPageInfo = new PageInfo<>(activitys);
        model.addAttribute("activitypage", activityPageInfo);
        model.addAttribute("activitys", activitys);
        model.addAttribute("loginsize","a");
        return "userpage/user_activity_list";
    }

    //查找指定活动到用户界面
    @RequestMapping("UserSelectOneActivity")
    public String userSelectOneActivityController(String activityname, Model model,HttpSession httpSession){
        List<Activity> activitys = activityService.selectOneActivity(activityname);
        model.addAttribute("activitys",activitys);
        if (activitys.size()<1){
            model.addAttribute("msg","当前活动不存在");
        }
        model.addAttribute("msg1","activity");
        httpSession.removeAttribute("activityname1");
        return "userpage/user_activity_list";

    }

//    参与指定社团活动
    @RequestMapping("UserJoinOneActivity")
    public String userJoinOneActivityController(String activityname,Model model,String username,int startnum){
        List<User> logins = loginService.login(username);
        User user = logins.get(0);
        List<Activity> activities = activityService.selectOneActivity(activityname);
        Activity activity = activities.get(0);
        if (activity.getActivityPermission().equals("1")){
            List<ClubMember> clubMembers = clubService.selectClubMemberByClubMemberneme(username);
            if (clubMembers.size()<1){
                model.addAttribute("msg", "当前活动仅限社团成员参与");
            }else {
                if (activity.getJoinedUserid() == null) {
                    activity.setJoinedUserid(String.valueOf(user.getUserId()));
                } else {
                    activity.setJoinedUserid(activity.getJoinedUserid() + "，" + user.getUserId());
                }
                System.out.println(activity.toString());
                int i = activityService.updateOneActivity(activity);
                if (i < 1) {
                    model.addAttribute("msg", "参与失败");
                } else {
                    ActivityMember activityMember = new ActivityMember();
                    activityMember.setActivityName(activity.getActivityName());
                    activityMember.setClubName(activity.getClub());
                    activityMember.setMemberName(username);
                    int i1 = activityService.insertOneActivityMember(activityMember);
                    model.addAttribute("msg", "参与成功");
                }
            }
        }else {
            if (activity.getJoinedUserid() == null) {
                activity.setJoinedUserid(String.valueOf(user.getUserId()));
            } else {
                activity.setJoinedUserid(activity.getJoinedUserid() + "，" + user.getUserId());
            }
            System.out.println(activity.toString());
            int i = activityService.updateOneActivity(activity);
            if (i < 1) {
                model.addAttribute("msg", "参与失败");
            } else {
                ActivityMember activityMember = new ActivityMember();
                activityMember.setActivityName(activity.getActivityName());
                activityMember.setClubName(activity.getClub());
                activityMember.setMemberName(username);
                int i1 = activityService.insertOneActivityMember(activityMember);
                model.addAttribute("msg", "参与成功");
            }
        }
        PageHelper.startPage(startnum, 2);
        List<Activity> activitys = activityService.selectAllActivity();

        PageInfo<Activity> activityPageInfo = new PageInfo<>(activitys);
        model.addAttribute("activitypage", activityPageInfo);
        model.addAttribute("activitys", activitys);
        model.addAttribute("loginsize","a");

        return "userpage/user_activity_list";
    }

    //    安卓端参与指定社团活动
    @RequestMapping(value = "AndroidUserJoinOneActivity", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String androiduserJoinOneActivityController(String activityname,String username){
        JSONObject json = new JSONObject();
        List<User> logins = loginService.login(username);
        User user = logins.get(0);
        List<Activity> activities = activityService.selectOneActivity(activityname);
        Activity activity = activities.get(0);
        if (activity.getJoinedUserid()==null){
            activity.setJoinedUserid(String.valueOf(user.getUserId()));
        }else {
            activity.setJoinedUserid(activity.getJoinedUserid() + "，" + user.getUserId());
        }
        System.out.println(activity.toString());
        int i = activityService.updateOneActivity(activity);
        if (i<1){
            json.put("msg","fail");
        }else {
            json.put("msg","success");
        }
        return json.toJSONString();
    }
//    添加指定社团活动
    @RequestMapping("AddOneActivity")
    public String AddOneActivityController(Activity activity, @RequestParam("header") MultipartFile file, HttpSession httpSession, Model model){
        try {
            file.transferTo(new File("E:\\clubmanage\\src\\main\\webapp\\static\\images\\header\\" + file.getOriginalFilename()));
            model.addAttribute("msg","success");
            activity.setActivityImage("/static/images/header/" + file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("msg","fail");
        }
        User user = (User)httpSession.getAttribute("user");
        List<Club> clubs = clubService.selectClubByManager(user.getUserName());
        String clubName = clubs.get(0).getClubName();
        activity.setClub(clubName);
        activity.setJoinedUserid(String.valueOf(user.getUserId()));
        int i = activityService.insertOneActivity(activity);
        if (i<1){
            model.addAttribute("msg","添加失败");
        }else {
            model.addAttribute("msg","添加成功");
        }
//        根据社团名查找当前社团活动
        List<Activity> activitys = activityService.selectOneActivityByClubname(clubName);
        model.addAttribute("activitys", activitys);
        model.addAttribute("msg1","activity");
        return "president/president_activity_list";
    }

//    根据社团名查找当前社团活动
@RequestMapping("SelectActivityByUsername")
public String selectActivityByUsernameController( HttpSession httpSession,Model model){
    User user = (User)httpSession.getAttribute("user");
    List<Club> clubs = clubService.selectClubByManager(user.getUserName());
    String clubName = clubs.get(0).getClubName();
//        根据社团名查找当前社团活动
    List<Activity> activitys = activityService.selectOneActivityByClubname(clubName);
    model.addAttribute("activitys", activitys);
    model.addAttribute("msg1","activity");
    return "president/president_activity_list";
}
    //    查询所有活动到首页
    @RequestMapping("AllActivityToIndex")
    @ResponseBody
    public List<Activity> allActivityToIndexController() {
        PageHelper.startPage(1, 4);
        List<Activity> activitys = activityService.selectAllActivity();
        return activitys;
    }
//    社长进入社团活动修改界面
    @RequestMapping("JoinUpdateOneActivityById")
    public String joinUpdateOneActivityByIdController(int activityid,Model model){
        Activity activity = activityService.selectOneActivityById(activityid);
        model.addAttribute("activity",activity);
        return "president/activityupdate_list";
    }
//    社长修改社团活动
    @RequestMapping("UpdateActivity")
    public String UpdateActivityController(Model model,Activity activity){
        int i = activityService.updateActivityById(activity);
        if (i>0){
            model.addAttribute("msg","修改成功");
        }else {
            model.addAttribute("msg","修改失败");

        }
        Activity activity1 = activityService.selectOneActivityById(activity.getActivityId());
        model.addAttribute("activity",activity1);
        return "president/activityupdate_list";
    }

    //    普通用户已参与的活动
    @RequestMapping("SelectUserJoinedActivity")
    public String selectUserJoinedActivityController(String username,Model model){
        List<ActivityMember> activityMembers = activityService.selectActivityByMember(username);
        List<Activity> list = new ArrayList<Activity>();
        for (int i=0;i<activityMembers.size();i++){
            List<Activity> activities = activityService.selectOneActivityByClubnameAndActname(activityMembers.get(i).getClubName(), activityMembers.get(i).getActivityName());
            for (int j = 0;j<activities.size();j++){
                list.add(activities.get(j));
            }
        }
        model.addAttribute("activitys",list);
        return "userpage/user_activityjoined_list";
    }
    //    安卓端某个用户已参与的活动
    @RequestMapping("AndroidSelectJoinedClub")
    @ResponseBody
    public List<Activity> androidSelectJoinedClubController(String username){
        List<ActivityMember> activityMembers = activityService.selectActivityByMember(username);
        List<Activity> list = new ArrayList<Activity>();
        for (int i=0;i<activityMembers.size();i++){
            List<Activity> activities = activityService.selectOneActivityByClubnameAndActname(activityMembers.get(i).getClubName(), activityMembers.get(i).getActivityName());
            for (int j = 0;j<activities.size();j++){
                list.add(activities.get(j));
            }
        }
        return list;
    }
}
