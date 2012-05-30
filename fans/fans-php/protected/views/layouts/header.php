<div id="header">
	<div id="logo">
		<h1><a href="#" title="Home">晒粉丝</a></h1>
		<p>你不知道，粉丝有多强大!!@fensme</p>
	</div>
	<ul id="nav">
		<?php if(!Yii::app()->user->isGuest){?>
		<li><a class="current" href="/fans"><span class="akey">晒</span>粉丝</a></li>
		<!-- <li><a href="#"><span class="akey">晒</span>微博</a></li> -->
		<li><a href="/site/logout"><span class="akey">退</span>出登陆</a></li>
		<?php } else {?>
		<li><a class="current" href="/"><span class="akey">首</span>页</a></li>
		<!-- <li><a href="/site/about"><span class="akey">关</span>于本站</a></li> -->
		<!-- <li><a href="#"><span class="akey">留</span>言板</a></li> -->
		<?php }?>
	</ul>
	<div class="c"></div>
</div>