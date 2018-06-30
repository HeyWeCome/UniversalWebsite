
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
	
	var modules=document.getElementsByName('module');
	var result=0;
	var count=0;
	var dateCount=0;
	for(var i=0; i<modules.length; i++){ 
		if(modules[i].checked) {
			count++;
			console.log("modules[i].value:"+modules[i].value);
			var moduleId = modules[i].value;
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
	
	//那么现在来检测s的值就知道选中的复选框的值了 
	//console.log(moduleId==''?'你还没有选择任何内容！': "modulesId:"+moduleId); 
}
