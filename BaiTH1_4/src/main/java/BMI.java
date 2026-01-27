import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BMI")
public class BMI extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BMI() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Chuyển sang file input
        response.sendRedirect("input.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String weightStr = request.getParameter("weight");
            String heightStr = request.getParameter("height");

            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr);

            double bmi = weight / (height * height);

            String message = "";
            if (bmi < 18.5) {
                message = "Gầy -> Cần ăn thêm nhiều";
            } else if (bmi < 23.5) {
                message = "Bình thường -> Cố gắng giữ thể trạng này nha";
            } else if (bmi < 30) {
                message = "Thừa cân -> Tập thể dục đều đặn vào";
            } else {
                message = "Béo phì -> Cần được đi gặp bác sĩ";
            }

            request.setAttribute("bmiKetQua", String.format("%.2f", bmi)); 
            request.setAttribute("loiKhuyen", message);
            request.setAttribute("canNangDaNhap", weight);
            request.setAttribute("chieuCaoDaNhap", height);
            request.getRequestDispatcher("kqua.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            // Xử lý lỗi nếu người dùng nhập chữ thay vì số
            response.getWriter().append("Lỗi: Vui lòng nhập đúng định dạng số (Ví dụ: 60 và 1.70)");
        }
    }
}