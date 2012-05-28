<h1>粉丝管理</h1>

<?php 
$user = Yii::app()->session['user'];
?>

<a href="/fans/wage">粉丝微博年龄</a><br/>
<a href="/fans/v">粉丝认证比例</a><br/>
<a href="/fans/gender">粉丝性别比例</a><br/>

<hr/>
<?php 
var_dump($user);
?>