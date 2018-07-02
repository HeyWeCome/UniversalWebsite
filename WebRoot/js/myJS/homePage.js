function jumpPage(courseName){
	window.location.href='../subweb.jsp?courseName="'+courseName+'"';
}
function showCourse(){
	$.ajax({    		
        url:"control/FindAllCourse",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        //data:{"questionnaireId":"<%=questionnaireId%>"},       
        success:function(data){
        	var content = ''
        	for(var i=0;i<data.length;i++){     		  	
     		  	content += connectCourse(data[i],i);		   	       		   
     	   }
        	document.getElementById("allCourse").innerHTML=content
        }
    });
}

function connectCourse(data,i){
	var url = 'window.location.href="subweb.jsp?courseName='+data.name+'"'
	
	var course = '<button class="courseButton" id="course'+data.id+'" onclick='+url+'>'+data.name+'</button>'
	
	return course;
}

