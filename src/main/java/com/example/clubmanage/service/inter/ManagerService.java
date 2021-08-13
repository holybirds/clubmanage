package com.example.clubmanage.service.inter;

import com.example.clubmanage.bean.Student;
import com.example.clubmanage.bean.User;

import java.util.List;

public interface ManagerService {
    List<User> selectAll();
    public int deleteOne(String username);
    public int insertStudent(Student student);
    List<Student> selectAllStudent();
    public List<Student> selectAllStudentByGrade(String grade);
    public int deleteAllStudentByGrade(String grade);
    public List<Student> selectAllStudentByStudentid(String id);
}
