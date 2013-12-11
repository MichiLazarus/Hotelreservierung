package hotel2013.hm;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String rcv = request.getParameter("submit");
		if(rcv.equals("submit")){
			Date birthday = new Date();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String fullname = request.getParameter("fullname");
			String email = request.getParameter("email");
			String sexs = request.getParameter("sex");
			String xbirthday = request.getParameter("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			char sex = sexs.charAt(0);
			try {
				birthday = sdf.parse(xbirthday);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Hotelmanagement x = new Hotelmanagement();
			 x.register(username, password, fullname, email, sex, birthday);
		}
		response.sendRedirect("index.jsp");
		
		
	}

}
