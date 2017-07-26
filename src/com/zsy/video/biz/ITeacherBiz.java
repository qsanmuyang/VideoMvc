package com.zsy.video.biz;

import java.util.List;
import java.util.Map;

import com.zsy.video.model.Teacher;

public interface ITeacherBiz {
	public List<Teacher> getTeachers();
	public boolean login(Map<String, String> map);
	public int addTeacher(Teacher teacher);
	public boolean findTeacher(String tnickname);
	public Teacher getTeacherByName(String name);
	public int updateTeacher(Teacher teacher);
}
