<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="language" content="zh" />

	<!-- blueprint CSS framework -->
	<!-- 
	<link rel="stylesheet" type="text/css" href="<?php echo Yii::app()->request->baseUrl; ?>/css/screen.css" media="screen, projection" />
	<link rel="stylesheet" type="text/css" href="<?php echo Yii::app()->request->baseUrl; ?>/css/print.css" media="print" />
	<link rel="stylesheet" type="text/css" href="<?php echo Yii::app()->request->baseUrl; ?>/css/ie.css" media="screen, projection" />
	<link rel="stylesheet" type="text/css" href="<?php echo Yii::app()->request->baseUrl; ?>/css/form.css" />
	-->
	<link rel="stylesheet" type="text/css" href="<?php echo Yii::app()->request->baseUrl; ?>/css/main.css" />
	<title><?php echo CHtml::encode($this->pageTitle); ?></title>
</head>

<body id="home">
	<div class="wrap">
		<div id="logo">
			<h1><a href="." title="Home">晒粉丝</a></h1>
			<p>你不知道，粉丝有多强大!!</p>
		</div>
		<ul id="nav">
			<li><a class="current" href="."><span class="akey">首</span>页</a></li>
			<li><a href="#"><span class="akey">晒</span>粉丝</a></li>
			<li><a href="#"><span class="akey">关</span>于本站</a></li>
			<li><a href="#"><span class="akey">留</span>言板</a></li>
			<li><a href="#"><span class="akey">退</span>出登陆</a></li>
		</ul>
		<div class="c"></div>
	</div>
	<div class="wrap">
		<div id="left">
			<?php echo $content; ?>
		</div>	
		<div id="right">
			<h2>Latest Entries</h2>
			<ul>
				<li><a href="#">Aenean justo nisl, luctus sit amet</a></li>
				<li><a href="#">Ut pretium mauris nec arcu</a></li>
				<li><a href="#">Praesent accumsan metus vel</a></li>
				<li><a href="#">Cum sociis natoque et magnis</a></li>
				<li><a href="#">Maecenas mattis ipsum a felis</a></li>
				<li><a href="#">Praesent accumsan metus vel</a></li>
				<li><a href="#">Ut pretium mauris nec arcu</a></li>
			</ul>
			<div id="tagcloud">
				<p>
					<span style="font-size: 1.3em"><a href="#">google</a></span>
					<span style="font-size: 1.1em"><a href="http://www.solucija.com">solucija</a></span>
					<span style="font-size: 1.6em"><a href="http://www.snewscms.com">snews</a></span>
					<span style="font-size: 1.5em"><a href="#">css</a></span>
					<span style="font-size: 1em"><a href="#">templates</a></span>
					<span style="font-size: .9em"><a href="#">apple</a></span>
					<span style="font-size: 1.6em"><a href="#">web 2.0</a></span>
					<span style="font-size: 1.4em"><a href="#">social</a></span>
					<span style="font-size: 1.5em"><a href="#">facebook</a></span>
					<span style="font-size: 1.7em"><a href="http://www.layoutica.com">layoutica</a></span>
				</p>
			</div>
			<p id="info">If you liked this template, you might like some other CSS templates from <a href="http://www.solucija.com" title="Information Architecture and Web Design">Solucija</a>!</p>
		</div>
		<div id="footer">
			<p><strong>Blog:</strong> <a href=".">Home</a> &middot; <a href="#">About</a> &middot; <a href="#">Media</a> &middot; <a href="#">References</a> &middot; <a href="#">Consulting</a> &middot; <a href="#">Contact</a></p>
			<p><strong>Network:</strong> <a href="#">Network site #1</a> &middot;  <a href="#">Network site #2</a> &middot;  <a href="#">Network site #3</a> &middot;  <a href="#">Network site #4</a></p>
			<p>@Copyright: bsspirit@gmail.com, <a title="Awsome Web Templates" href="http://www.solucija.com/">Solucija</a></p>
		</div>
	</div>


</body>
</html>
