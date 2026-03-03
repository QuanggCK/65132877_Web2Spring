<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Kết Quả Mini Game | QuanggCK</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    
    <style>
        /* GIỮ NGUYÊN CSS CỦA BẠN */
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #131314;
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }
        .result-card {
            background: #1a1a1a;
            padding: 40px;
            border-radius: 20px;
            border: 1px solid #333;
            width: 650px; /* Tăng nhẹ độ rộng để chứa 7 câu */
            max-width: 95%;
            text-align: center;
            box-shadow: 0 10px 40px rgba(0,0,0,0.6);
            animation: fadeIn 0.5s ease-in-out;
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-20px); }
            to { opacity: 1; transform: translateY(0); }
        }
        .score-circle {
            width: 140px; height: 140px;
            border-radius: 50%;
            border: 6px solid #0098CA;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0 auto 20px;
            font-size: 45px;
            font-weight: 800;
            color: #0098CA;
            background: rgba(0, 152, 202, 0.05);
            box-shadow: 0 0 20px rgba(0, 152, 202, 0.3);
        }
        .message { margin-bottom: 30px; font-size: 18px; color: #ddd; }
        .detail-box {
            text-align: left;
            background: #222;
            padding: 25px;
            border-radius: 12px;
            margin-bottom: 30px;
            border: 1px solid #333;
            max-height: 400px; /* Thêm cuộn nếu danh sách quá dài */
            overflow-y: auto;
        }
        .detail-row {
            display: flex;
            justify-content: space-between;
            padding: 10px 0;
            border-bottom: 1px solid #333;
            font-size: 14px;
        }
        .detail-row:last-child { border-bottom: none; }
        .q-name { color: #aaa; font-weight: 500; flex: 1; padding-right: 10px; }
        .q-status { flex: 0 0 150px; text-align: right; }
        .correct { color: #2ecc71; font-weight: bold; }
        .wrong { color: #e74c3c; font-weight: bold; }
        .ans-hint { font-size: 11px; color: #888; font-style: italic; display: block; }
        .btn-home {
            display: inline-block;
            text-decoration: none;
            background: #0098CA;
            color: white;
            padding: 12px 35px;
            border-radius: 50px;
            font-weight: bold;
            transition: all 0.3s;
        }
        .btn-home:hover { background: #0081ab; transform: scale(1.05); box-shadow: 0 5px 15px rgba(0, 152, 202, 0.4); }
    </style>
</head>
<body>

    <%
        request.setCharacterEncoding("UTF-8");

        // 1. Lấy dữ liệu từ form (ans1 đến ans7)
        String[] userAnswers = new String[7];
        for(int i = 0; i < 7; i++) {
            userAnswers[i] = request.getParameter("ans" + (i+1));
            if(userAnswers[i] == null) userAnswers[i] = "Chưa chọn";
        }

        // 2. Định nghĩa đáp án đúng (khớp chính xác với file JSON của bạn)
        String[] keys = {
            "QuanggCK",
            "Orcust - Blue-Eyes",
            "Trongdepzai - Trọng",
            "11",
            "10",
            "2300",
            "Strike Of Justice"
        };

        // 3. Tên hiển thị rút gọn cho từng câu
        String[] qLabels = {
            "Kênh Youtube",
            "Decks sở hữu",
            "Duelist gặp nhiều nhất",
            "Level Tecuhtlica",
            "Level Predapower",
            "ATK Decode Talker",
            "Pack mới nhất"
        };

        // 4. Chấm điểm
        int score = 0;
        boolean[] results = new boolean[7];
        for(int i = 0; i < 7; i++) {
            results[i] = userAnswers[i].equals(keys[i]);
            if(results[i]) score++;
        }
    %>

    <div class="result-card">
        <h2 style="color: #0098CA; text-transform: uppercase; margin-top: 0;">Kết Quả Thi Đấu</h2>
        
        <div class="score-circle">
            <%= score %>/7
        </div>

        <div class="message">
            <% if(score == 7) { %>
                <span><i class="fas fa-trophy" style="color: #f1c40f;"></i> King of Games! Xuất sắc!</span>
            <% } else if(score >= 4) { %>
                <span><i class="fas fa-thumbs-up"></i> Khá lắm! Bạn hiểu mình đấy!</span>
            <% } else { %>
                <span><i class="fas fa-book-reader"></i> Cần tìm hiểu thêm rồi :<<</span>
            <% } %>
        </div>

        <div class="detail-box">
            <% for(int i = 0; i < 7; i++) { %>
                <div class="detail-row">
                    <span class="q-name"><%= (i+1) %>. <%= qLabels[i] %>:</span>
                    <span class="q-status">
                        <% if(results[i]) { %> 
                            <span class="correct"><i class="fas fa-check"></i> Đúng</span>
                        <% } else { %> 
                            <span class="wrong"><i class="fas fa-times"></i> Sai</span>
                            <span class="ans-hint">(Đ/a: <%= keys[i] %>)</span>
                        <% } %>
                    </span>
                </div>
            <% } %>
        </div>

        <a href="Main.html" class="btn-home">
            <i class="fas fa-undo"></i> Quay lại trang chủ
        </a>
    </div>

</body>
</html>