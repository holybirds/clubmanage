package com.example.clubmanage.service;

import com.example.clubmanage.bean.*;
import com.example.clubmanage.dao.ClubCreatMapper;
import com.example.clubmanage.dao.ClubJoinMapper;
import com.example.clubmanage.dao.ClubMapper;
import com.example.clubmanage.dao.ClubMemberMapper;
import com.example.clubmanage.service.inter.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ClubMapper clubMapper;
    @Autowired
    private ClubCreatMapper clubCreatMapper;
    @Autowired
    private ClubJoinMapper clubJoinMapper;
    @Autowired
    private ClubMemberMapper clubMemberMapper;
//查询所有社团
    @Override
    public List<Club> selectAllclub() {
        ClubExample clubExample = new ClubExample();
        ClubExample.Criteria clubExampleCriteria = clubExample.createCriteria();
        clubExampleCriteria.andClubIdIsNotNull();
        clubExample.setOrderByClause("`club_id` desc");
        List<Club> clubs = clubMapper.selectByExample(clubExample);
        return clubs;
    }
//    查询指定社团
    @Override
    public List<Club> selectOneclub(String clubname) {
        ClubExample clubExample = new ClubExample();
        ClubExample.Criteria clubExampleCriteria = clubExample.createCriteria();
        clubExampleCriteria.andClubNameEqualTo(clubname);
        List<Club> clubs = clubMapper.selectByExample(clubExample);
        return clubs;
    }
//根据名字删除指定社团
    @Override
    public int deleteOneClub(String clubname) {
        ClubExample clubExample = new ClubExample();
        ClubExample.Criteria criteria = clubExample.createCriteria();
        criteria.andClubNameEqualTo(clubname);
         int i = clubMapper.deleteByExample(clubExample);
        return i;
    }
    //查询所有社团创建申请
    @Override
    public List<ClubCreat> selectAllClubCreat() {
        ClubCreatExample clubcreatExample = new ClubCreatExample();
        ClubCreatExample.Criteria clubCreatExampleCriteria = clubcreatExample.createCriteria();
        clubCreatExampleCriteria.andClubcreatIdIsNotNull();
        List<ClubCreat> clubCreats = clubCreatMapper.selectByExample(clubcreatExample);
        return clubCreats;
    }
    //    查询指定社团创建申请
    @Override
    public List<ClubCreat> selectOneClubCreat(String clubcreatname) {
        ClubCreatExample clubcreatExample = new ClubCreatExample();
        ClubCreatExample.Criteria clubCreatExampleCriteria = clubcreatExample.createCriteria();
        clubCreatExampleCriteria.andClubNameEqualTo(clubcreatname);
        List<ClubCreat> clubCreats = clubCreatMapper.selectByExample(clubcreatExample);
        return clubCreats;
    }
    //    更改社团创建申请审核状态
    @Override
    public int updateOneClubCreat(String clubcreatname,ClubCreat clubCreat) {
        ClubCreatExample clubcreatExample = new ClubCreatExample();
        ClubCreatExample.Criteria clubCreatExampleCriteria = clubcreatExample.createCriteria();
        clubCreatExampleCriteria.andClubNameEqualTo(clubcreatname);
        int i = clubCreatMapper.updateByExampleSelective(clubCreat, clubcreatExample);
        return i;
    }
//    增加社团
    @Override
    public int insertOneClub(Club club){
        int i = clubMapper.insertSelective(club);
        return i;
    }
//    增加社团申请加入表
    public int insertOneClubJoin(ClubJoin clubJoin){
        int i = clubJoinMapper.insertSelective(clubJoin);
        return i;
    }

//    按照用户名查找指定社团加入表
    public List<ClubJoin> selectOneClubJoin(String username){
        ClubJoinExample clubJoinExample = new ClubJoinExample();
        ClubJoinExample.Criteria criteria = clubJoinExample.createCriteria();
        criteria.andUserjoinNameEqualTo(username);
        List<ClubJoin> clubJoins = clubJoinMapper.selectByExample(clubJoinExample);
        return clubJoins;
    }

//    删除指定社团加入申请
    public int deleteOneClubJoin(String username,String clubname){
        ClubJoinExample clubJoinExample = new ClubJoinExample();
        ClubJoinExample.Criteria criteria = clubJoinExample.createCriteria();
        criteria.andUserjoinNameEqualTo(username);
        criteria.andClubNameEqualTo(clubname);
        int i = clubJoinMapper.deleteByExample(clubJoinExample);
        return i;
    }
//    通过社长名查询社团
    public List<Club> selectClubByManager(String managername){
        ClubExample clubExample = new ClubExample();
        ClubExample.Criteria criteria = clubExample.createCriteria();
        criteria.andClubManagerEqualTo(managername);
        List<Club> clubs = clubMapper.selectByExample(clubExample);
        return clubs;
    }
//    通过社长名查询指定社团加入表
    public List<ClubJoin> selectOneClubJoinByClubmanager(String clubmanagername){
        ClubJoinExample clubJoinExample = new ClubJoinExample();
        ClubJoinExample.Criteria criteria = clubJoinExample.createCriteria();
        criteria.andClubmanagerNameEqualTo(clubmanagername);
        List<ClubJoin> clubJoins = clubJoinMapper.selectByExample(clubJoinExample);
        return clubJoins;
    }
    //    通过id查询指定社团加入表数据
    public ClubJoin selectOneClubJoinById(int id){
        ClubJoin clubJoin = clubJoinMapper.selectByPrimaryKey(id);
        return clubJoin;
    }

//    根据社团类别查询社团
    public List<Club> selectClubByClass(int i){
        ClubExample clubExample = new ClubExample();
        ClubExample.Criteria criteria = clubExample.createCriteria();
        criteria.andClubClassEqualTo(i);
        List<Club> clubs = clubMapper.selectByExample(clubExample);
        return clubs;
    }
//    增加社团创建表
    public int addClubCreatTable(ClubCreat clubCreat){
        int i = clubCreatMapper.insertSelective(clubCreat);
        return i;
    }
    //    根据用户名查询指定社团创建申请
    @Override
    public List<ClubCreat> selectOneClubCreatByManagername(String managername) {
        ClubCreatExample clubcreatExample = new ClubCreatExample();
        ClubCreatExample.Criteria clubCreatExampleCriteria = clubcreatExample.createCriteria();
        clubCreatExampleCriteria.andClubManagerEqualTo(managername);
        List<ClubCreat> clubCreats = clubCreatMapper.selectByExample(clubcreatExample);
        return clubCreats;
    }
//    更新社团加入表数据
    public int updateOneClubJoin(ClubJoin clubJoin){
        int i = clubJoinMapper.updateByPrimaryKeySelective(clubJoin);
        return i;
    }
//    给社团成员表插入一条数据
    public int addOneClubMember(ClubMember clubMember){
        int i = clubMemberMapper.insertSelective(clubMember);
        return i;
    }
//    根据用户名和加入状态查询指定用户加入表
    public List<ClubJoin> selectOneClubJoinByUserNameAndState(String username,int state){
        ClubJoinExample clubJoinExample = new ClubJoinExample();
        ClubJoinExample.Criteria criteria = clubJoinExample.createCriteria();
        criteria.andUserjoinNameEqualTo(username);
        criteria.andClubjoinStateEqualTo(state);
        List<ClubJoin> clubJoins = clubJoinMapper.selectByExample(clubJoinExample);
        return clubJoins;
    }
//    根据id查询指定社团
    public Club selectClubById(int clubid){
        Club club = clubMapper.selectByPrimaryKey(clubid);
        return club;
    }
//    根据id修改社团
    public int updateClubById(Club club){
        int i = clubMapper.updateByPrimaryKeySelective(club);
        return i;
    }
//    根据社团名查询社团成员
    public List<ClubMember> selectClubMemberByClubneme(String clubname){
        ClubMemberExample clubMemberExample = new ClubMemberExample();
        ClubMemberExample.Criteria criteria = clubMemberExample.createCriteria();
        criteria.andClubNameEqualTo(clubname);
        List<ClubMember> clubMembers = clubMemberMapper.selectByExample(clubMemberExample);
        return clubMembers;
    }
    //    根据社团成员名查询社团成员
    public List<ClubMember> selectClubMemberByClubMemberneme(String clubmembername){
        ClubMemberExample clubMemberExample = new ClubMemberExample();
        ClubMemberExample.Criteria criteria = clubMemberExample.createCriteria();
        criteria.andClubmemberNameEqualTo(clubmembername);
        List<ClubMember> clubMembers = clubMemberMapper.selectByExample(clubMemberExample);
        return clubMembers;
    }


}
