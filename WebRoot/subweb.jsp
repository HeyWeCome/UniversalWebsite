<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String courseName = request.getParameter("courseName");
System.out.println(courseName);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>子网页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/homePage.css" />
	<script src="js/jquery-2.1.1.min.js"></script>
  </head>
  
  <body onload="loadShow()">
    <div class="top">
    	<div class="logo">
    		<img class="cqutLogo" src="images/cqutLogo.png" width="90" height="90"/>
    		<div class="cqutText">重庆理工大学</div>
    	</div>
    	<div class="topMenu" id="topMenu" ></div>
    </div>
    
    <div class="centerContent">
    	<div class="subHomePage" id="columns10000" style="display:none">首页</div>
    	<div class="introduction" id="columns10001" style="display:none">课程介绍</div>
    	<div class="teachingTeam" id="columns10002" style="display:none">教学团队</div>
    	<div class="courseConstruction" id="columns10003" style="display:none">课程建设</div>
    	<div class="courseware " id="columns10004" style="display:none">课程资源</div>
    	<div class="questionAndAnswer " id="columns10005" style="display:none">问题与答疑</div>
    	<div class="courseResearch " id="columns10006" style="display:none">课程研究</div>
    </div>
    
    <div class="bottom">
    	<div class="line"></div>
    	<div class="text1">重庆理工大学计算机科学与工程学院版权所有</div>
    	<div class="text2">联系地址：重庆市红光大道69号（邮编：400054）  联系电话：（023）68667334</div>
    </div>
    
  </body>
  <script type="text/javascript" src="js/jquery.cookie.js"></script>
  <script src="js/myJS/subweb.js"></script>
</html>
