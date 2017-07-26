package com.zsy.video.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.zsy.video.dao.ICourseCommentDao;
import com.zsy.video.model.CourseComment;
import com.zsy.video.util.BaseDao;

@Repository
public class CourseCommentDaoImpl extends BaseDao {
	private ICourseCommentDao iCourseCommentDao;
	public List<CourseComment> getCommentsByCid(int c_id){
		List<CourseComment> comments = new ArrayList<CourseComment>();
		SqlSession session=null;
		try {
			session=openSession();
			iCourseCommentDao=session.getMapper(ICourseCommentDao.class);
			comments=iCourseCommentDao.getCommentsByCid(c_id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iCourseCommentDao=null;
		}
		return comments;
	}
}
