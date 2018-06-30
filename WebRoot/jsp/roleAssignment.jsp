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

	<link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/bootstrap-treeview.css" rel="stylesheet">
	<link href="css/glyphicons.css" rel="stylesheet">
	<link href="css/roleAssignment.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/commonSystem.css" />
	<link rel="stylesheet" type="text/css" href="css/sweetalert.css">
	
	
  </head>
   <!--  <script src="js/jquery-2.1.1.min.js"></script> -->
	<script src="js/bootstrap.js"></script>
  	<script src="js/bootstrap-treeview.js"></script>
  	<script src="js/sweetalert.min.js"></script>
  <body>
   <!--  这里是roleAssignment.jsp界面，相应js,css未建立 <br> -->
    
    <div class="sortTree">
		<ul id="treeRole" class="treeview">
		</ul>
		<ul id="treeModule" class="treeview">
		</ul>
	</div>
  </body>
 
  <script src="js/myJS/roleAssignment.js"></script>
  

  </html>
