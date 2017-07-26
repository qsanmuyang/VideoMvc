package com.zsy.video.biz;

import java.util.List;

import com.zsy.video.model.Chapter;

public interface IChapterBiz {
	//通过科目获取章节信息
	public List<Chapter> getChaptersByCid(int c_id);
}
