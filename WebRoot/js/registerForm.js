$(function(){
  var sRegister = $('#userRegister');
  var tRegister = $('#teacherRegister');
  var sRegisterDiv = $('#userRegisterForm');
  var tRegisterDiv = $('#teacherRegisterForm');
  var triangle = $('i.triangle');
  //控制相应的模板显示
  sRegister.click(function(){
    $(this).addClass('text-active').siblings().removeClass('text-active');
    triangle.css('marginLeft','-65px');
    sRegisterDiv.show();
    tRegisterDiv.hide();
  })
  tRegister.click(function(){
    $(this).addClass('text-active').siblings().removeClass('text-active');
    $('html,body').animate({scrollTop:150},1000);
    triangle.css('marginLeft','65px');
    sRegisterDiv.hide();
    tRegisterDiv.show();
  })
  //提示信息长度控制
  function spanLength(){
    var span = $('span.span');
    span.each(function(index,item){
      var length=0;
      sLength = $(this).text().length;
      length = sLength * 16;
      $(this).css('width',length+'px');
    })
  }
  //用户表单验证
  // 1.获取表单以及对应的提示信息
  var email = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
  var userName = $('#userName');
  var userNameSpan = $('#userName+small>span');
  var userEmail = $('#userEmail');
  var userEmailSpan = $('#userEmail+small>span');
  var userPwd = $('#userPwd');
  var userPwdSpan = $('#userPwd+small>span');
  var userRpwd = $('#userRpwd');
  var userRpwdSpan = $('#userRpwd+small>span');
  var userRegisterBtn = $('#userRegisterBtn');
  userName.blur(function(){
    if(!userName.val().length){
      userNameSpan.text('用户名不能为空');
      spanLength();
      userNameSpan.show();
    }else{
    	var snickname=userName.val();
    	if(snickname!=null){
    	var url="servlet/studentAjax.do?opr=checkName&snickname="+snickname;
    		$.get(url,function(data){
    	  if(data.flag=="true"){
    		  userNameSpan.text('用户名已存在');
    	      spanLength();
    	      userNameSpan.show();
    	  }else{
    	      userNameSpan.hide();
    	  }
    	},"json")
    	}
    }
  })
  userEmail.blur(function(){
    if(!userEmail.val().length){
      userEmailSpan.text('邮箱不能为空');
      spanLength();
      userEmailSpan.show();
    }else if(!email.test(userEmail.val())){
      userEmailSpan.text('邮箱格式不正确');
      spanLength();
      userEmailSpan.show();
    }else{
      userEmailSpan.hide();
    }
  })
  userPwd.blur(function(){
    if(userPwd.val().length<6 || userPwd.val().length>12){
      userPwdSpan.text('密码长度应在6-12位之间');
      spanLength();
      userPwdSpan.show();
    }else{
      userPwdSpan.hide();
    }
  })
  userRpwd.blur(function(){
    if(userRpwd.val() != userPwd.val()){
      userRpwdSpan.text('密码不一致，请重新输入');
      spanLength();
      userRpwdSpan.show();
    }else{
      userRpwdSpan.hide();
    }
  })

  //触发每个input或者select事件  
  function userBlurForm(){
    userName.blur();
    userEmail.blur();
    userPwd.blur();
    userRpwd.blur();
  }
  //判断所有的提示语是否隐藏  
  function checkUserRegisterForm(){
    var userSpan = $('#userRegisterForm span.span');
    while(userName.val().length && userEmail.val().length && userPwd.val().length && userRpwd.val().length){
      for(var i=0;i<userSpan.length;i++){
      if(userSpan.eq(i).css('display') != 'none'){
          return false;
        }else if(i==userSpan.length-1){
          return true;
        }
      }
      break;
    }
    return false;
  }
  userRegisterBtn.click(function(){
    userBlurForm();
    return checkUserRegisterForm();
  })

  //教师表单验证
  // 1.得到表单
  var tel = /^1+[0-9]{10}$/;
  var teacherName = $('#teacherName');
  var teacherNameSpan = $('#teacherName+small>span');
  var teacherEmail = $('#teacherEmail');
  var teacherEmailSpan = $('#teacherEmail+small>span');
  var teacherTel = $('#teacherTel');
  var teacherTelSpan = $('#teacherTel+small>span');
  var educationBackground = $('#educationBackground');
  var educationBackgroundSpan = $('#educationBackground+small>span');
  var teachCourse = $('#teachCourse');
  var teachCourseSpan = $('#teachCourse+small>span');
  var teacherPwd = $('#teacherPwd');
  var teacherPwdSpan = $('#teacherPwd+small>span');
  var teacherRpwd = $('#teacherRpwd');
  var teacherRpwdSpan = $('#teacherRpwd+small>span');
  var teacherRegisterBtn = $('#teacherRegisterBtn');
  teacherName.blur(function(){
    if(!teacherName.val().length){
      teacherNameSpan.text('用户名不能为空');
      spanLength();
      teacherNameSpan.show();
    }else{
    	var tnickname=teacherName.val();
    	if(tnickname!=null){
    	var url="servlet/teacherAjax.do?opr=checkName&tnickname="+tnickname;
    		$.get(url,function(data){
    	  if(data.flag=="true"){
    		  teacherNameSpan.text('用户名已存在');
    	      spanLength();
    	      teacherNameSpan.show();
    	  }else{
    	      teacherNameSpan.hide();
    	  }
    	},"json")
    	}
    }
  })
  teacherEmail.blur(function(){
    if(!teacherEmail.val().length){
      teacherEmailSpan.text('邮箱不能为空');
      spanLength();
      teacherEmailSpan.show();
    }else if(!email.test(teacherEmail.val())){
      teacherEmailSpan.text('邮箱格式不正确');
      spanLength();
      teacherEmailSpan.show();
    }else{
      teacherEmailSpan.hide();
    }
  })
  teacherTel.blur(function(){
    if(!teacherTel.val().length){
      teacherTelSpan.text('联系电话不能为空');
      spanLength();
      teacherTelSpan.show();      
    }else if(!tel.test(teacherTel.val())){
      teacherTelSpan.text('电话格式不正确');
      spanLength();
      teacherTelSpan.show();            
    }else{
      teacherTelSpan.hide();
    }
  })
  educationBackground.change(function(){
    if(educationBackground.get(0).selectedIndex == 0){
      educationBackgroundSpan.text('请选择你的学历');
      spanLength();
      educationBackgroundSpan.show();
    }else{
      educationBackgroundSpan.hide();
    } 
  })
  teachCourse.change(function(){
    if(teachCourse.get(0).selectedIndex == 0){
      teachCourseSpan.text('请选择所教授的课程');
      spanLength();
      teachCourseSpan.show();
    }else{
      teachCourseSpan.hide();      
    }
  })
  teacherPwd.blur(function(){
    if(teacherPwd.val().length<6 || teacherPwd.val().length>12){
      teacherPwdSpan.text('密码长度应在6-12位之间');
      spanLength();
      teacherPwdSpan.show();
    }else{
      teacherPwdSpan.hide();
    }
  })
  teacherRpwd.blur(function(){
    if(teacherRpwd.val() != teacherPwd.val()){
      teacherRpwdSpan.text('密码不一致，请重新输入');
      spanLength();
      teacherRpwdSpan.show();
    }else{
      teacherRpwdSpan.hide();
    }
  })
  //触发每个input或者select事件
  function teacherBlurForm(){
    teacherName.blur();
    teacherEmail.blur();
    teacherTel.blur();
    educationBackground.change();
    teachCourse.change();
    teacherPwd.blur();
    teacherRpwd.blur();
  }
  //判断所有的提示语是否隐藏
  function checkTeacherRegisterForm(){
    var teacherSpan = $('#teacherRegisterForm span.span');
    while(teacherName.val().length && teacherEmail.val().length && teacherTel.val().length && teacherPwd.val().length && teacherRpwd.val().length){
      for(var i=0;i<teacherSpan.length;i++){
      if(teacherSpan.eq(i).css('display') != 'none'){
          return false;
        }else if(i==teacherSpan.length-1){
          return true;
        }
      }
      break;
    }
    return false;
  }
  //提交表单时触发blur事件
  teacherRegisterBtn.click(function(){
    teacherBlurForm();
    return checkTeacherRegisterForm();
  })
})