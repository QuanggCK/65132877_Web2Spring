<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

    String uname = request.getParameter("username");
    String pname = request.getParameter("password");

    if("quanggck".equals(uname) && "quanggck1610".equals(pname)) {
        response.sendRedirect("Main.html");
    } else {

%>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>Lỗi đăng nhập</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        <style>
            body { 
                font-family: 'Poppins', sans-serif;
                background: #ffe6e6; 
                height: 100vh; display: flex; justify-content: center; align-items: center; margin: 0;
            }
            .error-box { 
                background: white; padding: 40px; border-radius: 15px; text-align: center; 
                box-shadow: 0 10px 25px rgba(255,0,0,0.1); border-left: 5px solid red;
            }
            h2 { color: red; margin-top: 0; }
            .btn-back {
                display: inline-block; margin-top: 20px; padding: 10px 20px;
                background: #333; color: white; text-decoration: none; border-radius: 20px;
            }
        </style>
    </head>
    <body>
        <div class="error-box">
            <h2>Opps! Sai rồi</h2>
            <p>Tài khoản hoặc mật khẩu không chính xác.</p>
            <p>Bạn nhập: <b><%= uname %></b></p>
            <a href="Login.html" class="btn-back">Thử lại ngay</a>
        </div>
    </body>
    </html>
<%
    }
%>