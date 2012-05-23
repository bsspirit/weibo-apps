<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%
Long uid =(Long) session.getAttribute("uid");
String screen =(String) session.getAttribute("screen");
%>


<html>
	<head>
	</head>
	<body>
		<h1><%=screen%> - 粉丝男女比例</h1>
		<img src="http://image.fans.com/gender/<%=uid%>.png"/>
	</body>
</html>