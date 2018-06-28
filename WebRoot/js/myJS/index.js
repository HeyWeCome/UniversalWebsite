function loadShow(){
	parentModuleSize=0;
	parentModule=0;
	//alert("进入方法");
	$.ajax({    		
        url:"control/ShowLeftMenu",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        //data:{"questionnaireId":"<%=questionnaireId%>"},
        success:function(data1){
        	//alert("成功返回");
        	parentModule=data1;
        	var content = ''
        	parentModuleSize = data1.length; 
        	/*显示父模块*/
        	for(var i=0;i<data1.length;i++){     		  	
     		  	content += connectParentModule(data1[i],i,parentModuleSize);     		   	       		   
     	   }
        	//alert(content)
        	document.getElementById("firstLevelMenu").innerHTML=content
        	
        	/*显示子模块*/
        	$.ajax({    		
    	        url:"control/ShowSonModules",//servlet文件的名称  
    	        type:"POST",  
    	        dataType:"json",
    	        //data:{"questionnaireId":"<%=questionnaireId%>"},
    	        success:function(data2){
    	        	//alert("成功返回");
    	        	//alert("子模块："+data2); 
    	        	//alert("父模块："+parentModule);
    	        	for(var i=0;i<parentModuleSize;i++){
    	        		var sonContent=""
    	        		for(var j=0;j<data2.length;j++){
    	        			if(data2[j].parentModuleID==parentModule[i].id){
    	        				sonContent+=connectSonModule(data2[j],j);
    	        			}
    	        		}
    	        		document.getElementById("sonModules"+i).innerHTML=sonContent
    	        	}
         	   }
            	//alert(content)
    	        	
    	        
    		});
        }
	});
		
}

function connectSonModule(data,i){
	var sonModule = '<button class="sonModule" onclick="clickSonModule('
		+data.id
		+')" id="sonModule'
		+i
		+'">'
		+data.name
		+'</button>'
	return sonModule
}

function connectParentModule(data,i,parentModuleSize){
	
	var module = '<button class="parentModule" id="parentModule'
		+i
		+'" onclick="show('
		+i+','
		+parentModuleSize
		+')">'
		+data.name
		+'</button>'
	var sonModules = '<div class="sonModules" style="display:none" id="sonModules'
		+i
		+'"></div>'
	//alert(module);
	return module+sonModules;
}

function show(i,parentModuleSize){
	var sonModules = document.getElementById("sonModules"+i);
	if(sonModules.style.display=="none"){
		sonModules.style.display="block";
	}
	else{
		sonModules.style.display="none";
	}
	
}