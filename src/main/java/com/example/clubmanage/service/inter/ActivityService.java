package com.example.clubmanage.service.inter;

import com.example.clubmanage.bean.Activity;
import com.example.clubmanage.bean.ActivityMember;

import java.util.List;

public interface ActivityService {
    public List<Activity> selectAllActivity();
    public List<Activity> selectOneActivity(String activityname);
    public int deleteOneActivity(String activityname);
    public int updateOneActivity(Activity activity);
    public int insertOneActivity(Activity activity);
    public List<Activity> selectOneActivityByClubname(String clubname);
    public Activity selectOneActivityById(int activityid);
    public int updateActivityById(Activity activity);
    public List<ActivityMember> selectActivityByMember(String membername);
    public List<Activity> selectOneActivityByClubnameAndActname(String clubname,String actname);
    public int insertOneActivityMember(ActivityMember activityMember);
}
