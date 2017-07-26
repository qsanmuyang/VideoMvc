<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap - Prebuilt Layout</title>

<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/MK-I.css" rel="stylesheet">

</head>
<body>
	<div class="navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="javascript::" class="navbar-brand">Brand</a>
				<div class="right-nav">
					<ul class="nav navbar-nav">
					<c:choose>
					<c:when test="${empty LOGIN }">
					<li class="active"><a href="login.jsp">登录<span class="sr-only">(current)</span></a></li>
					<li><a href="register.jsp">注册</a></li>
					</c:when>
					<c:otherwise>
					<!--登陆成功后-->
					<li class="active"><span class="text-success" style="line-height: 50px;">欢迎您，（${LOGIN }）</span></li>
					<li><a href="servlet/student.do?opr=exit">注销</a></li>
                    </c:otherwise>
                    </c:choose>
                    <li><a href="video-list.jsp">视频列表</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">我的课程<span class="caret"></span></a>
					  <ul class="dropdown-menu" role="menu">
					  
						<li><a href="servlet/student.do?opr=stuInfo">个人中心</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					  </ul>
					</li>
				  </ul>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container-fluid" style="margin-top: 100px;">
		<div class="row">
			<div class="col-md-6 col-md-offset-3" id="slider" style="margin-left: 10%; width: 80%;height: 460px;overflow: hidden">
	  			<div class="banner" id="banner-bg">
	  				<div id="banner-img" style="background-image: url(images/01.jpg);"></div>
	  			</div>
		  		<div class="navbar-left" style="position: absolute; left: 0;">
		  			<ul class="list-group" style="height: 100%;">
		  				<li name="l-list" class="light" onMouseOver="take(0)">list-group-items</li>
		  				<li name="l-list" class="dark" onMouseOver="take(1)">list-group-items</li>
		  				<li name="l-list" class="dark" onMouseOver="take(2)">list-group-items</li>
		  				<li name="l-list" class="dark" onMouseOver="take(3)">list-group-items</li>
		  				<li name="l-list" class="dark" onMouseOver="take(4)">list-group-items</li>
		  			</ul>
		  		</div>
			</div>
		</div>
		
		<div class="m-container" style="margin-top: 20px;">
			<div class="m-title">
				<span>课程推荐</span><!--收费课程-->
				<a href="">更多&nbsp;&raquo;</a>
			</div>
			
			<!--标题、介绍和价格来自数据库-->
			<!--caption中为可插入部分-->
			 <div class="row" id="noFree">
			</div>
		</div>
		
		<div class="m-container" style="margin-top: 20px;">
		<div class="m-title">
			<span>免费资源</span>
			<a href="">更多&nbsp;&raquo;</a>
		</div>
		<!--标题和介绍来自数据库-->
		<!--caption中为可插入部分-->
		<div class="row" id="free">
			
		</div>
		</div>
		
		<div class="m-container">
			<div class="m-title">
				<span>语文</span>
				<a href="">更多&nbsp;&raquo;</a>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="thumbnail" style="height: 352px; background-image: url(images/12.jpg);background-size: cover;">
					</div>
				</div>
				<div class="col-md-6" id="cnCourse">
					<div class="thumbnail" style="height: 100px; background-image: url(images/s-title.jpg);background-size: 100%;"> 
						
					</div>
				</div>
				
				<div class="col-md-3">
					<div class="thumbnail" style="height: 352px;">
						<div class="caption">
							<img src="images/b_01.jpg" style="width: 100%;">
							<p class="text-primary">各版本各年级语文教材同步精讲，有效巩固课上教师所讲内容，搭配课后练习，强化记忆。</p>
							<button class="btn btn-info" style="width: 100%">查看</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="m-container">
			<div class="m-title">
				<span>数学</span>
				<a href="">更多&nbsp;&raquo;</a>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="thumbnail" style="height: 352px; background-image: url(images/math.jpg);background-size: cover;"></div>
				</div>
				<div class="col-md-9" id="MathCourse">
					<div class="thumbnail" style="height: 100px;background-image: url(images/m-title.jpg);">
					</div>
				</div>
			</div>
		</div>
		
		<div class="m-container">
			<div class="m-title">
				<span>英语</span>
				<a href="">更多&nbsp;&raquo;</a>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="thumbnail" style="height: 352px;background-image: url(images/english.jpg);background-size: cover;"></div>
				</div>
				
				<div class="col-md-6" id="EnglishCourse">
					<div class="thumbnail" style="height: 100px; background-image: url(images/s-title-1.jpg);background-size: 100%;"> 
						
					</div>
				</div>
				
				<div class="col-md-3">
					<div class="thumbnail" style="height: 352px;">
						<div class="caption">
							<img src="images/b_01.jpg" style="width: 100%;">
							<p class="text-primary">同步上海牛津版教材，课后精炼，听力练习，单词跟读，一步到位。</p>
							<button class="btn btn-info" style="width: 100%">查看</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!--教师信息来自数据库-->
		<!--仅提取教师姓名、教学科目和学历分类-->
		<div class="m-container">
			<div class="m-title">
				<span>名师推荐</span>
				<a href="">更多&nbsp;&raquo;</a>
			</div>
			<div class="row" id="teaList">
					
			</div>
		</div>
		<div class="row">
			<div class="divider"></div>
			<div class="text-center col-md-6 col-md-offset-3">
			  <h4>Footer</h4>
			  <p>Copyright &copy; 2017 &middot; All Rights Reserved &middot;</p>
			</div>
		</div>
	</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script src="js/jquery-3.2.1.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed --> 
<script src="js/bootstrap.js"></script>
<script type="text/javascript">
	var n = 0;
	var t = 0;
	var num= 0;
	var list = $("li[name='l-list']");
	var imgArr=["images/01.jpg","images/02.jpg","images/03.jpg","images/04.jpg","images/05.jpg"];
	$(document).ready(function(){
		
		t = setInterval("change()",4000);
	})
	
	function change(){
		for(var i=0;i<list.length;i++){
			list[i].className="dark";
		}
		
		$("#banner-img").css("background-image","url("+imgArr[num]+")");
		
		
		list[num].className="light";
		if(num==4){
			num=0;
		}else{
			num++;
		}
	}
	
	$("#slider").mouseover(function(){
		clearInterval(t);
	})
	
	$("#slider").mouseleave(function(){
		t = setInterval("change()",4000);
	})
	
	function take(number){
		num =number;
		$("#banner-img").css("background-image","url("+imgArr[num]+")");
		for(var i=0;i<list.length;i++){
			list[i].className="dark";
		}
		list[num].className="light";
	}
	window.onload=function(){
	if("${msg}"!=""&&"${msg}"!=null){
	alert("${msg}");
	}
	
	CourseList();
	TeacherList();
	}
	function TeacherList(){
	var url="servlet/teacherAjax.do?opr=teacherList";
	$.get(url,function(map){
	var teaList=map.teaList;
	for(var i=0;i<6;i++){
	$("#teaList").append("<div class='col-md-2'><div class='thumbnail' style='height: 254px;'>"+
	"<div class='caption'><div class='head-img' style='background-image: url("+teaList[i].timage+"); background-size: cover;'></div><div class='name'><h3>"+teaList[i].trealname+"</h3></div>"+
	"<div class='teacher-detail'><span class='text-info'>"+teaList[i].teducation+"</span></div>"+
	"<button class='btn btn-primary' style='margin-top: 10px; width:100%;'>咨询</button></div></div></div>");	
	}
	},"json");
		
	
	}
	
	function CourseList(){
	var url="servlet/courseAjax.do?opr=courseList";
	$.get(url,function(map){
	var nofreeList=map.nofreeCourse;
	for(var i=0;i<6;i++){
	$("#noFree").append("<div class='col-sm-6 col-md-4'><div class='thumbnail' style='height: 218px;'>"+
	"<div class='couser-card-top'></div><div class='caption'><h3>"+nofreeList[i].cname+"</h3>"+
	"<p>"+nofreeList[i].cintro+"</p>"+
	"<p style='position: absolute;bottom: 9px;'><a href='#' class='btn btn-primary' role='button'>¥"+nofreeList[i].cprice+"</a>"+
	" <a href='servlet/course.do?opr=videoInfo&id="+nofreeList[i].c_id+"' class='btn btn-default' role='button'>了解详情</a></p></div></div></div>");
	}
	var freeList=map.freeCourse;
	for(var i=0;i<6;i++){
	$("#free").append("<div class='col-sm-6 col-md-4'><div class='thumbnail' style='height: 218px;'>"+
	"<div class='couser-card-top1'></div><div class='caption'><h3>"+freeList[i].cname+"</h3>"+
	"<p>"+freeList[i].cintro+"</p>"+
	"<p style='position: absolute;bottom: 9px;'><a href='#' class='btn btn-primary' role='button'>免费</a>"+
	" <a href='servlet/course.do?opr=videoInfo&id="+freeList[i].c_id+"' class='btn btn-default' role='button'>了解详情</a></p></div></div></div>");
	}
	var ChineseCouList=map.ChineseCouList;
	for(var i=0;i<2;i++){
	$("#cnCourse").append("<div class='col-md-6'><div class='thumbnail' style='height: 232px;'>"+
	"<div class='couser-card-top2'></div><div class='caption'><p class='text-success'>"+ChineseCouList[i].cname+"</p>"+
	"<p>"+ChineseCouList[i].cintro+"</p>"+
	"<p style='position: absolute;bottom: 9px;'><a href='servlet/course.do?opr=videoInfo&id="+ChineseCouList[i].c_id+"' class='btn btn-success' role='button'>开始学习</a>"+
	" </p></div></div></div>");
	}
	var MathCouList=map.MathCouList;
	for(var i=0;i<3;i++){
	$("#MathCourse").append("<div class='col-md-4'><div class='thumbnail' style='height: 232px;'>"+
	"<div class='couser-card-top3'></div><div class='caption'><p class='text-success'>"+MathCouList[i].cname+"</p>"+
	"<p>"+MathCouList[i].cintro+"</p>"+
	"<p style='position: absolute;bottom: 9px;'><a href='servlet/course.do?opr=videoInfo&id="+MathCouList[i].c_id+"' class='btn btn-success' role='button'>开始学习</a>"+
	" </p></div></div></div>");
	}
	var EnglishCouList=map.EnglishCouList;
	for(var i=0;i<2;i++){
	$("#EnglishCourse").append("<div class='col-md-6'><div class='thumbnail' style='height: 232px;'>"+
	"<div class='couser-card-top4'></div><div class='caption'><p class='text-success'>"+EnglishCouList[i].cname+"</p>"+
	"<p>"+EnglishCouList[i].cintro+"</p>"+
	"<p style='position: absolute;bottom: 9px;'><a href='servlet/course.do?opr=videoInfo&id="+EnglishCouList[i].c_id+"' class='btn btn-success' role='button'>开始学习</a>"+
	" </p></div></div></div>");
	}
	},"json");
	}
</script>
</body>
</html>


