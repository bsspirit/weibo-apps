<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8" />
	<link rel="stylesheet" type="text/css" href="/css/main.css" />
	<link rel="stylesheet" type="text/css" href="/css/jquery-ui-1.8.20.custom.css" />
	<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="/js/jquery-ui-1.8.20.custom.min.js"></script>
	<script type="text/javascript" src="/js/common.js"></script>
	<script type="text/javascript" src="/js/google.js"></script>
	<title><?php echo CHtml::encode($this->pageTitle); ?></title>
	<link rel="shortcut icon" href="favicon.ico" /> 
</head>
<body>
	<div id="content">
		<?php include_once 'header.php';?>
		<?php echo $content; ?>
	</div>
	<div class="h">
		<script type="text/javascript" src="/js/baidu.js"></script>
	</div>
</body>
</html>
