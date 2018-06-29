<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>通用课程后台管理界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/index.css" />
	
	<script src="js/jquery-2.1.1.min.js"></script>
  </head>
  
  <body onload="loadShow()">
  	 <!-- 顶部 -->
  	<div class="topContent">
  		<div>
  			<img class="courseLogo" src="images/courseLogo1.png" width="60" height="60" />
  			<div class="logoText">通用课程后台管理系统</div>
  		</div>
  		<div class="topContent1">
  			<div class="welcomeWords">
  				<p id="welcomeWordsText" class="welcomeWordsText"></p><!-- 要填入对应管理员欢迎语 -->
  			</div>
  		</div>
  	</div>
  	<!-- 左边菜单栏整体 -->
    <div class="leftPart">
    	<div class="firstLevelMenu" id="firstLevelMenu"></div>
    </div>
    
    
  </body>
  <script src="js/myJS/index.js"></script>
</html>
