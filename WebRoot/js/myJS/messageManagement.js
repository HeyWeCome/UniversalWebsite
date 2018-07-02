
function operationIcon5(value,row,index) {
    return[
			'<button type="button" id="reply" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#replyMessageModal" >回复',
			'<button type="button" id="deleteMessage" class="btn btn-primary btn-xs" style="background-color:#fff;color:#337AB7;" >删除'
        ].join('');
}

/* 刷新方法 */
function refresh5(){
    $('#messageTable').bootstrapTable('refresh', null);
}

/*每行表格尾部的小图标点击*/
window.operateEvents5 = {
	'click #reply':function (e,value,row,index) {
    	//alert("进入查看弹框")
        //将该行数据填入模态框中
        $('#messageContent').val(row.content);
        $('#message_createTime').val(row.createTime);
        var a=$.cookie("userName");
        $('#message_replyEmployee').val(a);
    },
	'click #deleteMessage':function (e,value,row,index) {
        var determine = confirm("确认删除？");
        if(determine==true){
        	//alert(row.title+" "+row.author)
        	$.ajax({    		
                url:"control/DeleteMessage",//servlet文件的名称  
                type:"POST",  
                dataType:"json",
                data:{
                	"content":row.content
                },
                //data:{"questionnaireId":"<%=questionnaireId%>"},
                success:function(data1){
                	alert("删除成功！")
                }
            });
        }
    }
}

function deletesMessage(){
	var data = $('#messageTable').bootstrapTable('getSelections');
	    
	    if(data.length==0){
	        alert("请至少选中一条数据");
	        return;
	    }
	    var ids = "";
	    var determine = confirm("确认删除？")
	    if(determine==true){
	    	for(var i=0; i<data.length; i++){
	    		//alert(data[i].title+" "+data[i].author)    	
	    		$.ajax({    		
	                url:"control/DeleteMessage",//servlet文件的名称  
	                type:"POST",  
	                dataType:"json",
	                data:{
	                	"content":data[i].content
	                },
	                success:function(data1){
	                	
	                }
	    		});
	    	}
	    	alert("删除成功！")
	    	
	    }
}

/*定义表格*/
$(function () {
    $('#messageTable').bootstrapTable({
        //height: 400,//定义表格的高度
        //data:students,
    	url:'control/FindAllMessage',
    	contentType:'application/json',//发送到服务器的数据编码类型
    	method: 'post',//请求方式
		dataType:'json',//服务器返回的数据类型	
		//showRefresh: true,  //显示刷新按钮 
        search:true,
        striped: true,// 隔行变色效果
        pagination: true,//在表格底部显示分页条
        pageSize: 10,//页面数据条数
        // sidePagination: "server",
        //pageNumber:1,//首页页码
        //showRefresh:true,
        pageList: [8,10,15,20,30],//设置可供选择的页面数据条数
        clickToSelect:false,//设置true 将在点击行时，自动选择rediobox 和 checkbox
        cache: false,//禁用 AJAX 数据缓存
        toolbar : '#toolbar',//工具按钮容器
        //sortName:'OPERATORID',//定义排序列
        //sortOrder:'asc',//定义排序方式
        // sidePagination:'server',//设置在哪里进行分页
        onLoadSuccess:function(data){
        	console.log(data);
        },
        columns:[{
            checkbox:true,//勾选框
            width:'3'//宽度
        },{
            title:'序号',
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'5',//宽度
            formatter:function (value,row,index) {//生成序号
                return index+1;
            }
        },{
            field:'content',//返回值名称
            title:'留言',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'10'//宽度
        },{
            field:'createTime',//返回值名称
            title:'留言时间',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'5'//宽度
        },{
            field:'reply',//返回值名称
            title:'回复',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'20'//宽度
        },{
            field:'replyTime',//返回值名称
            title:'回复时间',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'10'//宽度
        },{
            field:'replyEmployee',//返回值名称
            title:'回复人',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'10'//宽度
        },{
            field:'status',//返回值名称
            title:'回复状态',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'10'//宽度
        },{
            field:'oprate',//返回值名称
            title:'操作',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'15',//宽度
            events:operateEvents5,
            formatter:operationIcon5
        }]//列配置项,详情请查看 列参数 表格
        /*事件*/
    });
});
