<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%@include file="header/auth.jsp" %>

<html>
	<head>
	</head>
	<body>
		<a href="<%=request.getAttribute("authorize")%>">通过新浪登陆</a>
	</body>
</html>