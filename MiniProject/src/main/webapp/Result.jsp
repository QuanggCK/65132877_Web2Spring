<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Kết Quả Mini Game | QuanggCK</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    
    <style>
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
            width: 600px;
            max-width: 90%;
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
        }
        
        .detail-row {
            display: flex;
            justify-content: space-between;
            padding: 10px 0;
            border-bottom: 1px solid #333;
            font-size: 14px;
        }
        .detail-row:last-child { border-bottom: none; }
        
        .q-name { color: #aaa; font-weight: 500; }
        .correct { color: #2ecc71; font-weight: bold; }
        .wrong { color: #e74c3c; font-weight: bold; }
        .ans-hint { font-size: 12px; color: #888; font-style: italic; margin-left: 5px; }

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
        // --- XỬ LÝ LOGIC JAVA (SERVER SIDE) ---
        request.setCharacterEncoding("UTF-8");

        // 1. Lấy dữ liệu từ form Main.html
        String u1 = request.getParameter("ans1");
        String u2 = request.getParameter("ans2");
        String u3 = request.getParameter("ans3");
        String u4 = request.getParameter("ans4");
        String u5 = request.getParameter("ans5");

        // Xử lý null (tránh lỗi nếu người dùng truy cập trực tiếp link này)
        if(u1 == null) u1 = "";
        if(u2 == null) u2 = "";
        if(u3 == null) u3 = "";
        if(u4 == null) u4 = "";
        if(u5 == null) u5 = "";

        // 2. ĐỊNH NGHĨA ĐÁP ÁN ĐÚNG
        // Câu 1: QuanggCK
        String KEY_1 = "QuanggCK";
        
        // Câu 2: Orcust, Blue-Eyes (Logic: chứa cả 2 từ khóa này)
        // Không cần biến KEY cố định vì logic check string chứa chuỗi con
        
        // Câu 3: Trongdepzai
        String KEY_3 = "Trongdepzai";
        
        // Câu 4: 11
        String KEY_4 = "11";
        
        // Câu 5: 10
        String KEY_5 = "10";

        // 3. CHẤM ĐIỂM
        int score = 0;

        // Check Câu 1 (Không phân biệt hoa thường)
        boolean r1 = u1.trim().equalsIgnoreCase(KEY_1);
        if(r1) score++;

        // Check Câu 2 (Phức tạp: Chuyển về chữ thường, check xem có chứa "orcust" VÀ "blue-eyes" không)
        String a2Fix = u2.trim().toLowerCase();
        // Cho phép "blue eyes" (có cách) hoặc "blue-eyes" (gạch nối)
        boolean r2 = a2Fix.contains("orcust") && (a2Fix.contains("blue-eyes") || a2Fix.contains("blue eyes"));
        if(r2) score++;

        // Check Câu 3
        boolean r3 = u3.trim().equalsIgnoreCase(KEY_3);
        if(r3) score++;

        // Check Câu 4
        boolean r4 = u4.trim().equals(KEY_4);
        if(r4) score++;

        // Check Câu 5
        boolean r5 = u5.trim().equals(KEY_5);
        if(r5) score++;
    %>

    <div class="result-card">
        <h2 style="color: #0098CA; text-transform: uppercase; margin-top: 0;">Kết Quả Thi Đấu</h2>
        
        <div class="score-circle">
            <%= score %>/5
        </div>

        <div class="message">
            <% if(score == 5) { %>
                <span><i class="fas fa-trophy" style="color: #f1c40f;"></i> Xuất sắc!</span>
            <% } else if(score >= 3) { %>
                <span><i class="fas fa-thumbs-up"></i> Làm tốt lắm! Nhưng vẫn còn sai sót nhé :V</span>
            <% } else { %>
                <span><i class="fas fa-book-reader"></i> Sai hơi nhiều :<<</span>
            <% } %>
        </div>

        <div class="detail-box">
            <div class="detail-row">
                <span class="q-name">1. Kênh Youtube:</span>
                <span>
                    <% if(r1) { %> 
                        <span class="correct"><i class="fas fa-check"></i> Đúng</span>
                    <% } else { %> 
                        <span class="wrong"><i class="fas fa-times"></i> Sai</span>
                        <span class="ans-hint">(Đ/a: QuanggCK)</span>
                    <% } %>
                </span>
            </div>

            <div class="detail-row">
                <span class="q-name">2. Decks sở hữu:</span>
                <span>
                    <% if(r2) { %> 
                        <span class="correct"><i class="fas fa-check"></i> Đúng</span>
                    <% } else { %> 
                        <span class="wrong"><i class="fas fa-times"></i> Sai</span>
                        <span class="ans-hint">(Đ/a: Orcust, Blue-Eyes)</span>
                    <% } %>
                </span>
            </div>

            <div class="detail-row">
                <span class="q-name">3. Duelist gặp nhiều nhất:</span>
                <span>
                    <% if(r3) { %> 
                        <span class="correct"><i class="fas fa-check"></i> Đúng</span>
                    <% } else { %> 
                        <span class="wrong"><i class="fas fa-times"></i> Sai</span>
                        <span class="ans-hint">(Đ/a: Trongdepzai)</span>
                    <% } %>
                </span>
            </div>

            <div class="detail-row">
                <span class="q-name">4. Level Tecuhtlica:</span>
                <span>
                    <% if(r4) { %> 
                        <span class="correct"><i class="fas fa-check"></i> Đúng</span>
                    <% } else { %> 
                        <span class="wrong"><i class="fas fa-times"></i> Sai</span>
                        <span class="ans-hint">(Đ/a: 11)</span>
                    <% } %>
                </span>
            </div>

            <div class="detail-row">
                <span class="q-name">5. Level Predapower:</span>
                <span>
                    <% if(r5) { %> 
                        <span class="correct"><i class="fas fa-check"></i> Đúng</span>
                    <% } else { %> 
                        <span class="wrong"><i class="fas fa-times"></i> Sai</span>
                        <span class="ans-hint">(Đ/a: 10)</span>
                    <% } %>
                </span>
            </div>
        </div>

        <a href="Main.html" class="btn-home">
            <i class="fas fa-undo"></i> Quay lại trang chủ
        </a>
    </div>

</body>
</html>