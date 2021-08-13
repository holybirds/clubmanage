package com.example.clubmanage.service.inter;

import com.example.clubmanage.bean.User;

import java.util.List;

public interface LoginService {
     List<User> login(String username);
     int regist(User user);
     int update(User user);
     List<User> studentid(String studentid);
     public int updateUsenById(User user);
}
