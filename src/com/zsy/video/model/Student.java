package com.zsy.video.model;
/**
 * 学员类
 * @author 
 *
 */
public class Student {
	//主键
	private int sid;
	//真实姓名
	private String srealname;
	//昵称
	private String snickname;
	//密码
	private String spassword;
	//学校
	private String school;
	//区域
	private String sarea;
	//年纪
	private String sgrade;
	//手机号码
	private String sphone;
	//电子邮箱
	private String semail;
	//QQ
	private String sqq;
	//头像
	private String simage;
	public Student() {
		
	}
	public Student(int sid, String srealname, String snickname,
			String spassword, String school, String sarea, String sgrade,
			String sphone, String semail, String sqq, String simage) {
		super();
		this.sid = sid;
		this.srealname = srealname;
		this.snickname = snickname;
		this.spassword = spassword;
		this.school = school;
		this.sarea = sarea;
		this.sgrade = sgrade;
		this.sphone = sphone;
		this.semail = semail;
		this.sqq = sqq;
		this.simage = simage;
	}
	
	
	
	public Student(String snickname, String spassword, String semail) {
		super();
		this.sid = 0;
		this.snickname = snickname;
		this.spassword = spassword;
		this.semail = semail;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSrealname() {
		return srealname;
	}
	public void setSrealname(String srealname) {
		this.srealname = srealname;
	}
	public String getSnickname() {
		return snickname;
	}
	public void setSnickname(String snickname) {
		this.snickname = snickname;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getSarea() {
		return sarea;
	}
	public void setSarea(String sarea) {
		this.sarea = sarea;
	}
	public String getSgrade() {
		return sgrade;
	}
	public void setSgrade(String sgrade) {
		this.sgrade = sgrade;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getSqq() {
		return sqq;
	}
	public void setSqq(String sqq) {
		this.sqq = sqq;
	}
	public String getSimage() {
		return simage;
	}
	public void setSimage(String simage) {
		this.simage = simage;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", srealname=" + srealname
				+ ", snickname=" + snickname + ", spassword=" + spassword
				+ ", school=" + school + ", sarea=" + sarea + ", sgrade="
				+ sgrade + ", sphone=" + sphone + ", semail=" + semail
				+ ", sqq=" + sqq + ", simage=" + simage + "]";
	}
	
	
	
}
