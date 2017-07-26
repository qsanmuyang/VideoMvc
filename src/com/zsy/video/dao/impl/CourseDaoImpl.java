package com.zsy.video.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.zsy.video.dao.ICourseDao;
import com.zsy.video.model.Course;
import com.zsy.video.util.BaseDao;
@Repository
public class CourseDaoImpl extends BaseDao{
	private ICourseDao iCourseDao;
	
	public List<Course> getCourses(){
		List<Course> couList=new ArrayList<Course>();
		SqlSession session=null;
		try {
			session=openSession();
			iCourseDao=session.getMapper(ICourseDao.class);
			couList=iCourseDao.getCourses();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			iCourseDao=null;
			session.close();
		}
		return couList;
	}
	public List<Course> getCourses1(Map<Object, Object> map){
		List<Course> couList=new ArrayList<Course>();
		SqlSession session=null;
		try {
			session=openSession();
			iCourseDao=session.getMapper(ICourseDao.class);
			couList=iCourseDao.getCourses1(map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			iCourseDao=null;
			session.close();
		}
		return couList;
	}
	
	public List<Course> getNoFreeCourses(){
		List<Course> couList=new ArrayList<Course>();
		SqlSession session=null;
		try {
			session=openSession();
			iCourseDao=session.getMapper(ICourseDao.class);
			couList=iCourseDao.getNoFreeCourses();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			iCourseDao=null;
			session.close();
		}
		return couList;
	}
	public List<Course> getFreeCourses(){
		List<Course> couList=new ArrayList<Course>();
		SqlSession session=null;
		try {
			session=openSession();
			iCourseDao=session.getMapper(ICourseDao.class);
			couList=iCourseDao.getFreeCourses();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iCourseDao=null;
		}
		return couList;
	}
	
	public List<Course> getSubjectCourses(String subject){
		List<Course> couList=new ArrayList<Course>();
		SqlSession session=null;
		try {
			session=openSession();
			iCourseDao=session.getMapper(ICourseDao.class);
			couList=iCourseDao.getSubjectCourses(subject);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iCourseDao=null;
		}
		return couList;
	}
	public List<Course> getSubjectCourses1(Map<Object, Object> map){
		List<Course> couList=new ArrayList<Course>();
		SqlSession session=null;
		try {
			session=openSession();
			iCourseDao=session.getMapper(ICourseDao.class);
			couList=iCourseDao.getSubjectCourses1(map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iCourseDao=null;
		}
		return couList;
	}

	public List<Course> getVideoList(Map<Object, Object> map){
		List<Course> couList=new ArrayList<Course>();
		SqlSession session=null;
		try {
			session=openSession();
			iCourseDao=session.getMapper(ICourseDao.class);
			couList=iCourseDao.getVideoList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iCourseDao=null;
		}
		return couList;
	}
	public List<Course> getVideoList1(Map<Object, Object> map){
		List<Course> couList=new ArrayList<Course>();
		SqlSession session=null;
		try {
			session=openSession();
			iCourseDao=session.getMapper(ICourseDao.class);
			couList=iCourseDao.getVideoList1(map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iCourseDao=null;
		}
		return couList;
	}
	
	public List<Course> getCoursesByGrade(String grade){
		List<Course> couList=new ArrayList<Course>();
		SqlSession session=null;
		try {
			session=openSession();
			iCourseDao=session.getMapper(ICourseDao.class);
			couList=iCourseDao.getCoursesByGrade(grade);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iCourseDao=null;
		}
		return couList;
	}
	public List<Course> getCoursesByGrade1(Map<Object, Object> map){
		List<Course> couList=new ArrayList<Course>();
		SqlSession session=null;
		try {
			session=openSession();
			iCourseDao=session.getMapper(ICourseDao.class);
			couList=iCourseDao.getCoursesByGrade1(map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iCourseDao=null;
		}
		return couList;
	}
	
	public Course getCourseByCid(int c_id){
		Course course = new Course();
		SqlSession session=null;
		try {
			session=openSession();
			iCourseDao=session.getMapper(ICourseDao.class);
			course=iCourseDao.getCourseByCid(c_id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iCourseDao=null;
		}
		return course;
	}
}
