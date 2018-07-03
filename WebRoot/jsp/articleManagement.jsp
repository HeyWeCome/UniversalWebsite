<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文章管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- <script src="js/jquery-2.1.1.min.js"></script> -->
	<link rel="stylesheet" type="text/css" href="css/articleManagement.css">
	
	<!-- <script src="js/jquery-2.1.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-table.css">

    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap-table.js"></script>
    <script src="js/bootstrap-table-zh-CN.js"></script>
	 -->
  </head>
  
  <body >
    <div class="top">
    	<div class="topText"> &nbsp;文章管理</div>
    </div>
    <iframe id="id_iframe" name="nm_iframe" style="display:none;"></iframe>
    
    <div class="leftColumns" id="leftColumns">
    	<button class="allColumns" id="allColumns" onclick="showColumnsOrNot()">所有栏目</button>
    	<div class="columns" id="columns" ></div>
    </div>
    
    <div class="rightTable">
	    <div class="buttons">
	        <button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#addArticleModal" onclick="getColumnsName()" style="background-color:#5E6F8A;color:#fff;">&nbsp;新增&nbsp;</button>
	        <button id="del" onclick="deletes()" type="button" class="btn btn-primary " style="background-color:#5E6F8A;color:#fff;">&nbsp;删除&nbsp;</button>
	    	<button onclick="refresh1()" type="button" class="btn btn-primary " style="color:#5E6F8A;background-color:#fff;">&nbsp;刷新&nbsp;</button>
	    </div>
	
	    <!--表格，样式在js中定义-->
	    <div ><!-- style="font-size: 20px;" -->
		    <table id="articleTable" style="background-color:#b0c4de2e;" >
		    	<!-- <div class="pull-right search">
		    		<input class="form-control" type="text" id="searchColumn" placeholder="搜索">
		   		</div> -->
		    </table>
	    </div>
	    <!-- 上传资源弹框 -->
		   <div id="uploadModal" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
		       <div class="modal-dialog" role="document">
		           <div class="modal-content">
		               <div class="modal-header" style="background-color: #999">
		                   <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		                   <h4 class="modal-title">上传资源</h4>
		               </div>
		              <form action="control/UploadServlet" method="post" enctype="multipart/form-data" target="nm_iframe">
		                <div class="modal-body">
		                    <div class="row">
		                    	 <div class="col-xs-12 col-md-12">
		                            <h4>文章标题：</h4>
		                            <input readonly="true" type="text" id="upload_title" name="title" class="form-control" aria-describedby="basic-addon1"/>
		                        </div>
		                        <div class="col-xs-12 col-md-12">
		                            <h4>作者：</h4>
		                            <input readonly="true" type="text" id="upload_author" name="author" class="form-control" aria-describedby="basic-addon1"/>
		                        </div>
		                        <div class="col-xs-12 col-md-12">
		                            <h4>资源地址：</h4>
		                            <input type="file" name="file" id="upload_file" class="form-control" aria-describedby="basic-addon1">
		                        </div>
		                           
		                    </div>
		                </div>
		                <!-- <div class="uploadImformation" name="uploadImformation" id="uploadImformation" type="hidden"></div> -->
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		                    <button type="submit" class="btn btn-primary" id="alertSuccess">上传</button>
		                </div>
		               </form>
		           </div>
		       </div>
		   </div>
	    
	    
	    <!-- 新增弹框 -->
		   <div id="addArticleModal" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
		       <div class="modal-dialog" role="document">
		           <div class="modal-content">
		               <div class="modal-header" style="background-color: #999">
		                   <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		                   <h4 class="modal-title">新增文章</h4>
		               </div>
		            	<!-- <form action="control/InsertArticle" method="post" target="nm_iframe"> -->
		                <div class="modal-body">
		                    <div class="row">
		                        <div class="col-xs-12 col-md-12">
		                            <h4>文章标题：</h4>
		                            <input  type="text" id="add_title" name="title"class="form-control"aria-describedby="basic-addon1"/>
		                        </div>
		                         <div class="col-xs-12 col-md-12">
		                            <h4>作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：</h4>
		                            <input readonly="true" type="text" id="add_author" name="author" class="form-control" aria-describedby="basic-addon1"/>
		                        </div> 
		                        <div class="col-xs-12 col-md-12">
		                            <h4>栏目名称：</h4>
		                            <!-- <input  type="text" id="add_GRADE" name="GRADE" class="form-control" aria-describedby="basic-addon1"/> -->
		                        	<select class="form-control" id="add_columnName" name="columnName" style="width:188px">
		                        		<!-- <option>男</option>
		                        		<option>女</option> -->
		                        	</select>
		                        </div>
		                        <div class="col-xs-12 col-md-12">
		                            <h4>是否置顶：</h4>
		                            <select class="form-control" id="add_whetherTop" name="whetherTop" style="width:188px">
		                        		<option>否</option>
		                        		<option>是</option>
		                        	</select>
		                        </div>
		                        
		                        <div class="col-xs-12 col-md-12">
		                            <h4 class="textAreah4" style="margin-left:8%">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述：</h4>
		                            <textarea class="textArea" name="content" id="add_articleContent" rows="8" cols="60"></textarea>
		                        </div>
		                        
		                        
		                    </div>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-default" data-dismiss="modal" style="background-color:#fff;color:#5E6F8A;">关闭</button>
		                    <button type="button" onclick="addArticle()" class="btn btn-primary" style="background-color:#5E6F8A;color:#fff;">新增</button>
		                </div>
		                <!-- </form>
		                <iframe id="id_iframe" name="nm_iframe" style="display:none"></iframe> -->
		           </div>
		       </div>
		   </div>
		
		
		   <!-- 查看弹框 -->
		   <div id="checkArticleModal" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
		       <div class="modal-dialog" role="document">
		           <div class="modal-content">
		               <div class="modal-header" style="background-color: #999">
		                   <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		                   <h4 class="modal-title">查看文章信息</h4>
		               </div>
		               <div class="modal-body">
		                   <div class="row">
		                       <div class="col-xs-12 col-md-12">
		                           <h4>文章标题：</h4>
		                           <input readonly="true" type="text" id="check_title" name="title"class="form-control"aria-describedby="basic-addon1"/><!--设置不可编辑-->
		                       </div>
		                       <div class="col-xs-12 col-md-12">
		                           <h4>作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：</h4>
		                           <input  readonly="true" type="text" id="check_author" name="author" class="form-control" aria-describedby="basic-addon1"/>
		                       </div>
		                       <div class="col-xs-12 col-md-12">
		                           <h4>栏目名称：</h4>
		                           <!-- <input  readonly="true" type="text" id="check_SEX" name="SEX" class="form-control" aria-describedby="basic-addon1"/> -->
		                       		<input readonly="true" type="text" class="form-control" id="check_columnName" name="columnName" aria-describedby="basic-addon1"/>		                       		
		                       </div>
		                    
		                       <div class="col-xs-12 col-md-12">
		                           <h4>创建时间：</h4>
		                           <input  readonly="true" type="text" id="check_createTime" name="createTime" class="form-control" aria-describedby="basic-addon1"/>
		                       </div>
		                       <div class="col-xs-12 col-md-12">
		                           <h4>是否置顶：</h4>
		                           <input readonly="true" class="form-control" id="check_whetherTop" name="whetherTop"/>
		                       </div>
		                       
		                       <div class="col-xs-12 col-md-12">
		                            <h4 class="textAreah4" style="margin-left:8%">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述：</h4>
		                            <textarea readonly="true" class="textArea" id="check_content" name="content" rows="8" cols="60"></textarea>
		                        </div>
		                        
		                   </div>
		               </div>
		               <div class="modal-footer">
		                   <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
		                   <!--<button type="button" class="btn btn-primary" onclick="add()">新增</button>-->
		               </div>
		           </div>
		       </div>
		   </div>
		
		
		   <!-- 修改弹框 -->
		   <div id="editArticleModal" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
		       <div class="modal-dialog" role="document">
		           <div class="modal-content">
		               <div class="modal-header" style="background-color: #999">
		                   <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		                   <h4 class="modal-title">编辑文章信息</h4>
		               </div>
		               
		               <!-- <form action="control/UpdateArticle" method="post"> -->
		                <div class="modal-body">
		                    <div class="row">
		                        <div class="col-xs-12 col-md-12">
		                            <h4>文章标题：</h4>
		                            <input  onclick="getColumnsName()" type="text" id="edit_title" name="title"class="form-control"aria-describedby="basic-addon1"/>
		                        </div>
		                        <div class="col-xs-12 col-md-12">
		                            <h4>作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：</h4>
		                            <input readonly="true" type="text" id="edit_author" name="author" class="form-control" aria-describedby="basic-addon1"/>
		                        </div>
		                        <div class="col-xs-12 col-md-12">
		                            <h4>栏目名称：</h4>
		                            <!-- <input  type="text" id="edit_SEX" name="SEX" class="form-control" aria-describedby="basic-addon1"/> -->
		                        	<select class="form-control" id="edit_columnName" name="columnName" style="width:188px">
		                        		
		                        	</select>
		                        </div>
		                        <div class="col-xs-12 col-md-12">
		                            <h4>是否置顶：</h4>
		                            <!-- <input  type="text" id="edit_whetherTop" name="whetherTop" class="form-control" aria-describedby="basic-addon1"/> -->
		                        	<select class="form-control" id="edit_whetherTop" name="whetherTop" style="width:188px">
			                       		<option>否</option>
			                       		<option>是</option>
		                       	   </select>
		                        </div>
		                        
		                        <div class="col-xs-12 col-md-12">
		                            <h4 class="textAreah4" style="margin-left:8%">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述：</h4>
		                            <textarea class="textArea" id="edit_articleContent" name="content" rows="8" cols="60"></textarea>
		                        </div>
		                        		                        
		                    </div>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-default" data-dismiss="modal" style="background-color:#fff;color:#5E6F8A;">关闭</button>
		                    <button id="btEdit" onclick="editArticle()" type="button" class="btn btn-primary" style="background-color:#5E6F8A;color:#fff;">编辑</button>
		                </div>
		            <!-- </form> -->
		            
		           </div>
		       </div>
		   </div>
		    
    </div>
    
  </body>
  <script src="./js/myJS/articleManagement.js"></script>
</html>
