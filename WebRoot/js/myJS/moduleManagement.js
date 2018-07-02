/*定义表格*/
$(function () {
    $('#moduleManagementTable').bootstrapTable({
        //data:students,
  //  	url:'control/FindAllRole',
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
        },{
            field:'parentName',//返回值名称
            title:'父模块名',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'10'//宽度
        },{
            field:'parentStatus',//返回值名称
            title:'父模块状态',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'5'//宽度
        },{
            field:'sonName',//返回值名称
            title:'子模块名',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'10'//宽度
        },{
            field:'sonStatus',//返回值名称
            title:'子模块状态',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'5'//宽度
        }/*,{
            field:'oprate',//返回值名称
            title:'操作',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'15',//宽度
            events:operateEvents2,
            formatter:operationIcon2
        }*/]//列配置项,详情请查看 列参数 表格
        /*事件*/
    });
});

function getModuleName(){
	$.ajax({    		
        url:"control/ShowLeftMenu",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        //data:{"questionnaireId":"<%=questionnaireId%>"},
        success:function(data1){
        	//alert("成功返回");
        	var content= '<option>已是父模块</option>'
        	for(var i=0;i<data1.length;i++){
        		content+=connectModules(data1[i],i);
        	}
        //	alert(content);
        	console.log(content);
        	document.getElementById("selectModuleName").innerHTML=content
        //	document.getElementById("edit_columnName").innerHTML=content
        	var a=$.cookie("userName")
        	$('#add_author').val(a);
        	
        }
    });	
}

function connectModules(data,i){
	var moduleOption = '<option>'
		+data.name
		+'</option>' 
	//alert(columnOption);
	return moduleOption
}

function addModule(){
	$.ajax({    		
     //   url:"control/InsertModule",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        data:{
        	//"id":document.getElementById("addModuleId").value,
        	"name":document.getElementById("addModuleName").value,
        	"status":document.getElementById("addModuleStutus").value,
        	"parentModuleName":document.getElementById("selectModuleName").value,
        },
        success:function(data){
        	$('#addModuleModal').modal('hide');
        	
        	if(data==1){alert("插入成功!");$('#moduleManagementTable').bootstrapTable('refresh', null);}
        	else if(data==0){alert("插入失败!");$('#moduleManagementTable').bootstrapTable('refresh', null);}
        },
        error: function (msg) {//ajax请求失败后触发的方法
	    	 	alert("请求失败");
	    	 	console.log(msg)
	     	}
	});
}
