<?php $user = Yii::app()->session['user'];?>

<h1 class="l">微博增长力</h1>
<div class="share">
	<a href="javascript:void(0);" onclick="share()">
		<span class="btn_share" type="rest.increase">分享下图到微博</span>
	</a>
</div>

<p><?php echo $obj->tweet?></p>
<img src="<?php echo $obj->img?>"/>
