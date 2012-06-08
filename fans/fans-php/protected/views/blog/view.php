<div class="blog">
	<h2><?php echo CHtml::encode($model->title); ?></h2>
	<div class="author">
	作者:&nbsp;<a href="http://weibo.com/u/<?php echo $model->uid?>" target="_blank">Conan_Z</a>&nbsp;&nbsp;&nbsp;&nbsp;
	发布日期:&nbsp;<?php echo CHtml::encode($model->create_date);?>&nbsp;&nbsp;<br/>
	本文链接:<a href="http://www.fens.me/blog/view/<?php echo $model->id?>">http://www.fens.me/blog/view/<?php echo $model->id?></a><br/>
	<!-- 标签:&nbsp;开发日志&nbsp;&nbsp;&nbsp;&nbsp;分享:weibo,abc,abc,bac<br/> -->
	</div>
	<div class="content">
	<?php echo CHtml::encode($model->content);?>
	</div>
</div>
