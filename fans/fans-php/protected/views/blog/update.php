<div class="blog">
	<h1>修改日志</h1>
	<?php $form=$this->beginWidget('CActiveForm', array(
		'id'=>'blog-form',
		'enableAjaxValidation'=>true,
	)); ?>
	
	<p><?php echo $form->errorSummary($model); ?></p>

	<p>标题:
	<?php echo $form->textField($model,'title',array('size'=>57,'maxlength'=>32)); ?>
	</p>

	<p>内容:<br/>
		<textarea name="content" style="width:auto;height:300px;visibility:hidden;"><?php echo $model->content?></textarea>
	</p>
	<p><input type="submit" value="发布" class="btn"/></p>
	<?php $this->endWidget(); ?>
</div>

<script src="/js/lib/kindeditor/kindeditor-min.js"></script>
<script src="/js/lib/kindeditor/zh_CN.js"></script>
<script type="text/javascript">
var editor_content;
var editor_desc;
KindEditor.ready(function(K) {
	editor_content = K.create('textarea[name="content"]', {
		//uploadJson : '/blog/upload',
		//fileManagerJson : 'manager',
		//allowFileManager : false
		resizeType : 1,
		allowPreviewEmoticons : false,
		allowImageUpload : false,
		items : [
			'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
			'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
			'insertunorderedlist', 'link']
	});
});
</script>
