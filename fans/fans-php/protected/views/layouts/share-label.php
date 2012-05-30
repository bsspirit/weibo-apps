<h2>微博分享</h2>
<div class="card">
	<script type="text/javascript" charset="utf-8">
	(function(){
	  var _w = 106 , _h = 24;
	  var param = {
	    url:'http://www.fens.me'/**location.href**/,
	    type:'5',
	    count:'', /**是否显示分享数，1显示(可选)*/
	    appkey:'<?php echo Yii::app()->params['WB_AKEY'];?>', /**您申请的应用appkey,显示分享来源(可选)*/
	    title:'我正在使用微博粉丝分析, 很好用的工具, 推荐给你们哦!!', /**分享的文字内容(可选，默认为所在页面的title)*/
	    pic:'', /**分享图片的路径(可选)*/
	    ralateUid:'2816038140', /**关联用户的UID，分享微博会@该用户(可选)*/
		language:'zh_cn', /**设置语言，zh_cn|zh_tw(可选)*/
	    rnd:new Date().valueOf()
	  }
	  var temp = [];
	  for( var p in param ){
	    temp.push(p + '=' + encodeURIComponent( param[p] || '' ) )
	  }
	  document.write('<iframe allowTransparency="true" frameborder="0" scrolling="no" src="http://hits.sinajs.cn/A1/weiboshare.html?' + temp.join('&') + '" width="'+ _w+'" height="'+_h+'"></iframe>')
	})()
	</script>
</div>