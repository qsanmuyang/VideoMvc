package com.zsy.video.biz;

import java.util.List;
import java.util.Map;

import com.zsy.video.model.Student;

public interface IStudentBiz {
	//获得所有学员信息
	public List<Student> getStudents();
	//判断用户登录
	public boolean login(Map<String, String> map);
	//添加学员
	public int addStudent(Student student);
	//判断用户是否存在
	public boolean findStudent(String snickname);
	//通过登录名得到学员信息
	public Student getStudentByName(String name);
	//修改学员信息
	public int updateStudent(Student student);
	
}
