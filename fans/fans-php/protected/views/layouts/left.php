<div id="left">
	<?php if(!Yii::app()->user->isGuest && preg_match('[^/fans]',Yii::app()->request->url)){?>
	<div class="nav">
		<ul>
			<!-- <li><a href="/fans">晒粉丝</a></li> -->
			<li><a href="/fans/wage">粉丝微博年龄</a></li>
			<li><a href="/fans/v">粉丝认证比例</a></li>
			<li><a href="/fans/gender">粉丝性别比例</a></li>
			<li><a href="/fans/cloud">粉丝云</a></li>
			<li><a href="/fans/face">粉丝笑脸</a></li>
			<li><a href="/fans/map">粉丝地图</a></li>
			<li><a href="/fans/increase">微博增长力</a></li>
		</ul>
	</div>
	<div class="c"></div>
	<hr />
	<?php }?>
	<?php echo $content; ?>
</div>