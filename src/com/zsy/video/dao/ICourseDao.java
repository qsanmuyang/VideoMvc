package com.zsy.video.dao;

import java.util.List;
import java.util.Map;

import com.zsy.video.model.Course;

public interface ICourseDao {
	
	public List<Course> getCourses();
	public List<Course> getCourses1(Map<Object, Object> map);
	
	public List<Course> getNoFreeCourses();
	public List<Course> getFreeCourses();
	
	public List<Course> getSubjectCourses(String subject);
	public List<Course> getSubjectCourses1(Map<Object, Object> map);
	
	public List<Course> getVideoList(Map<Object, Object> map);
	public List<Course> getVideoList1(Map<Object, Object> map);
	
	public List<Course> getCoursesByGrade(String grade);
	public List<Course> getCoursesByGrade1(Map<Object, Object> map);
	
	public Course getCourseByCid(int c_id);
}
