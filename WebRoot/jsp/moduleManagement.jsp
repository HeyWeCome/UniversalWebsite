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
    	<div class="topText"> &nbsp;模块管理</div>
    </div>
    
    <div class="buttons">
        <button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#addModuleModal" style="background-color:#5E6F8A;color:#fff;">&nbsp;新增&nbsp;</button>
    	<button onclick="refresh3()" type="button" class="btn btn-primary " style="color:#5E6F8A;background-color:#fff;">&nbsp;刷新&nbsp;</button>
    </div>
    
    <!--表格，样式在js中定义-->
    <table id="moduleManagementTable" style="font-size: 12px; background-color:#b0c4de2e;"></table>
    
    <!-- 新增弹框 -->
   <div id="addModuleModal" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
       <div class="modal-dialog" role="document">
           <div class="modal-content">
               <div class="modal-header" style="background-color: #999">
                   <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                   <h4 class="modal-title">新增模块</h4>
               </div>
            	<form action="control/InsertModule" method="post">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12 col-md-12">
                            <h4>模&nbsp;&nbsp;块&nbsp;&nbsp;ID：</h4>
                            <input  type="text" id="add_roleName" name="id"class="form-control"aria-describedby="basic-addon1"/>
                        </div>
                         <div class="col-xs-12 col-md-12">
                            <h4>模块名称：</h4>
                            <input  type="text" id="add_description" name="name" class="form-control" aria-describedby="basic-addon1"/>
                        </div> 	
                        <div class="col-xs-12 col-md-12">
                            <h4>模块状态：</h4>
                            <input  type="text" id="add_description" name="status" class="form-control" aria-describedby="basic-addon1"/>
                        </div> 	
                        <div class="col-xs-12 col-md-12">
                            <h4>父类模块：</h4>
                            <input  type="text" id="add_description" name="parentModuleID" class="form-control" aria-describedby="basic-addon1"/>
                        </div> 		                        		                        		                        
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" style="background-color:#fff;color:#5E6F8A;">关闭</button>
                    <button type="submit" class="btn btn-primary" style="background-color:#5E6F8A;color:#fff;">新增</button>
                </div>
                </form> 
           </div>
       </div>
   </div>
    
  </body>
  <script src="./js/myJS/moduleManagement.js"></script>
</html>
