<?php

class SiteController extends Controller
{
	
	public function actions()
	{
		return array(
			// captcha action renders the CAPTCHA image displayed on the contact page
// 			'captcha'=>array(
// 				'class'=>'CCaptchaAction',
// 				'backColor'=>0xFFFFFF,
// 			),
// 			// page action renders "static" pages stored under 'protected/views/site/pages'
// 			// They can be accessed via: index.php?r=site/page&view=FileName
// 			'page'=>array(
// 				'class'=>'CViewAction',
// 			),
		);
	}

	/**
	 * This is the default 'index' action that is invoked
	 * when an action is not explicitly requested by users.
	 */
	public function actionIndex()
	{
		$this->layout='//layouts/one-col';
		if(!Yii::app()->user->isGuest){
			$this->redirect('/fans');//粉丝管理页面
		}
		$this->render('index');
	}
	
	public function actionCallback(){
		$o = new SaeTOAuthV2( Yii::app()->params['WB_AKEY'] , Yii::app()->params['WB_SKEY'] );
		if (isset($_REQUEST['code'])) {
			$keys = array();
			$keys['code'] = $_REQUEST['code'];
			$keys['state'] = $_REQUEST['state'];
			$keys['redirect_uri'] = Yii::app()->params['WB_CALLBACK_URL'];
			try {
				$token = $o->getAccessToken( 'code', $keys ) ;
// 				var_dump($token);exit;
			} catch (OAuthException $e) {
				var_dump($e);
			}
		}
		
		if ($token) {//success
			Yii::app()->session['token'] = $token;
			setcookie( 'weibojs_'.$o->client_id, http_build_query($token) );
			$access = $token['access_token'];
			$uid=$token['uid'];
			$expiresIn=$token['expires_in'];
			$url = 'http://api.fens.me/api/oauth/'.$uid.'?code='.$access.'&expireIn='.$expiresIn.'&state='.$_REQUEST['state'];
			Yii::app()->session['user']=json_decode(HttpService::get($url));
			
			//login
			$model=new LoginForm;
			if($model->login()){
				$this->redirect('/fans');//粉丝管理页面
			} 
		}
		$this->redirect('/');//登录首页
	}

	/**
	 * This is the action to handle external exceptions.
	 */
	public function actionError()
	{
	    if($error=Yii::app()->errorHandler->error)
	    {
	    	if(Yii::app()->request->isAjaxRequest)
	    		echo $error['message'];
	    	else
	        	$this->render('error', $error);
	    }
	}

// 	/**
// 	 * Displays the contact page
// 	 */
// 	public function actionContact()
// 	{
// 		$model=new ContactForm;
// 		if(isset($_POST['ContactForm']))
// 		{
// 			$model->attributes=$_POST['ContactForm'];
// 			if($model->validate())
// 			{
// 				$headers="From: {$model->email}\r\nReply-To: {$model->email}";
// 				mail(Yii::app()->params['adminEmail'],$model->subject,$model->body,$headers);
// 				Yii::app()->user->setFlash('contact','Thank you for contacting us. We will respond to you as soon as possible.');
// 				$this->refresh();
// 			}
// 		}
// 		$this->render('contact',array('model'=>$model));
// 	}

	public function actionLogin()
	{
// 		$model=new LoginForm;

// 		// if it is ajax validation request
// 		if(isset($_POST['ajax']) && $_POST['ajax']==='login-form')
// 		{
// 			echo CActiveForm::validate($model);
// 			Yii::app()->end();
// 		}

// 		// collect user input data
// 		if(isset($_POST['LoginForm']))
// 		{
// 			$model->attributes=$_POST['LoginForm'];
// 			// validate user input and redirect to the previous page if valid
// 			if($model->validate() && $model->login())
// 				$this->redirect(Yii::app()->user->returnUrl);
// 		}
// 		// display the login form
// 		$this->render('login',array('model'=>$model));
		
		$this->redirect('/');//转向首页登录
	}
	
	public function actionAbout(){
		$this->render('about');
	}
	
	/**
	 * Logs out the current user and redirect to homepage.
	 */
	public function actionLogout()
	{
		Yii::app()->session->clear();
// 		Yii::app()->session->destroy();
		Yii::app()->user->logout();
		$this->redirect('/');
	}
}