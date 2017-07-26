package com.zsy.video.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsy.video.biz.IChapterBiz;
import com.zsy.video.dao.impl.ChapterDaoImpl;
import com.zsy.video.model.Chapter;

@Service
public class ChapterBizImpl implements IChapterBiz {
	@Autowired
	private ChapterDaoImpl cDaoImpl;
	
	
	public ChapterDaoImpl getcDaoImpl() {
		return cDaoImpl;
	}


	public void setcDaoImpl(ChapterDaoImpl cDaoImpl) {
		this.cDaoImpl = cDaoImpl;
	}


	@Override
	public List<Chapter> getChaptersByCid(int c_id) {

		return cDaoImpl.getChaptersByCid(c_id);
	}

}
