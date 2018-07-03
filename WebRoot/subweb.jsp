<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String courseName = request.getParameter("courseName");
String introduction = request.getParameter("introduction");
String principal= request.getParameter("principal");

/*这个注释里面你们不用管，我转码用的 ,不影响你们运行
String CourseName = request.getParameter("courseName");
String Introduction = request.getParameter("introduction");
String Principal = request.getParameter("principal");
String courseName=new String(CourseName.getBytes("ISO-8859-1"),"UTF-8");
String introduction=new String(Introduction.getBytes("ISO-8859-1"),"UTF-8");
String principal=new String(Principal.getBytes("ISO-8859-1"),"UTF-8"); */
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
		function submitMessage1(){
			var courseNmae = "<%=courseName%>";
			submitMessage(courseNmae);
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
    
    
    	<div class="subHomePage" id="columns10000" >
    		<div class="briefIntroduction">
    			<div class="introductionTitle" style="margin-top: 5px;margin-left: 20px;">
    				<div class="titleText" style="font-size: 21px;">课程简介</div>
    				<div class="line1"></div>
    				<div class="introductionContent" style="width: 95%;">&nbsp;&nbsp;<%=introduction%></div>
    			</div>
    		</div>
    		
    		<div class="coursePrincipal">
    			<div class="principalTitle" style="margin-top: 5px;margin-left: 21px;">
    				<div class="titleText" style="font-size: 20px;">课程负责人</div>
    				<div class="line2"></div>
    				<div class="principalContent" style="width: 95%;">&nbsp;&nbsp;<%=principal%></div>
    			</div>
    		</div> 
    		
    		<div class="briefIntroduction" style="margin-top:20px; width:35%" onclick="showColumn(10001)">
   				<div class="introductionTitle" style="margin-top: 5px;margin-left: 20px;">
    				<div class="titleText" style="font-size: 21px;">课程介绍</div>
    				<div class="line1"></div>
    				<div class="introductionContent1" style="width: 95%;">
    					<p>课程简介</p>
    					<p>教学方法</p>
    					<p>课程安排</p>
    					<p>课程大纲</p>
    					<p>课程理念与目标</p>
    					<p>课程动态</p>
    				</div>
    			</div>
			</div>  
			
			<div class="briefIntroduction" style="margin-top: 20px;width: 40%;margin-left: 22%;" onclick="showColumn(10004)">
   				<div class="introductionTitle" style="margin-top: 5px;margin-left: 20px;">
    				<div class="titleText" style="font-size: 21px;">课程资源</div>
    				<div class="line1"></div>
    				<div class="introductionContent1" style="width: 95%;">
    					<div style="float: left;"><img class="pptLogo" src="images/PPT.png" width="100"height="100" /><p style="margin-left: 18px;">教学课件</p></div>
    					<div style="float: left;"><img class="pptLogo" src="images/DOC.png" width="100"height="100" /><p style="margin-left: 18px;">教学文档</p></div>
    					<div style="float: left;"><img class="pptLogo" src="images/TXT.png" width="100"height="100" /><p style="margin-left: 18px;">教学文本</p></div>
    				</div>
    			</div>
			</div>   	
    	</div>
    	
    	
    	   	
    	<div class="introduction" id="columns10001" style="display:none">
    		<div class="introductionLeftMenu">
    			<div class="introductionTtileText" id="introductionTtileText"><p>课程介绍</p></div>
    			<div class="putSonColumns" id="putSonColumns"></div>
    		</div>
    	
    		<div class="introductionRight" id="introductionRight">   		
    			<div class="introductionrightTitle">
		   			<div class="titTop">
		   				<div class="rightTitleText" id="rightTitleText"></div>
		   				<div class="showPosition" id="showPosition"></div>
		   			</div>	
		   			<div class="line3"></div>
    			</div>
    			
    			<div class="putTitleAndContent" id="putTitleAndContent">
    			</div>
    			
    		</div>
    	</div>
    	
    	
    	
    	<div class="teachingTeam" id="columns10002" style="display:none">教学团队无内容</div>
    	<div class="courseConstruction" id="columns10003" style="display:none">课程建设无内容</div>
    	<!-- <div class="courseware " id="columns10004" style="display:none">课程资源</div> -->
    	
    	
    	<div class="courseware " id="columns10004" style="display:none">
			<div class="curriculumResources" id="toShowResources">
			</div>
		</div>
    	
    	<div class="questionAndAnswer " id="columns10005" style="display:none">
    		<div class="showMessageAndReply" id="showMessageAndReply"> </div>
    		
    		<div class="collectMessages" id="collectMessages">
    			<div class="collectMessagesText">请输入你的问题或者建议，管理员会进行回复：</div>
    			<textarea name="writeMessage" class="writeMessage" id="writeMessage" rows="6" cols="40"></textarea>
    			<button class="submitButton" onclick="submitMessage1()">提交留言</button>
    		</div>
    	</div>
    	
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
