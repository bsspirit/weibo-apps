<?php 
$user = Yii::app()->session['user'];
if(!empty($user) && ($user->uid==1999250817 || $user->uid==2816038140)){
?>
<div class="blog">
	<a class="btn" href="/blog/create">发日志</a>
</div>
<?php }?>

<div class="blog">
	<h1>开发日志</h1>
	<?php 
	$this->widget('zii.widgets.CListView', array(
			'dataProvider'=>$dataProvider,
			'itemView'=>'_view',
	));
	?>
</div>

