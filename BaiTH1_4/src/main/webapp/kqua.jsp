<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kết quả BMI</title>
<style>
    /* 1. Căn giữa màn hình (Giống trang nhập) */
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        font-family: Arial, sans-serif;
        background-color: #f0f2f5;
    }

    /* 2. Tạo khung hiển thị kết quả (Card) */
    .result-card {
        background-color: white;
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        text-align: center;
        width: 320px;
    }

    h2 {
        color: #333;
        margin-top: 0;
    }

    /* Trang trí phần thông tin chi tiết */
    .info {
        color: #555;
        margin: 10px 0;
        font-size: 0.95em;
    }

    /* Làm nổi bật số BMI */
    .bmi-number {
        font-size: 2.5em;
        font-weight: bold;
        color: #2196F3; /* Màu xanh dương */
        margin: 10px 0;
    }

    /* Phần lời khuyên/đánh giá */
    .message {
        font-size: 1.2em;
        font-weight: bold;
        color: #e91e63; /* Màu hồng đậm nhấn mạnh */
        margin-bottom: 30px;
    }

    /* 3. Biến thẻ <a> thành nút bấm (Button) */
    .btn-back {
        text-decoration: none;
        background-color: #4CAF50;
        color: white;
        padding: 10px 25px;
        border-radius: 5px;
        transition: background-color 0.3s;
    }

    .btn-back:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>

    <div class="result-card">
        <h2>Kết quả BMI của bạn</h2>
        
        <div class="info">
            Cân nặng: <b>${canNangDaNhap}</b> kg <br>
            Chiều cao: <b>${chieuCaoDaNhap}</b> m
        </div>
        
        <hr style="border: 0; border-top: 1px solid #eee; margin: 20px 0;">
        
        <div>Chỉ số BMI:</div>
        <div class="bmi-number">${bmiKetQua}</div>
        
        <div>Đánh giá:</div>
        <div class="message">${loiKhuyen}</div>
        
        <a href="input.html" class="btn-back">Nhập lại</a>
    </div>

</body>
</html>