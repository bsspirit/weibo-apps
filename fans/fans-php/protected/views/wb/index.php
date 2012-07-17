<?php $user = Yii::app()->session['user'];?>

<h1>晒微博 - 索引</h1>

<div class="view">
	<div class="box">
		<h3><a href="/wb/socialName">社交关系图</a></h3>
		<p>说明:你知道在你的社交网络中，谁是活跃份子，谁是个性独立的吗？快来看看他们都是谁吧!!</p>
		<a href="/wb/socialName">点击进入</a>
	</div>
	<div class="box">
		<h3><a href="/wb/socialNode">社交关系网络图</a></h3>
		<p>说明:你知道的社交网络是什么样的吗？这个图能很神奇的告诉你！</p>
		<a href="/wb/socialNode">点击进入</a>
	</div>
	<div class="box">
		<h3><a href="/wb/increase">微博增长力</a></h3>
		<p>说明:你知道你的微博是增长了多少吗?我们会记录您的运营情况,帮您把这份辛苦记录下来!!</p>
		<a href="/wb/increase">点击进入</a>
	</div>
</div>

