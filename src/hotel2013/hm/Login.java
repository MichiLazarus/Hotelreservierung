package hotel2013.hm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

    /**
     * Default constructor. 
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String check = "index.jsp";
		response.setContentType("text/html");
		String rcv = request.getParameter("submit");
		if(rcv.equals("Login")){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			Hotelmanagement x = new Hotelmanagement();
		   check = x.login(username, password);

		}
		response.sendRedirect(check);
		
		}

}
