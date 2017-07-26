package com.zsy.video.biz;

import java.util.List;

import com.zsy.video.model.Video;

public interface IVideoBiz {
	//通过章cptid获得节信息
	public List<Video> getVideosByCptid(int cptid);
	//通过vid获得视频信息
	public Video getVideoByVid(int vid);
	
}
