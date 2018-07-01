function getRolesName(){
	$.ajax({    		
        url:"control/FindAllRole",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        //data:{"questionnaireId":"<%=questionnaireId%>"},
        success:function(data1){
        	//alert("成功返回");
        	var content=''
        	for(var i=0;i<data1.length;i++){
        		content+=connectRoles(data1[i],i);
        	}
        	//alert(content);
        	document.getElementById("add_managerRole").innerHTML=content
        	document.getElementById("edit_managerRole").innerHTML=content
        	/*var a=$.cookie("userName")
        	$('#add_author').val(a);*/
        	
        }
    });	
}

function connectRoles(data,i){
	var roleOption = '<option>'
		+data.name
		+'</option>' 
	//alert(columnOption);
	return roleOption
}

function operationIcon3(value,row,index) {
    return[
        '<img alt="img-responsive" id="checkManager" class="img-responsive" style="float: left; padding-left:10px" data-toggle="modal" data-target="#checkManagerModal"  src="images/check.png" />',
        '<img alt="img-responsive" id="editManager" class="img-responsive" style="float: left; padding-left:10px" data-toggle="modal" data-target="#editManagerModal" src="images/edit.png" />',
        '<img alt="img-responsive" id="deleteManager" class="img-responsive" style="float: left; padding-left:10px" src="images/delete.png" />'
        ].join('');
}

/*每行表格尾部的小图标点击*/
window.operateEvents3 = {
    'click #checkManager':function (e,value,row,index) {
    	//alert("进入查看弹框")
        //将该行数据填入模态框中
        $('#check_managerName').val(row.name);
        $('#check_managerSex').val(row.sex);
        $('#check_managerAccount').val(row.account);
        $('#check_managerPassword').val(row.passWord);
        $('#check_managerRole').val(row.roleName);
    },

    'click #editManager':function (e,value,row,index) {
        //将该行数据填入模态框中
    	$('#edit_managerName').val(row.name);
        $('#edit_managerSex').val(row.sex);
        $('#edit_managerAccount').val(row.account);
        $('#edit_managerPassword').val(row.passWord);
        $('#edit_managerRole').val(row.roleName);
        getRolesName();
    },
}

/* 刷新方法 */
function refresh4(){
    $('#managerTable').bootstrapTable('refresh', null);
}

/*定义表格*/
$(function () {
    $('#managerTable').bootstrapTable({
        //height: 400,//定义表格的高度
        //data:students,
    	url:'control/FindAllEmployee',
    	contentType:'application/json',//发送到服务器的数据编码类型
    	method: 'post',//请求方式
		dataType:'json',//服务器返回的数据类型	
		//showRefresh: true,  //显示刷新按钮
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
            title:'姓名',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'10'//宽度
        },{
            field:'sex',//返回值名称
            title:'性别',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'5'//宽度
        },{
            field:'account',//返回值名称
            title:'账号',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'20'//宽度
        },{
            field:'passWord',//返回值名称
            title:'密码',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'10'//宽度
        },{
            field:'roleName',//返回值名称
            title:'角色',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'10'//宽度
        },{
            field:'oprate',//返回值名称
            title:'操作',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'15',//宽度
            events:operateEvents3,
            formatter:operationIcon3
        }]//列配置项,详情请查看 列参数 表格
        /*事件*/
    });
});