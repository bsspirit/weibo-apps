<?php $user = Yii::app()->session['user'];?>

<h1 class="l">粉丝微博年龄比例</h1>
<div class="r">
	<a href="javascript:void(0);">
		<span class="btn_share" type="rest.wage">分享下图到微博</span>
	</a>
</div>

<p><?php echo $obj->tweet?></p>
<img src="<?php echo $obj->img?>"/>

<script type="text/javascript" src="/js/send.js"></script>