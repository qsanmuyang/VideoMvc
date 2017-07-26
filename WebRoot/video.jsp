<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
<title>video</title>

<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/MK-I.css" rel="stylesheet" type="text/css">
<link href="http://vjs.zencdn.net/c/video-js.css" rel="stylesheet">
</head>
<body>
<div class="navbar-static-top" style="background-color: white">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="javascript::" class="navbar-brand">Brand</a>
				<div class="right-nav">
					<ul class="nav navbar-nav">
					<li class="active"><span class="text-success" style="line-height: 50px;">欢迎您，（${LOGIN }）</span></li>
					<li><a href="servlet/student.do?opr=exit">注销</a></li>
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
<div class="container-fluid" style="margin-top: 40px;">
  <div class="row" style="background-color: white;">
    <div class="col-md-12">
     <h2>${video.vname }</h2>
     <ol class="breadcrumb" style="background: none;">
	  <li><a href="index.jsp">主页</a></li>
	  <li><a href="video-list.jsp">${course.subject }</a></li>
	  <li><a href="coursedata.jsp">${course.grade }</a></li>
	  <li class="active">${video.vname }</li>
	</ol>
      <video id="my_video_1" class="video-js vjs-default-skin" controls preload="auto" width="100%" height="600" poster="" data-setup="{}">
      <source src="${video.vpath }" type="video/mp4">
      <p class="vjs-no-js">
      	本视频基于JavaScript，请启用您浏览器的ActiveX控件。若需要，请更新支持HTML 5的浏览器。
      </p>
      </video>
	</div>
  </div>
  <div class="row" style="margin-top: 10px;">
  	<div class="col-md-8" style="margin-top: 10px;">
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
					<div class="right-btn btn btn-primary" onclick="addComment(this)">提交评论</div>
				  </div>
				</div>
 				<hr>
 				<div id="commentList">
 				<c:forEach items="${videoComments }" var="vcomment">
  				<div class="media">
				  <div class="media-left">
					<a href="#">
					  <div class="user-head"></div>
					</a>
				  </div>
				  <div class="media-body">
					<h4 class="media-heading">${vcomment.snickname }</h4>
					<p>${vcomment.ccontent }  <span style="float:right">${vcomment.cdate }</span></p>
					<a href="javascript::" class="flip">回复</a>
					<div class="toogle">
						<textarea style="width: 100%;height: 100px;" placeholder="看点槽点，不吐不快！别憋着，想说什么就说出来吧！"></textarea>
						<div class="right-btn btn btn-primary">提交评论</div>
					</div>
				  </div>
				</div>
				</c:forEach>
				</div>
  			</div>
  		</div>
  	</div>
  	
  	<div class="col-md-4" style="margin-top: 10px;">
  		<div class="panel panel-primary">
  			<div class="panel-heading">
  				视频推荐
  			</div>
  			<div class="panel-body">
  				<div class="media">
				  <div class="media-left">
					<a href="#">
					  <div class="video-head">
					  	<img src="" width="100%">
					  </div>
					</a>
				  </div>
				  <div class="media-body">
					<h4 class="media-heading">啊哦，视频不见了！</h4>
					<p>连接已失效</p>
				  </div>
				</div>
				<div class="media">
				  <div class="media-left">
					<a href="#">
					  <div class="video-head">
					  	<img src="" width="100%">
					  </div>
					</a>
				  </div>
				  <div class="media-body">
					<h4 class="media-heading">啊哦，视频不见了！</h4>
					<p>连接已失效</p>
				  </div>
				</div>
				<div class="media">
				  <div class="media-left">
					<a href="#">
					  <div class="video-head">
					  	<img src="" width="100%">
					  </div>
					</a>
				  </div>
				  <div class="media-body">
					<h4 class="media-heading">啊哦，视频不见了！</h4>
					<p>连接已失效</p>
				  </div>
				</div>
				<div class="media">
				  <div class="media-left">
					<a href="#">
					  <div class="video-head">
					  	<img src="" width="100%">
					  </div>
					</a>
				  </div>
				  <div class="media-body">
					<h4 class="media-heading">啊哦，视频不见了！</h4>
					<p>连接已失效</p>
				  </div>
				</div>
  			</div>
  		</div>
  	</div>
  </div>
  <div class="row">
			<div class="divider"></div>
			<div class="text-center col-md-6 col-md-offset-3">
			  <h4>Footer </h4>
			  <p>Copyright &copy; 2017 &middot; All Rights Reserved &middot; <span>本站基于：</span><a href="http://www.bootcss.com/" target="new">Bootstrap</a></p>
			</div>
</div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
<script src="js/jquery-3.2.1.min.js"></script>
<script src="http://vjs.zencdn.net/c/video.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed --> 
<script src="js/bootstrap.js"></script>
<script>
	$(document).ready(function(){
		if($.support.msie) { 
		alert("本网页基于HTML 5，请使用非IE内核浏览器浏览，以免造成页面崩溃。"); 
		} 
	$(".flip").click(function(e){
		$(this).siblings(".toogle").slideDown("slow");
		
		$("body").click(function(){
		$(".toogle").slideUp("slow");
	});
		e.stopPropagation();
	});
	$(".toogle").click(function(e){
		e.stopPropagation();
	})
	});
	
	function addComment(ele){
	var ccontent=$(ele).prev().val();
	var vid=${video.vid };
	if(ccontent!=null && ccontent!=""){
	var url="servlet/chapterCommentAjax.do?opr=addComment&vid="+vid+"&ccontent="+ccontent;
	$.get(url,function(data){
	var comment=data.videoComment
	if(comment!=null){
	$("#commentList").prepend("<div class='media'><div class='media-left'><a href='#'><div class='user-head'></div>"+
	"</a></div><div class='media-body'><h4 class='media-heading'>"+comment.snickname+"</h4><p>"+comment.ccontent+"<span style='float:right'>"+comment.cdate+"</span></p>"+
	"<a href='javascript::' class='flip'>回复</a><div class='toogle'><textarea style='width: 100%;height: 100px;' placeholder='看点槽点，不吐不快！别憋着，想说什么就说出来吧！'>"+
	"</textarea><div class='right-btn btn btn-primary'>提交评论</div></div></div></div>");
	}
	},"json");
	}else{
	alert("提交的评论内容不能为空！")
	}
	}
	
</script>
</body>
</html>
<%@ include file="checkLogin.jsp" %>
