<?php $user = Yii::app()->session['user'];?>
<?php $this->beginContent('//layouts/main'); ?>
<div class="nav">
	<ul>
		<li><a href="/fans/wage">粉丝微博年龄</a></li>
		<li><a href="/fans/v">粉丝认证比例</a></li>
		<li><a href="/fans/gender">粉丝性别比例</a></li>
		<li><a href="/fans/cloud">粉丝云</a></li>
		<li><a href="/fans/face">粉丝笑脸</a></li>
	</ul>
</div>
<div class="c"></div>
<hr />
<div id="content">
	<?php echo $content; ?>
</div>
<?php $this->endContent(); ?>