<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
  <title>用户登录</title>
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<style>
body, div, dl, dt, dd, ul, ol, li, h1,
h2, h3, h4, h5, h6, pre, code, form, fieldset,
legend, 	input, button, textarea, p, blockquote, th, td {
  margin: 0;
  padding: 0;
}
body{
  background-color: #F4F7ED;
  color: #A69999;
}
.form-row{
  position: relative;
  background-color:#fff;
  padding:35px 0px 20px 0px;
  margin-bottom: 50px;
  box-shadow: 1px 1px 10px 2px rgba(0,0,0,.1)
              ,-1px -1px 10px 2px rgba(0,0,0,.1);  
}
i.triangle{
  content:'';
  position: absolute;
  width: 30px;
  height: 30px;
  background-color: #fff;
  left: 50%;
  top: 0;
  transform:translate(-50%,-50%) rotate(45deg);
  margin-left: -65px;
  border-top: 1px solid #ccc;
  border-left: 1px solid #ccc;
}
div.form-group{
  position: relative;
}
.span{
  position: absolute;
  padding:5px 10px;
  border-radius: 10px;
  border: 1px solid #E2AFAF;
  left:105%;
  top: 50%;
  transform: translateY(-50%);
  display: none;
}
.span:before{
  content:'';
  position: absolute;
  width: 10px;
  height: 10px;
  background-color: #F2DEDE;
  left: 0;
  top: 50%;
  transform:translate(-50%,-50%) rotate(45deg);
  border-bottom: 1px solid #E2AFAF;
  border-left: 1px solid #E2AFAF;
}
.h4 a{
  text-decoration: none;
}
.h4 a:hover{
  opacity:0.8;
}
a.text-active{
  color: #A69999;
}
#teacherLoginForm{
  display: none;
}
</style>
<body>
  <div class="container" style="width:600px;height:500px;margin-top:5%;">
    <div class="row">
      <div class="col-lg-12 text-center">
        <a href="#"><img src="images/logo.png"></a>
      </div>
    </div>
    <div class="row" style="margin-top:40px;">
      <div class="col-lg-12" style="margin-bottom:30px;">
        <div class="h4 text-center">
          <a href="javascript:;" class="text-active" id="userLogin">用户登录</a>
          <small style="margin:0px 20px;">或</small>
          <a href="javascript:;" id="teacherLogin">教师登录</a>
        </div>
      </div>
    </div>
    <div class="form-row row col-xs-8 col-xs-offset-2">
      <i class="triangle"></i>
      <form action="servlet/student.do?opr=login" method="post"  class="form col-xs-10 col-xs-offset-1" id="userLoginForm">
        <div class="form-group">
          <input type="text" name="snickname" class="form-control input-lg" placeholder="用户名" id="userName">
          <small><span class="span bg-danger text-danger" id="span1">用户名不存在</span></small>
        </div>
        <div class="form-group">
          <input type="password" name="spassword" class="form-control input-lg" placeholder="密码" id="userPwd">
          <small><span class="span bg-danger text-danger" id="span2">密码不正确，请重新输入</span></small>
        </div>
        <div class="form-group">
          <label for="" class="checkbox-inline text-sm">
            <input type="checkbox" name="autoLogin">记住密码
          </label>
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-lg btn-success" style="width:100%;" id="userLoginBtn">登录</button>
        </div>
        <div class="form-group text-center">
          <small>没有账号？</small><a href="register.jsp" class="text-danger text-sm" style="margin-top:10px;"><small>立即注册→</small></a>
        </div>
      </form>
      <form action="servlet/teacher.do?opr=login" method="post"  class="form col-xs-10 col-xs-offset-1" id="teacherLoginForm">
        <div class="form-group">
          <input type="text" class="form-control input-lg" name="tnickname" placeholder="教师用户名" id="teacherName">
          <small><span class="span bg-danger text-danger" id="span1">教师用户名不存在</span></small>
        </div>
        <div class="form-group">
          <input type="password" class="form-control input-lg" name="tpassword" placeholder="密码" id="teacherPwd">
          <small><span class="span bg-danger text-danger" id="span2">密码不正确，请重新输入</span></small>
        </div>
        <div class="form-group">
          <label for="" class="checkbox-inline text-sm">
            <input type="checkbox" name="autoLogin">记住密码
          </label>
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-lg btn-success" style="width:100%;" id="teacherLoginBtn">登录</button>
        </div>
        <div class="form-group text-center">
          <small>没有账号？</small><a href="register.jsp" class="text-danger text-sm" style="margin-top:10px;"><small>立即注册→</small></a>
        </div>
      </form>
    </div>
  </div>
</body>
<script src="js/jquery-3.2.1.min.js"></script>
<!--<script src="../js/bootstrap.js"></script>-->
<script src="js/loginForm.js"></script>
</html>
