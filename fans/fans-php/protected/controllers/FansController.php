<?php

class FansController extends Controller
{
	public function actionIndex(){
		$this->render('index');
	}
	
	public function actionV(){
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/verifer/'.$uid;
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('verifer',array("obj"=>$obj));
	}
	
	public function actionGender(){
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/gender/'.$uid;
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('gender',array("obj"=>$obj));
	}

	public function actionWage(){
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/wage/'.$uid;
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('wage',array("obj"=>$obj));
	}
	
	public function actionFace(){
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/face/'.$uid;
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('face',array("obj"=>$obj));
	}
	
	public function actionCloud(){
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/cloud/'.$uid;
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('cloud',array("obj"=>$obj));
	}
	
	public function actionLoad(){
		if(!empty(Yii::app()->session['logon']) && Yii::app()->session['logon']){
			$uid = Yii::app()->session['user']->uid;
			$url = 'http://api.fens.me/api/load/'.$uid;
			$json = HttpService::get($url);
		}
		$this->render('index');
	}
	
	public function actionReport(){
		if(!empty(Yii::app()->session['logon']) && Yii::app()->session['logon']){
			$uid = Yii::app()->session['user']->uid;
			$url = 'http://api.fens.me/api/report/'.$uid;
			$json = HttpService::get($url);
		}
		$this->render('index');
	}
}