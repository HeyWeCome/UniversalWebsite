/*操作小图标*/
function operationIcon1(value,row,index) {
    return[
           '<button type="button" id="adopt" class="btn btn-primary btn-xs"  >通过',
           '<button type="button" id="notAdopt" class="btn btn-primary btn-xs"  >通过'
        ].join('');
}
/*每行表格尾部的小图标点击*/
window.operateEvents = {
    'click #adopt':function (e,value,row,index) {
    	$.ajax({    		
            url:"control/DeleteArticle",//servlet文件的名称  
            type:"POST",  
            dataType:"json",
            data:{
            	"title":row.title,
            	"author":row.author,
            	"status":"1",
            },
            success:function(data1){
            	alert("审核成功")
            }
        });
    },
    'click #notAdopt':function (e,value,row,index) {
    	$.ajax({    		
            url:"control/DeleteArticle",//servlet文件的名称  
            type:"POST",  
            dataType:"json",
            data:{
            	"title":row.title,
            	"author":row.author,
            	"status":"2",
            },
            success:function(data1){
            	alert("审核成功")
            }
        });
    }
}
/*定义表格*/
$(function () {
    $('#articleReviewTable').bootstrapTable({
        //height: 400,//定义表格的高度
        //data:students,
    	url:'control/FindAllAuditArticle',
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
            field:'status',//返回值名称
            title:'审核状态',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'10'//宽度
        },{
            field:'oprate',//返回值名称
            title:'操作',//列名
            align:'center',//水平居中显示
            valign:'middle',//垂直居中显示
            //width:'15',//宽度
            events:operateEvents,
            formatter:operationIcon1
        }]//列配置项,详情请查看 列参数 表格
        /*事件*/
    });
});
