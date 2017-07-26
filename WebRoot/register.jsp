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
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>用户注册</title>
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
select{
  color: #9FA19F !important;
  padding-left: 10px !important;
}
#teacherRegisterForm{
  display: none;
}
</style>
<body>
  <div class="container" style="width:600px;margin-top:5%;">
    <div class="row">
      <div class="col-lg-12 text-center">
        <a href="#"><img src="images/logo.png"></a>
      </div>
    </div>
    <div class="row" style="margin-top:40px;">
      <div class="col-lg-12" style="margin-bottom:30px;">
        <div class="h4 text-center">
          <a href="javascript:;" class="text-active" id="userRegister">用户注册</a>
          <small style="margin:0px 20px;">或</small>
          <a href="javascript:;" id="teacherRegister">教师注册</a>
        </div>
      </div>
    </div>
    <div class="form-row row col-xs-8  col-xs-offset-2">
      <i class="triangle"></i>
      <!--用户注册-->
      <form action="servlet/student.do?opr=reg" method="post"  class="form col-xs-10 col-xs-offset-1" id="userRegisterForm">
        <div class="form-group">
          <input type="text" name="snickname" class="form-control input-lg" placeholder="用户名" id="userName">
          <small><span class="span bg-danger text-danger" id="nameLabel">用户名不能为空</span></small>
        </div>
        <div class="form-group">
          <input type="text" name="semail" class="form-control input-lg" placeholder="邮箱" id="userEmail">
          <small><span class="span bg-danger text-danger">邮箱不能为空</span></small>
        </div>
        <div class="form-group">
          <input type="password" name="spassword" class="form-control input-lg" placeholder="密码" id="userPwd">
          <small><span class="span bg-danger text-danger" >密码长度应在6至12位之间</span></small>
        </div>
        <div class="form-group">
          <input type="password" class="form-control input-lg" placeholder="确认密码" id="userRpwd">
          <small><span class="span bg-danger text-danger">密码不一致，请重新输入</span></small>
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-lg btn-success" style="width:100%;" id="userRegisterBtn">注册</button>
        </div>
        <div class="form-group text-center">
          <small>已有账号？</small><a href="login.jsp" class="text-danger text-sm" style="margin-top:10px;"><small>直接登录→</small></a>
        </div>
      </form>
      <!--教师注册-->
      <form action="servlet/teacher.do?opr=reg" method="post"  class="form col-xs-10 col-xs-offset-1" id="teacherRegisterForm">
        <div class="form-group">
          <input type="text" name="tnickname" class="form-control input-lg" placeholder="教师用户名" id="teacherName">
          <small><span class="span bg-danger text-danger">用户名不能为空</span></small>
        </div>
        <div class="form-group">
          <input type="text" name="temail" class="form-control input-lg" placeholder="邮箱" id="teacherEmail">
          <small><span class="span bg-danger text-danger">邮箱不能为空</span></small>
        </div>
        <div class="form-group">
          <input type="text" name="tphone" class="form-control input-lg" placeholder="联系电话(1+10位数字)" id="teacherTel">
          <small><span class="span bg-danger text-danger">联系电话不能为空</span></small>
        </div>
        <div class="form-group">
          <select class="form-control input-lg" name="teducation" id="educationBackground">
            <option value="学历" selected="selected" disabled="disabled">— 学历 —</option>            
            <option value="专业教师">专业教师</option>
            <option value="研究生(硕士，博士)">研究生(硕士，博士)</option>
            <option value="本科生">本科生</option>
            <option value="专科生">专科生</option>
            <option value="高职学生">高职学生</option>            
          </select>
          <small><span class="span bg-danger text-danger">请选择学历</span></small>
        </div>
        <div class="form-group">
          <select class="form-control input-lg" name="tcourse" placeholder="1" id="teachCourse">
            <option value="教授课程" selected="selected" disabled="disabled">— 教授课程 —</option>
            <option value="理科数学">理科数学</option>
            <option value="文科数学">文科数学</option> 
            <option value="语文">语文</option>           
            <option value="英语">英语</option>
            <option value="物理">物理</option>
            <option value="化学">化学</option>
            <option value="生物">生物</option>
            <option value="历史">历史</option>
            <option value="地理">地理</option>
            <option value="政治">政治</option>            
          </select>
          <small><span class="span bg-danger text-danger">请选择所教授的课程</span></small>
        </div>
        <div class="form-group">
          <input type="password" name="tpassword" class="form-control input-lg" placeholder="密码" id="teacherPwd">
          <small><span class="span bg-danger text-danger">密码不能小于6位数并且大于10位数</span></small>
        </div>
        <div class="form-group">
          <input type="password" class="form-control input-lg" placeholder="确认密码" id="teacherRpwd">
          <small><span class="span bg-danger text-danger">密码不一致，请重新输入</span></small>
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-lg btn-success" style="width:100%;" id="teacherRegisterBtn">注册</button>
        </div>
        <div class="form-group text-center">
          <small>已有账号？</small><a href="login.jsp" class="text-danger text-sm" style="margin-top:10px;"><small>直接登录→</small></a>
        </div>
      </form>
    </div>
  </div>
</body>
<script src="js/jquery-3.2.1.min.js"></script>
<!--<script src="../js/bootstrap.js"></script>-->
<script src="js/registerForm.js"></script>
</html>
