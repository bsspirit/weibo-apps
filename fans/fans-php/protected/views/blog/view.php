<?php 
$user = Yii::app()->session['user'];
if(!empty($user) && ($user->uid==1999250817 || $user->uid==2816038140)){
?>
<div class="blog">
	<a class="btn" href="/blog/create">发日志</a>
	<a class="btn" href="/blog/update/<?php echo $model->id?>">修改日志</a>
	<a class="btn" href="javascript:void(0);" onclick="deleteBlog(this)" path="/blog/delete/<?php echo $model->id?>">删除日志</a>
</div>
<script type="text/javascript">
function deleteBlog(obj){
	if(window.confirm("请确认删除日志!!")){
		$.ajax({
		  url: $(obj).attr("path"),
		  type: 'POST',
		  success: function(obj){
			location.href="http://www.fens.me/blog";  
		  }
		});
	}
}
</script>
<?php }?>

<div class="blog">
	<h2><?php echo CHtml::encode($model->title); ?></h2>
	<div class="author">
	作者:&nbsp;<a href="http://weibo.com/u/<?php echo $model->uid?>" target="_blank">Conan_Z</a>&nbsp;&nbsp;&nbsp;&nbsp;
	发布日期:&nbsp;<?php echo CHtml::encode($model->create_date);?>&nbsp;&nbsp;<br/>
	本文链接:<a href="http://www.fens.me/blog/view/<?php echo $model->id?>">http://www.fens.me/blog/view/<?php echo $model->id?></a><br/>
	<!-- 标签:&nbsp;开发日志&nbsp;&nbsp;&nbsp;&nbsp;分享:weibo,abc,abc,bac<br/> -->
	</div>
	<div class="content">
	<?php echo $model->content?>
	</div>
</div>

