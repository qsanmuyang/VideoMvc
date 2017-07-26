package com.zsy.video.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsy.video.biz.IVideoBiz;
import com.zsy.video.dao.impl.VideoDaoImpl;
import com.zsy.video.model.Video;

@Service
public class VideoBizImpl implements IVideoBiz {
	@Autowired
	private VideoDaoImpl vDaoImpl;

	public void setvDaoImpl(VideoDaoImpl vDaoImpl) {
		this.vDaoImpl = vDaoImpl;
	}

	@Override
	public List<Video> getVideosByCptid(int cptid) {
		
		return vDaoImpl.getVideosByCptid(cptid);
	}

	@Override
	public Video getVideoByVid(int vid) {
	
		return vDaoImpl.getVideoByVid(vid);
	}

	

}
