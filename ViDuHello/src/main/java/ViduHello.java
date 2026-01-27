

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ViduHello")
public class ViduHello extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ViduHello() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		String noiDungHTML = "";
		noiDungHTML += "<center><h3>TÔI HỌC WEB JAVA </h3></center>";
		noiDungHTML += "<hr>";
		noiDungHTML += "65-CNTT.CLC";
		
		PrintWriter boTraLoi = response.getWriter();
		boTraLoi.print(noiDungHTML);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
