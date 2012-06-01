<h1>晒粉丝 - 索引</h1>

<?php 
$user = Yii::app()->session['user'];
?>
<div class="view">
<ul>
	<li>
		<h3><a href="/fans/wage">粉丝微博年龄</a></h3>
		<p>说明....................................................................................</p>
	</li>
	<li>
		<h3><a href="/fans/v">粉丝认证比例</a></h3>
		<p>说明....................................................................................</p>
	</li>
	<li>
		<h3><a href="/fans/gender">粉丝性别比例</a></h3>
		<p>说明....................................................................................</p>
	</li>
	<li>
		<h3><a href="/fans/cloud">粉丝云</a></h3>
		<p>说明....................................................................................</p>
	</li>
	<li>
		<h3><a href="/fans/face">粉丝笑脸</a></h3>
		<p>说明....................................................................................</p>
	</li>
</ul>
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

