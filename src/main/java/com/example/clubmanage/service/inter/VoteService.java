package com.example.clubmanage.service.inter;

import com.example.clubmanage.bean.Vote;

import java.util.List;

public interface VoteService {
    public List<Vote> selectAllVote();
    public List<Vote> selectOneVote(String username);
    public int updateOneVote(Vote vote);
    public int insertOneVote(Vote vote);
    public int deleteOneVote(int voteid);
    public Vote selectOneVoteById(int id);
    public List<Vote> selectVoteByState();
    public List<Vote> selectVoteByStateAndName(String username);
    public List<Vote> selectOneVoteByContent(String content);
}
