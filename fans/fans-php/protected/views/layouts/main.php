<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8" />
	<link rel="stylesheet" type="text/css" href="/css/main.css" />
	<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
	<title><?php echo CHtml::encode($this->pageTitle); ?></title>
	<link rel="shortcut icon" href="favicon.ico" /> 
</head>
<body>
	<div id="content">
		<?php include_once 'header.php';?>
		<?php echo $content; ?>
	</div>
</body>
</html>
