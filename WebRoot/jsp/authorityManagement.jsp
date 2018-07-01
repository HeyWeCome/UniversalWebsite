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

	<!-- <link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/bootstrap-treeview.css" rel="stylesheet"> -->
	<link href="css/glyphicons.css" rel="stylesheet">
	<link href="css/authorityManagement.css" rel="stylesheet">
	<!-- <link rel="stylesheet" type="text/css" href="css/commonSystem.css" />
	<link rel="stylesheet" type="text/css" href="css/sweetalert.css"> -->
	
	
  </head>
   <!--  <script src="js/jquery-2.1.1.min.js"></script> -->
	<!-- <script src="js/bootstrap.js"></script>
  	<script src="js/bootstrap-treeview.js"></script>
  	<script src="js/sweetalert.min.js"></script> -->
  <body>
   <div class="top">
   		<div class="topText">&nbsp;权限管理</div>
   </div>
    
    <div class="showTree">
    	<!-- <form name="submitAllocation"> -->
	    	<div>
	    		<ul id="showRoles"></ul>
	    	</div>
			<div>
				<ul id="showModules"></ul>
			</div>
			<div>
				<button class="btn btn-primary" id="allocation" onclick="submitAllocation()">确认分配</button>
			</div>
		<!-- </form> -->
	</div>
  </body>
 
  <script src="js/myJS/authorityManagement.js"></script>
  

  </html>
