<div class="blog">
	<h1>发日志</h1>
	<?php $form=$this->beginWidget('CActiveForm', array(
		'id'=>'blog-form',
		'enableAjaxValidation'=>true,
	)); ?>
	
	<p><?php echo $form->errorSummary($model); ?></p>

	<p>标题:
	<?php echo $form->textField($model,'title',array('size'=>57,'maxlength'=>32)); ?>
	</p>

	<p>内容:<br/>
		<?php echo $form->textArea($model,'content',array('rows'=>6, 'cols'=>50)); ?>
	</p>
	<p><input type="submit" value="发布" class="btn"/></p>
	<?php $this->endWidget(); ?>
</div>