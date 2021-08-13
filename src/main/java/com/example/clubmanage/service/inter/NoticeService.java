package com.example.clubmanage.service.inter;

import com.example.clubmanage.bean.Notice;

import java.util.List;

public interface NoticeService {
    public int addOneNotice(Notice notice);
    public List<Notice> selectAllNotice();
    public List<Notice> selectOneNotice(String noticename);
    public int deletdOneNotice(int noticeid);
}
