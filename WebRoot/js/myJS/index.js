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
	var sonModule = '<button class="sonModule" id="'
		+data.id
		+'" onclick="showSubpage()">'
		+data.name
		+'</button>'
	
	console.log(data.id);
	return sonModule
}

function connectParentModule(data,i,parentModuleSize){
	
	var module = '<button class="parentModule" id="parentModule'
		+i
		+'" onclick="show('
		+i+','
		+parentModuleSize
		+')" data-toggle="collapse">'
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

function showSubpage(){
	console.log("showSubpage");
	$(document).ready(function() {
		var temp = "none";
		
		console.log("showSubpage ready");
		
		$("#10000").click(function () {
	        openMatter(1);
	        console.log("showSubpage ready #10000");
	    });
		
		$("#10001").click(function () {
	        openMatter(2);
	        console.log("showSubpage ready #10001");
	    });
		
		$("#10002").click(function () {
	        openMatter(3);
	        console.log("showSubpage ready #10003");
	    });
		
		$("#10003").click(function () {
	        openMatter(4);
	    });
		
		$("#10004").click(function () {
	        openMatter(5);
	    });
		
		$("#10005").click(function () {
	        openMatter(6);
	    });
		
		$("#10006").click(function () {
	        openMatter(7);
	    });
		
		$("#10007").click(function () {
	        openMatter(8);
	    });
		
		$("#10008").click(function () {
	        openMatter(9);
	    });
		
		function openMatter(obj) {
	        for (var i = 1; i < 10; i++) {
	            if (i == obj) {
	                temp = "block";
	            } else {
	                temp = "none";
	            }
	            
	            console.log("openMatter");
	            document.getElementById("matter" + i).style.display = temp;
	        }
	    }
		
	});
}


