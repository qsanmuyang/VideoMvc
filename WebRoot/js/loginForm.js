$(function(){
  var sLogin = $('#userLogin');
  var tLogin = $('#teacherLogin');
  var sLoginDiv = $('#userLoginForm');
  var tLoginDiv = $('#teacherLoginForm');
  var triangle = $('i.triangle');
  //控制提示语长度
  function spanLength(){
    var span = $('span.span');
    span.each(function(index,item){
      var length=0;
      sLength = $(this).text().length;
      length = sLength * 16;
      $(this).css('width',length+'px');
    })
  }
  //控制相应的模板显示
  sLogin.click(function(){
    $(this).addClass('text-active').siblings().removeClass('text-active');
    triangle.css('marginLeft','-65px');
    sLoginDiv.show();
    tLoginDiv.hide();
  })
  tLogin.click(function(){
    $(this).addClass('text-active').siblings().removeClass('text-active');
    triangle.css('marginLeft','65px');
    sLoginDiv.hide();
    tLoginDiv.show();
  })
  
  //用户登录验证
  var userName = $('#userName');
  var userNameSpan = $('#userName+small>span');
  var userPwd = $('#userPwd');
  var userPwdSpan = $('#userPwd+small>span');
  var userLoginBtn = $('#userLoginBtn');

  userLoginBtn.click(function(){
    if(!userName.val().length){
      userNameSpan.text('用户名不能为空');
      spanLength();
      userNameSpan.show();
      return false;
    }else if(!userPwd.val().length){
      userPwdSpan.text('密码不正确，请重新输入');
      spanLength();
      userPwdSpan.show();
      return false;
    }
  })

  //教师登录验证
  var teacherName = $('#teacherName');
  var teacherNameSpan = $('#teacherName+small>span');
  var teacherPwd = $('#teacherPwd');
  var teacherPwdSpan = $('#teacherPwd+small>span');
  var teacherLoginBtn = $('#teacherLoginBtn');
  teacherLoginBtn.click(function(){
    if(!teacherName.val().length){
      teacherNameSpan.text('教师用户名不能为空');
      spanLength();
      teacherNameSpan.show();
      return false;
    }else if(!teacherPwd.val().length){
      teacherPwdSpan.text('密码不正确，请重新输入');
      spanLength();
      teacherPwdSpan.show();
      return false;
    }
  })
})