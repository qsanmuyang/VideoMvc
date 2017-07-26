package com.zsy.video.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.zsy.video.dao.ITeacherDao;
import com.zsy.video.model.Teacher;
import com.zsy.video.util.BaseDao;

@Repository
public class TeacherDaoImpl extends BaseDao {
	private ITeacherDao iTeacherDao;
	
	public List<Teacher> getTeachers(){
		List<Teacher> teaList = new ArrayList<Teacher>();
		SqlSession session=null;
		try {
			session=openSession();
			iTeacherDao=session.getMapper(ITeacherDao.class);
			teaList=iTeacherDao.getTeachers();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iTeacherDao=null;
		}
		return teaList;
	}
	
	public List<Teacher> login(Map<String, String> map){
		List<Teacher> teaList = new ArrayList<Teacher>();
		SqlSession session=null;
		try {
			session=openSession();
			iTeacherDao=session.getMapper(ITeacherDao.class);
			teaList=iTeacherDao.login(map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iTeacherDao=null;
		}
		return teaList;
	}
	
	public int addTeacher(Teacher teacher){
		int num=0;
		SqlSession session=null;
		try {
			session=openSession();
			iTeacherDao=session.getMapper(ITeacherDao.class);
			num=iTeacherDao.addTeacher(teacher);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iTeacherDao=null;
		}
		return num;
	}
	
	public List<Teacher> findTeacher(String tnickname){
		List<Teacher> teaList = new ArrayList<Teacher>();
		SqlSession session=null;
		try {
			session=openSession();
			iTeacherDao=session.getMapper(ITeacherDao.class);
			teaList=iTeacherDao.findTeacher(tnickname);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iTeacherDao=null;
		}
		return teaList;
	}

	public int updateTeacher(Teacher teacher) {
		int num = 0;
		SqlSession session = null;
		try {
			session = openSession();
			iTeacherDao=session.getMapper(ITeacherDao.class);
			num = iTeacherDao.updateTeacher(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
}
