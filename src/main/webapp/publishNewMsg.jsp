<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	var editor1 = K.create('textarea[name="content"]', {					
	});	
});
function cl()
{
	KindEditor.html("content","");
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
</div>

<div class="layui-container" >
 
 <div class="layui-row">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
     <legend>消息发布</legend>
    </fieldset>
 </div>
 <form action="MsgPublish" method="post">
 <div class="layui-row">
      <div class="layui-form-item">
      <font color="red">${requestScope.error}</font>
       <label class="layui-form-label">请输入标题</label>
       <div class="layui-input-block">
       <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
       </div>
       </div>
 </div>
 
  <div class="layui-row">
   <textarea id="editor_id" name="content" style="width:100%;height:300px;"></textarea> 
  </div>  
  <div class="layui-row" style="margin:10px 100px 10px 0px;">
      <button class="layui-btn layui-btn-normal">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-normal"
      onclick="cl()">重&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp置</button>
  </div>
  </form>
  <div class="layui-row layui-footer">
           <a>企业信息管理系统 @wyj版权所有</a>
  </div>
</div>
</body>
</html>