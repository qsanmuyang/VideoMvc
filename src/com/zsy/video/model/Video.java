package com.zsy.video.model;

public class Video {
	private int vid;
	private int cptid;
	private String vname;
	private String vlength;
	private String vpath;
	public Video() {
		
	}
	public Video(int vid, int cptid, String vname, String vlength, String vpath) {
		super();
		this.vid = vid;
		this.cptid = cptid;
		this.vname = vname;
		this.vlength = vlength;
		this.vpath = vpath;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	
	public int getCptid() {
		return cptid;
	}
	public void setCptid(int cptid) {
		this.cptid = cptid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVlength() {
		return vlength;
	}
	public void setVlength(String vlength) {
		this.vlength = vlength;
	}
	public String getVpath() {
		return vpath;
	}
	public void setVpath(String vpath) {
		this.vpath = vpath;
	}
	@Override
	public String toString() {
		return "Video [vid=" + vid + ", vptid=" + cptid + ", vname=" + vname
				+ ", vlength=" + vlength + ", vpath=" + vpath + "]";
	}
	
	
}
