package com.zsy.video.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.zsy.video.dao.IVideoDao;
import com.zsy.video.model.Video;
import com.zsy.video.util.BaseDao;

@Repository
public class VideoDaoImpl extends BaseDao{
	private IVideoDao iVideoDao;
	public List<Video> getVideosByCptid(int cptid){
		List<Video> videos = new ArrayList<Video>();
		SqlSession session=null;
		try {
			session=openSession();
			iVideoDao=session.getMapper(IVideoDao.class);
			videos=iVideoDao.getVideosByCptid(cptid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iVideoDao=null;
		}
		return videos;
	}
	public Video getVideoByVid(int vid){
		Video video=new Video();
		SqlSession session=null;
		try {
			session=openSession();
			iVideoDao=session.getMapper(IVideoDao.class);
			video=iVideoDao.getVideoByVid(vid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iVideoDao=null;
		}
		return video;
	}
}
