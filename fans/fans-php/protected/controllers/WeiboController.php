<?php

class WeiboController extends Controller
{
	
	public function filters()	{
		return array('accessControl',);
	}
	
	public function accessRules()	{
		return array(
			array('allow','users'=>array('@'),),
			array('deny', 'users'=>array('*')),
		);
	}
	
	//ajax
	public function actionSend($type){
		if(empty($type)){
			echo 0;return;
		}

		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/send/'.$type.'/'.$uid;
		$json = HttpService::get($url);
		echo $json;
	}
	
	public function actionFollowus(){
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/follow/'.$uid.'?fid=2816038140';
		$json = HttpService::get($url);
		echo $json;
	}
	
	public function actionApply($type){
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/apply/'.$type.'/'.$uid;
		$json = HttpService::get($url);
		
		$referer=$_SERVER["HTTP_REFERER"];
		$this::redirect($referer);
	}

}