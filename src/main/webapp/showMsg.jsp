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
<link rel="stylesheet" href="kindeditor/themes/default/default.css" />
<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
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
KindEditor.ready(function(K) {
	var editor1 = K.create('textarea[name="replyContent"]', {					
	});	
});
KindEditor.ready(function(K) {
	var editor1 = K.create('textarea[name="criticismContent"]', {					
	});	
});
function cl1()
{
	KindEditor.html("replyContent","");
}
function cl2()
{
	KindEditor.html("criticismContent","");
}
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
<blockquote class="layui-elem-quote2" style="margin: 10px 0 0 0;" >
<br/>
	<h2 align="center">${message.messageTitle}</h2>
	<br/>
	${message.messageContent}
	<div align="right">发布人ID：${message.employeeID} 
	  		发布时间：${message.publishTime}</div>
</blockquote>
</div>
	
	<!--批复-->
	<blockquote class="layui-elem-quote2" style="margin:0 0 0 0;height:60px;background-color:#F2FFBF">
		<h5 style="color:red">领导批复:${empty criticism ? "暂无":criticism.criticismContent}</h5>
	</blockquote>
	<!--回复-->
	
	<c:forEach items="${requestScope.replyList}" var="reply">

<blockquote class="layui-elem-quote2" style="margin: 0 0 0 0;height:100px">
 ${reply.replyContent}

		<div align="right"></br></br>回复人ID：${reply.employeeID} 
	  		回复时间：${reply.replyTime}</div>
 </blockquote>
 </c:forEach>
 	
	<div align="center">
		第<c:forEach varStatus="stat" begin="1" end="${page.totalPage}">
			<a href="GetMessage?messageID=${message.messageID}&currentPage=${stat.index}">${stat.index}</a>
		</c:forEach>页
	</div>
	
<div class="layui-row">
  <div align="left">
  	<p>回复:</p>
  	<p><font color="red">${error }</font></p>
  	<form action="CommitReply" method="post">
  		<div class="layui-row">
   <textarea id="editor_id" name="replyContent" style="width:100%;height:100px;"></textarea> 
  </div>  
  <div class="layui-row" style="margin:10px 100px 10px 0px;">
  <input type="hidden" name="messageID" value="${message.messageID}"/> 
      <button class="layui-btn layui-btn-normal">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-normal"
      onclick="cl1()">重&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp置</button>
  </div>
  	</form>	 
  </div>
  
  <c:if test="${sessionScope.employee.lead}">
   <div align="left">
  	<p>批复:</p>
  	<p><font color="red">${error }</font></p>
  	<form action="CommitCriticism" method="post">
  		<div class="layui-row">
   <textarea id="editor_id" name="criticismContent" style="width:100%;height:100px;"></textarea> 
  </div>  
  <div class="layui-row" style="margin:10px 100px 10px 0px;">
  <input type="hidden" name="messageID" value="${message.messageID}"/> 
      <button class="layui-btn layui-btn-normal" >立即提交</button>
      <button type="reset" class="layui-btn layui-btn-normal"
      onclick="cl2()">重&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp置</button>
  </div>
  	</form>	 
  </div>
  </c:if>
</div>	
<div class="layui-row layui-footer" style="margin:20px 0 0 0">
           <a>企业信息管理系统 @wyj版权所有</a>
</div>
</div>

</body>
</html>