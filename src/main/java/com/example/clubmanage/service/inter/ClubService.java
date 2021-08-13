package com.example.clubmanage.service.inter;

import com.example.clubmanage.bean.Club;
import com.example.clubmanage.bean.ClubCreat;
import com.example.clubmanage.bean.ClubJoin;
import com.example.clubmanage.bean.ClubMember;

import java.util.List;

public interface ClubService {
    public List<Club> selectAllclub();
    public List<Club> selectOneclub(String clubname);

    int deleteOneClub(String clubname);
    public List<ClubCreat> selectAllClubCreat();
    public List<ClubCreat> selectOneClubCreat(String clubcreatname);
    public int updateOneClubCreat(String clubcreatname,ClubCreat clubCreat);
    public int insertOneClub(Club club);
    public int insertOneClubJoin(ClubJoin clubJoin);
    public List<ClubJoin> selectOneClubJoin(String username);
    public int deleteOneClubJoin(String username,String clubname);
    public List<Club> selectClubByManager(String managername);
    public List<ClubJoin> selectOneClubJoinByClubmanager(String clubmanagername);
    public List<Club> selectClubByClass(int i);
    public int addClubCreatTable(ClubCreat clubCreat);
    public List<ClubCreat> selectOneClubCreatByManagername(String managername);
    public ClubJoin selectOneClubJoinById(int id);
    public int updateOneClubJoin(ClubJoin clubJoin);
    public int addOneClubMember(ClubMember clubMember);
    public List<ClubJoin> selectOneClubJoinByUserNameAndState(String username,int state);
    public Club selectClubById(int clubid);
    public int updateClubById(Club club);
    public List<ClubMember> selectClubMemberByClubneme(String clubname);
    public List<ClubMember> selectClubMemberByClubMemberneme(String clubmembername);
}
