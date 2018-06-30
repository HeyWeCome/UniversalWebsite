function operationIcon2(value,row,index) {
    return[
        '<img alt="img-responsive" id="checkRole" class="img-responsive" style="float: left; padding-left:10px" data-toggle="modal" data-target="#checkRoleModal"  src="images/check.png" />',
        '<img alt="img-responsive" id="editRole" class="img-responsive" style="float: left; padding-left:10px" data-toggle="modal" data-target="#editRoleModal" src="images/edit.png" />',
        '<img alt="img-responsive" id="deleteRole" class="img-responsive" style="float: left; padding-left:10px" src="images/delete.png" />'
        ].join('');
}
/*每行表格尾部的小图标点击*/
window.operateEvents2 = {
    'click #checkRole':function (e,value,row,index) {
    	//alert("进入查看弹框")
        //将该行数据填入模态框中
        $('#check_roleName').val(row.name);
        $('#check_rolecreateTime').val(row.createTime);
        $('#check_description').val(row.description);
    },

    'click #editRole':function (e,value,row,index) {
        //将该行数据填入模态框中
    	$('#edit_roleName').val(row.name);       
        $('#edit_description').val(row.description);   
    },
    
    'click #deleteRole':function (e,value,row,index) {
        var determine = confirm("确认删除？");
        if(determine==true){
        	//alert(row.title+" "+row.author)
        	$.ajax({    		
                url:"control/DeleteRole",//servlet文件的名称  
                type:"POST",  
                dataType:"json",
                data:{
                	"roleName":row.name
                },
                //data:{"questionnaireId":"<%=questionnaireId%>"},
                success:function(data1){
                	alert("删除成功！")
                }
            });
        }
    }
}

function deletesRole() {
    var data = $('#roleTable').bootstrapTable('getSelections');
   /* 
    for(var i=0; i<data.length; i++){
    	alert(data[i].title);  	
    }*/
    
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
                url:"control/DeleteRole",//servlet文件的名称  
                type:"POST",  
                dataType:"json",
                data:{
                	"roleName":data[i].name
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
    $('#roleTable').bootstrapTable({
        //height: 400,//定义表格的高度
        //data:students,
    	url:'control/FindAllRole',
    	contentType:'application/json',//发送到服务器的数据编码类型
    	method: 'post',//请求方式
		dataType:'json',//服务器返回的数据类型	
        search:true,
        striped: true,// 隔行变色效果
        pagination: true,//在表格底部显示分页条
        pageSize: 8,//页面数据条数
        // sidePagination: "server",
        //pageNumber:1,//首页页码
        //showRefresh:true,
        pageList: [5, 8, 10,20],//设置可供选择的页面数据条数
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
            field:'name',//返回值名称
            title:'角色名称',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'10'//宽度
        },{
            field:'createTime',//返回值名称
            title:'创建时间',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'5'//宽度
        },{
            field:'description',//返回值名称
            title:'角色描述',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'20'//宽度
        },{
            field:'oprate',//返回值名称
            title:'操作',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'15',//宽度
            events:operateEvents2,
            formatter:operationIcon2
        }]//列配置项,详情请查看 列参数 表格
        /*事件*/
    });
});
