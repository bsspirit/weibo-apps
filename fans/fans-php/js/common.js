//公用的功能JS
function followus(){//关注我们
	var path='/weibo/followus';
	$.ajax({
	  url: path,
	  success: function(obj){
//		  if(obj=='1'){
//			  alert("关注@fensme成功,谢谢您的支持!");
//		  } else {
//			  alert("发布失败!");
//		  }
		  alert("关注@fensme成功,谢谢您的支持!");
	  }
	});
}

function share(){//分享内容
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
}


