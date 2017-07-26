package com.zsy.video.dao;

import java.util.List;

import com.zsy.video.model.CourseComment;

public interface ICourseCommentDao {
	public List<CourseComment> getCommentsByCid(int c_id);
}
