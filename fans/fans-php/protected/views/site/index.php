<?php
$o = new SaeTOAuthV2( Yii::app()->params['WB_AKEY'] , Yii::app()->params['WB_SKEY'] );
$code_url = $o->getAuthorizeURL( Yii::app()->params['WB_CALLBACK_URL']);
?>

<p>
<a href="<?=$code_url?>">
<img src="<?php echo Yii::app()->request->baseUrl; ?>/images/weibo_login.png" title="点击进入授权页面" alt="点击进入授权页面" border="0" /></a>
</p>