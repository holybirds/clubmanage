package com.example.clubmanage.service;
import com.example.clubmanage.bean.Student;
import com.example.clubmanage.bean.StudentExample;
import com.example.clubmanage.bean.User;
import com.example.clubmanage.bean.UserExample;
import com.example.clubmanage.dao.StudentMapper;
import com.example.clubmanage.dao.UserMapper;
import com.example.clubmanage.service.inter.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;

//查询所有用户
    @Override
    public List<User> selectAll() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdIsNotNull();
        userExample.setOrderByClause("`manage_id` desc");
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }
//    根据用户名删除指定用户
    @Override
    public int deleteOne(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        int i = userMapper.deleteByExample(userExample);
        return i;
    }
//    插入学生数据
    public int insertStudent(Student student){
        int i = studentMapper.insertSelective(student);
        return i;
    }
//    查询所有学生数据
    public List<Student> selectAllStudent(){
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andStudentNameidIsNotNull();
        List<Student> students = studentMapper.selectByExample(studentExample);
        return students;
    }
    //    按照年级查询学生数据
    public List<Student> selectAllStudentByGrade(String grade){
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andGradeEqualTo(grade);
        List<Student> students = studentMapper.selectByExample(studentExample);
        return students;
    }
    //    按照年级删除学生数据
    public int deleteAllStudentByGrade(String grade){
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andGradeEqualTo(grade);
        int i = studentMapper.deleteByExample(studentExample);
        return i;
    }
    //    按照学号查询学生数据
    public List<Student> selectAllStudentByStudentid(String id){
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andStudentNameidEqualTo(id);
        List<Student> students = studentMapper.selectByExample(studentExample);
        return students;
    }
}
