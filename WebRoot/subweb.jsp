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
    	
    	
    	
    	<div class="teachingTeam" id="columns10002" style="display:none"><p>&nbsp;&nbsp;&nbsp;&nbsp;学校始终坚持人才强校战略。
    	建有重庆市人才管理改革试验区、重庆市博士后科研工作站、重庆市院士专家工作站和重庆市海智工作站等4个省部级人才平台。
    	拥有千人计划、百千万人才工程国家级人选、万人计划领军人才、国家有突出贡献的中青年专家以及重庆市两江学者、巴渝学者特聘教授等省部级以上优秀人才200余人次。
    	<br>&nbsp;&nbsp;&nbsp;&nbsp;学校高度重视师资队伍建设工作，坚持实施“人才强校”战略，坚持把人才工作摆在优先发展的战略位置，集中精力，狠抓人才引进和培养工作，凝聚和培养了一批又一批高水平的专家学者。
    	学校建有重庆市人才管理改革试验区、重庆市博士后科研工作站、重庆市院士专家工作站和重庆市海智工作站等四个省部级人才平台；拥有千人计划、百千万人才工程国家级人选、万人计划领军人才、国家有突出贡献的中青年专家等国家级人才40余名；
    	拥有重庆市两江学者、巴渝学者特聘教授、重庆市学术技术带头人、重庆市百名学术学科领军人才、重庆市百名海外高层次聚集计划人选等省部级优秀人才 160余人。
我校人才工作受到上级有关部门的充分肯定和认可。先后获得“重庆市海外留学人员先进工作集体”“重庆市海外智力引进示范单位"“全市人才工作先进集体”“重庆市教育系统人事工作先进集体”等多项荣誉称号。</p></div>


    	<div class="courseConstruction" id="columns10003" style="display:none"><p>&nbsp;&nbsp;&nbsp;&nbsp;根据2014年12月学校官网显示，学校有国家级特色专业4个、
    	综合改革试点专业2个、国家级实验教学示范中心1个、重庆市级特色专业6个、综合改革试点专业2个、“三特行动计划”特色专业5个；有国家级精品课程1门、双语教学示范课程1门、
    	精品资源共享课入选课程1门、大学生校外实践教育基地1个；有重庆市精品课程20门、精品视频公开课程6门、精品资源共享课程13门、双语教学示范课程3门、研究生优质课程10门、
    	人才培养模式创新实验区4个、实验教学示范中心7个、大学生校外实践教育基地2个。
    	<br>&nbsp;&nbsp;&nbsp;&nbsp;国家级特色专业（4个）：车辆工程、材料成型及控制、计算机科学与技术、会计学   
		<br>&nbsp;&nbsp;&nbsp;&nbsp;国家级综合改革试点专业（2个）：车辆工程、会计学  
		<br>&nbsp;&nbsp;&nbsp;&nbsp;国家级实验教学示范中心（1个）：车辆工程实验教学中心  
		<br>&nbsp;&nbsp;&nbsp;&nbsp;国家级大学生校外实践教育基地（1个）：国家知识产权局知识产权发展研究中心  
		<br>&nbsp;&nbsp;&nbsp;&nbsp;重庆市市级特色专业（6个）：材料科学与工程、电子信息工程、机械设计制造及其自动化、人力资源管理、自动化、信息管理与信息系统 </p></div>
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
    	
    	<div class="courseResearch " id="columns10006" style="display:none"><p>&nbsp;&nbsp;&nbsp;&nbsp;根据2014年12月学校官网显示，学校建有重庆市高校创新团队8个、
    	1个教育部重点实验室、1个教育部工程研究中心、1个生产力促进中心（科技部批建）、11个重庆市重点基地（含重点实验室、工程技术研究中心、人文社会科学重点研究基地）、
    	1个重庆市协同创新中心、2个校级后备重点实验室、2个校级后备人文社会科学重点研究基地、32个校级科研机构；与中国科学院、中国汽车工程研究院、重庆科学技术研究院、重庆长安汽车（集团）有限责任公司、重庆建设工业（集团）有限责任公司、重庆大江工业有限责任公司等科研院所和大型企业共建联合实验室、研究中心24个。   
		<br>&nbsp;&nbsp;&nbsp;&nbsp;教育部重点实验室（1个）：汽车零部件先进制造技术教育部重点实验室   
		<br>&nbsp;&nbsp;&nbsp;&nbsp;教育部工程研究中心（1个）：机械检测技术与装备教育部工程研究中心 
		<br>&nbsp;&nbsp;&nbsp;&nbsp;科技部生产力促进中心（1个）：激光快速原形及模具制造生产力促进中心（重庆）   
		<br>&nbsp;&nbsp;&nbsp;&nbsp;重庆市市级重点实验室（2个）：重庆市汽车零部件及其检测技术重点实验室、重庆市模具技术重点实验室  
		<br>&nbsp;&nbsp;&nbsp;&nbsp;重庆市市级人文社会科学重点研究基地（2个）：重庆市财会研究与开发中心、重庆市劳动经济与人力资源研究中心 
		<br>&nbsp;&nbsp;&nbsp;&nbsp;重庆市市级工程技术研究中心（5个）：重庆市车辆模拟与实验工程技术研究中心、重庆市汽车动力系统及控制工程技术研究中心、重庆市模具工程技术研究中心、重庆市轻合金工程技术研究中心（分中心）、重庆中英（国际）数字医疗技术工程中心 [10]  
		<br>&nbsp;&nbsp;&nbsp;&nbsp;重庆市市级协同创新中心（1个）：高端装备技术协同创新中心
		<br>&nbsp;&nbsp;&nbsp;&nbsp;重庆市市级高校研究中心（2个）：重庆市高校科技发展研究中心、重庆理工大学科技成果转化中心  
		<br>&nbsp;&nbsp;&nbsp;&nbsp;重庆市市级高校创新团队（8个）   </p></div>
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
