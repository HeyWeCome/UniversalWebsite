
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
	
	$.ajax({
		type : 'POST',
		url : 'control/ShowSonModules',
		async:false,
		dataType : 'json',
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

function submitAllocation(){
	var roleId = $('input:radio[name="role"]:checked').val();
	if (roleId == null) {
		console.log("请选择角色");
	} else {
		console.log("roleId:"+roleId);
	}
	
	//重新分配角色权限时，先删除该角色已有权限
	$.ajax({    		
      //  url:"control/InsertPrivilege",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        data:{
        	"roleID": roleId,
        },
        success:function(date){
        }
	});
	
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
                success:function(date){
                	console.log("date:"+date);
                	result=date;
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

/*
$(function(){
	  $(":radio").click(function(){
		  var roleId = $(this).val();
		  console.log("roleId:"+roleId);
		  
		  //返回角色id,获取当前角色已有权限模块
		  $.ajax({
				type : 'POST',
		//		url : 'control/FindAllRole',
				async:false,
				dataType : 'json',
				success : function(modulesId) {
					var str = "A,B,C";
					$(str.split(",")).each(function (i,e){
					    $("input[name='module'][value='"+e+"']").prop("checked",true);
					});
				}
			});
		  
	  });
});*/
