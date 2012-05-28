<?php 

class HttpService {
	
	public static function get($url){
		$user_agent = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; .NET CLR 1.1.4322)";
		header('Content-Type: text/html; charset=utf-8');
		if(empty($url))return ;
		$curl = curl_init (); // 启动一个CURL会话
		curl_setopt ( $curl, CURLOPT_URL, $url ); // 要访问的地址
		curl_setopt ( $curl, CURLOPT_SSL_VERIFYPEER, 0 ); // 对认证证书来源的检查
		curl_setopt ( $curl, CURLOPT_SSL_VERIFYHOST, 1 ); // 从证书中检查SSL加密算法是否存在
		curl_setopt ( $curl, CURLOPT_USERAGENT, $user_agent ); // 模拟用户使用的浏览器
		@curl_setopt ( $curl, CURLOPT_FOLLOWLOCATION, 1 ); // 使用自动跳转
		curl_setopt ( $curl, CURLOPT_AUTOREFERER, 1 ); // 自动设置Referer
		curl_setopt ( $curl, CURLOPT_HTTPGET, 1 ); // 发送一个常规的Post请求
		// 		curl_setopt ( $curl, CURLOPT_COOKIEFILE, $this->cookie()); // 读取上面所储存的Cookie信息
		curl_setopt ( $curl, CURLOPT_TIMEOUT, 120 ); // 设置超时限制防止死循环
		curl_setopt ( $curl, CURLOPT_HEADER, 0 ); // 显示返回的Header区域内容
		curl_setopt ( $curl, CURLOPT_RETURNTRANSFER, 1 ); // 获取的信息以文件流的形式返回
		$body = curl_exec ( $curl ); // 执行操作
		if (curl_errno ( $curl )) echo 'Errno' . curl_error ( $curl );
		curl_close ( $curl ); // 关闭CURL会话
		return $body;
	}
}

?>