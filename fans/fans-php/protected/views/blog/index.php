<div class="blog">
	<h1>开发日志</h1>
	<?php 
	$this->widget('zii.widgets.CListView', array(
		'dataProvider'=>$dataProvider,
		'itemView'=>'_view',
	));
	?>
</div>

<div class="blog">
	<div class="btn">
		<a href="/blog/create">发日志	</a>
	</div>
</div>


