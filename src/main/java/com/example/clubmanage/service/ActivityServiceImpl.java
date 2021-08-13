package com.example.clubmanage.service;

import com.example.clubmanage.bean.*;
import com.example.clubmanage.dao.ActivityMapper;
import com.example.clubmanage.dao.ActivityMemberMapper;
import com.example.clubmanage.service.inter.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivityMemberMapper activityMemberMapper;


    //查询所有活动
    @Override
    public List<Activity> selectAllActivity() {
        ActivityExample activityExample = new ActivityExample();
        ActivityExample.Criteria activityExampleCriteria = activityExample.createCriteria();
        activityExampleCriteria.andActivityIdIsNotNull();
        activityExample.setOrderByClause("`activity_id` desc");
        List<Activity> activitys = activityMapper.selectByExample(activityExample);
        return activitys;
    }
    //    根据活动名查询指定活动
    @Override
    public List<Activity> selectOneActivity(String activityname) {
        ActivityExample activityExample = new ActivityExample();
        ActivityExample.Criteria activityExampleCriteria = activityExample.createCriteria();
        activityExampleCriteria.andActivityNameEqualTo(activityname);
        List<Activity> activitys = activityMapper.selectByExample(activityExample);
        return activitys;
    }
    //根据名字删除指定活动
    @Override
    public int deleteOneActivity(String activityname) {
        ActivityExample activityExample = new ActivityExample();
        ActivityExample.Criteria criteria = activityExample.createCriteria();
        criteria.andActivityNameEqualTo(activityname);
        int i = activityMapper.deleteByExample(activityExample);
        return i;
    }
//加入即修改指定活动
    public int updateOneActivity(Activity activity){
        ActivityExample activityExample = new ActivityExample();
        ActivityExample.Criteria criteria = activityExample.createCriteria();
        criteria.andActivityNameEqualTo(activity.getActivityName());
        int i = activityMapper.updateByExampleSelective(activity,activityExample);
        return i;
    }
//添加指定社团活动
    public int insertOneActivity(Activity activity){
        int i = activityMapper.insertSelective(activity);
        return i;
    }
    //    根据社团名查询指定活动
    @Override
    public List<Activity> selectOneActivityByClubname(String clubname) {
        ActivityExample activityExample = new ActivityExample();
        ActivityExample.Criteria activityExampleCriteria = activityExample.createCriteria();
        activityExampleCriteria.andClubEqualTo(clubname);
        List<Activity> activitys = activityMapper.selectByExample(activityExample);
        return activitys;
    }
//    根据活动id查询指定活动
    public Activity selectOneActivityById(int activityid){
        Activity activity = activityMapper.selectByPrimaryKey(activityid);
        return activity;
    }
//    根据id修改社团活动
    public int updateActivityById(Activity activity){
        int i = activityMapper.updateByPrimaryKeySelective(activity);
        return i;
    }
//    根据成员名查询社团活动
    public List<ActivityMember> selectActivityByMember(String membername){
        ActivityMemberExample activityMemberExample = new ActivityMemberExample();
        ActivityMemberExample.Criteria criteria = activityMemberExample.createCriteria();
        criteria.andMemberNameEqualTo(membername);
        List<ActivityMember> activityMembers = activityMemberMapper.selectByExample(activityMemberExample);
        return activityMembers;
    }
    //    根据社团名查询指定活动
    @Override
    public List<Activity> selectOneActivityByClubnameAndActname(String clubname,String actname) {
        ActivityExample activityExample = new ActivityExample();
        ActivityExample.Criteria activityExampleCriteria = activityExample.createCriteria();
        activityExampleCriteria.andClubEqualTo(clubname);
        activityExampleCriteria.andActivityNameEqualTo(actname);
        List<Activity> activitys = activityMapper.selectByExample(activityExample);
        return activitys;
    }
//    添加活动成员表数据
    public int insertOneActivityMember(ActivityMember activityMember){
        int i = activityMemberMapper.insertSelective(activityMember);
        return i;
    }
}
