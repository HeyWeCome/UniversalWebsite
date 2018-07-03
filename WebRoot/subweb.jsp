<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String courseName = request.getParameter("courseName");
String introduction = request.getParameter("introduction");
String principal = request.getParameter("principal");
System.out.println("课程名："+courseName);
System.out.println("课程简介："+introduction);
System.out.println("课程负责人："+principal);
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
	<link rel="stylesheet" type="text/css" href="css/subweb.css" />
	<script src="js/jquery-2.1.1.min.js"></script>
  </head>
  
  <body onload="loadShow1()">
	<script type="text/javascript">
		function loadShow1(){
			var courseNmae = "<%=courseName%>";
			loadShow(courseNmae);
		}	   
	</script> 
	
	
    <div class="top">
    	<div class="logo">
    		<img class="cqutLogo" src="images/cqutLogo.png" width="90" height="90"/>
    		<div class="cqutText">重庆理工大学</div>
    		<div class="courseText"><%=courseName%>精品课程</div>
    	</div>
    	<div class="topMenu" id="topMenu" ></div>
    </div>
    
    <div class="centerContent">
    
    
    	<div class="subHomePage" id="columns10000" style="display:none">
    		<div class="briefIntroduction">
    			<div class="introductionTitle" style="margin-top: 5px;margin-left: 20px;">
    				<div class="titleText" style="font-size: 21px;">课程简介</div>
    				<div class="line1"></div>
    				<div class="introductionContent" style="width: 95%;"><%=introduction%></div>
    			</div>
    		</div>
    		
    		<div class="coursePrincipal">
    			<div class="principalTitle" style="margin-top: 5px;margin-left: 21px;">
    				<div class="titleText" style="font-size: 20px;">课程负责人</div>
    				<div class="line2"></div>
    				<div class="principalContent" style="width: 95%;"><%=principal%></div>
    			</div>
    		</div>    	
    	</div>
    	
    	
    	   	
    	<div class="introduction" id="columns10001" >
    		<div class="introductionLeftMenu">
    			<div class="introductionTtileText" id="introductionTtileText" onclick="aa()"><p>课程介绍</p></div>
    			<div class="putSonColumns" id="putSonColumns"></div>
    		</div>
    	
    		<div class="introductionRight"></div>
    	</div>
    	
    	
    	
    	<div class="teachingTeam" id="columns10002" style="display:none">教学团队无内容</div>
    	<div class="courseConstruction" id="columns10003" style="display:none">课程建设无内容</div>
    	<div class="courseware " id="columns10004" style="display:none">课程资源</div>
    	<div class="questionAndAnswer " id="columns10005" style="display:none">问题与答疑</div>
    	<div class="courseResearch " id="columns10006" style="display:none">课程研究无内容</div>
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
