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
	var parentColumns = '<button class="parentColumns" onclick="showColumn('
		+data.id
		+')" id="'
		+data.id
		+'">'
		+data.name
		+'</button>'
	return parentColumns
}

function showColumn(id){
	var columns0 = document.getElementById("columns10000");columns0.style.display="none";
	var columns1 = document.getElementById("columns10001");columns1.style.display="none";
	var columns2 = document.getElementById("columns10002");columns2.style.display="none";
	var columns3 = document.getElementById("columns10003");columns3.style.display="none";
	var columns4 = document.getElementById("columns10004");columns4.style.display="none";
	var columns5 = document.getElementById("columns10005");columns5.style.display="none";
	var columns6 = document.getElementById("columns10006");columns6.style.display="none";
	
	
	var columns = document.getElementById("columns"+id);
	columns.style.display="block";
	
}