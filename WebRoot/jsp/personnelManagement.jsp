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
    	<div class="topText"> &nbsp;人员管理</div>
    </div>
    
    
    <div class="rightTable" style="width:100%" >
	    <div class="buttons">
	        <button type="button" class="btn btn-primary"  onclick="getRolesName()" data-toggle="modal" data-target="#addManagerModal" style="background-color:#5E6F8A;color:#fff;">&nbsp;新增&nbsp;</button>
	        <button id="del" onclick="deletesManager()" type="button" class="btn btn-primary " style="background-color:#5E6F8A;color:#fff;">&nbsp;删除&nbsp;</button>
	    	<button onclick="refresh4()" type="button" class="btn btn-primary " style="color:#5E6F8A;background-color:#fff;">&nbsp;刷新&nbsp;</button>
	    </div>
	
	    <!--表格，样式在js中定义-->
	    <table id="managerTable" style="font-size: 12px; background-color:#b0c4de2e;">
	    </table>
	    
	    
	    <!-- 新增弹框 -->
		   <div id="addManagerModal" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
		       <div class="modal-dialog" role="document">
		           <div class="modal-content">
		               <div class="modal-header" style="background-color: #999">
		                   <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		                   <h4 class="modal-title">新增人员</h4>
		               </div>
		            	<form action="control/InsertEmployee" method="post">
		                <div class="modal-body">
		                    <div class="row">
		                        <div class="col-xs-12 col-md-12">
		                            <h4>人员姓名：</h4>
		                            <input  type="text" id="add_managerName" name="name" class="form-control" aria-describedby="basic-addon1"/>
		                        </div>
		                         <div class="col-xs-12 col-md-12">
		                            <h4>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</h4>
		                            <select class="form-control" id="add_managerSex" name="sex" style="width:168px">
		                        		<option>男</option>
		                        		<option>女</option>
		                        	</select>
		                        </div> 
		                        <div class="col-xs-12 col-md-12">
		                            <h4>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</h4>
		                            	<input  type="text" id="add_managerAccount" name="account" class="form-control" aria-describedby="basic-addon1"/>
		                        </div>
		                        <div class="col-xs-12 col-md-12">
		                            <h4>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</h4>
		                            	<input  type="text" id="add_managerPassword" name="passWord" class="form-control" aria-describedby="basic-addon1"/>
		                        </div>
		                        <div class="col-xs-12 col-md-12">
		                            <h4>人员角色：</h4>
		                            <select class="form-control" id="add_managerRole" name="roleName" style="width:168px">
		                        		
		                        	</select>
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
		   
		   
		   <!-- 查看弹框 -->
		   <div id="checkManagerModal" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
		       <div class="modal-dialog" role="document">
		           <div class="modal-content">
		               <div class="modal-header" style="background-color: #999">
		                   <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		                   <h4 class="modal-title">查看人员</h4>
		               </div>
		                <div class="modal-body">
		                    <div class="row">
		                        <div class="col-xs-12 col-md-12">
		                            <h4>人员姓名：</h4>
		                            <input readonly="true" type="text" id="check_managerName" name="name" class="form-control" aria-describedby="basic-addon1"/>
		                        </div>
		                         <div class="col-xs-12 col-md-12">
		                            <h4>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</h4>
		                            <input readonly="true" type="text" id="check_managerSex" name="sex" class="form-control" aria-describedby="basic-addon1"/>
		                            <!-- <select class="form-control" id="check_managerSex" name="sex" style="width:168px">
		                        		<option>男</option>
		                        		<option>女</option>
		                        	</select> -->
		                        </div> 
		                        <div class="col-xs-12 col-md-12">
		                            <h4>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</h4>
		                            	<input readonly="true" type="text" id="check_managerAccount" name="account" class="form-control" aria-describedby="basic-addon1"/>
		                        </div>
		                        <div class="col-xs-12 col-md-12">
		                            <h4>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</h4>
		                            	<input readonly="true" type="text" id="check_managerPassword" name="passWord" class="form-control" aria-describedby="basic-addon1"/>
		                        </div>
		                        <div class="col-xs-12 col-md-12">
		                            <h4>人员角色：</h4>
		                            <input readonly="true" type="text" id="check_managerRole" name="roleName" class="form-control" aria-describedby="basic-addon1"/>
		                           <!--  <select class="form-control" id="add_managerRole" name="roleName" style="width:168px">
		                        		
		                        	</select> -->
		                        </div>

		                    </div>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-default" data-dismiss="modal" style="background-color:#fff;color:#5E6F8A;">关闭</button>
		                	
		                </div>
		           </div>
		       </div>
		   </div>
		   
		   
		    <!-- 修改弹框 -->
		   <div id="editManagerModal" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
		       <div class="modal-dialog" role="document">
		           <div class="modal-content">
		               <div class="modal-header" style="background-color: #999">
		                   <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		                   <h4 class="modal-title">修改人员</h4>
		               </div>
		               
		               <form action="control/InsertArticle" method="post">
		                <div class="modal-body">
		                    <div class="row">
		                        <div class="col-xs-12 col-md-12">
		                            <h4>人员姓名：</h4>
		                            <input type="text" id="edit_managerName" name="name" class="form-control" aria-describedby="basic-addon1"/>
		                        </div>
		                         <div class="col-xs-12 col-md-12">
		                            <h4>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</h4>
		                            <!-- <input type="text" id="check_managerSex" name="sex" class="form-control" aria-describedby="basic-addon1"/> -->
		                            <select class="form-control" id="edit_managerSex" name="sex" style="width:168px">
		                        		<option>男</option>
		                        		<option>女</option>
		                        	</select>
		                        </div> 
		                        <div class="col-xs-12 col-md-12">
		                            <h4>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</h4>
		                            	<input readonly="true" type="text" id="edit_managerAccount" name="account" class="form-control" aria-describedby="basic-addon1"/>
		                        </div>
		                        <div class="col-xs-12 col-md-12">
		                            <h4>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</h4>
		                            	<input  type="text" id="edit_managerPassword" name="passWord" class="form-control" aria-describedby="basic-addon1"/>
		                        </div>
		                        <div class="col-xs-12 col-md-12">
		                            <h4>人员角色：</h4>
		                            <!-- <input readonly="true" type="text" id="check_managerRole" name="roleName" class="form-control" aria-describedby="basic-addon1"/> -->
		                           	<select class="form-control" id="edit_managerRole" name="roleName" style="width:168px">
		                        		
		                        	</select>
		                        </div>

		                    </div>
		                </div>
		                </form>
		                
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-default" data-dismiss="modal" style="background-color:#fff;color:#5E6F8A;">关闭</button>
		                	<button type="submit" class="btn btn-primary" style="background-color:#5E6F8A;color:#fff;">编辑</button>
		                </div>
		           </div>
		       </div>
		   </div>
		   
		   
	    
	</div>
	
	
	
  </body>
  <script src="./js/myJS/personnelManagement.js"></script>
</html>
