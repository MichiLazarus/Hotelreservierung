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
 * Servlet implementation class MasterServlet
 */
@WebServlet("/MasterServlet")
public class MasterServlet extends HttpServlet {
	Hotelmanagement x = new Hotelmanagement();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String check = "index.jsp";
		response.setContentType("text/html");
		String rcv = request.getParameter("submit");
		if(rcv.equals("Login")){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
		   check = x.login(username, password);

		}
		

		if(rcv.equals("Register")){
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
			check = x.register(username, password, fullname, email, sex, birthday);		 
		}

		
		if(rcv.equals("ShowStatistics")){
			
		}
		
		if(rcv.equals("MakePriceOffer")){
			
		}
		
		if(rcv.equals("ShowAllRooms")){
			
		}
		
		if(rcv.equals("ShowRating")){
			
		}
		
		if(rcv.equals("NewOffer")){
			
		}
		
		if(rcv.equals("EditRoom")){
			
		}
		
		if(rcv.equals("CancelBooking")){
			
		}
		
		if(rcv.equals("RateBooking")){
			
		}
		
		if(rcv.equals("Book")){
			
		}
		
	response.sendRedirect(check);

}
}
