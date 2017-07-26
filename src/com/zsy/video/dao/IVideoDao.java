package com.zsy.video.dao;

import java.util.List;

import com.zsy.video.model.Video;

public interface IVideoDao {
	public List<Video> getVideosByCptid(int cptid);
	public Video getVideoByVid(int vid);
}
