//发布微博
$("a .btn_share").click(function() {
	var path = '/weibo/send?type=';
	var type = $("a .btn_share").attr("type");
	
	$.ajax({
	  url: path+type,
	  success: function(obj){
		  if(obj=='1'){
			  alert("成功分享到新浪微博!");
		  } else {
			  alert("发布失败!");
		  }
	  }
	});
});

