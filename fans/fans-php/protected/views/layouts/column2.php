<?php $user = Yii::app()->session['user'];?>
<?php $this->beginContent('//layouts/main'); ?>

<div class="span-19">
	<div id="content">
		<?php echo $content; ?>
	</div>
	<!-- content -->
</div>
<div class="span-5 last">
	<div id="sidebar">
		用户信息管理
	</div>
</div>
<?php $this->endContent(); ?>