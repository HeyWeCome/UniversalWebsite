/*定义表格*/
$(function () {
    $('#columnManagementTable').bootstrapTable({
        //data:students,
    	url:'control/FindAllPASColumns',
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
        columns:[/*{
            checkbox:true,//勾选框
          //  width:'3'//宽度
        },*/{
            title:'序号',
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'5',//宽度
            formatter:function (value,row,index) {//生成序号
                return index+1;
            }
        }/*,{
            field:'id',//返回值名称
            title:'栏目ID',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'10'//宽度
        }*/,{
            field:'name',//返回值名称
            title:'栏目名称',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'5'//宽度
        },{
            field:'level',//返回值名称
            title:'栏目级别',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'20'//宽度
        },{
            field:'parentName',//返回值名称
            title:'上级栏目',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'20'//宽度
        },{
            field:'oprate',//返回值名称
            title:'操作',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'15',//宽度
            events:operateEventColumn,
            formatter:operationIconColumn
        }]//列配置项,详情请查看 列参数 表格
        /*事件*/
    });
});

function operationIconColumn(value,row,index) {
    return[
           '<img alt="img-responsive" id="deleteColumn" class="img-responsive" style="float: left; padding-left:10px" src="images/delete.png" />',
        ].join('');
}

/* 刷新方法 */
function refreshColumn(){
    $('#columnManagementTable').bootstrapTable('refresh', null);
}

/*每行表格尾部的小图标点击*/
window.operateEventColumn = {
    'click #deleteColumn':function (e,value,row,index) {
        var determine = confirm("确认删除？");
        if(determine==true){
        	$.ajax({    		
                url:"control/DeleteColumns",//servlet文件的名称  
                type:"POST",  
                dataType:"json",
                data:{
                	"name":row.name,
                	"parentColumnName":row.parentName
                },
                //data:{"questionnaireId":"<%=questionnaireId%>"},
                success:function(data){
                	var data1 = data;
                	if(data==1){alert("删除成功!");$('#columnManagementTable').bootstrapTable('refresh', null);}
                	else if(data1==0){alert("删除失败!");}
                },
                error: function (msg) {//ajax请求失败后触发的方法
       	    	 	alert("请求失败");
       	    	 	console.log(msg)
       	     	}

            });
        }
    }
};

//获取所有上级栏目
function getColumnName(){
	$.ajax({    		
        url:"control/FindAllColumns",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        //data:{"questionnaireId":"<%=questionnaireId%>"},
        success:function(data1){
        	//alert("成功返回");
        	var content= '<option value="已是上级栏目">已是上级栏目</option>'
        	for(var i=0;i<data1.length;i++){
        		content+=connectColumns(data1[i],i);
        	}
        //	alert(content);
        	console.log(content);
        	document.getElementById("selectColumnName").innerHTML=content
        //	document.getElementById("edit_columnName").innerHTML=content
        	var a=$.cookie("userName")
        	$('#add_author').val(a);
        	
        }
    });	
}

function connectColumns(data,i){
	var columnOption = '<option value="'+data.name+'">'
		+data.name
		+'</option>' 
	//alert(columnOption);
		console.log("value="+data.name)
	return columnOption
}

//新增栏目
function addColumn(){
	$.ajax({    		
        url:"control/InsertColumns",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        data:{
        	//"id":document.getElementById("addColumnId").value,
        	"name":document.getElementById("addColumnName").value,
        	//"lever":document.getElementById("addColumnLever").value,
        	"parentColumnName":document.getElementById("selectColumnName").value,
        },
        success:function(data){
        	$('#addColumnModal').modal('hide');
        	
        	if(data==1){alert("插入成功!");$('#columnManagementTable').bootstrapTable('refresh', null);}
        	else if(data==0){alert("插入失败!");$('#columnManagementTable').bootstrapTable('refresh', null);}
        },
        error: function (msg) {//ajax请求失败后触发的方法
	    	 	alert("请求失败");
	    	 	console.log(msg)
	     	}
	});
}

/*//修改栏目
function deleteColumn(){
	$.ajax({    		
        url:"control/DeleteColumns",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        data:{
        	"name":document.getElementById("deleteColumnName").value,
        	"level":document.getElementById("deleteColumnLevel").value,
        },
        success:function(data){
        	$('#editColumnModal').modal('hide');
        	
        	if(data==1){alert("修改成功!");$('#columnManagementTable').bootstrapTable('refresh', null);}
        	else if(data==0){alert("修改失败!");$('#columnManagementTable').bootstrapTable('refresh', null);}
        },
        error: function (msg) {//ajax请求失败后触发的方法
    	 	alert("请求失败");
    	 	console.log(msg)
     	}
	});
}*/
