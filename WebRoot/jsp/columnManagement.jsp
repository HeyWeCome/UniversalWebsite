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

  </head>
  
  <body>
    <div class="top">
    	<div class="topText"> &nbsp;栏目管理</div>
    </div>
    <div class="showTree">
    <div class="buttons">
        <button type="button" onclick="getColumnName()" class="btn btn-primary"  data-toggle="modal" data-target="#addColumnModal" style="background-color:#5E6F8A;color:#fff;">&nbsp;新增&nbsp;</button>
    	<button onclick="refreshColumn()" type="button" class="btn btn-primary " style="color:#5E6F8A;background-color:#fff;">&nbsp;刷新&nbsp;</button>
    </div>
    
     <!--表格，样式在js中定义-->
    <table id="columnManagementTable" style="font-size: 12px; background-color:#b0c4de2e;"></table>
    
   <!-- 新增弹框 -->
   	<div id="addColumnModal" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
       <div class="modal-dialog" role="document">
           <div class="modal-content">
               <div class="modal-header" style="background-color: #999">
                   <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                   <h4 class="modal-title">新增栏目</h4>
               </div>
            	<!-- <form action="control/InsertColumn" method="post"> -->
                <div class="modal-body">
                    <div class="row">
                        <!-- <div class="col-xs-12 col-md-12">
                            <h4>栏&nbsp;&nbsp;目&nbsp;&nbsp;ID：</h4>
                            <input  type="text" id="addColumnId" name="id"class="form-control"aria-describedby="basic-addon1"/>
                        </div> -->
                         <div class="col-xs-12 col-md-12">
                            <h4>栏目名称：</h4>
                            <input  type="text" id="addColumnName" name="name" class="form-control" aria-describedby="basic-addon1"/>
                        </div> 	
                       <!--  <div class="col-xs-12 col-md-12">
                            <h4>栏目级别：</h4>
                            <input  type="text" id="addColumnLevel" name="level" class="form-control" aria-describedby="basic-addon1"/>
                        </div> 	 -->
                        <div class="col-xs-12 col-md-12">
                            <h4>上级栏目：</h4>
                            <select class="form-control" id="selectColumnName" name="parentColumnName" style="width:196px">
		                    </select>
                        </div> 		                        		                        		                        
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" style="background-color:#fff;color:#5E6F8A;">关闭</button>
                    <button type="button" onclick="addColumn()" class="btn btn-primary" style="background-color:#5E6F8A;color:#fff;">新增</button>
                </div>
               <!--  </form>  -->
           </div>
       </div>
  </div>
  
   <!-- 修改弹框 -->
   <div id="editColumnModal" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
       <div class="modal-dialog" role="document">
           <div class="modal-content">
               <div class="modal-header" style="background-color: #999">
                   <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                   <h4 class="modal-title">编辑栏目</h4>
               </div>
               
               <!-- <form action="control/UpdateArticle" method="post"> -->
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12 col-md-12">
                            <h4>栏目名称：</h4>
                            <input  type="text" id="editColumnName" name="name" class="form-control" aria-describedby="basic-addon1"/>
                        </div> 	
                        <div class="col-xs-12 col-md-12">
                            <h4>栏目级别：</h4>
                            <select class="form-control" id="editColumnLevel" name="level" style="width:196px">
                        		<option value="0">0级</option>
                        		<option value="1">1级</option>
		                    </select>
                            <!-- <input  type="text" id="editColumnLevel" name="level" class="form-control" aria-describedby="basic-addon1"/> -->
                        </div> 	
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" style="background-color:#fff;color:#5E6F8A;">关闭</button>
                    <button id="btEdit" onclick="editColumn()" type="button" class="btn btn-primary" style="background-color:#5E6F8A;color:#fff;">编辑</button>
                </div>
            <!-- </form> -->
            
           </div>
       </div>
   </div>
  
  </div>
  </body>
  <script src="./js/myJS/columnManagement.js"></script>
</html>
