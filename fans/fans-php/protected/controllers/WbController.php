<?php

class WbController extends Controller{
	
	public function filters()	{
		return array('accessControl',);
	}
	
	public function accessRules()	{
		return array(
				array('allow','users'=>array('@'),),
				array('deny', 'users'=>array('*')),
		);
	}
	
	public function actionIndex(){
		$this->checkSession();
		$this->render('index');
	}
	
	public function actionIncrease(){
		$this->checkSession();
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/increase/'.$uid;
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('increase',array("obj"=>$obj));
	}
	
	public function actionSocialName(){
		$this->checkSession();
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/socialName/'.$uid;
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('socialName',array("obj"=>$obj));
	}
	
	public function actionSocialNode(){
		$this->checkSession();
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/socialNode/'.$uid;
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('socialNode',array("obj"=>$obj));
	}

}