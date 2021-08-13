package com.example.clubmanage.controller;

import com.example.clubmanage.bean.ClubCreat;
import com.example.clubmanage.bean.User;
import com.example.clubmanage.bean.Vote;
import com.example.clubmanage.dao.VoteMapper;
import com.example.clubmanage.service.inter.VoteService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller("/")
public class VoteController {

    @Autowired
    private VoteService voteService;
    @Autowired
    private VoteMapper voteMapper;



//    查询所有投票审核
    @RequestMapping("SelectAllVoteAuditing")
    public String selectAllVoteAuditingController(Integer startnum, Model model){
        PageHelper.startPage(startnum, 2);
        List<Vote> votes = voteService.selectAllVote();
        PageInfo<Vote> votePageInfo = new PageInfo<>(votes);
        model.addAttribute("votepage", votePageInfo);
        model.addAttribute("votes", votes);
        model.addAttribute("loginsize","a");
        return "vote/vote_creatauditing";
    }
    //    根据发起人姓名查询投票
    @RequestMapping("SelectOneVoteAuditing")
    public String selectOneVoteAuditingController( Model model,String username) {
        List<Vote> votes = voteService.selectOneVote(username);
        model.addAttribute("votes", votes);
        if (votes.size()<1){
            model.addAttribute("msg","当前投票不存在");

        }
        model.addAttribute("msg1","vote");

        return "vote/vote_creatauditing";
    }
    //    安卓端根据发起人姓名查询投票
    @RequestMapping(value = "AndroidSelectVoteByUserName", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Vote> androidSelectVoteByUserNameController(String username) {
        List<Vote> votes = voteService.selectVoteByStateAndName(username);
        return votes;
    }
    //    安卓端查询所有投票
    @RequestMapping(value = "AndroidSelectAllVote", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Vote> androidSelectAllVoteController() {
        List<Vote> votes = voteService.selectVoteByState();
        return votes;
    }


//    投票审核处理
    @RequestMapping("DoVoteAuditing")
    public String doVoteAuditingController(int auditing,int voteid,Model model){
        Vote vote = voteService.selectOneVoteById(voteid);
        vote.setVoteCreatstate(auditing);
        int i = voteService.updateOneVote(vote);
        model.addAttribute("msg","审核已完成");
        PageHelper.startPage(1, 2);
        List<Vote> votes2 = voteService.selectAllVote();
        PageInfo<Vote> votePageInfo = new PageInfo<>(votes2);
        model.addAttribute("votepage", votePageInfo);
        model.addAttribute("votes", votes2);
        model.addAttribute("loginsize","a");
        return "vote/vote_creatauditing";
    }

//    增加投票
    @RequestMapping("AddOneVote")
    public String addOneVoteController(Vote vote,Model model){
        int i = voteService.insertOneVote(vote);
        if (i<1){
            model.addAttribute("msg","创建失败");
        }else {
            model.addAttribute("msg", "创建成功");
        }
        List<Vote> votes = voteService.selectOneVote(vote.getUserName());
        model.addAttribute("votes", votes);
            return "userpage/vote_list";

    }
    //    根据发起人姓名查询投票到用户界面
    @RequestMapping("UserSelectOneVote")
    public String userSelectOneVoteController( Model model,String username) {
        List<Vote> votes = voteService.selectOneVote(username);
        model.addAttribute("votes", votes);
        if (votes.size()<1){
            model.addAttribute("msg","您还没有发起投票");

        }
//        model.addAttribute("msg1","vote");

        return "userpage/vote_list";
    }
//    根据id删除指定投票
    @RequestMapping("UserDeleteOneVote")
    public String userDeleteOneVoteController(Model model, int voteid, HttpSession session) {
        int deleteOneVote = voteService.deleteOneVote(voteid);
        if (deleteOneVote<1){
            model.addAttribute("msg","删除失败");
        }
        User user = (User)session.getAttribute("user");
        List<Vote> votes = voteService.selectOneVote(user.getUserName());
        model.addAttribute("votes", votes);
        if (votes.size()<1){
            model.addAttribute("msg","您还没有发起投票");

        }
//        model.addAttribute("msg1","vote");

        return "userpage/vote_list";
    }

    //    查询所有已审核通过投票
    @RequestMapping("SelectAllVoteState")
    public String selectAllVoteStateController(Integer startnum, Model model){
        PageHelper.startPage(startnum, 2);
        List<Vote> votes = voteService.selectVoteByState();
        PageInfo<Vote> votePageInfo = new PageInfo<>(votes);
        model.addAttribute("votepage", votePageInfo);
        model.addAttribute("votes", votes);
        model.addAttribute("loginsize","a");
        return "vote/vote_list";
    }

//    参与投票
    @RequestMapping("JoinVoteItem")
    @ResponseBody
    public Vote joinVoteItemController(int id,int item){
        Vote vote = voteService.selectOneVoteById(id);
        if (item==1){
            vote.setYesNumber(vote.getYesNumber()+1);
            vote.setJoinedNumber(vote.getJoinedNumber()+1);
            }else if (item==0){
                vote.setJoinedNumber(vote.getJoinedNumber()+1);
                }
        int i = voteService.updateOneVote(vote);
        return vote;
    }
    //    安卓端参与投票
    @RequestMapping("AndroidJoinVoteItem")
    @ResponseBody
    public String androidjoinVoteItemController(String content,int item){
        List<Vote> votes = voteService.selectOneVoteByContent(content);
        Vote vote = votes.get(0);
        if (item==1){
            vote.setYesNumber(vote.getYesNumber()+1);
            vote.setJoinedNumber(vote.getJoinedNumber()+1);
        }else if (item==0){
            vote.setJoinedNumber(vote.getJoinedNumber()+1);
        }
        int i = voteService.updateOneVote(vote);
        if (i>0){
            return "success";
        }else {
            return "fail";
        }
    }
}
