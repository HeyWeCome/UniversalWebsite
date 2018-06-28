function loadShow(){
	parentColumnsSize=0;
	parentColumns=0;
	//alert("进入");
	$.ajax({    		
        url:"control/FindAllColumns",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        //data:{"questionnaireId":"<%=questionnaireId%>"},
        success:function(data1){
        	//alert(data1);
        	//alert("成功返回");
        	parentColumns=data1;
        	var content = ''
        	parentColumnsSize = data1.length; 
        	
        	for(var i=0;i<data1.length;i++){     		  	
     		  	content += connectParentColumns(data1[i],i); 		   	       		   
     	    }
        	//alert(content)
        	document.getElementById("topMenu").innerHTML=content
        }
    });
}

function connectParentColumns(data,i){
	var parentColumns = '<button class="parentColumns" id="'
		+data.id
		+'">'
		+data.name
		+'</button>'
	return parentColumns
}