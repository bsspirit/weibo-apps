<?php

class FansController extends Controller
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

	public function actionIndex(){
		$this->checkSession();
		$this->render('index');
	}

	public function actionV(){
		$this->checkSession();
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/verifer/'.$uid;
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('verifer',array("obj"=>$obj));
	}

	public function actionGender(){
		$this->checkSession();
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/gender/'.$uid;
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('gender',array("obj"=>$obj));
	}

	public function actionWage(){
		$this->checkSession();
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/wage/'.$uid;
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('wage',array("obj"=>$obj));
	}

	public function actionFace(){
		$this->checkSession();
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/face/'.$uid;
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('face',array("obj"=>$obj));
	}
	
	public function actionRado(){
		$this->checkSession();
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/rado/'.$uid;
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('rado',array("obj"=>$obj));
	}

	public function actionCloud(){
		$this->checkSession();
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/cloud/'.$uid;
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('cloud',array("obj"=>$obj));
	}
	
	public function actionMap(){
		$this->checkSession();
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/map/'.$uid;
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('map',array("obj"=>$obj));
	}

	public function actionLoad(){
		$this->checkSession();
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/load/'.$uid;
		$json = HttpService::get($url);
		return $json;
	}

	public function actionReport(){
		$this->checkSession();
		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/report/'.$uid;
		$json = HttpService::get($url);
		return $json;
	}

	public function actionLoadreport(){
		$json=0;
		if($this->actionLoad()==1)
			$json=$this->actionReport();
		echo $json;
	}
}