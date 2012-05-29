<?php

class WeiboController extends Controller
{
	public function actionIndex(){
		$this->render('index');
	}

	//ajax
	public function actionSend($type){
		if(empty($type)){
			echo 0;
			return;
		}

		$uid = Yii::app()->session['user']->uid;
		$url = 'http://api.fens.me/api/send/'.$type.'/'.$uid;
		$json = HttpService::get($url);
		echo $json;
		//CJSON::encode(array('uid'=>$uid));
	}

}