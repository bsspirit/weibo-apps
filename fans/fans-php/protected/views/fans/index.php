<h1>粉丝管理</h1>

<?php 
$user = Yii::app()->session['user'];
?>

<p><a href="/fans/wage">粉丝微博年龄</a></p>
<p><a href="/fans/v">粉丝认证比例</a></p>
<p><a href="/fans/gender">粉丝性别比例</a></p>
<p><a href="/fans/cloud">粉丝云</a></p>
<p><a href="/fans/face">粉丝笑脸</a></p>

<hr/>
<a href="/fans/load">加载数据</a><br/>
<a href="/fans/report">产生报表</a><br/>

<hr/>
<?php 
var_dump($user);
echo '<br/>';
$token = Yii::app()->session['token'];
var_dump($token);
?>