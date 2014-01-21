package hotel2013.hm;

import hotel2013.hm.dao.PersonDAO;
import hotel2013.hm.data.Booking;
import hotel2013.hm.data.Room;
import hotel2013.hm.users.Analyst;
import hotel2013.hm.users.Customer;
import hotel2013.hm.users.Hotelier;
import hotel2013.hm.users.Person;

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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MasterServlet
 */
@SuppressWarnings("serial")
@WebServlet("/MasterServlet")
public class MasterServlet extends HttpServlet {
	Hotelmanagement x = new Hotelmanagement();
	
	private static int sroomnumber;
	private static double sprice;
	private static String sequipment;
	private static int snop;
	private static int [][]sstat;
	private static double[] pstat;
	private static int[][] ostat;
	
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
	public static int[][] getSstat(){
		return sstat;
	}
	public static double[] getPstat(){
		return pstat;
	}
	public static int[][] getOstat(){
		return ostat;
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

	HttpSession session;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = null;
		session = request.getSession(true);
		
		String check = "index.jsp";
		response.setContentType("text/html");

		String rcv = request.getParameter("submit");
		
		if(rcv.equals("Login")){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			check = "loginfail.jsp";
			Person person = x.login(username, password);
			
			if(person != null){
			session.setAttribute("person", person.getUsername());
			if(person instanceof Customer)
			check = "CustomerInterface.jsp";
			if(person instanceof Hotelier)
			check = "HotelierInterface.jsp";
			if(person instanceof Analyst)
			check = "AnalystInterface.jsp";
			}
//			if ( check != "loginfail.jsp"){
//				session.setAttribute("person", );
//			}
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

		
		if(rcv.equals("SeasonStatistic")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Analyst){
			String xyear = request.getParameter("year");
			int year = Integer.parseInt(xyear);
			sstat = x.SeasonStatistic(year);
			check = "AnalystSeason.jsp";
			}
			else{
				check = "index.jsp";
			}
		}
		
		if(rcv.equals("PriceStatistic")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Analyst){
				String xyear = request.getParameter("year");
				int year = Integer.parseInt(xyear);
			pstat = x.PriceStatistic(year);
			check = "AnalystPrice.jsp";
			}
			else{
				check = "index.jsp";
			}
		}
		
		if(rcv.equals("OccStatistic")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Analyst){
				String xyear = request.getParameter("year");
				int year = Integer.parseInt(xyear);
			ostat = x.OccupancyStatistic(year);
			check = "AnalystOccupancy.jsp";
			}
			else{
				check = "index.jsp";
			}
		}
		
		if(rcv.equals("MakePriceOffer")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Analyst){
			String xpriceoffer = request.getParameter("priceoffer");
			String xroomnumber = request.getParameter("rnumber");
			double priceoffer = Double.parseDouble(xpriceoffer);
			int roomnumber = Integer.parseInt(xroomnumber);
			check = x.MakePriceOffer(priceoffer, roomnumber);
			}
			else{
				check = "index.jsp";
			}
		}
		
		if(rcv.equals("Show all Rooms")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Hotelier){
			roomlist = x.ShowAllRooms();
			check = "HotelierShowAllRooms.jsp";
			}
			else{
				check = "index.jsp";
			}
			
		}
		
		if(rcv.equals("Show All Rooms")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Analyst){
			roomlist = x.ShowAllRooms();
			check = "AnalystShowAllRooms.jsp";
			}
			else{
				check = "index.jsp";
			}
			
		}
		
		if(rcv.equals("ShowRating")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Hotelier){
			String xroomnumber = request.getParameter("roomnumber");
			sroomnumber = Integer.parseInt(xroomnumber);
			check = "HotelierShowRating.jsp";
			}
			else{
				check = "index.jsp";
			}
		}
		
		if(rcv.equals("ShowRatingAnalyst")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Analyst ){
			String xroomnumber = request.getParameter("roomnumber");
			sroomnumber = Integer.parseInt(xroomnumber);
			check = "AnalystShowRating.jsp";
			}
			else{
				check = "index.jsp";
			}
		}
		if(rcv.equals("Create")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Hotelier){
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
			else{
				check = "index.jsp";
			}
		}
		
		if(rcv.equals("SearchRoom")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Customer){
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
			else{
				check = "index.jsp";
			}
		}
		
		if(rcv.equals("EditRoom")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Hotelier){
			String xroomnumber = request.getParameter("rnumber");
			sroomnumber = Integer.parseInt(xroomnumber);
			String xprice = request.getParameter("price");
			sprice = Double.parseDouble(xprice);
			 sequipment = request.getParameter("equipment");
			String xnop = request.getParameter("nop");
			snop = Integer.parseInt(xnop);
			
			check = "HotelierEditRoom.jsp";
			}
			else{
				check = "index.jsp";
			}
		}
		
		if(rcv.equals("FinishEdit")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Hotelier){
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
			else{
				check = "index.jsp";
			}
		}
		
		if(rcv.equals("MyBookings")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Customer){
			 booklist = x.getBooklist(type);
			check = "CustomerCancelBooking.jsp";
			}
			else{
				check = "index.jsp";
			}
		}
		
		if(rcv.equals("CancelBooking")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Customer){
			String b = request.getParameter("bnumber");
			int i = Integer.parseInt(b);
			booklist = x.getBooklist(type);
			check = x.CancelBooking(i);
			}
			else{
				check = "index.jsp";
			}
		}
		
		if(rcv.equals("RateBooking")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Customer){
			String xbookingnumber = request.getParameter("bookingnumber");
			String rating = request.getParameter("ratearea");
			int bookingnumber = Integer.parseInt(xbookingnumber);
			check = x.RateBooking(bookingnumber, rating);
			}
			else{
				check = "index.jsp";
			}
		}
		
		
		if(rcv.equals("Book")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Customer){
			String xroomnumber = request.getParameter("rnumber");
			sroomnumber = Integer.parseInt(xroomnumber);
			check = "CustomerBook.jsp";
			}
			else{
				check = "index.jsp";
			}
		}
		
		if(rcv.equals("FinishBooking")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Customer){
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
			long difference = bookingend.getTime() - bookingstart.getTime();
			long day = ((((difference / 1000 )/60)/60)/24);
		
			
			check = x.Book(bookingstart, bookingend, payment, bnop, broomnumber,user, day);
			}
			else{
				check = "index.jsp";
			}
			
		}
		
	response.sendRedirect(check);

}
}
