<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'curriculumResources.jsp' starting page</title>
    
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
  <!-- 	<div class="courseware " id="columns10004" style="display:none">课程资源 -->
    		<div style="width:60%;height:500px;background-color:#999">
  				<div class="box" style="flex-wrap: wrap ;">
  					<div style="width:200px;height:280px;float:left;background-color:#666">
  						<img src="images/TXT.png"  alt="txt下载" />
  						<p>文章名称：数据结构</p>
  						<p>课程名称：数据结构</p>
  						<a href="images/TXT.png" download="TXT">点击下载</a>
  					</div>
  					<div style="width:200px;height:280px;float:left">
  						<img src="images/DOC.png"  alt="txt下载" />
  						<p>文章名称：数据结构</p>
  						<p>课程名称：数据结构</p>
  						<a>点击下载</a>
  					</div>
  					<div style="width:200px;height:280px;float:left">
  						<img src="images/AVI.png"  alt="txt下载" />
  						<p>文章名称：数据结构</p>
  						<p>课程名称：数据结构</p>
  						<a>点击下载</a>
  					</div>
  					<div style="width:200px;height:280px;float:left">
  						<img src="images/PPT.png"  alt="txt下载" />
  						<p>文章名称：数据结构</p>
  						<p>课程名称：数据结构</p>
  						<a>点击下载</a>
  					</div>
  						<!-- <img src="images/TXT.png"  alt="txt下载" />
  						<img src="images/DOC.png"  alt="txt下载" />
  						<img src="images/AVI.png"  alt="txt下载" />
  						<img src="images/PPT.png"  alt="txt下载" /> -->
  				</div>
  				
  			</div>
  	
  	<!-- </div> -->
  </body>
</html>
