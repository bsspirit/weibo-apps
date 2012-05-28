<?php
$o = new SaeTOAuthV2( Yii::app()->params['WB_AKEY'] , Yii::app()->params['WB_SKEY'] );
if (isset($_REQUEST['code'])) {
	$keys = array();
	$keys['code'] = $_REQUEST['code'];
	$keys['redirect_uri'] = Yii::app()->params['WB_CALLBACK_URL'];
	try {
		$token = $o->getAccessToken( 'code', $keys ) ;
		var_dump($token);
	} catch (OAuthException $e) {
		var_dump($e);
	}
}

if ($token) {
	Yii::app()->session['token'] = $token;
	setcookie( 'weibojs_'.$o->client_id, http_build_query($token) );
?>
授权完成,<a href="weibolist.php">进入你的微博列表页面</a><br />
<?php
} else {
?>
授权失败。
<?php
}
?>
