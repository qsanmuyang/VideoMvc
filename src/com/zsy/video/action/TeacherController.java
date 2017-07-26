package com.zsy.video.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zsy.video.biz.impl.TeacherBizImpl;
import com.zsy.video.model.Student;
import com.zsy.video.model.Teacher;

@Controller
@RequestMapping("/servlet")
public class TeacherController {
	@Autowired
	private TeacherBizImpl tBizImpl;

	public void settBizImpl(TeacherBizImpl tBizImpl) {
		this.tBizImpl = tBizImpl;
	}
	
	@RequestMapping("/teacher.do")
	public String teacherManager(HttpServletRequest request,HttpServletResponse response){
		String opr=request.getParameter("opr");
		HttpSession session=request.getSession();
		if(opr.equals("login")){
			String tnickname=request.getParameter("tnickname");
			String tpassword=request.getParameter("tpassword");
			String autoLogin=request.getParameter("autoLogin");
			if(autoLogin!=null){
				Cookie uname = new Cookie("snickname",tnickname);
				  Cookie upwd = new Cookie("spassword",tpassword);
				  int day5 = 60 * 60 * 24 * 5;
				  uname.setMaxAge(day5);
				  upwd.setMaxAge(day5);
				  uname.setPath("/");
				  upwd.setPath("/");
				  response.addCookie(uname);
				  response.addCookie(upwd);
			}
			Map<String, String> map=new HashMap<String, String>();
			map.put("tnickname", tnickname);
			map.put("tpassword", tpassword);
			if(tBizImpl.login(map)){
				Teacher teacher = new Teacher();
				teacher = tBizImpl.getTeacherByName(tnickname);
				session.setAttribute("teacherInfo", teacher);
				session.setAttribute("TLOGIN", tnickname);
				
				
				return "redirect:/teacherInfo.jsp";
				
			}
		}else if(opr.equals("reg")){
			String tnickname=request.getParameter("tnickname");
			String tpassword=request.getParameter("tpassword");
			String tphone=request.getParameter("tphone");
			String temail=request.getParameter("temail");
			String teducation=request.getParameter("teducation");
			String tcourse=request.getParameter("tcourse");
			Teacher teacher=new Teacher(tnickname, tpassword, tphone, temail, teducation, tcourse);
			int num=tBizImpl.addTeacher(teacher);
			if(num>0){
				return "redirect:/teacherInfo.jsp";
			}else{
				return "redirect:/register.jsp";
			}
		}else if(opr.equals("exitTea")){
			String tnickname=(String) session.getAttribute("TLOGIN");
			String temail = request.getParameter("temail");
			String tqq=request.getParameter("tqq");
			String tphone = request.getParameter("tphone");
			String teducation=request.getParameter("teducation");
			String tcourse = request.getParameter("tcourse");
			String texperience = request.getParameter("texperience");
			String school = request.getParameter("school");
			String tarea = request.getParameter("tarea");
			String trealname = request.getParameter("trealname");
			Teacher teacher = new Teacher();
			teacher = tBizImpl.getTeacherByName(tnickname);
			teacher.setTemail(temail);
			teacher.setTqq(tqq);
			teacher.setTphone(tphone);
			teacher.setTeducation(teducation);
			teacher.setTcourse(tcourse);
			teacher.setTexperience(texperience);
			teacher.setSchool(school);
			teacher.setTarea(tarea);
			teacher.setTrealname(trealname);
			int num = tBizImpl.updateTeacher(teacher);
			if(num>0){
				session.setAttribute("teacherInfo", teacher);
				return "redirect:/teacherInfo.jsp";
			}else{
				return "redirect:/teacherInfo.jsp";
			}
		}else if(opr.equals("exitPaw")){
			String tnickname=(String) session.getAttribute("TLOGIN");
			String oldPaw=request.getParameter("paw1");
			String newPaw = request.getParameter("paw2");
			Teacher teacher = new Teacher();
			teacher = tBizImpl.getTeacherByName(tnickname);
			if(oldPaw.equals(teacher.getTpassword())){
				teacher.setTpassword(newPaw);
				int num = tBizImpl.updateTeacher(teacher);
				return "redirect:/teacherInfo.jsp";
			}else{
				return "redirect:/teacherInfo.jsp";
				
			}
		}
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("/teacherAjax.do")
	@ResponseBody
	public Map<Object, Object> ajaxManage(HttpServletRequest request){
		HttpSession session=request.getSession();
		session.removeAttribute("msg");
		Map<Object, Object> map = new HashMap<Object, Object>();
		String opr=request.getParameter("opr");
		if(opr.equals("teacherList")){
			List<Teacher> teaList = new ArrayList<Teacher>();
			teaList=tBizImpl.getTeachers();
			map.put("teaList", teaList);
		}else if(opr.equals("checkName")){
			String tnickname=request.getParameter("tnickname");
			if(!tBizImpl.findTeacher(tnickname)){
				map.put("flag", "false");
			}else{
				map.put("flag", "true");
			}
		}
		return map;
	}
	
}
