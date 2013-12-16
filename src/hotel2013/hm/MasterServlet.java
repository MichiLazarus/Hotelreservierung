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
			String status = request.getParameter("status");
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
			
			if(status.equals("customer"))
			check = x.registerC(username, password, fullname, email, sex, birthday);
			else if(status.equals("hotelier"))
			check = x.registerH(username, password, fullname, email, sex, birthday);
			else
			check = x.registerA(username, password, fullname, email, sex, birthday);
		}

		
		if(rcv.equals("ShowStatistics")){
			String type = request.getParameter("type");
			//check = x.ShowStatistic(type);
			//oder hier andere Art des Aufrufs
		}
		
		if(rcv.equals("MakePriceOffer")){
			String xpriceoffer = request.getParameter("priceoffer");
			String xroomnumber = request.getParameter("roomnumber");
			double priceoffer = Double.parseDouble(xpriceoffer);
			int roomnumber = Integer.parseInt(xroomnumber);
			//check = x.MakePriceOffer(priceoffer, roomnumber);
		}
		
		if(rcv.equals("ShowAllRooms")){
			check = x.ShowAllRooms();
			//Methode
		}
		
		if(rcv.equals("ShowRating")){
			String xroomnumber = request.getParameter("roomnumber");
			int roomnumber = Integer.parseInt(xroomnumber);
			check = x.ShowRating(roomnumber);
		}
		
		if(rcv.equals("NewOffer")){
			String xroomnumber = request.getParameter("roomnumber");
			String xnop = request.getParameter("nop");
			String equipment = request.getParameter("equipment"); // muss nicht konvertiert werden
			String xprice = request.getParameter("price");
			int roomnumber = Integer.parseInt(xroomnumber);
			int nop = Integer.parseInt(xnop);
			double price = Double.parseDouble(xprice);
			String rating ="No rating available";
			
			check = x.NewOffer(roomnumber, nop, equipment, price, rating);
		}
		
		if(rcv.equals("EditRoom")){
			String xroomnumber = request.getParameter("roomnumber");
			String xnop = request.getParameter("nop");
			String equipment = request.getParameter("equipment"); // muss nicht konvertiert werden
			String xprice = request.getParameter("price");
			int roomnumber = Integer.parseInt(xroomnumber);
			int nop = Integer.parseInt(xnop);
			double price = Double.parseDouble(xprice);
			//String rating    ----  Rating aus dem Room holen!
			//Hier evtl. andere L�sungsm�glichkeit?
			//Methode ---- check = 
		}
		
		if(rcv.equals("CancelBooking")){
			String xbookingnumber = request.getParameter("bookingnumber");
			int bookingnumber = Integer.parseInt(xbookingnumber);
			//Methode ---- check = 
		}
		
		if(rcv.equals("RateBooking")){
			String xbookingnumber = request.getParameter("bookingnumber");
			String rating = request.getParameter("rating");
			int bookingnumber = Integer.parseInt(xbookingnumber);
			//Methode ---- check = 
		}
		
		if(rcv.equals("Book")){
			String xbookingstart = request.getParameter("bookingstart");
			String xbookingend = request.getParameter("bookingend");
			String xpayment = request.getParameter("payment");
			String xbnop = request.getParameter("bnop");
			String xbroomnumber = request.getParameter("broomnumber");
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			try {
				Date bookingstart = sdf.parse(xbookingstart);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Date bookingend = sdf.parse(xbookingend);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean payment = Boolean.parseBoolean(xpayment);
			int bnop = Integer.parseInt(xbnop);
			int broomnumber = Integer.parseInt(xbroomnumber);
			//Methode ---- check = 
		}
		
	response.sendRedirect(check);

}
}
