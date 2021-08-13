package com.example.clubmanage.controller;

import com.example.clubmanage.bean.Notice;
import com.example.clubmanage.bean.Vote;
import com.example.clubmanage.dao.NoticeMapper;
import com.example.clubmanage.service.inter.NoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private NoticeMapper noticeMapper;


//    添加一条新闻公告
    @RequestMapping("AddOneNotice")
    public String addOneNoticeController(Notice notice,Model model){
        int i = noticeService.addOneNotice(notice);
         System.out.println(notice.getClubName());
        if (i>0){
            List<Notice> notices = noticeService.selectOneNotice(notice.getClubName());
            model.addAttribute("notices", notices);
            model.addAttribute("msg1","notice");
        }
        return "notice/notice_list";
    }


//    查询所有新闻公告
    @RequestMapping("SelectAllNotice")
    public String selectAllNoticeController(Integer startnum, Model model){
        PageHelper.startPage(startnum, 2);
        List<Notice> notices = noticeService.selectAllNotice();
        PageInfo<Notice> noticePageInfo = new PageInfo<>(notices);
        model.addAttribute("noticepage", noticePageInfo);
        model.addAttribute("notices", notices);
        model.addAttribute("loginsize","a");
        return "notice/notice_list";
    }

//    查询指定新闻公告
    @RequestMapping("SelectOneNotice")
    public String selectOneNoticeController(Model model, String noticename, HttpSession httpSession){
        List<Notice> notices = noticeService.selectOneNotice(noticename);
        model.addAttribute("notices", notices);
        if (notices.size()<1){
            model.addAttribute("msg","当前新闻不存在");

        }
        model.addAttribute("msg1","notice");
        httpSession.removeAttribute("noticename1");
        return "notice/notice_list";
    }

    //    安卓端查询所有新闻公告
    @RequestMapping(value = "AndroidSelectAllNotice", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Notice> androidSelectAllNoticeController() {
        List<Notice> notices = noticeService.selectAllNotice();
        return notices;
    }
//    删除指定新闻公告
    @RequestMapping("DeleteOneNotice")
    public String deleteOneNoticeController(int noticeid,Model model,int startnum){
        int i = noticeService.deletdOneNotice(noticeid);
        if (i<1){
            model.addAttribute("msg","删除失败");
        }else {
            model.addAttribute("msg","删除成功");
        }
        PageHelper.startPage(startnum, 2);
        List<Notice> notices = noticeService.selectAllNotice();
        PageInfo<Notice> noticePageInfo = new PageInfo<>(notices);
        model.addAttribute("noticepage", noticePageInfo);
        model.addAttribute("notices", notices);
        model.addAttribute("loginsize","a");
        return "notice/notice_list";
    }
    //    查询所有新闻公告到首页
    @RequestMapping("SelectAllNoticeToIndex")
    @ResponseBody
    public List<Notice> selectAllNoticeToIndexController(){
        PageHelper.startPage(1, 4);
        List<Notice> notices = noticeService.selectAllNotice();
        return notices;
    }
}
