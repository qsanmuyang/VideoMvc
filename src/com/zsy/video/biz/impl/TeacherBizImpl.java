package com.zsy.video.biz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.zsy.video.biz.ITeacherBiz;
import com.zsy.video.dao.impl.TeacherDaoImpl;
import com.zsy.video.model.Teacher;

@Service
public class TeacherBizImpl implements ITeacherBiz {
	private TeacherDaoImpl tDaoImpl;
	
	
	public void settDaoImpl(TeacherDaoImpl tDaoImpl) {
		this.tDaoImpl = tDaoImpl;
	}


	@Override
	public List<Teacher> getTeachers() {
		return tDaoImpl.getTeachers();
	}
	
	@Override
	public boolean login(Map<String, String> map) {
		boolean flag=false;
		List<Teacher> teaList = new ArrayList<Teacher>();
		teaList=tDaoImpl.login(map);
		if(!teaList.isEmpty()){
			flag=true;
		}
		return flag;
	}


	@Override
	public int addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return tDaoImpl.addTeacher(teacher);
	}

	@Override
	public boolean findTeacher(String tnickname) {
		boolean flag=false;
		List<Teacher> teaList=new ArrayList<Teacher>();
		teaList=tDaoImpl.findTeacher(tnickname);
		if(!teaList.isEmpty()){
			flag=true;
		}
		return flag;
	}


	@Override
	public Teacher getTeacherByName(String name) {
		Teacher teacher = new Teacher();
		List<Teacher> teachers = new ArrayList<Teacher>();
		teachers = tDaoImpl.findTeacher(name);
		if(!teachers.isEmpty()){
			teacher = teachers.get(0);
			}
		return teacher;
	}


	public int updateTeacher(Teacher teacher) {
		
		return tDaoImpl.updateTeacher(teacher);
	}

}
