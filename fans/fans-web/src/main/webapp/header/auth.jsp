<%
Boolean logon = (Boolean) request.getSession().getAttribute("logon");
if (logon != null && logon) {
    response.sendRedirect("home");
    return;
} else {
    response.sendRedirect("index");
    return;
}
%>