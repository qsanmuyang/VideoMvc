package com.zsy.video.model;
/**
 * 教员类
 * @author 
 *
 */
public class Teacher {
	//主键
	private int tid;
	//真实姓名
	private String trealname;
	//昵称
	private String tnickname;
	//密码
	private String tpassword;
	//学校
	private String school;
	//区域
	private String tarea;
	//手机号码
	private String tphone;
	//电子邮箱
	private String temail;
	//QQ
	private String tqq;
	//学历
	private String teducation;
	//课程
	private String tcourse;
	//经验
	private String texperience;
	//头像
	private String timage;
	
	public Teacher() {
		
	}
	
	public Teacher(String tnickname, String tpassword, String tphone,
			String temail, String teducation, String tcourse) {
		super();
		this.tid=0;
		this.tnickname = tnickname;
		this.tpassword = tpassword;
		this.tphone = tphone;
		this.temail = temail;
		this.teducation = teducation;
		this.tcourse = tcourse;
	}
	
	public Teacher(int tid, String trealname, String tnickname,
			String tpassword, String school, String tarea, String tphone,
			String temail, String tqq, String teducation, String tcourse,
			String texperience, String timage) {
		super();
		this.tid = tid;
		this.trealname = trealname;
		this.tnickname = tnickname;
		this.tpassword = tpassword;
		this.school = school;
		this.tarea = tarea;
		this.tphone = tphone;
		this.temail = temail;
		this.tqq = tqq;
		this.teducation = teducation;
		this.tcourse = tcourse;
		this.texperience = texperience;
		this.timage = timage;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTrealname() {
		return trealname;
	}

	public void setTrealname(String trealname) {
		this.trealname = trealname;
	}

	public String getTnickname() {
		return tnickname;
	}

	public void setTnickname(String tnickname) {
		this.tnickname = tnickname;
	}

	public String getTpassword() {
		return tpassword;
	}

	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public String getTphone() {
		return tphone;
	}

	public void setTphone(String tphone) {
		this.tphone = tphone;
	}

	public String getTemail() {
		return temail;
	}

	public void setTemail(String temail) {
		this.temail = temail;
	}

	public String getTqq() {
		return tqq;
	}

	public void setTqq(String tqq) {
		this.tqq = tqq;
	}

	public String getTeducation() {
		return teducation;
	}

	public void setTeducation(String teducation) {
		this.teducation = teducation;
	}

	public String getTcourse() {
		return tcourse;
	}

	public void setTcourse(String tcourse) {
		this.tcourse = tcourse;
	}

	public String getTexperience() {
		return texperience;
	}

	public void setTexperience(String texperience) {
		this.texperience = texperience;
	}

	public String getTimage() {
		return timage;
	}

	public void setTimage(String timage) {
		this.timage = timage;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", trealname=" + trealname
				+ ", tnickname=" + tnickname + ", tpassword=" + tpassword
				+ ", school=" + school + ", tarea=" + tarea + ", tphone="
				+ tphone + ", temail=" + temail + ", tqq=" + tqq
				+ ", teducation=" + teducation + ", tcourse=" + tcourse
				+ ", texperience=" + texperience + ", timage=" + timage + "]";
	}
	
	
}
