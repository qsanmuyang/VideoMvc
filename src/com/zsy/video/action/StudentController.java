package com.zsy.video.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zsy.video.biz.impl.StudentBizImpl;
import com.zsy.video.model.Student;

@Controller
@RequestMapping("/servlet")
public class StudentController {
	@Autowired
	private StudentBizImpl sBizImpl;

	public void setsBizImpl(StudentBizImpl sBizImpl) {
		this.sBizImpl = sBizImpl;
	}


	@RequestMapping("/student.do")
	public String studentManage(HttpServletRequest request,HttpServletResponse response){
		String opr=request.getParameter("opr");
		HttpSession session=request.getSession();
		if(opr.equals("login")){
			String snickname=request.getParameter("snickname");
			String spassword=request.getParameter("spassword");
			String autoLogin=request.getParameter("autoLogin");
			if(autoLogin!=null){
				Cookie uname = new Cookie("snickname",snickname);
				  Cookie upwd = new Cookie("spassword",spassword);
				  int day5 = 60 * 60 * 24 * 5;
				  uname.setMaxAge(day5);
				  upwd.setMaxAge(day5);
				  uname.setPath("/");
				  upwd.setPath("/");
				  response.addCookie(uname);
				  response.addCookie(upwd);
			}
			Map<String, String> map=new HashMap<String, String>();
			map.put("snickname", snickname);
			map.put("spassword", spassword);
			if(sBizImpl.login(map)){
				session.setAttribute("LOGIN", snickname);
				return "redirect:/index.jsp";
			}
		}else if(opr.equals("reg")){
			String snickname=request.getParameter("snickname");
			String spassword=request.getParameter("spassword");
			String semail=request.getParameter("semail");
			Student student=new Student(snickname, spassword, semail);
			int num=sBizImpl.addStudent(student);
			if(num>0){
				return "redirect:/index.jsp";
			}else{
				return "redirect:/register.jsp";
			}
		}else if(opr.equals("exit")){
			session.removeAttribute("LOGIN");
			Cookie [] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				return "redirect:/index.jsp";
			}
		}else if(opr.equals("stuInfo")){
			String snickname=(String) session.getAttribute("LOGIN");
			Student student = new Student();
			student=sBizImpl.getStudentByName(snickname);
			session.setAttribute("studentInfo", student);
			return "redirect:/studentInfo.jsp";
		}else if(opr.equals("exitStu")){
			String snickname=(String) session.getAttribute("LOGIN");
			String semail = request.getParameter("semail");
			String sqq=request.getParameter("sqq");
			String sphone = request.getParameter("sphone");
			String school = request.getParameter("school");
			String sarea = request.getParameter("sarea");
			String sgrade = request.getParameter("sgrade");
			String srealname = request.getParameter("srealname");
			Student student = new Student();
			student = sBizImpl.getStudentByName(snickname);
			student.setSemail(semail);
			student.setSqq(sqq);
			student.setSphone(sphone);
			student.setSchool(school);
			student.setSarea(sarea);
			student.setSgrade(sgrade);
			student.setSrealname(srealname);
			int num = sBizImpl.updateStudent(student);
			if(num>0){
				session.setAttribute("studentInfo", student);
				return "redirect:/studentInfo.jsp";
			}else{
				return "redirect:/studentInfo.jsp";
			}
		}else if(opr.equals("exitPaw")){
			String snickname=(String) session.getAttribute("LOGIN");
			String oldPaw=request.getParameter("paw1");
			String newPaw = request.getParameter("paw2");
			Student student = new Student();
			student = sBizImpl.getStudentByName(snickname);
			if(oldPaw.equals(student.getSpassword())){
				student.setSpassword(newPaw);
				int num = sBizImpl.updateStudent(student);
				session.setAttribute("msg1", "修改成功！");
				return "redirect:/studentInfo.jsp";
			}else{
				session.setAttribute("msg1", "旧密码不正确，请重新输入！");
				return "redirect:/studentInfo.jsp";
				
			}
		}
		return "redirect:/login.jsp";
	}
	@RequestMapping("/student1.do")
	public String studentManage1(HttpServletRequest request,HttpServletResponse response){
		String opr=request.getParameter("opr");
		HttpSession session=request.getSession();
		if(opr.equals("exit")){
			session.removeAttribute("LOGIN");
			Cookie [] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				return "redirect:/video-list.jsp";
			}
		}
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("/studentAjax.do")
	@ResponseBody
	public Map<Object, Object> ajaxManage(HttpServletRequest request){
		String opr=request.getParameter("opr");
		HttpSession session=request.getSession();
		session.removeAttribute("msg");
		Map<Object, Object> map=new HashMap<Object, Object>();
		if(opr.equals("checkName")){
			String snickname=request.getParameter("snickname");
			if(!sBizImpl.findStudent(snickname)){
				map.put("flag", "false");
			}else{
				map.put("flag", "true");
			}
		}
		return map;
	}
	
	
}
