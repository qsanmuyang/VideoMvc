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

<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/MK-I-video.css" rel="stylesheet">
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
					<li><a href="servlet/student1.do?opr=exit">注销</a></li>
                    </c:otherwise>
                    </c:choose>
                    <li><a href="index.jsp">首页</a></li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">我的课程<span class="caret"></span></a>
                      <ul class="dropdown-menu" role="menu">
                        <li><a href="servlet/student.do?opr=stuInfo">个人中心</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                      </ul><!-- end-of-dropdown-menu -->
                    </li>
                  </ul>
                </div>
            </div><!-- end-of-navbar-header -->
        </div>
    </div><!-- end-of-navbar-fixed-top -->

    <div class="container-fluid" style="margin-top: 50px;">
       <div class="course-nav row">
            <div class="col-md-6 col-md-offset-3"  style="margin-left: 10%; width: 80%;overflow: hidden">
                <ul>
                   <li id="grade">
                       <span>年级：</span>
                       <a href="javascript:;" id="g-all" class="active">全部</a>
                       <a href="javascript:;" id="m1">初一</a>
                       <a href="javascript:;" id="m2">初二</a>
                       <a href="javascript:;" id="m3">初三</a>
                       <a href="javascript:;" id="h1">高一</a>
                       <a href="javascript:;" id="h2">高二</a>
                       <a href="javascript:;" id="h3">高三</a>
                   </li>
                   <li style="border-bottom: none;" id="subject">
                       <span>科目：</span>
                       <a href="javascript:;" id="s-all" class="active">全部</a>
                       <a href="javascript:;" id="cn">语文</a>
                       <a href="javascript:;" id="math">数学</a>
                       <a href="javascript:;" id="en">英语</a>
                       <a href="javascript:;" id="pol">政治</a>
                       <a href="javascript:;" id="his">历史</a>
                       <a href="javascript:;" id="geo">地理</a>
                       <a href="javascript:;" id="phy">物理</a>
                       <a href="javascript:;" id="chem">化学</a>
                       <a href="javascript:;" id="bio">生物</a>
                   </li>
               </ul>
            </div>
       </div><!-- end-of-course-nav -->
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 col-md-offset-3"  style="margin-left: 10%; width: 80%;overflow: hidden">
                <div class="v-container">
                    <div class="v-title" style="margin: 10px 0;">
                        <a href="#">最新</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="#">最热</a>
                    </div>
                    <div class="row" id="videoList">
                        
                    </div>
                </div><!-- end-of-v-container -->

                <div class="v-container">
                  <nav aria-label="Page navigation" class="text-center">
                      <ul class="pagination" id="pageList">
                       
                      </ul>
                    </nav>
                </div>

            </div>
        </div>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed --> 
    <script src="js/bootstrap.js"></script>
<script src="js/video-list.js"></script>

</body>
</html>
