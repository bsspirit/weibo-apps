<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%@include file="header/auth.jsp" %>

<html>
	<head>
	</head>
	<body>
		<%=session.getAttribute("uid")%>
	</body>
</html>