package com.zsy.video.model;

public class CourseComment {
	//主键
	private int ccid;
	//昵称
	private String snickname;
	//课程评论
	private String cconment;
	//评论时间
	private String ccdate;
	//课程id
	private int c_id;
	public CourseComment() {
		
	}
	public CourseComment(int ccid, String snickname, String cconment,
			String ccdate, int c_id) {
		super();
		this.ccid = ccid;
		this.snickname = snickname;
		this.cconment = cconment;
		this.ccdate = ccdate;
		this.c_id = c_id;
	}
	public int getCcid() {
		return ccid;
	}
	public void setCcid(int ccid) {
		this.ccid = ccid;
	}
	public String getSnickname() {
		return snickname;
	}
	public void setSnickname(String snickname) {
		this.snickname = snickname;
	}
	public String getCconment() {
		return cconment;
	}
	public void setCconment(String cconment) {
		this.cconment = cconment;
	}
	public String getCcdate() {
		return ccdate;
	}
	public void setCcdate(String ccdate) {
		this.ccdate = ccdate;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	@Override
	public String toString() {
		return "CourseComment [ccid=" + ccid + ", snickname=" + snickname
				+ ", cconment=" + cconment + ", ccdate=" + ccdate + ", c_id="
				+ c_id + "]";
	}
	
	
	
}
