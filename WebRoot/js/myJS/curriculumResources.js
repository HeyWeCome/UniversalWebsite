
$(document).ready(function() {
	$.ajax({
		type : 'POST',
	//	url : 'control/ShowSonModules',
		async:false,
		dataType : 'json',
	//	data:{"userName":$.cookie("userName")},
		success : function(data) {
			var resources = "";
			/*for(var i=0;i<resources.length;i++){	//循环获取所有模块
				modules += getModule(sonModules[i], i);
			}*/
			for(var i =0; i< 1;i++){
				resources += getResource();
			}
			console.log(resources);
			document.getElementById("showaaa").innerHTML=resources  //将所有角色写入相应位置
		}
	});
	
});


function getResource(){
	var resource = '<img src="images/TXT.png"  alt="txt下载" />'+
		'<p>文章名称：数据结构</p><p>资源名称：数据结构</p>'+
		'<a href="images/TXT.png" download="TXT">点击下载</a>';
	return resource;
}