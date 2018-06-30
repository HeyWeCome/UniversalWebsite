<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

  </head>
  
  <body>
    <div class="top">
    	<div class="topText"> &nbsp;文章管理</div>
    </div>
    
    
    <div class="rightTable">
	    <div class="buttons">
	        <button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#addModal" onclick="getColumnsName()" style="background-color:#5E6F8A;color:#fff;">&nbsp;新增&nbsp;</button>
	        <button id="del" onclick="deletes()" type="button" class="btn btn-primary " style="background-color:#5E6F8A;color:#fff;">&nbsp;删除&nbsp;</button>
	    </div>
	
	    <!--表格，样式在js中定义-->
	    <table id="RoleTable" style="font-size: 12px; background-color:#b0c4de2e;">
	    </table>
	 </div>
  </body>
</html>
