function loadShow(){
	parentColumnsSize=0;
	$.ajax({    		
        url:"control/ShowLeftMenu",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        //data:{"questionnaireId":"<%=questionnaireId%>"},
        success:function(data1){
        	
        }
    });
}