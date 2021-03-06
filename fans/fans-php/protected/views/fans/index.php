<?php $user = Yii::app()->session['user'];?>

<h1>晒粉丝 - 索引</h1>
<div class="view">
	<div class="box">
		<h3><a href="/fans/map">粉丝地图</a></h3>
		<p>说明:你知道你的粉丝都来自哪里吗?"粉丝地图"将以中国地图的范围展示你的粉丝!!快来试试吧!</p>
		<a href="/fans/map">点击进入</a>
	</div>
	<div class="box">
		<h3><a href="/fans/wage">粉丝微博年龄</a></h3>
		<p>说明:你知道你的粉丝是从什么时候,开始使用微博的吗?有些人可能已经使用超过1000天了,快来试试吧!</p>
		<a href="/fans/wage">点击进入</a>
	</div>
	<div class="box">
		<h3><a href="/fans/v">粉丝认证比例</a></h3>
		<p>说明:你知道你的粉丝,有多少是认证?有多少是未认证?快来看看吧!</p>
		<a href="/fans/v">点击进入</a>
	</div>
	<div class="box">
		<h3><a href="/fans/gender">粉丝性别比例</a></h3>
		<p>说明:你知道你的粉丝,有多少是男性?有多少是女性?快来看看吧!</p>
		<a href="/fans/gender">点击进入</a>
	</div>
	<div class="box">
		<h3><a href="/fans/cloud">粉丝云</a></h3>
		<p>说明:你的粉丝谁的影响力最大,通过粉丝云为您完美展示!快来看看吧!</p>
		<a href="/fans/cloud">点击进入</a>
	</div>
	<div class="box">
		<h3><a href="/fans/face">粉丝笑脸</a></h3>
		<p>说明:你知道你的粉丝,是多么的可爱.我们为您选出前16名粉丝,画出他们的微笑!</p>
		<a href="/fans/face">点击进入</a>
	</div>
	<div class="box">
		<h3><a href="/fans/rado">粉丝雷达</a></h3>
		<p>说明:你知道你的粉丝,关注数,粉丝数,微博数的横向比例吗?我们为您选出最近关注您的16名粉丝,画出他们的横向比例图!</p>
		<a href="/fans/rado">点击进入</a>
	</div>
</div>
<div id="load-dialog"></div>
<!-- <a href="javascript:void(0);" onclick="load('manual')">手动加载数据</a><br/> -->

<script type="text/javascript">
$("#load-dialog").dialog({
	autoOpen: false,
	height: 150,
	width: 300,
	modal: true
});

function load(type){
	var obj = {'title':'请稍等: 正在加载微博数据','path':'/fans/loadreport'};
	$('#load-dialog').html($(obj).attr('title'));
	$('#load-dialog').dialog('option','title','数据初始化......');
	$('#load-dialog').dialog('open');

	$.ajax({
	  url: $(obj).attr('path'),
	  success: function(obj){
		  if(obj=='1'){
			  if(type=='manual'){
				  alert('完成数据加载!');
			  }
			  $('#load-dialog').dialog('close');
		  } else {
			  alert("读取失败!");
			  $('#load-dialog').dialog('close');
		  }
	  }
	});
}

load();
</script>

