<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
// Lấy giá trị tham số từ URL
String strA = request.getParameter("a");
int valueA = Integer.parseInt(strA);
// Hoặc int valueA = Integer.parseInt(request.getParameter("a"));

String strB = request.getParameter("b");
int valueB = Integer.parseInt(strB);
// Hoặc int valueB = Integer.parseInt(request.getParameter("b"));


%>
</body>
</html>