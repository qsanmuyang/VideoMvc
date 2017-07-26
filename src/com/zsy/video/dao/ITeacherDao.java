package com.zsy.video.dao;

import java.util.List;
import java.util.Map;

import com.zsy.video.model.Teacher;

public interface ITeacherDao {
	public List<Teacher> getTeachers();
	public List<Teacher> login(Map<String, String> map);
	public int addTeacher(Teacher teacher);
	public List<Teacher> findTeacher(String tnickname);
	public int updateTeacher(Teacher teacher);
}
