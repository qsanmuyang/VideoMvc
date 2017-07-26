package com.zsy.video.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zsy.video.biz.impl.ChapterBizImpl;
import com.zsy.video.biz.impl.ChapterCommentBizImpl;
import com.zsy.video.biz.impl.CourseBizImpl;
import com.zsy.video.biz.impl.VideoBizImpl;
import com.zsy.video.model.Chapter;
import com.zsy.video.model.ChapterComment;
import com.zsy.video.model.Course;
import com.zsy.video.model.Video;

@Controller
@RequestMapping("/servlet")
public class CourseController {
	@Autowired
	private CourseBizImpl cBizImpl;
	
	private ChapterBizImpl cBizImpl2;
	
	private ChapterCommentBizImpl chapterCommentBizImpl;
	
	private VideoBizImpl vBizImpl;
	public void setcBizImpl(CourseBizImpl cBizImpl) {
		this.cBizImpl = cBizImpl;
	}
	
	public void setcBizImpl2(ChapterBizImpl cBizImpl2) {
		this.cBizImpl2 = cBizImpl2;
	}

	public void setvBizImpl(VideoBizImpl vBizImpl) {
		this.vBizImpl = vBizImpl;
	}
	
	public void setChapterCommentBizImpl(ChapterCommentBizImpl chapterCommentBizImpl) {
		this.chapterCommentBizImpl = chapterCommentBizImpl;
	}

	@RequestMapping("/course.do")
	public String courseManage(HttpServletRequest request){
		HttpSession session = request.getSession();
		String opr=request.getParameter("opr");
		if(opr.equals("videoInfo")){
			String c_id1=request.getParameter("id");
			int c_id=Integer.parseInt(c_id1);
			List<Chapter> chapters = new ArrayList<Chapter>();
			chapters=cBizImpl2.getChaptersByCid(c_id);
			for (Chapter chapter : chapters) {
				List<Video> videos=new ArrayList<Video>();
				int cptid=chapter.getCptid();
				videos=vBizImpl.getVideosByCptid(cptid);
				chapter.setVideos(videos);
			}
			Course course=new Course();
			course=cBizImpl.getCourseByCid(c_id);
			session.setAttribute("chapters", chapters);
			session.setAttribute("course", course);
			return "redirect:/coursedata.jsp";
		}else if(opr.equals("openVideo")){
			String vid1=request.getParameter("vid");
			int vid=Integer.parseInt(vid1);
			Video video=new Video();
			video=vBizImpl.getVideoByVid(vid);
			List<ChapterComment> videoComments=new ArrayList<ChapterComment>();
			videoComments=chapterCommentBizImpl.getCommentsByVid(vid);
			session.setAttribute("videoComments", videoComments);
			session.setAttribute("video", video);
			return "redirect:/video.jsp";
		}
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/courseAjax.do")
	@ResponseBody
	public Map<Object, Object> ajaxManage(HttpServletRequest request){
		Map<Object, Object> map=new HashMap<Object, Object>();
		String opr=request.getParameter("opr");
		HttpSession session = request.getSession();
		session.removeAttribute("msg");
		if(opr.equals("courseList")){
			List<Course> noFreeCouList=new ArrayList<Course>();
			List<Course> FreeCouList=new ArrayList<Course>();
			List<Course> ChineseCouList=new ArrayList<Course>();
			List<Course> MathCouList=new ArrayList<Course>();
			List<Course> EnglishCouList=new ArrayList<Course>();
			noFreeCouList=cBizImpl.getNoFreeCourse();
			FreeCouList=cBizImpl.getFreeCourse();
			ChineseCouList=cBizImpl.getSubjectCourses("语文");
			MathCouList=cBizImpl.getSubjectCourses("数学");
			EnglishCouList=cBizImpl.getSubjectCourses("英语");
			map.put("nofreeCourse", noFreeCouList);
			map.put("freeCourse", FreeCouList);
			map.put("ChineseCouList", ChineseCouList);
			map.put("MathCouList", MathCouList);
			map.put("EnglishCouList", EnglishCouList);
		}else if(opr.equals("videoList")){
			List<Course> allCouList=new ArrayList<Course>();
			List<Course> allCouList1=new ArrayList<Course>();
			String grade=request.getParameter("grade");
			String sub=request.getParameter("sub");
			if(grade.equals("m1")){
				grade="初一";
			}else if(grade.equals("m2")){
				grade="初二";
			}else if(grade.equals("m3")){
				grade="初三";
			}else if(grade.equals("h1")){
				grade="高一 ";
			}else if(grade.equals("h2")){
				grade="高二";
			}else if(grade.equals("h3")){
				grade="高三";
			}else{
				grade="g-all";
			}
			if(sub.equals("cn")){
				sub="语文";
			}else if(sub.equals("math")){
				sub="数学";
			}else if(sub.equals("en")){
				sub="英语";
			}else if(sub.equals("pol")){
				sub="政治";
			}else if(sub.equals("his")){
				sub="历史";
			}else if(sub.equals("geo")){
				sub="地理";
			}else if(sub.equals("phy")){
				sub="物理";
			}else if(sub.equals("chem")){
				sub="化学";
			}else if(sub.equals("bio")){
				sub="生物";
			}else{
				sub="s-all";
			}
			Map<Object, Object> map1=new HashMap<Object, Object>();
			String currentPage1=request.getParameter("currentPage");
			int pageNum=8;
			int currentPage=Integer.parseInt(currentPage1);
			int pages=0;
			int begin=0;
			map1.put("pageNum", pageNum);
			if(sub.equals("s-all") && grade.equals("g-all")){
				allCouList=cBizImpl.getCourses();
				begin=cBizImpl.countBeginPosition(currentPage, pageNum);
				pages=cBizImpl.countPage(pageNum, allCouList);
				map1.put("begin", begin);
				allCouList1=cBizImpl.getCourses1(map1);
			}else if(sub.equals("s-all") && !grade.equals("g-all")){
				map1.put("grade", grade);
				allCouList=cBizImpl.getCoursesByGrade(grade);
				begin=cBizImpl.countBeginPosition(currentPage, pageNum);
				pages=cBizImpl.countPage(pageNum, allCouList);
				map1.put("begin", begin);
				allCouList1=cBizImpl.getCoursesByGrade1(map1);
			}else if(!sub.equals("s-all") && grade.equals("g-all")){
				map1.put("subject", sub);
				allCouList=cBizImpl.getSubjectCourses(sub);
				begin=cBizImpl.countBeginPosition(currentPage, pageNum);
				pages=cBizImpl.countPage(pageNum, allCouList);
				map1.put("begin", begin);
				allCouList1=cBizImpl.getSubjectCourses1(map1);
			}else{
				map1.put("subject", sub);
				map1.put("grade", grade);
				allCouList=cBizImpl.getVideoList(map1);
				begin=cBizImpl.countBeginPosition(currentPage, pageNum);
				map1.put("begin", begin);
				pages=cBizImpl.countPage(pageNum, allCouList);
				allCouList1=cBizImpl.getVideoList1(map1);
			}
			map.put("pages", pages);
			map.put("allCouList", allCouList1);
		}
		return map;
	}
	
	@RequestMapping("/chapterCommentAjax.do")
	@ResponseBody
	public Map<Object, Object> chapterCommentAjax(HttpServletRequest request){
		Map<Object, Object> map = new HashMap<Object, Object>();
		HttpSession session = request.getSession();
		String opr = request.getParameter("opr");
		if(opr.equals("addComment")){
			String vid1 = request.getParameter("vid");
			int vid = Integer.parseInt(vid1);
			String snickname = (String) session.getAttribute("LOGIN");
			String ccontent = request.getParameter("ccontent");
			Date date = new Date();
			String cdate = date.toLocaleString();
			cdate=cBizImpl.translateDate(cdate);
			System.out.println(cdate);
			ChapterComment comment = new ChapterComment(snickname, ccontent, cdate, vid);
			int num = chapterCommentBizImpl.addComment(comment);
			if(num>0){
				map.put("videoComment", comment);
			}
			
		}
		return map;
	}
}
