package com.zsy.video.dao;

import java.util.List;

import com.zsy.video.model.Chapter;

public interface IChapterDao {
	public List<Chapter> getChaptersByCid(int c_id);
}
