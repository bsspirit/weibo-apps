<?php

// uncomment the following to define a path alias
// Yii::setPathOfAlias('local','path/to/local-folder');

// This is the main Web application configuration. Any writable
// CWebApplication properties can be configured here.
return array(
		'basePath'=>dirname(__FILE__).DIRECTORY_SEPARATOR.'..',
		'name'=>'晒粉丝',
		'language'=>'zh_cn',
		'preload'=>array('log'),
		'import'=>array(
				'application.models.*',
				'application.services.*',
				'application.components.*',
				'application.extensions.*',
		),

		'modules'=>array(
				'gii'=>array(
						'class'=>'system.gii.GiiModule',
						'password'=>'gii',
						'ipFilters'=>array('127.0.0.1','::1'),
				),
		),

		'components'=>array(
				'user'=>array(
						'allowAutoLogin'=>true,
				),
				'urlManager'=>array(
						'urlFormat'=>'path',
						'rules'=>array(
								'<controller:\w+>/<id:\d+>'=>'<controller>/view',
								'<controller:\w+>/<action:\w+>/<id:\d+>'=>'<controller>/<action>',
								'<controller:\w+>/<action:\w+>'=>'<controller>/<action>',
						),
				),
				// 		'db'=>array(
				// 			'connectionString' => 'sqlite:'.dirname(__FILE__).'/../data/testdrive.db',
				// 		),
				// uncomment the following to use a MySQL database
				/*
'db'=>array(
		'connectionString' => 'mysql:host=localhost;dbname=testdrive',
		'emulatePrepare' => true,
		'username' => 'root',
		'password' => '',
		'charset' => 'utf8',
),
*/
				'curl' =>array(
						'class' => 'application.extensions.curl.Curl',
				),
				'errorHandler'=>array(
						'errorAction'=>'site/error',
				),
				'log'=>array(
						'class'=>'CLogRouter',
						'routes'=>array(
								array(
										'class'=>'CFileLogRoute',
										'levels'=>'error, warning',
								),
								// 								array(
										// 										'class'=>'CWebLogRoute',
										// 								),
						),
				),
		),

		// application-level parameters that can be accessed
		// using Yii::app()->params['paramName']
		'params'=>array(
				'adminEmail'=>'bsspirit@gmail.com',
				'WB_AKEY'=>	'4213416087',
				'WB_SKEY'=> '2f02b4d6d52c9360cec4bfa29fa37778',
				'WB_CALLBACK_URL'=>'http://www.fens.me/site/callback',
					
				// 			define( "WB_AKEY" , '4213416087');
// 			define( "WB_SKEY" , '2f02b4d6d52c9360cec4bfa29fa37778');
// 			define( "WB_CALLBACK_URL" , 'http://www.fens.me/site/callback' );
		),
);