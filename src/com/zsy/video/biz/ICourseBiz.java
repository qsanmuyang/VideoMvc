package com.zsy.video.biz;

import java.util.List;
import java.util.Map;

import com.zsy.video.model.Course;

public interface ICourseBiz {
	
	//获得所有课程信息
	public List<Course> getCourses();
	//分页所有
	public List<Course> getCourses1(Map<Object, Object> map);
	
	//获得推荐课程
	public List<Course> getNoFreeCourse();
	//获得免费课程
	public List<Course> getFreeCourse();
	
	//通过科目名称获取课程
	public List<Course> getSubjectCourses(String subject);
	//分页科目
	public List<Course> getSubjectCourses1(Map<Object, Object> map);
	
	//通过科目和年级获取课程
	public List<Course> getVideoList(Map<Object, Object> map);
	//分页
	public List<Course> getVideoList1(Map<Object, Object> map);
	
	//通过年级获取课程
	public List<Course> getCoursesByGrade(String grade);
	//分页
	public List<Course> getCoursesByGrade1(Map<Object, Object> map);
	
	//计算开始位置
	public int countBeginPosition(int currentPage, int pageNum);
	//计算页数
	public int countPage(int pageNum, List<Course> couList);
	
	//通过c_id获取课程
	public Course getCourseByCid(int c_id);
	
	//转换时间
	public String translateDate(String cdate);
}
