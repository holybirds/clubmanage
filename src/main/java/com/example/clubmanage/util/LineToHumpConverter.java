package com.example.clubmanage.util;

import com.example.clubmanage.bean.User;
import org.springframework.core.convert.converter.Converter;

import java.util.Map;


public class LineToHumpConverter implements Converter<Map<String,String>, User> {

    //下划线转驼峰
    @Override
    public User convert(Map map) {
        User user = new User();
        user.setUserName((String) map.get("user_name"));
        user.setUserPass((String) map.get("user_pass"));
        user.setStudentId((String) map.get("student_id"));
        user.setSex((String) map.get("sex"));
        user.setGrade((String) map.get("grade"));
        user.setCollege((String) map.get("ceolleg"));
        user.setEmail((String) map.get("email"));
        user.setPhone((String) map.get("phone"));
        return user;
    }


}
