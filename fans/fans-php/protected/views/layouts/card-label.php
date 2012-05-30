<?php 
$user = Yii::app()->session['user'];
if(!empty($user)){
?>
<div class="card">
	<h2>用户信息</h2>
	<div class="pic l">
		<a href="http://weibo.com/u/<?php echo $user->uid?>" target="_blank">
			<img src="<?php echo $user->profile_image_url?>" />
		</a>
	</div>
	<div class="text l">
		<a href="http://weibo.com/u/<?php echo $user->uid?>" target="_blank"><?php echo $user->screen_name;?></a><br/>
		<?php echo $user->gender=='m'?'男':'女';?>&nbsp;&nbsp;<?php echo $user->location;?><br/>
		<?php echo '<span class="darkblue">关注</span>:'.$user->friends_count.'&nbsp;&nbsp;<span class="darkblue">粉丝</span>:'.$user->followers_count.'&nbsp;&nbsp;<span class="darkblue">微博</span>:'.$user->statuses_count?><br/>
		<?php echo '介绍:'.$user->description;?><br/>
	</div>
	<div class="c"></div>
</div>
<?php }?>