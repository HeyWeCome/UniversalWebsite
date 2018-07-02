
//初始化加载界面，获取所有角色和所有模块
$(document).ready(function() {
	$.ajax({
		type : 'POST',
		url : 'control/FindAllRole',
		async:false,
		dataType : 'json',
		success : function(roles) {
			var role = "<h4 class='show'>角色</h4>";
			for(var i=0;i<roles.length;i++){	//循环获取所有角色
				role += getRole(roles[i], i);
			}
			document.getElementById("showRoles").innerHTML=role  //将所有角色写入相应位置
		}
	});
	
	//alert($.cookie("userName"));
	$.ajax({
		type : 'POST',
		url : 'control/ShowSonModules',
		async:false,
		dataType : 'json',
		data:{"userName":$.cookie("userName")},
		success : function(sonModules) {
			var modules = "<h4 class='show'>模块</h4>";
			for(var i=0;i<sonModules.length;i++){	//循环获取所有模块
				modules += getModule(sonModules[i], i);
			}
			document.getElementById("showModules").innerHTML=modules //将所有模块写入相应位置
		}
	});
});

//每获取一个角色便添加一个radio单选框
function getRole(date,i){
	var sonModule = '<li>'+'<input style="margin:5px" type="radio" id="role'+date.id+'" name="role" value="'+date.id+'">'+date.name+'</li>';
	return sonModule;
}

//每获取一个模块便添加一个radio单选框
function getModule(date,i){
	var sonModule = '<li>'+'<input style="margin:5px" type="checkbox" id="module'+date.id+'" name="module" value="'+date.id+'">'+date.name+'</li>';
	return sonModule;
}

//参数n为休眠时间，单位为毫秒:
function sleep(n) {
    var start = new Date().getTime();
      console.log('休眠前：' + start);
    while (true) {
        if (new Date().getTime() - start > n) {
            break;
        }
    }
     console.log('休眠后：' + new Date().getTime());
}

//确认给角色分配权限
function submitAllocation(){
	var roleId = $('input:radio[name="role"]:checked').val();
	if (roleId == null) {
		console.log("请选择角色");
	} else {
		console.log("roleId:"+roleId);
	}
	
	var returnDate=-1;
	
	//重新分配角色权限时，先删除该角色已有权限
	$.ajax({    		
        url:"control/DeleteExistingPrivilege",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        data:{
        	"roleID": roleId,
        },
        success:function(date1){
        	var returnDate=date1;
        	console.log("date1:"+returnDate);
        }
	});
	
	//睡眠300毫秒，以确保删除模块的操作在新增模块之前
    sleep(300);
	
	var modules=document.getElementsByName('module');
	var result=0;
	var count=0;
	var dateCount=0;
	
	for(var i=0; i<modules.length; i++){ 
		if(modules[i].checked) {
			count++;
			console.log("modules[i].value:"+modules[i].value);
			var moduleId = modules[i].value;
			//给角色分配权限
			$.ajax({    		
                url:"control/InsertPrivilege",//servlet文件的名称  
                type:"POST",  
                dataType:"json",
                data:{
                	"roleID": roleId,
                	"moduleID": moduleId
                },
                success:function(date2){
                	console.log("date2:"+date2);
                	result=date2;
                	console.log("result:"+result);
                	if(result==1){
                		dateCount++;
                	}
                	if(result==1 && count==dateCount){
                		alert("角色权限分配成功!");
                	}
                }
    		});
		}
	} 
	
	
}

//选中角色显示出该角色已有权限模块id
$(function(){
	  $(":radio").click(function(){
		  var roleId = $(this).val();
		  console.log("roleId:"+roleId);
		  
		  var allModules =$("input[name='module']");//获取名字为module的所有多选框对象
		  console.log("allModules:"+allModules);
		  
		  //将之前选中的模块设为不选中
	       $("input[name='module']").each(function(){
                if(this.checked){
                	this.checked=false;
				}
            })
		  
		  //返回角色id,获取当前角色已有权限模块
		  $.ajax({
				type : 'POST',
				url : 'control/FindAccountPermission',
				async:false,
				dataType : 'json',
				data:{
		        	"roleID": roleId,
		        },
				success : function(modulesId) {
					console.log("modulesId:"+modulesId);
					
					for(var i=0;i<modulesId.length;i++){//
				       //获取所有复选框对象的value属性，然后，用checkArray[i]和他们匹配，如果有，则说明他应被选中
				        $.each(allModules,function(j,checkbox){
				            //获取复选框的value属性
				           var checkValue=$(checkbox).val();
				            if(modulesId[i].moduleID==checkValue){//判断该模块是否应被选中
			                 	this.checked=true;		//选中该模块
				            }
				       })
				   }
				}
			});
		  
	  });
});
