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

    'click #deleteManager':function (e,value,row,index) {
        //将该行数据填入模态框中
    	var determine = confirm("确认删除？");
        if(determine==true){
        	//alert(row.title+" "+row.author)
        	$.ajax({    		
                url:"control/DeleteEmployee",//servlet文件的名称  
                type:"POST",  
                dataType:"json",
                data:{
                	"name":row.name,
                	"account":row.account
                },
                //data:{"questionnaireId":"<%=questionnaireId%>"},
                success:function(data1){
                	alert("删除成功！")
                }
            });
        }
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

function deletesManager(){
	 var data = $('#managerTable').bootstrapTable('getSelections');
	    
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
	                url:"control/DeleteEmployee",//servlet文件的名称  
	                type:"POST",  
	                dataType:"json",
	                data:{
	                	"name":data[i].name,
	                	"account":data[i].account
	                },
	                success:function(data1){
	                	
	                }
	    		});
	    	}
	    	alert("删除成功！")
	    	
	    }
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

function addManager(){
	alert("进入增加人员");
	$.ajax({    		
        url:"control/InsertEmployee",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        data:{
        	"name":document.getElementById("add_managerName").value,
        	"sex":document.getElementById("add_managerSex").value,
        	"account":document.getElementById("add_managerAccount").value,
        	"passWord":document.getElementById("add_managerPassword").value,
        	"roleName":document.getElementById("add_managerRole").value,
        },
        success:function(data){
        	$('#addManagerModal').modal('hide');
        	
        	if(data==1){alert("插入成功!");$('#managerTable').bootstrapTable('refresh', null);}
        	else if(data==0){alert("插入失败!");$('#managerTable').bootstrapTable('refresh', null);}
        },
        error: function (msg) {//ajax请求失败后触发的方法
	    	 	alert("请求失败");
	    	 	$('#addManagerModal').modal('hide');
	    	 	$('#managerTable').bootstrapTable('refresh', null);
	    	 	console.log(msg);
     	}
	});
}

function editManager(){
	$.ajax({    		
        url:"control/UpdateEmployee",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        data:{
        	"name":document.getElementById("edit_managerName").value,
        	"sex":document.getElementById("edit_managerSex").value,
        	"account":document.getElementById("edit_managerAccount").value,
        	"passWord":document.getElementById("edit_managerPassword").value,
        	"roleName":document.getElementById("edit_managerRole").value,
        },
        success:function(data){
        	$('#editManagerModal').modal('hide');
        	
        	if(data==1){alert("修改成功!");$('#managerTable').bootstrapTable('refresh', null);}
        	else if(data==0){alert("修改失败!");$('#managerTable').bootstrapTable('refresh', null);}
        },
        error: function (msg) {//ajax请求失败后触发的方法
    	 	alert("请求失败");
    	 	console.log(msg)
     	}
	});
}