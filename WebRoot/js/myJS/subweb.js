/*courseName='';*/

function loadShow(ca){
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
     		  	content += connectParentColumns(data1[i],i,ca); 		   	       		   
     	    }
        	//alert(content)
        	document.getElementById("topMenu").innerHTML=content
        }
    });	
	 //getCourseSonColumns(ca);
	 //courseName=ca;
	 /*var columnsbuttom = document.getElementById("10000");
		columnsbuttom.style.background="#fff";
		columnsbuttom.style.color="#337ab7";*/
}

function connectParentColumns(data,i,courseName){
	var a = courseName;
	var b = data.name;
	var parentColumns = '<button class="parentColumns" onclick="showColumn('
		+data.id
		+'); getCourseSonColumns(&quot;'+a+'&quot;,&quot;'+b+'&quot;);" id="'
		+data.id
		+'">'
		+data.name
		+'</button>'
	return parentColumns
}

function showColumn(id){
	//使其他div隐藏
	var columns0 = document.getElementById("columns10000");columns0.style.display="none";
	var columns1 = document.getElementById("columns10001");columns1.style.display="none";
	var columns2 = document.getElementById("columns10002");columns2.style.display="none";
	var columns3 = document.getElementById("columns10003");columns3.style.display="none";
	var columns4 = document.getElementById("columns10004");columns4.style.display="none";
	var columns5 = document.getElementById("columns10005");columns5.style.display="none";
	var columns6 = document.getElementById("columns10006");columns6.style.display="none"; 
	
	//使当前div显示
	var columnsDIV = document.getElementById("columns"+id);
	columnsDIV.style.display="block";
	
	//使其他按钮变回背景色
	var columnsbuttom0 = document.getElementById(10000);columnsbuttom0.style.background="#337ab7";columnsbuttom0.style.color="#fff";
	var columnsbuttom1 = document.getElementById(10001);columnsbuttom1.style.background="#337ab7";columnsbuttom1.style.color="#fff";
	var columnsbuttom2 = document.getElementById(10002);columnsbuttom2.style.background="#337ab7";columnsbuttom2.style.color="#fff";
	var columnsbuttom3 = document.getElementById(10003);columnsbuttom3.style.background="#337ab7";columnsbuttom3.style.color="#fff";
	var columnsbuttom4 = document.getElementById(10004);columnsbuttom4.style.background="#337ab7";columnsbuttom4.style.color="#fff";
	var columnsbuttom5 = document.getElementById(10005);columnsbuttom5.style.background="#337ab7";columnsbuttom5.style.color="#fff";
	var columnsbuttom6 = document.getElementById(10006);columnsbuttom6.style.background="#337ab7";columnsbuttom6.style.color="#fff";
	
	//使当前点击的按钮变色
	var columnsbuttom = document.getElementById(id);
	columnsbuttom.style.background="#fff";
	columnsbuttom.style.color="#337ab7";	
}

/*$("#introductionTtileText").click(function(){
});*/

function getCourseSonColumns(courseName,parentColumnsName){
	//alert("courseName:"+courseName);
	//alert("parentColumnsName:"+parentColumnsName);
	//alert("进入")
	$.ajax({    		
        url:"control/HomePageFindAllSonColumns",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        data:{
        	"courseName":courseName,
        	"parentColumnsName":parentColumnsName
        	},
        //data:{"questionnaireId":"<%=questionnaireId%>"},
        success:function(data){
        	//alert(data1);
        	//alert("成功返回");
        	//if(data!=0){
        		var content='';
            	for(var i=0;i<data.length;i++){
            		content+=connectSonColumns(data[i],i,courseName);
            	}
            	//alert(content)
            	document.getElementById("putSonColumns").innerHTML=content
        	//}
        	
        },
        /*error: function (msg) {//ajax请求失败后触发的方法
	    	 	alert("请求失败");
	    	 	console.log(msg)
	     	}*/
    });	
	//alert(courseName);
}

function connectSonColumns(data,i,courseName){
	var sonColumn = '<button class="sonColumns" onclick="getArticleTitle(&quot;'
		+courseName+'&quot;,'+ data.id+',&quot;'+data.name
		+'&quot;)" id="sonColumns'
		+data.id
		+'" >'
		+data.name
		+'</button>'
	return sonColumn
}

function getArticleTitle(courseName,id,courseSonColumnsName){
	//alert("进入方法");
	var rightTitleText = '<p>'+courseSonColumnsName+'</p>'
	document.getElementById("rightTitleText").innerHTML=rightTitleText
	var position = '<p>您当前的位置：课程介绍>'+courseSonColumnsName+'</p>'
	document.getElementById("showPosition").innerHTML=position
	$('#putTitleAndContent').html("");
	$.ajax({    		
        url:"control/HomePageFindAllSonColumnsArticle",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        data:{
        	"courseSonColumnsId":id
        	},
        success:function(data){
        	var content='';
        	for(var i=0;i<data.length;i++){
        		content+=connectArticleTitle(data[i]);
        	}
        	document.getElementById("putTitleAndContent").innerHTML=content
    	}
    });
}

function connectArticleTitle(data){
	var articleTitle = '<div class="articleTitle" id="'
		+data.title
		+'" onclick="getArticleContent(&quot;'+data.title+'&quot;)"><p>'+data.title+'</p></div>'
		
		return articleTitle;
}
function getArticleContent(title){
	$('#putTitleAndContent').html("");
	$.ajax({    		
        url:"control/???",//servlet文件的名称  
        type:"POST",  
        dataType:"json",
        data:{
        	"articleTitle":title
        	},
        success:function(data){
        	var content = '<div>'+data.content+'</div>'
        	document.getElementById("putTitleAndContent").innerHTML=content;
    	}
    });
}
