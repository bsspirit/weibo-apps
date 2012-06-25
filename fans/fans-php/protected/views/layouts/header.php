<div id="header">
	<div id="logo">
		<h1><a href="http://www.fens.me" title="Home">晒粉丝</a></h1>
		<p>你不知道，粉丝有多强大!!@fensme</p>
	</div>
	<ul id="nav">
		<?php 
		$url=Yii::app()->request->url;
		$indexPath=(preg_match('[^/$|^/site$|^/site/$|^/site/index$]',$url))?true:false;
		$aboutPath=(preg_match('[^/site/about$]',$url))?true:false;
		$fansPath=(preg_match('[^/fans]',$url))?true:false;
		$wbPath=(preg_match('[^/wb]',$url))?true:false;
		$blogPath=(preg_match('[^/blog]',$url))?true:false;
		$adminPath=(preg_match('[^/admin]',$url))?true:false;
		?>
			
		<?php if(Yii::app()->user->isGuest){?>
		<li><a <?php echo $indexPath?'class="current"':''?> href="/"><span class="akey">登</span>录</a></li>
		<?php }?>
	
		<?php if(!Yii::app()->user->isGuest){?>
		<li><a <?php echo $fansPath?'class="current"':''?> href="/fans"><span class="akey">晒</span>粉丝</a></li>
		<li><a <?php echo $wbPath?'class="current"':''?> href="/wb"><span class="akey">晒</span>微博</a></li>
		<li><a href="javascript:void(0);" onclick="followus()"><span class="akey">关</span>注我们</a></li>
		<?php }?>
		
		<li><a <?php echo $blogPath?'class="current"':''?> href="/blog"><span class="akey">开</span>发日志</a></li>
		<li><a <?php echo $aboutPath?'class="current"':''?> href="/site/about"><span class="akey">关</span>于本站</a></li>
		
		<?php 
		$user = Yii::app()->session['user'];
		if(!empty($user) && ($user->uid==1999250817 || $user->uid==2816038140)){
		?>
		<li><a <?php echo $adminPath?'class="current"':''?> href="/admin"><span class="akey">管</span>理员</a></li>
		<?php }?>
		
		
		<?php if(!Yii::app()->user->isGuest){?>
		<li><a href="/site/logout"><span class="akey">退</span>出登陆</a></li>
		<?php }?>
	</ul>
	<div class="c"></div>
</div>