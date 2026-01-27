

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class testDoGet
 */
@WebServlet("/testDoGet")
public class testDoGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        String value1 = request.getParameter("param1");
        String value2 = request.getParameter("param2");

        PrintWriter traVe = response.getWriter();
        
        traVe.append("Giá trị tham số param1 = ");

        traVe.append(value1);
        
        traVe.append("<br>");

        traVe.append("Giá trị tham số param2 = ");

        traVe.append(value2);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
