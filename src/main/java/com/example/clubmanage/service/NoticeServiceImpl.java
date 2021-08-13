package com.example.clubmanage.service;

import com.example.clubmanage.bean.Notice;
import com.example.clubmanage.bean.NoticeExample;
import com.example.clubmanage.dao.NoticeMapper;
import com.example.clubmanage.service.inter.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;


//    添加一条新闻
    public int addOneNotice(Notice notice){
        int i = noticeMapper.insertSelective(notice);
        return i;
    }

//    查询所有新闻
    public List<Notice> selectAllNotice(){
        NoticeExample noticeExample = new NoticeExample();
        NoticeExample.Criteria criteria = noticeExample.createCriteria();
        criteria.andNoticeIdIsNotNull();
        List<Notice> notices = noticeMapper.selectByExample(noticeExample);
        return notices;
    }

    //    查询指定新闻
    public List<Notice> selectOneNotice(String noticename){
        NoticeExample noticeExample = new NoticeExample();
        NoticeExample.Criteria criteria = noticeExample.createCriteria();
        criteria.andClubNameEqualTo(noticename);
        List<Notice> notices = noticeMapper.selectByExample(noticeExample);
        return notices;
    }

//    删除指定新闻
    public int deletdOneNotice(int noticeid){
        NoticeExample noticeExample = new NoticeExample();
        NoticeExample.Criteria criteria = noticeExample.createCriteria();
        criteria.andNoticeIdEqualTo(noticeid);
        int i = noticeMapper.deleteByExample(noticeExample);
        return i;
    }

}
