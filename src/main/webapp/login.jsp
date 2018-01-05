<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="script/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
//user
var user_Boolean = false;
var password_Boolean = false;
var varconfirm_Boolean = false;
$('#reg_user').blur(function(){
	//ajax请求
	$.ajax({
		url:'ajaxAction',
		type:'post',
		data:{username: function(){
        	return $('#reg_user').val() ;}
        },
		dataFilter:function(data,type){
			if(data == 'false'){
        		//禁表单
        		$("input:text").attr("disabled",true);
        		$("input:password").attr("disabled",true); 
        		$("#reg_user").removeAttr("disabled");
        		$('#user_hint').html("USED").css("color","red");
        	}else{
        		//解禁
        		$("input:text").removeAttr("disabled");
        		$("input:password").removeAttr("disabled"); 
        	}
		}
	});
	var target = /^[a-z0-9A-Z]{4,16}$/;
	var reg_user = $("#reg_user").val() ;
  if(target.test(reg_user)){  
      $('#user_hint').html("✔").css("color","green");
      user_Boolean = true ;
  }else{
	  $('#user_hint').html("×").css("color","red");
	  user_Boolean = false ;
  }
});
// password
$('#reg_password').blur(function(){
  if((/^[a-z0-9A-Z]{6,16}$/).test($("#reg_password").val())){
	  $('#password_hint').html("✔").css("color","green");
	  password_Boolean = true;
  }else{
      $('#password_hint').html("×").css("color","red");
      password_Boolean = false;
  }
});

// password_confirm
$('#reg_confirm').blur(function(){
  if(($("#reg_password").val())==($("#reg_confirm").val())){
    $('#confirm_hint').html("✔").css("color","green");
    varconfirm_Boolean = true;
  }else{
    $('#confirm_hint').html("×").css("color","red");
    varconfirm_Boolean = false;
  }
})
 $('.submit1').click(function(){
        if(user_Boolean && password_Boolean && varconfirm_Boolean ){
           $('form').submit();
           }
            else{
              return false;
            }
});
});
</script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/normalize.css">
<title>注册页面</title>
</head>
<body>
<form action="LoginAction" onsubmit="return checkall()">
<div class="reg_div">
    <p>注册</p>
    <ul class="reg_ul">
      <li>
          <span>用户名：</span>
          <input type="text" name="username" value="" placeholder="4-16位用户名" id="reg_user">
          <span id="user_hint" style="width: 20px"></span>
      </li>
      <li>
          <span>密码：</span>
          <input type="password" name="password" value="" placeholder="6-16位密码" id="reg_password">
          <span id="password_hint" style="width: 20px"></span>
      </li>
      <li>
          <span>确认密码：</span>
          <input type="password" name="cpasswd" value="" placeholder="确认密码" id="reg_confirm">
          <span id="confirm_hint" style="width: 20px"></span>
      </li>     
    </ul>
          <br><input type="submit" class="submit1" value="注册">
   </div>
</form>
</body>
</html>