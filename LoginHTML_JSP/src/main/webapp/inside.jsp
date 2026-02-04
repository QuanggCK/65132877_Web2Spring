<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bên trong</title>
</head>
<body>
<%
	String uname = request.getParameter("uname");
	String upass = request.getParameter("upass");
	if ((uname.equals("quanggck")) && (upass.equals("quanggck1610"))) {
		response.sendRedirect("UserProfile.html");
    } else {
        response.sendRedirect("Login.html");
	}
%>
</body>
</html>