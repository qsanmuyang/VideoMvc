package com.zsy.video.dao;

import java.util.List;

import com.zsy.video.model.ChapterComment;

public interface IChapterCommentDao {
	public List<ChapterComment> getCommentsByVid(int vid);
	
	public int addComment(ChapterComment chapterComment);
	
}
