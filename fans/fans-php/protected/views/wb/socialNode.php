<?php 
$user = Yii::app()->session['user'];
?>

<h1 class="l">社交关系网络图</h1>
<?php if($obj->apply==0 && $obj->status==0){ ?>
<p>
由于生成社交关系网络图的数据量特别巨大，而且非常耗时。<br/>
您可以申请生成此图，我们生成图片完成后会在微博上，第一时间@<?php echo $user->screen_name?></p>
<p class="apply">
	<a href="/weibo/apply?type=weibo.social">
		<span class="btn_apply">马上申请</span>
	</a>
</p>
<?php } else if($obj->apply==1 && $obj->status==0){ ?>
<p>您已经申请生成社交关系网络图，但尚未完成！</p>
<p>
由于生成社交关系网络图的数据量特别巨大，而且非常耗时。<br/>
您可以申请生成此图，我们生成图片完成后会在微博上，第一时间@<?php echo $user->screen_name?>
</p>


<?php } else {?>
<div class="share">
	<a href="javascript:void(0);" onclick="share()">
		<span class="btn_share" type="rest.social.node">分享下图到微博</span>
	</a>
</div>

<p><?php echo $obj->tweet?></p>
<img src="<?php echo $obj->img?>"/>
<?php } ?>

