package com.zsy.video.biz;

import java.util.List;

import com.zsy.video.model.CourseComment;

public interface ICourseCommentBiz {
	//通过c_id获得所有评论信息
	public List<CourseComment> getCommentsByCid(int c_id);
}
