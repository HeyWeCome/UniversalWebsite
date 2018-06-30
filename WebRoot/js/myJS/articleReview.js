/*function showAllColumns(){
	//console.log("当前账号为:"+$.cookie("userName"));
	
	parentColumnsSize=0;
	parentColumns=0;
	alert("进入方法");
	显示父栏目
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
        	alert(content)
        	document.getElementById("columns").innerHTML=content
        	
        	显示子栏目
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
显示父栏目
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
显示子栏目
function connectSonColumns(data,i){
	var sonColumns = '<button class="sonColumns" id="'
		+data.id
		+'">'
		+data.name
		+'</button>'
	//alert(sonColumns)
	return sonColumns
}
控制div块的显示与隐藏
function show1(i){
	var sonColumns = document.getElementById("sonColumns1"+i);
	if(sonColumns.style.display=="none"){
		sonColumns.style.display="block";
	}
	else{
		sonColumns.style.display="none";
	}
	
}*/