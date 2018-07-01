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
    <div class="rightTable">
	    <div class="buttons">        
	        <button id="del" onclick="deletesMessage()" type="button" class="btn btn-primary " style="background-color:#5E6F8A;color:#fff;">&nbsp;删除&nbsp;</button>
	    	<button onclick="refresh5()" type="button" class="btn btn-primary " style="color:#5E6F8A;background-color:#fff;">&nbsp;刷新&nbsp;</button>
	    </div>
	
	    <!--表格，样式在js中定义-->
	    <div ><!-- style="font-size: 20px;" -->
		    <table id="messageTable" style="background-color:#b0c4de2e;" >
		    	<!-- <div class="pull-right search">
		    		<input class="form-control" type="text" id="searchColumn" placeholder="搜索">
		   		</div> -->
		    </table>
	    </div>
	    
	    <!-- 回复弹框 -->
		   <div id="replyMessageModal" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
		       <div class="modal-dialog" role="document">
		           <div class="modal-content">
		               <div class="modal-header" style="background-color: #999">
		                   <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		                   <h4 class="modal-title">回复留言</h4>
		               </div>
		            	<form action="control/InsertArticle" method="post">
		                <div class="modal-body">
		                    <div class="row">
		                        <div class="col-xs-12 col-md-12">
		                            <h4>留&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;言：</h4>
		                            <textarea readonly="true" class="textArea" name="content" id="messageContent" rows="3" cols="60"></textarea>
		                        </div>
		                         <div class="col-xs-12 col-md-12">
		                            <h4>留言时间：</h4>
		                            <input readonly="true" type="text" id="message_createTime" name="createTime" class="form-control" aria-describedby="basic-addon1"/>
		                        </div> 
		                        <div class="col-xs-12 col-md-12">
		                            <h4>回&nbsp;&nbsp;复&nbsp;&nbsp;人：</h4>
		                            <input readonly="true" type="text" id="message_replyEmployee" name="replyEmployee" class="form-control" aria-describedby="basic-addon1"/>
		                        </div>
		                        <div class="col-xs-12 col-md-12">
		                            <h4>回&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;复：</h4>
		                            <textarea class="textArea" name="content" rows="8" cols="60"></textarea>
		                        </div>
		                        
		                        <input style="displar:none" type="text" id="message_replyEmployee" name="replyEmployee" class="form-control" aria-describedby="basic-addon1"/>
		                    
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
		   
		   
    </div>
  </body>
    <script src="./js/myJS/messageManagement.js"></script>
</html>
