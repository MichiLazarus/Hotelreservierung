package hotel2013.hm;

import hotel2013.hm.data.Booking;
import hotel2013.hm.data.Room;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MasterServlet
 */
@SuppressWarnings("serial")
@WebServlet("/MasterServlet")
public class MasterServlet extends HttpServlet {
	Hotelmanagement x = new Hotelmanagement();
	
	public static int sroomnumber;
	public static double sprice;
	public static String sequipment;
	public static int snop;
	
	public static int getSroomnumber(){
		return sroomnumber;
	}
	public static double getSprice() {
		return sprice;
	}
	public static String getSequipment() {
		return sequipment;
	}
	public static int getSnop() {
		return snop;
	}
	
	
	
	static String user;
	
	public static String getUser(){
		return user;
	}
	
	
	
	public static ArrayList <Room> roomlist = new ArrayList <Room>();
	private static ArrayList<Booking> booklist =  new ArrayList <Booking>();

	public static ArrayList<Booking> getBooklist(){
		return booklist;
		
	}
	public static ArrayList <Room> getRoomlist(){
		return roomlist;
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String check = "index.jsp";
		response.setContentType("text/html");

		String rcv = request.getParameter("submit");
		
		if(rcv.equals("Login")){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			check = x.login(username, password);
			if ( check != "loginfail.jsp"){
				user = username;
			}
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
			x.MakePriceOffer(priceoffer, roomnumber);
		}
		
		if(rcv.equals("Show all Rooms")){
			roomlist = x.ShowAllRooms();
			check = "HotelierShowAllRooms.jsp";
			
		}
		
		if(rcv.equals("Show All Rooms")){
			roomlist = x.ShowAllRooms();
			check = "AnalystShowAllRooms.jsp";
			
		}
		
		if(rcv.equals("ShowRating")){
			String xroomnumber = request.getParameter("roomnumber");
			sroomnumber = Integer.parseInt(xroomnumber);
			check = "HotelierShowRating.jsp";
		}
		
		if(rcv.equals("MakeNewOffer")){
			
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
		
		if(rcv.equals("SearchRoom")){
			String xprice = request.getParameter("price");
			double price = 0;
			if(!(xprice.equals("*")) && (xprice != null)){
				price = Double.parseDouble(xprice);
			}
			String equipment = request.getParameter("equipment");
			String xnop = request.getParameter("nop");
			int nop = Integer.parseInt(xnop);
			roomlist = x.SearchRoom(price, equipment, nop);
		    
			
			check = "CustomerSearchRooms.jsp";
			
		}
		
		if(rcv.equals("EditRoom")){
			String xroomnumber = request.getParameter("rnumber");
			sroomnumber = Integer.parseInt(xroomnumber);
			String xprice = request.getParameter("price");
			sprice = Double.parseDouble(xprice);
			String sequipment = request.getParameter("equipment");
			String xnop = request.getParameter("nop");
			snop = Integer.parseInt(xnop);
			
			check = "HotelierEditRoom.jsp";
		}
		
		if(rcv.equals("FinishEdit")){
			String xroomnumber = request.getParameter("rnumber");
			int roomnumber = Integer.parseInt(xroomnumber);
			String xprice = request.getParameter("price");
			double price = Integer.parseInt(xprice);
			String equipment = request.getParameter("equipment");
			String xnop = request.getParameter("nop");
			int nop = Integer.parseInt(xnop);
			String rating = x.ShowRating(roomnumber);
			sroomnumber = roomnumber;
			x.EditRoom(roomnumber, nop, equipment, price, rating);
			check = "HotelierInterface.jsp";
		}
		
		if(rcv.equals("MyBookings")){
			 booklist = x.getBooklist(user);
			check = "CustomerCancelBooking.jsp";
		}
		
		if(rcv.equals("CancelBooking")){
			String b = request.getParameter("bnumber");
			int i = Integer.parseInt(b);
			check = x.CancelBooking(i);
		}
		
		if(rcv.equals("RateBooking")){
			String xbookingnumber = request.getParameter("bookingnumber");
			String rating = request.getParameter("rating");
			int bookingnumber = Integer.parseInt(xbookingnumber);
			check = x.RateBooking(bookingnumber, rating);
		}
		
		
		if(rcv.equals("Book")){
			String xroomnumber = request.getParameter("rnumber");
			sroomnumber = Integer.parseInt(xroomnumber);
			check = "CustomerBook.jsp";
		}
		
		if(rcv.equals("FinishBooking")){
			Date bookingstart = null;
			Date bookingend = null;
			
			String xbookingstart = request.getParameter("bookingstart");
			
			String xbookingend = request.getParameter("bookingend");
			
			String payment = request.getParameter("payment");
			
			String xbnop = request.getParameter("bnop");
			
			String xbroomnumber = request.getParameter("broomnumber");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			
			try {
				bookingstart = sdf.parse(xbookingstart);
			} catch (ParseException e) {
				check = "CustomerBookFail.jsp";
				response.sendRedirect(check);
				return;
			}
			try {
				bookingend = sdf.parse(xbookingend);
			} catch (ParseException e) {
				check = "CustomerBookFail.jsp";
				response.sendRedirect(check);
				return;
			}
			
			int bnop = Integer.parseInt(xbnop);
			
			int broomnumber = Integer.parseInt(xbroomnumber);
			String user = request.getParameter("user");
			
			check = x.Book(bookingstart, bookingend, payment, bnop, broomnumber,user);
			
		}
		
	response.sendRedirect(check);

}
}
