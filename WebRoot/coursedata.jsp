<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>课程详情</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap -->
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
                    <li><a href="index.jsp">首页</a></li>
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
	
	<div class="container-fluid">
		<div class="row">
			<div class="data-bg">
				<div class="col-lg-6">
					<h1 style="color: white;">${course.cname }</h1>
					<span>主讲人：&nbsp;</span><span>${course.tname }</span>
				</div>
				<div class="col-md-6">
					<p>课程简介：</p>
					<p>${course.cintro }</p>
				</div>
			</div>
		</div>
		
		<div class="row" style="margin-top: 20px;">
			<div class="col-md-9">
				<div class="switch-tab">
					<span class="text-primary pointerspan" id="clist">课程列表</span>&nbsp;|&nbsp;<span class="text-primary  pointerspan" id="comlist">评论</span>
				
					<div class="angel" id="angel"></div>
					
				</div>
				<div class="sl-container">
					<div class="slider-container" id="slicontainer">
						<div class="chapter-container">
							<ul class="data-list">
							<c:forEach items="${chapters }" var="chapter" varStatus="a">
								<li class="list-group-item-info chapter">${chapter.chaptername}</li>
								<li>
									<ul>
									<c:forEach items="${chapter.videos }" var="video">
										<li><a href="servlet/course.do?opr=openVideo&vid=${video.vid }" class="list-group-item">${video.vname }</a></li>
									</c:forEach>
										
									</ul>
								</li>
							</c:forEach>
							</ul>
						</div>
						
						<div class="commit-container">
							<div class="panel panel-primary">
								<div class="panel-heading">
									评论
								</div>
								<div class="panel-body">
									<div class="media">
									  <div class="media-left">
										<a href="#">
										  <div class="user-head"></div>
										</a>
									  </div>
									  <div class="media-body">
										<h4 class="media-heading">${LOGIN }</h4>
										<textarea style="width: 100%;height: 100px;" placeholder="看点槽点，不吐不快！别憋着，想说什么就说出来吧！"></textarea>
										<div class="right-btn btn btn-primary">提交评论</div>
									  </div>
									</div>
									<hr>
									<div class="media">
									  <div class="media-left">
										<a href="#">
										  <div class="user-head"></div>
										</a>
									  </div>
									  <div class="media-body">
										<h4 class="media-heading">匿名用户</h4>
										<p>看完之后受益良多！</p>
										<a href="javascript::" class="flip">回复</a>
										<div class="toogle">
											<textarea style="width: 100%;height: 100px;" placeholder="看点槽点，不吐不快！别憋着，想说什么就说出来吧！"></textarea>
											<div class="right-btn btn btn-primary">提交评论</div>
										</div>
									  </div>
									</div>
									<div class="media">
									  <div class="media-left">
										<a href="#">
										  <div class="user-head"></div>
										</a>
									  </div>
									  <div class="media-body">
										<h4 class="media-heading">Nick</h4>
										<p>有没有人跟我一样，看到5分钟多的时候直接奔溃了~</p>
										<a href="javascript::" class="flip">回复</a>
										<div class="toogle">
											<textarea style="width: 100%;height: 100px;" placeholder="看点槽点，不吐不快！别憋着，想说什么就说出来吧！"></textarea>
											<div class="right-btn btn btn-primary">提交评论</div>
										</div>
									  </div>
									</div>
									<div class="media">
									  <div class="media-left">
										<a href="#">
										  <div class="user-head"></div>
										</a>
									  </div>
									  <div class="media-body">
										<h4 class="media-heading">我是谁</h4>
										<p>一般的企业站优化也就这些内容了</p>
										<a href="javascript::" class="flip">回复</a>
										<div class="toogle">
											<textarea style="width: 100%;height: 100px;" placeh	older="看点槽点，不吐不快！别憋着，想说什么就说出来吧！"></textarea>
											<div class="right-btn btn btn-primary">提交评论</div>
										</div>
									  </div>
									</div>
									<div class="media">
									  <div class="media-left">
										<a href="#">
										  <div class="user-head"></div>
										</a>
									  </div>
									  <div class="media-body">
										<h4 class="media-heading">我不知道楼上是谁</h4>
										<p>我该写点啥。。。不知道。。。</p>
										<a href="javascript::" class="flip">回复</a>
										<div class="toogle">
											<textarea style="width: 100%;height: 100px;" placeholder="看点槽点，不吐不快！别憋着，想说什么就说出来吧！"></textarea>
											<div class="right-btn btn btn-primary">提交评论</div>
										</div>
									  </div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="panel-container" style="margin-top: 48px;">
					<div class="panel panel-primary">
						<div class="panel-heading">
							相似课程推荐
						</div>
						<ul>
							<li><a href="#" class="list-group-item">list-group-item</a></li>
							<li><a href="#" class="list-group-item">list-group-item</a></li>
							<li><a href="#" class="list-group-item">list-group-item</a></li>
							<li><a href="#" class="list-group-item">list-group-item</a></li>
							<li><a href="#" class="list-group-item">list-group-item</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
	<script src="js/jquery-3.2.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed --> 
	<script src="js/bootstrap.js"></script>
	<script>
		$(document).ready(function(){
		$(".flip").click(function(e){
			$(this).siblings(".toogle").slideDown("slow");

			$("body").click(function(){
			$(".toogle").slideUp("slow");
		});
			e.stopPropagation();
		});
		$(".toogle").click(function(e){
			e.stopPropagation();
		});
		})
		$("#comlist").click(function(){
			$("#slicontainer").css("margin-left","-100%");
			$("#angel").css({"margin-left":"105px","border-color":"transparent transparent #337ab7 transparent"});
		})
		$("#clist").click(function(){
			$("#slicontainer").css("margin-left","0");
			$("#angel").css({"margin-left":"30px","border-color":"transparent transparent #d9edf7 transparent"});
		})
	</script>
</body>
</html>

