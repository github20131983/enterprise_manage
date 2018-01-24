<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/login.css" rel="stylesheet" type="text/css" />
<link href="css/css.css" type="text/css" rel="stylesheet" media="all" />

<script language="JavaScript" src="js/jquery.js"></script>
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 
<title>Insert title here</title>
</head>
<body bgcolor="#c5e7fa">              
<div class="loginbox"> 
<form action="StatusRecogniseAction" method="post">   
    <ul>
     <font color="red">${requestScope.error}</font>
    <li><input name="employeeID" type="text" class="loginuser" value="${param.employeeID}" onclick="JavaScript:this.value=''"/></li>
    <li><input name="password" type="password" class="loginpwd" value="" onclick="JavaScript:this.value=''"/></li>          				  	
    <li><input name="" type="submit" class="loginbtn" value="登录" />
	<label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
    </ul> 
    </form>   
</div>  
</body>
</html>