<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="layui/css/layui.css" type="text/css" rel="stylesheet" media="all"/>
<script src="layui/layui.js" charset="utf-8"></script>
<script>
layui.use('element', function(){
  var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块  
  //监听导航点击
  element.on('nav(demo)', function(elem){
    console.log(elem)
    layer.msg(elem.text());
  });
});

layui.use(['carousel', 'form'], function(){
	  var carousel = layui.carousel
	  ,form = layui.form;
	  
	  
	  //图片轮播
	  carousel.render({
	    elem: '#test10'
	    ,width: '100%'
	    ,height: '350px'
	    ,interval: 5000
	  });
	});
</script>
</head>
<body bgcolor="#ededed">
<div class="layui-container" >
<div class="layui-row layui-header">
      <ul class="layui-nav ">
         <li class="layui-nav-item"><a href="index.jsp">首页</a></li>
         <li class="layui-nav-item"><a href="GetMessageList">消息列表</a></li>      
         <li class="layui-nav-item"><a href="publishNewMsg.jsp">发布新消息</a></li>          
       </ul> 
       <ul class="layui-nav layui-layout-right">
         <li class="layui-nav-item"><a href="login.jsp">登录</a></li>
      </ul>
</div>

<div class="layui-row layui-carousel" id="test10">
  <div carousel-item>
    <div><img src="layui/images/image/1.jpg"></div>
    <div><img src="layui/images/image/2.bmp"></div>
    <div><img src="layui/images/image/3.jpg"></div>
  </div>
</div>
</div>

<div class="layui-container" >
<div class="layui-row style="height:100">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 15px;">
  <legend>信息列表</legend>
     </fieldset>
  <c:forEach items="${requestScope.messageList}" var="message">

<blockquote class="layui-elem-quote2" style="margin: 10px 0 10px 0;height:100px">
 <a href="GetMessage?messageID=${message.messageID}">${message.messageTitle}</a>
 <div align="right">发布人ID：${message.employeeID} 
	  		发布时间：${message.publishTime}</div>
 </blockquote>
 </c:forEach>
</div>

<div class="layui-row" >
  <div align="center">
	<c:choose>
		<c:when test="${page.hasPrePage}">
			<a href="GetMessageList?currentPage=1">首页</a> | 
	<a href="GetMessageList?currentPage=${page.currentPage -1 }">上一页</a>
		</c:when>
		<c:otherwise>
			首页 | 上一页
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${page.hasNextPage}">
			<a href="GetMessageList?currentPage=${page.currentPage + 1 }">下一页</a> | 
	<a href="GetMessageList?currentPage=${page.totalPage }">尾页</a>
		</c:when>
		<c:otherwise>
			下一页 | 尾页
		</c:otherwise>
	</c:choose>
	当前为第${page.currentPage}页,共${page.totalPage}页
  </div>
</div>
<div class="layui-row layui-footer" style="margin:20px 0 0 0">
           <a>企业信息管理系统 @wyj版权所有</a>
</div>
</div>
</body>
</html>