<?php

class FansController extends Controller
{
	public function actionIndex(){
		$this->render('index');
	}
	
	public function actionV(){
		$url = 'http://api.fens.me/api/gender/1999250817';
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('verifer',array("obj"=>$obj));
	}
	
	public function actionGender(){
		$url = 'http://api.fens.me/api/gender/1999250817';
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('gender',array("obj"=>$obj));
	}

	public function actionWage(){
		$url = 'http://api.fens.me/api/wage/1999250817';
		$json = HttpService::get($url);
		$obj = json_decode($json);
		$this->render('wage',array("obj"=>$obj));
	}
}