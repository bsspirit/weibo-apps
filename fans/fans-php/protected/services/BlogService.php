<?php 

class BlogService {
	
	public static function getBlogList(){
		$sort = new CSort;
		$sort->defaultOrder = 'id DESC';
		
		$criteria=new CDbCriteria;
		$criteria->select = array('id', 'title', 'uid', 'utype', 'create_date');
		
		$dataProvider=new CActiveDataProvider('Blog',array(
			'criteria'=>$criteria,
			'sort'=>$sort,
		));
		
		return $dataProvider;
	}
	
}

?>