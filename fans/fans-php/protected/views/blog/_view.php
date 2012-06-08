<div class="item">
<a title="<?php echo CHtml::encode($data->title); ?>" href="http://www.fens.me/blog/view/<?php echo $data->id?>">
	<span style="float:left;margin-left:10px;">
		<?php echo CHtml::encode($data->title); ?>
	</span>
</a>
<span style="float:right;margin-right:10px;"><?php echo CHtml::encode(substr($data->create_date, 0,10)); ?></span>
<div class="c"></div>
</div>
