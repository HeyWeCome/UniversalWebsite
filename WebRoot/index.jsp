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
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
	
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
  				<p id="welcomeWordsText" class="welcomeWordsText"></p>要填入对应管理员欢迎语
  			</div>
  		</div>
  	</div>
  	
  	
  	<!-- 左边菜单栏整体 -->
    <div class="leftPart">
    	<div class="firstLevelMenu" id="firstLevelMenu"></div>
    </div>
    
    
    <!--右侧主体内容,点击左侧菜单栏后显示相应内容, 用bootstrap的content类包含在一起-->
    <div class="content">
        <div id="matter1" style="display: none">
            <!--留言管理---引入外部文件，即需要在右侧加载的内容，-->
            <jsp:include page="messageManagement.jsp"/>
        </div>

        <%-- <div id="matter2" style="display: none">
        	<!--文章管理  -->
            <jsp:include page="articleManagement.jsp"/>
        </div> --%>

        <div id="matter3" style="display: none">
        	<!--审核文章  -->
            <jsp:include page="articleReview.jsp"/>
        </div>

        <div id="matter4" style="display: none">
        	<!--栏目管理  -->
            <jsp:include page="columnManagement.jsp"/>
        </div>
        
         <div id="matter5"  style="display: none">
            <!--权限管理-->
            <jsp:include page="authorityManagement.jsp"/>
        </div>

        <div id="matter6" style="display: none">
        	<!--模块管理  -->
            <jsp:include page="moduleManagement.jsp"/>
        </div>

        <div id="matter7" style="display: none">
        	<!--角色分配  -->
            <jsp:include page="roleAssignment.jsp"/>
        </div>

        <div id="matter8" style="display: none">
        	<!--人员管理-->
            <jsp:include page="personnelManagement.jsp"/>
        </div>
        
        <div id="matter9" style="display: none">
        	<!--角色管理  -->
            <jsp:include page="roleManagement.jsp"/>
        </div>
    </div>
    
  </body>
  <script src="js/myJS/index.js"></script>
  <script src="js/bootstrap.js"></script>
</html>
