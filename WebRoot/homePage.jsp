<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>通用课程主首页</title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-table.css">
	<link rel="stylesheet" type="text/css" href="css/homePage.css">
	 
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
  </head>
  
  <body onload="showCourse()">
  	<div class="header">
  		<img class="headerBackground" alt="重庆理工大学" src="images/cqutBackground.png" width="100%" height="250px">
  	</div>
  
  	<div class="mainContent">
  		<div class="leftContent">
  			<p class="selectWord">请选择课程：</p>
  			<div class="selectCourse">
  				<div class="allCourse" id="allCourse"></div>
  			</div>
  		</div>
  		<div class="centerContent">
  			<div style="float:left;width: 2px;height:400px; margin-top:25px;background: #966a6a;"></div> 
  		</div>
  		
  		<div class="rightContent">
  			<p class="rightWord">
  				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  				软件工程专业本专业培养适应我国社会主义现代化建设需要的，德、智、体全面发展，具有良好的人文和科学素养，受到良好的实际应用训练，较系统、扎实地掌握软件工程的基本理论、
  				专业知识和技能，掌握国际上最新的软件开发技术和软件项目管理方法，具有较强的实践动手能力，能从事信息技术领域相关工作的高素质应用型专门人才。
  				本专业毕业生可在信息技术产业、大专院校、企业、部队以及相关科研院所等单位从事各类计算机软件的设计、开发、应用与维护等方面的工作，
  				也可以继续攻读软件工程及相关专业的硕士和博士研究生。<br/>
  				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  				本专业毕业生需要达到全国计算机技术与软件专业技术资格（水平）考试中的初级水平（程序员级）。
  				主要课程：离散数学、数据结构、数字电子技术、计算机组成原理、数据库原理、面向对象程序设计(C++/Java)、操作系统、计算机网络技术、软件工程、
  				统一建模语言及建模工具、系统分析与设计、软件测试技术、软件项目管理、面向对象系统分析设计、软件构件技术、J2EE架构与程序设计、.NET架构与程序设计等。
  				主要实践环节：程序设计实践、数据结构课程设计、软件文档案例学习与实践、软件需求分析案例学习与实践、软件架构与设计案例学习与实践、软件测试案例学习与实践、
  				软件项目管理案例学习与实践等。<br/>
  				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  				专业特色：本专业以市场需求为导向，面向软件工程领域的前沿，强调培养适合国家产业结构调整、与国际接轨的应用型软件人才。
  				部分课程将直接采用国外著名高校的最新原版英文教材，部分课程采用双语或聘请校外专家授课。引进国内高校先进的教学模式，在精简理论知识授课时数的同时，
  				专业核心课程通过案例教学和项目实践来培养学生的动手与自学能力。使学生掌握国际上最新的软件开发技术和软件项目管理方法，熟练使用国际上最新的流行软件环境与工具，具备较强的软件开发能力。
  				本专业设置了软件开发员、软件架构与设计师和多媒体软件开发三个专业方向，各学期均安排高强度的软件开发实践，可以使学生根据自己的兴趣爱好自由选择和发展。
  			</p>
  		</div>
  	</div>
   
    <div class="footer">
  		<img class="footerBackground" alt="重庆理工大学校徽" src="images/cqutFooter.png" width="100%">
  	</div>
  </body>
  
  <script type="text/javascript" src="js/jquery.cookie.js"></script>
	<script src="js/myJS/homePage.js"></script>
</html>
