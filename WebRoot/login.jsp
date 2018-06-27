<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>通用课程网站管理员登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script src="js/jquery-2.1.1.min.js"></script>
  <script src="js/gVerify.js"></script>
  
  <script type="text/javascript">
	  function verify(){	
		  alert("进入方法");
			/* document.getElementById("confirmLogin").onclick = function(){ */
				var res = verifyCode.validate(document.getElementById("verify").value);
				if(res){
					alert("验证正确");
					//var account = document.getElementById("ACCOUNT").value;
					//var password = document.getElementById("PASSWORD").value;
					var userAccount = {
							ACCOUNT:document.getElementById("ACCOUNT").value,
							PASSWORD:document.getElementById("PASSWORD").value,
					}
					 $.ajax({    
				            url:"servlet/Login",//servlet文件的名称  
				            type:"POST",  
				            dataType:"json",
				            data:userAccount,
				            success:function(data){
				            	if(data=="-1"){
				            		alert("用户名不能为空！");
				            	}
				            	else if(data=="-2"){
				            		alert("密码不能为空！");
				            	}
				            	else if(data=="-3"){
				            		alert("用户名不存在！");
				            	}
				            	else if(data=="-4"){
				            		alert("密码输入错误！");
				            	}
				            	else if(data=="1"){
				            		alert("登录成功！");
				            		var url = "login.jsp";
				            		window.location = url;

				            	}
				            }
				      });
					
				}else{
					alert("验证码错误");
					
				}
			//}
	  }		
  </script>

  </head>
  
  <body>
  
  	<style type="text/css">
		* {
			margin: 0;
			padding: 0;
		}
		
		body {
			width: 100%;
			height: 500px;
			display: inline;
		}
		.leftPart{
			width: 50%;
			height: 500px;
			float: left;
		}		
		.logo{
			width: 80%;
			height: 500px;
		}
		.teacherLogo{
			margin-top:30%;
			margin-left:50%;
		}
		.verticalLine{
			width:1%;
			height:80%;
			background-color:#b0c4de;
			border-radius: 5px;
			float:right;
			margin-top:20%;
			margin-right:-22%;
		}
		.rightPart {
			width: 45%;
			height: 500px;
			float: right;
		}
		
		.inputForm {
			width: 20%;
			height: 300px;
			margin-top: 28%;
		}
		
		.btn-default {
			float: left;
		}
		
		.input-form {
			margin-bottom: 20%;
			line-height: 40px;
			padding-left: 20px;
			width: 380px;		
			border: 1px solid #ccc;		
			border-radius: 4px;
		}
		input:-webkit-autofill {
			-webkit-box-shadow: 0 0 0px 1000px white inset;
			border: 1px solid #CCC!important;
			border-radius: 0 4px 4px 0;
		}

		
		.btn {
			color: #fff;
			background-color: #337ab7;
			border-color: #2e6da4;
			display: inline-block;
			/* padding: 8px 194px; */
			height: 50px;
			width: 380px;
			float:right;
			margin-right:-251px;
			font-size: 14px;
			font-weight: normal;
			line-height: 1.42857143;
			text-align: center;
			white-space: nowrap;
			vertical-align: middle;
			-ms-touch-action: manipulation;
			touch-action: manipulation;
			cursor: pointer;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none;
			background-image: none;
			border: 1px solid transparent;
			border-radius: 4px;
		}
		
		.toPhoneNum {
			float: left;
			font-size: 13px;
			color: #23527c;
			margin-top: 5px;
			margin-left: 41%;
		}
		.line1{
		    width: 28%;
		    height: 4px;
		    background-color: lightsteelblue;
		    float: left;
		    margin-top: 3%;
		    margin-left:5.5%;
		 
		}
		.title{
		    font-family: "Microsoft YaHei";
		    font-size: 18px;
		    color: #333;
		    float: left;
		    font-weight: bold;
		    margin-left: 10%;
		    margin-right: 4%;
		    margin-top: 2%;
		}

	</style>
	
    <div class="line1"></div>
    <p class="title">通用课程网站后台系统</p>
    <div class="line1"></div>
    
	<div class="leftPart">
		<div class="logo">
				<img class="teacherLogo" src="images/courseLogo.png" width="250" height="250" />
				<div class="verticalLine"></div>
		</div>
		
	</div>

	<div class="rightPart">
		<div class="inputForm">
			<h3 style="margin-bottom: 10%;width:150px;float:left;">登录账号</h3>
			<!-- <form action="" method="post" onsubmit="return verify();"> -->
				<input name="ACCOUNT" id="ACCOUNT" type="text" class="input-form" id="ACCOUNT" placeholder="请输入用户名" > 
				<input name="PASSWORD" id="PASSWORD" type="password" class="input-form" id="PASSWORD" placeholder="请输入密码" readonly onfocus="this.removeAttribute('readonly');"/>
				<input name="verify" type="text" class="input-form"  id="verify" placeholder="请输入图片验证码" >
				<div id="v_container" style="width: 200px;height: 50px; float:left;"></div> 
				<button style="width:150px;" class="btn btn-default" id="confirmLogin" onclick="verify()" >登录</button>
			<!-- </form> -->
		</div>
	</div>
  </body>
  <script>
  	var verifyCode = new GVerify("v_container");
	  
	</script>
</html>
