package com.zsy.video.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsy.video.dao.ICourseCommentDao;
import com.zsy.video.dao.impl.CourseCommentDaoImpl;
import com.zsy.video.model.CourseComment;

@Service
public class CourseCommentBizImpl implements ICourseCommentDao{
	@Autowired
	private CourseCommentDaoImpl cDaoImpl;
	
	public void setcDaoImpl(CourseCommentDaoImpl cDaoImpl) {
		this.cDaoImpl = cDaoImpl;
	}

	@Override
	public List<CourseComment> getCommentsByCid(int c_id) {
		
		return cDaoImpl.getCommentsByCid(c_id);
	}

}
