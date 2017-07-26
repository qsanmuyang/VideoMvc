package com.zsy.video.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.zsy.video.dao.IStudentDao;
import com.zsy.video.model.Student;
import com.zsy.video.util.BaseDao;

@Repository
public class StudentDaoImpl extends BaseDao implements IStudentDao {
	private IStudentDao iStudentDao;
	public List<Student> getStudents(){
		List<Student> stuList = new ArrayList<Student>();
		SqlSession session=null;
		try {
			session=openSession();
			iStudentDao=session.getMapper(IStudentDao.class);
			stuList=iStudentDao.getStudents();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iStudentDao=null;
		}
		return stuList;
		
	}
	public List<Student> login(Map<String, String> map){
		List<Student> stuList = new ArrayList<Student>();
		SqlSession session=null;
		try {
			session=openSession();
			iStudentDao=session.getMapper(IStudentDao.class);
			stuList=iStudentDao.login(map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iStudentDao=null;
		}
		return stuList;
	}
	public int addStudent(Student student){
		int num=0;
		SqlSession session=null;
		try {
			session=openSession();
			iStudentDao=session.getMapper(IStudentDao.class);
			num=iStudentDao.addStudent(student);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iStudentDao=null;
		}
		return num;
	}
	public List<Student> findStudent(String snickname){
		List<Student> stuList = new ArrayList<Student>();
		SqlSession session=null;
		try {
			session=openSession();
			iStudentDao=session.getMapper(IStudentDao.class);
			stuList=iStudentDao.findStudent(snickname);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iStudentDao=null;
		}
		return stuList;
	}
	@Override
	public int updateStudent(Student student) {
		int num=0;
		SqlSession session=null;
		try {
			session=openSession();
			iStudentDao=session.getMapper(IStudentDao.class);
			num=iStudentDao.updateStudent(student);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iStudentDao=null;
		}
		return num;
	}
}
