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
	showMessageAndReply(ca);
	showResources(ca);
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
				content+=connectArticleTitle(data[i],courseSonColumnsName);
			}
			document.getElementById("putTitleAndContent").innerHTML=content
		}
	});
}

function connectArticleTitle(data,courseSonColumnsName){
	var articleTitle = '<div class="articleTitle" id="'
		+data.title
		+'" onclick="getArticleContent(&quot;'+data.title+'&quot;,&quot;'+courseSonColumnsName+'&quot;)"><p>'+data.title+'</p></div>'

		return articleTitle;
}
function getArticleContent(title,courseSonColumnsName){
	$('#putTitleAndContent').html("");
	$.ajax({    		
		url:"control/HomePageFindAllSonColumnsArticleContent",//servlet文件的名称  
		type:"POST",  
		dataType:"json",
		data:{
			"articleTitle":title
		},
		success:function(data){
			//alert("返回成功")
			//alert(data[0].title+" "+data[0].content);
			var content = '<div class="putContent">'+data[0].content+'</div>'
			document.getElementById("putTitleAndContent").innerHTML=content;

			var position = '<p>您当前的位置：课程介绍>'+courseSonColumnsName+'>'+data[0].title+'</p>'
			document.getElementById("showPosition").innerHTML=position
		}
	});
}

function showMessageAndReply(courseName){
	//alert("进入");

	$('#showMessageAndReply').html("");
	$.ajax({    		
		url:"control/HomePageFindAllMessage",//servlet文件的名称  
		type:"POST",  
		dataType:"json",
		data:{
			"courseName":courseName
		},
		success:function(data){
			//alert(data.length);
			var content='';
			for(var i=0;i<data.length;i++){
				if(data[i].status=="1"){
					content+=connectReplyedMessage(data[i]);
				}
				else if(data[i].status=="0"){
					content+=connectUnReplyedMessage(data[i]);
				}
			}
			document.getElementById("showMessageAndReply").innerHTML=content
		}
	});
}

function connectReplyedMessage(data){
	var message = '<div class="messageWithReply">'
		+'<div class="message">'
		+'<div class="messageText">留言：'+data.content+'</div>'
		+'<div class="package"><div class="messageTime">'+data.createTime+'</div>'
		+'<div class="hadReply">已回复</div></div>'
		+'</div>'
		+'<div class="line4"></div>'
		+'<div class="reply">'
		+'<div class="replyText">回复：'+data.reply+'</div>'
		+'<div class="package"><div class="replyTime">'+data.replyTime+'</div>'						
		+'<div class="replyEmployee">回复人：'+data.replyEmployee+'</div></div>'
		+'</div>'
		+'</div>'
		return message;
}
function connectUnReplyedMessage(data){
	var message = '<div class="messageWithoutReply">'
		+'<div class="message">'
		+'<div class="messageText">留言:'+data.content+'</div>'
		+'<div class="package"><div class="messageTime">'+data.createTime+'</div>'
		+'<div class="hadReply">未回复</div></div>'
		+'</div>'
		+'</div>'
		return message;
}

function submitMessage(courseName){
	//alert(courseName);
	$.ajax({    		
		url:"control/HomePageInsertMessage",//servlet文件的名称  
		type:"POST",  
		dataType:"json",
		data:{
			"courseName":courseName,
			"content":document.getElementById("writeMessage").value,
		},
		success:function(data){
			if(data==1){alert("留言成功!");showMessageAndReply(courseName);}
			else if(data==0){alert("留言失败!");}
		}
	});
}

function showResources(courseName){
	console.log("showResources");
	console.log("courseName:"+courseName);
	$.ajax({    		
		url:"control/HomePageFindAllResource",//servlet文件的名称  
		type:"POST",  
		dataType:"json",
		data:{
			"courseName":courseName
		},
		success:function(value){
			var data = value;
			var resources='';
			for(var i=0;i<data.length;i++){
				resources+=getResource(data[i].title,data[i].name);
			}
			document.getElementById("toShowResources").innerHTML=resources
		}
	});
}

function getResource(title,name){
	console.log("title:"+title);
	console.log("name:"+name);
	var image = '';
	image = confirmEnding(name);

	var resource = '<div class="showResource"><img src="'+image+'" alt="txt下载" />'+
	'<p>文章名称：'+title+'</p><p>资源名称：'+name+'</p>'+
	'<a onclick="downloadResource(&quot;'+name+'&quot;)";>点击下载</a></div>';
	return resource;
}

function downloadResource(name){
	$.ajax({    		
		url:"control/SourceFileDownload",//servlet文件的名称  
		type:"POST",  
		dataType:"json",
		data:{
			"name":name
		},
		success:function(value){
			alert("请求成功");
			alert(value);
		},
		error: function (msg) {//ajax请求失败后触发的方法
			alert("请求失败");
			console.log(msg);
		}
	});
}

function confirmEnding(name) {
	console.log("name:"+name);

	var txtSuffix = ".txt";
	var docSuffix = ".doc";
	var docxSuffix = ".docx";
	var pptSuffix = ".ppt";
	var pptxSuffix = ".pptx";

	var txtStart = name.length - txtSuffix.length;
	var docStart = name.length - docSuffix.length;
	var docxStart = name.length - docxSuffix.length;
	var pptStart = name.length - pptSuffix.length;
	var pptxStart = name.length - pptxSuffix.length;

	var txtImg = name.substr(txtStart,txtSuffix.length);
	var docImg = name.substr(docStart,docSuffix.length);
	var docxImg = name.substr(docxStart,docxSuffix.length);
	var pptImg = name.substr(pptStart,pptSuffix.length);
	var pptxImg = name.substr(pptxStart,pptxSuffix.length);

	if(txtImg == txtSuffix){
		return "images/TXT.png";
	}
	else if(docImg == docSuffix){
		return "images/DOC.png";
	}
	else if(docxImg == docxSuffix){
		return "images/DOC.png";
	}
	else if(pptImg == pptSuffix){
		return "images/PPT.png";
	}
	else if(pptxImg == pptxSuffix){
		return "images/PPT.png";
	}
	else{
		return "images/AVI.png";
	}
}
