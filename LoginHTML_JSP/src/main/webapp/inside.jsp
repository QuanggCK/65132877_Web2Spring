<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bên trong</title>

<style>
    .center {
        text-align: center;
        margin-top: 50px;
    }
</style>
</head>

<body>
<%
    String uname = request.getParameter("uname");
    String upass = request.getParameter("upass");

    if ("quanggck".equals(uname) && "quanggck1610".equals(upass)) {
%>

    <div class="center">
        <h2>Thông tin sinh viên</h2>
        <p><b>Họ tên:</b> Phạm Minh Quang</p>
        <p><b>Mã sinh viên:</b> 65132877</p>
        <p><b>Lớp:</b>65.CNTT-CLC</p>
    </div>

<%
    } else {
%>

    <div class="center">
        <h2>❌ Nhập sai rồi</h2>
        <a href="Login.html">Quay về trang đăng nhập</a>
    </div>

<%
    }
%>
</body>
</html>
