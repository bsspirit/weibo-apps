<?php 
$user = Yii::app()->session['user'];
?>

<h1>粉丝的笑脸</h1>
<a href="http://weibo.com/u/<?php echo $user->uid?>" target="_blank"><?php echo $user->screen_name?></a><br/>
<?php echo $obj->tweet?><br/>

<a href="/weibo/send?type=rest.face">发微博</a><br/>

<img src="<?php echo $obj->img?>"/>


