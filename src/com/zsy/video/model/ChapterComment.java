package com.zsy.video.model;

public class ChapterComment {
	private int cid;
	private String snickname;
	private String ccontent;
	private String cdate;
	private int vid;
	public ChapterComment() {
		
	}
	public ChapterComment(int cid, String snickname, String ccontent,
			String cdate, int vid) {
		super();
		this.cid = cid;
		this.snickname = snickname;
		this.ccontent = ccontent;
		this.cdate = cdate;
		this.vid = vid;
	}
	
	public ChapterComment(String snickname, String ccontent, String cdate,
			int vid) {
		super();
		this.snickname = snickname;
		this.ccontent = ccontent;
		this.cdate = cdate;
		this.vid = vid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getSnickname() {
		return snickname;
	}
	public void setSnickname(String snickname) {
		this.snickname = snickname;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	@Override
	public String toString() {
		return "ChapterComment [cid=" + cid + ", snickname=" + snickname
				+ ", ccontent=" + ccontent + ", cdate=" + cdate + ", vid="
				+ vid + "]";
	}
	
}
