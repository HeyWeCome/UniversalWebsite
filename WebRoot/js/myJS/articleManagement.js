function showAllColumns(){
	parentColumnsSize=0;
	parentColumns=0;
	//alert("进入方法");
	/*显示父栏目*/
	$.ajax({    		
        url:"control/FindAllColumns",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        //data:{"questionnaireId":"<%=questionnaireId%>"},
        success:function(data1){
        	parentColumns=data1;
        	var content = ''
        	parentColumnsSize = data1.length; 
        	
        	for(var i=0;i<data1.length;i++){     		  	
     		  	content += connectParentColumns(data1[i],i); 		   	       		   
     	    }
        	//alert(content)
        	document.getElementById("columns").innerHTML=content
        	
        	/*显示子栏目*/
        	$.ajax({    		
                url:"control/FindAllSonColumns",//servlet文件的名称  
                type:"POST",  
                dataType:"json",
                //data:{"questionnaireId":"<%=questionnaireId%>"},
                success:function(data2){
                	//alert(data2);
                	for(var i=0;i<parentColumnsSize;i++){
    	        		var sonContent=""
    	        		for(var j=0;j<data2.length;j++){
    	        			if(data2[j].parentID==parentColumns[i].id){
    	        				sonContent+=connectSonColumns(data2[j],j);
    	        			}
    	        		}
    	        		document.getElementById("sonColumns1"+i).innerHTML=sonContent
    	        	}
                }
            });
        }
    });
}
/*显示父栏目*/
function connectParentColumns(data,i){
	var parentColumns = '<button class="parentColumns" onclick="show1('
		+i
		+')" id="'
		+data.id
		+'">'
		+data.name
		+'</button>'
	var sonColumns = '<div class="sonColumn" style="display:none" id="sonColumns1'
		+i
		+'"></div>'
	return parentColumns+sonColumns
}
/*显示子栏目*/
function connectSonColumns(data,i){
	var sonColumns = '<button class="sonColumns" id="'
		+data.id
		+'">'
		+data.name
		+'</button>'
	//alert(sonColumns)
	return sonColumns
}
/*控制div块的显示与隐藏*/
function show1(i){
	var sonColumns = document.getElementById("sonColumns1"+i);
	if(sonColumns.style.display=="none"){
		sonColumns.style.display="block";
	}
	else{
		sonColumns.style.display="none";
	}
	
}



function operationIcon(value,row,index) {
    return[
        '<img alt="img-responsive" id="check" class="img-responsive" style="float: left; padding-left:10px" data-toggle="modal" data-target="#checkModal"  src="images/check.png" />',
        '<img alt="img-responsive" id="edit" class="img-responsive" style="float: left; padding-left:10px" data-toggle="modal" data-target="#editModal" src="images/edit.png" />',
        '<img alt="img-responsive" id="delete" class="img-responsive" style="float: left; padding-left:10px" src="images/delete.png" />'
        ].join('');
}


/*每行表格尾部的小图标点击*/
window.operateEvents = {
    'click #check':function (e,value,row,index) {
        //将该行数据填入模态框中
        $('#check_title').val(row.title);
        $('#check_author').val(row.author);
        $('#check_columnName').val(row.columnName);
        $('#check_createTime').val(row.createTime);
        $('#check_whetherTop').val(row.whetherTop);
    },

    'click #edit':function (e,value,row,index) {
        //将该行数据填入模态框中
        $('#edit_ID').val(row.id);
        $('#edit_title').val(row.title);
        $('#edit_author').val(row.author);
        $('#edit_columnName').val(row.columnName);
        /*$('#edit_createTime').val(row.createTime);*/
        $('#edit_whetherTop').val(row.whetherTop);
        
        /*$('#btEdit').on('click',function(){
            var inputRight = 1;
            var id = $('#edit_ID').val();
            var name = $('#edit_NAME').val();
            var college = $('#edit_COLLEGE').val();
            var major = $('#edit_MAJOR').val();
            var sex = $('#edit_SEX').val();
            var birthday = $('#edit_BIRTHDAY').val();
            var salary = $('#edit_SALARY').val();

            var checkId = /^[0-9]+.?[0-9]*$/;   //验证学号的长度且是否为数字/^1\d{10}$/
            if(!checkId.test(id)){
                inputRight = 0;
            }
            var checkName = /^[\u4e00-\u9fa5]+$/;    //验证输入的名字是否为汉字
            if(!checkName.test(name)){
                inputRight = 0;
            }
            if(inputRight == 0){
                alert("输入数据不合法！");
            }
            else{
                $('#studentInformationTable').bootstrapTable('updateRow',{
                    index:index,
                    row:{
                        ID:id,
                        NAME:name,
                        COLLEGE:college,
                        MAJOR:major,
                        SEX:sex,
                        BIRTHDAY:birthday,
                        SALARY:salary
                    }
                });
                $('#studentInformationTable').bootstrapTable('load',students);
                $('#editModal').modal('hide');
                index = null;
            }

        });*/
    },

    'click #delete':function (e,value,row,index) {
        var determine = confirm("确认删除？");
        if(determine==true){
            /*$('#studentInformationTable').bootstrapTable('remove',{
                field:'ID',
                values:[row.ID]
            });*/
        	var tmp = document.createElement("form");
        	var id = row.id;
        	var action = "../servlet/deleteServlet?ID="+id;
        	tmp.action = action;
        	tmp.method = "post";
        	document.body.appendChild(tmp);
        	tmp.submit();
        	
        }
    }
};

/* 刷新方法 */
function refresh(){
    $('#articleTable').bootstrapTable('refresh', null);
}
/*
function add() {
    var inputRight = 1;
  
    var id = $('#add_ID').val();
    var name = $('#add_NAME').val();
    var college = $('#add_COLLEGE').val();
    var major = $('#add_MAJOR').val();
    var sex = $('#eadd_SEX').val();
    var birthday = $('#add_BIRTHDAY').val();
    var salary = $('#add_SALARY').val();

    
    
    var checkId = /^[0-9]+.?[0-9]*$/;   //验证学号的长度且是否为数字/^1\d{10}$/
    if(!checkId.test(id)){
        inputRight = 0;
    }
    var checkName = /^[\u4e00-\u9fa5]+$/;    //验证输入的名字是否为汉字
    if(!checkName.test(name)){
        inputRight = 0;
    }
    if(inputRight == 0){
        alert("输入数据不合法！");
    }
    else{
        var student = "{"+"\""+"STUDENTID"+"\""+":"+"\""+studentId+"\""+","
            +"\""+"NAME"+"\""+":"+"\""+name+"\""+","
            +"\""+"COLLEGE"+"\""+":"+"\""+college+"\""+","
            +"\""+"MAJOR"+"\""+":"+"\""+major+"\""+","
            +"\""+"GRADE"+"\""+":"+"\""+grade+"\""+","
            +"\""+"CLASS"+"\""+":"+"\""+clAss+"\""+","
            +"\""+"AGE"+"\""+":"+"\""+age+"\""+"}";
        students.unshift(JSON.parse(student));
        $('#studentInformationTable').bootstrapTable('load',students);

        $('#addModal').modal('hide');
    }

}*/


function deletes() {
    var data = $('#studentInformationTable').bootstrapTable('getSelections');
    
    for(var i=0; i<data.length; i++){
    	alert(data[i].id);
    	
    }
    
    if(data.length==0){
        alert("请至少选中一条数据");
        return;
    }
    var ids = "";
    var determine = confirm("确认删除？")
    if(determine==true){
    	var tmp = document.createElement("form");
    	var action =  "../servlet/deletesServlet?";
    	action = action+"size="+data.length;
        for(var i=0; i<data.length; i++){
        	var tmp = document.createElement("form");
        	var id = data[i].id;
        	action =action+"&ID["+i+"]="+id;
        	
        }
        tmp.action = action;
    	tmp.method = "post";
    	document.body.appendChild(tmp);
    	tmp.submit();
    	//console.log(data[i].id);
    	
    	/*for(var i=0; i<data.length; i++){
    		var tmp = document.createElement("form");
    		var id = data[i].ID;
    		var action =  "../servlet/deleteServlet?ID="+id;
    		tmp.action = action;
        	tmp.method = "post";
        	document.body.appendChild(tmp);
        	tmp.submit();
    	}*/
    	
    }
}

/*定义表格*/
$(function () {
    $('#articleTable').bootstrapTable({
        //height: 400,//定义表格的高度
        //data:students,
    	url:'control/FindAllArticle',
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
            field:'title',//返回值名称
            title:'文章标题',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'10'//宽度
        },{
            field:'author',//返回值名称
            title:'作者',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'5'//宽度
        },{
            field:'columnName',//返回值名称
            title:'栏目名称',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'20'//宽度
        },{
            field:'createTime',//返回值名称
            title:'创建时间',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'10'//宽度
        },{
            field:'whetherTop',//返回值名称
            title:'是否置顶',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'10'//宽度
        },{
            field:'oprate',//返回值名称
            title:'操作',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'10',//宽度
            events:operateEvents,
            formatter:operationIcon
        }]//列配置项,详情请查看 列参数 表格
        /*事件*/
    });
});

function getColumnsName(){
	$.ajax({    		
        url:"control/FindAllSonColumns",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        //data:{"questionnaireId":"<%=questionnaireId%>"},
        success:function(data1){
        	//alert("成功返回");
        	var content=''
        	for(var i=0;i<data1.length;i++){
        		content+=connectSonColumn(data1[i],i);
        	}
        	//alert(content);
        	document.getElementById("add_columnName").innerHTML=content
        }
    });
	
	
}

function connectSonColumn(data,i){
	var columnOption = '<option>'
		+data.name
		+'</option>' 
	//alert(columnOption);
	return columnOption
}