package com.zsy.video.model;

import java.util.List;

/**
 * 
 * @author 钟森阳
 *
 */
public class Course {
	private int c_id;
	private String cname;
	private String cintro;
	private String grade;
	private String tname;
	private double cprice;
	private String subject;
	private List<Video> videos;
	public Course() {

	}
	public Course(int c_id, String cname, String cintro, String grade,
			String tname, double cprice, String subject) {
		super();
		this.c_id = c_id;
		this.cname = cname;
		this.cintro = cintro;
		this.grade = grade;
		this.tname = tname;
		this.cprice = cprice;
		this.subject = subject;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCintro() {
		return cintro;
	}
	public void setCintro(String cintro) {
		this.cintro = cintro;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public double getCprice() {
		return cprice;
	}
	public void setCprice(double cprice) {
		this.cprice = cprice;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	@Override
	public String toString() {
		return "Course [c_id=" + c_id + ", cname=" + cname + ", cintro="
				+ cintro + ", grade=" + grade + ", tname=" + tname
				+ ", cprice=" + cprice + ", subject=" + subject + "]";
	}
	
	
	
	
}
