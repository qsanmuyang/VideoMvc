package com.zsy.video.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsy.video.biz.ICourseBiz;
import com.zsy.video.dao.impl.CourseDaoImpl;
import com.zsy.video.model.Course;

@Service
public class CourseBizImpl implements ICourseBiz {
	@Autowired
	private CourseDaoImpl cDaoImpl;
	
	public void setcDaoImpl(CourseDaoImpl cDaoImpl) {
		this.cDaoImpl = cDaoImpl;
	}

	@Override
	public List<Course> getCourses() {
		
		return cDaoImpl.getCourses();
	}
	@Override
	public List<Course> getCourses1(Map<Object, Object> map) {
		
		return cDaoImpl.getCourses1(map);
	}

	@Override
	public List<Course> getNoFreeCourse() {
		return cDaoImpl.getNoFreeCourses();
	}
	@Override
	public List<Course> getFreeCourse() {
		return cDaoImpl .getFreeCourses();
	}

	@Override
	public List<Course> getSubjectCourses(String subject) {
		return cDaoImpl.getSubjectCourses(subject);
	}
	@Override
	public List<Course> getSubjectCourses1(Map<Object, Object> map) {
		return cDaoImpl.getSubjectCourses1(map);
	}
	
	@Override
	public List<Course> getVideoList(Map<Object, Object> map) {
		
		return cDaoImpl.getVideoList(map);
	}
	@Override
	public List<Course> getVideoList1(Map<Object, Object> map) {
		
		return cDaoImpl.getVideoList1(map);
	}
	
	@Override
	public List<Course> getCoursesByGrade(String grade) {

		return cDaoImpl.getCoursesByGrade(grade);
	}
	@Override
	public List<Course> getCoursesByGrade1(Map<Object, Object> map) {

		return cDaoImpl.getCoursesByGrade1(map);
	}
	
	@Override
	public int countBeginPosition(int currentPage, int pageNum) {
		return (currentPage-1)*pageNum;
	}
	@Override
	public int countPage(int pageNum,List<Course> couList) {
		int num =couList.size();
		int countPage=0;
		if(num%pageNum==0){
			countPage=num/pageNum;
		}else{
			countPage=num/pageNum+1;
		}
		return countPage;
	}

	@Override
	public Course getCourseByCid(int c_id) {

		return cDaoImpl.getCourseByCid(c_id);
	}
	
	@Override
	public String translateDate(String cdate) {
		String a=cdate.split("-")[1];
		int b = Integer.parseInt(a);
		if(b<10){
			cdate=cdate.substring(0, 5)+"0"+cdate.substring(5)+".0";
		}
		return cdate;
	}
}
