<?php 
$user = Yii::app()->session['user'];
?>


<h1 class="l">社交关系网络图</h1>
<?php if($obj->status==0){ ?>

<?php } else {?>
<div class="share">
	<a href="javascript:void(0);" onclick="share()">
		<span class="btn_share" type="rest.social.node">分享下图到微博</span>
	</a>
</div>

<p><?php echo $obj->tweet?></p>
<img src="<?php echo $obj->img?>"/>
<?php } ?>

