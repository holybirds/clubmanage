package com.example.clubmanage.service;

import com.example.clubmanage.bean.User;
import com.example.clubmanage.bean.UserExample;
import com.example.clubmanage.dao.UserMapper;
import com.example.clubmanage.service.inter.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

//    通过姓名查询指定用户
    public List<User> login(String usernama){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(usernama);
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }
//    通过学号查询指定用户
    public List<User> studentid(String studentid){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andStudentIdEqualTo(studentid);
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }
//    新增用户
    public int regist(User user){
        int i = userMapper.insertSelective(user);
        return i;
    }
//  更新用户
    @Override
    public int update(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        int i = userMapper.updateByExampleSelective(user, userExample);
        return i;
    }
//  通过主键更新用户
    public int updateUsenById(User user){
        int i = userMapper.updateByPrimaryKeySelective(user);
        return i;
    }
}
