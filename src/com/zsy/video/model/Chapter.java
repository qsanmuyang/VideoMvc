package com.zsy.video.model;

import java.util.List;

public class Chapter {
	//主键章节
	private int cptid;
	//课程
	private int c_id;
	//章节名称
	private String chaptername;
	
	private List<Video> videos;
	public Chapter() {
		
	}
	public Chapter(int cptid, int c_id, String chaptername) {
		super();
		this.cptid = cptid;
		this.c_id = c_id;
		this.chaptername = chaptername;
	}
	public int getCptid() {
		return cptid;
	}
	public void setCptid(int cptid) {
		this.cptid = cptid;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getChaptername() {
		return chaptername;
	}
	public void setChaptername(String chaptername) {
		this.chaptername = chaptername;
	}
	
	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	@Override
	public String toString() {
		return "Chapter [cptid=" + cptid + ", c_id=" + c_id + ", chaptername="
				+ chaptername + "]";
	}
	
}
