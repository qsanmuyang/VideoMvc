package com.zsy.video.dao;

import java.util.List;
import java.util.Map;

import com.zsy.video.model.Student;

public interface IStudentDao {
	public List<Student> getStudents();
	public List<Student> login(Map<String, String> map);
	public int addStudent(Student student);
	public List<Student> findStudent(String snickname);
	public int updateStudent(Student student);
}
