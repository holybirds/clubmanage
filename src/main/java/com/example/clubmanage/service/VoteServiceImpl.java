package com.example.clubmanage.service;

import com.example.clubmanage.bean.Vote;
import com.example.clubmanage.bean.VoteExample;
import com.example.clubmanage.dao.VoteMapper;
import com.example.clubmanage.service.inter.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    private VoteMapper voteMapper;

//    查询所有投票
    public List<Vote> selectAllVote(){
        VoteExample voteExample = new VoteExample();
        VoteExample.Criteria criteria = voteExample.createCriteria();
        criteria.andVoteIdIsNotNull();
        voteExample.setOrderByClause("`vote_creatstate` asc");
        List<Vote> votes = voteMapper.selectByExample(voteExample);

        return votes;
    }
//    根据id查询指定投票
    public Vote selectOneVoteById(int id){
        Vote vote = voteMapper.selectByPrimaryKey(id);
        return vote;
    }
    //    根据发起人名字查询指定投票
    public List<Vote> selectOneVote(String username){
        VoteExample voteExample = new VoteExample();
        VoteExample.Criteria criteria = voteExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<Vote> votes = voteMapper.selectByExample(voteExample);

        return votes;
    }
    //    根据投票题目名字查询指定投票
    public List<Vote> selectOneVoteByContent(String content){
        VoteExample voteExample = new VoteExample();
        VoteExample.Criteria criteria = voteExample.createCriteria();
        criteria.andVoteContentEqualTo(content);
        List<Vote> votes = voteMapper.selectByExample(voteExample);

        return votes;
    }

//      修改投票
    public int updateOneVote(Vote vote){
        int i = voteMapper.updateByPrimaryKeySelective(vote);
        return i;
    }
//      增加投票
    public int insertOneVote(Vote vote){
        int i = voteMapper.insertSelective(vote);
        return i;
    }
//    删除指定投票
    public int deleteOneVote(int voteid){
        int i = voteMapper.deleteByPrimaryKey(voteid);
        return i;
    }
//    查询所有已审核通过投票
    public List<Vote> selectVoteByState(){
        VoteExample voteExample = new VoteExample();
        VoteExample.Criteria criteria = voteExample.createCriteria();
        criteria.andVoteCreatstateEqualTo(2);
        List<Vote> votes = voteMapper.selectByExample(voteExample);
        return votes;
    }
    //    查询指定用户所有已审核通过投票
    public List<Vote> selectVoteByStateAndName(String username){
        VoteExample voteExample = new VoteExample();
        VoteExample.Criteria criteria = voteExample.createCriteria();
        criteria.andVoteCreatstateEqualTo(2);
        criteria.andUserNameEqualTo(username);
        List<Vote> votes = voteMapper.selectByExample(voteExample);
        return votes;
    }
}
