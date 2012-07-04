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

}