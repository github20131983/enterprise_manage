<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import=
"java.util.*,
com.wyj.dao.MessageDAO,
com.wyj.factory.MessageDAOFactory,
com.wyj.util.Page,
com.wyj.util.PageUtil,
com.wyj.bean.Message"
%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<div class="layui-row">
   <div class="layui-col-md4" style="height:100">
   　<fieldset class="layui-elem-field layui-field-title" style="margin-top: 5px;">
  <legend>员工信息</legend>
   </fieldset>
   <blockquote class="layui-elem-textarea" style="margin: 0 10,10,0;height:300px">
         <c:choose>
		<c:when test="${empty sessionScope.employee}">
			没有进行身份识别，请先进行身份识别!
		</c:when>
		<c:otherwise>
			<ul>
			  <li>员工编号：${employee.employeeID}</li>
			  <li>员工姓名：${employee.employeeName}</li>
			  <li>员工性别：${employee.employeeSex ? "男" : "女"}</li>
			  <li>出生日期：${employee.employeeBirth }</li>
			  <li>办公室电话：${employee.employeePhone }</li>
			  <li>住址：${employee.employeePlace }</li>
			  <li>管理层领导：${employee.lead ? '是' : '否'}</li>
			</ul>
		</c:otherwise>
	</c:choose> 
          </blockquote>
   
   <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>公告</legend>
   </fieldset>
   <blockquote class="layui-elem-textarea" style="margin: 0 10,10,0;height:175px">
           我们要跟新系统啦！我们将用新系统逐步更换掉老系统，新系统将用LayUI作为前端框架，我们
           会慢慢完善新系统，给予大家更好的体验！</blockquote>
   </div>
   <div class="layui-col-md8" >
   <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>最新消息</legend>
   </fieldset>
   <%
		MessageDAO messageDAO = MessageDAOFactory.getMessageAOInstance();
		Page pageX = PageUtil.creatPage(6, messageDAO.findAllCount(), 1);
		List<Message> messages = messageDAO.findAllMessagee(pageX);
		for(Message message : messages) {
	%>
	
   <blockquote class="layui-elem-quote " style="height:60px">
     <span class="layui-badge layui-bg-red" style="position:relative;left:-20px">新</span><br/>
     <a href="GetMessage?messageID=<%=message.getMessageID()%>"><%=message.getMessageTitle()%>     
     <%=message.getPublishTime() %></a></blockquote>  
	<%	
		}
	 %>
   </div>
</div>
<div class="layui-row layui-footer" style="margin:20px 0 0 0">
           <a>企业信息管理系统 @wyj版权所有</a>
</div>
</div> 
</body>
</html>