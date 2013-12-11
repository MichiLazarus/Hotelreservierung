package hotel2013.hm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oifwenfwo.bravo;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

    /**
     * Default constructor. 
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String geilo = request.getParameter("dasistgut");
		String matico = request.getParameter("dasistauchgut");
		String master = bravo.login(geilo,matico);
		out.println("geilo post methode" + master);
		}

}
