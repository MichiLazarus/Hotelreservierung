/**
 * @author Hotelreservierung Gruppe 8H2
 */
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
 * Neues Objekt der Klasse Hotelmanagement wird erstellt.
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
	
	/**
	 * Sendet die Raumnummer an die jsp-Seite, wo diese Methode aufgerufen wird.
	 * 
	 * @return Raumnummer
	 */
	public static int getSroomnumber(){
		return sroomnumber;
	}
	
	/**
	 * Sendet den Preis an die jsp-Seite, wo diese Methode aufgerufen wird.
	 * 
	 * @return Preis
	 */
	public static double getSprice() {
		return sprice;	
	}
	
	/**
	 * Sendet das Equipment an die jsp-Seite, wo diese Methode aufgerufen wird.
	 * 
	 * @return Equipment
	 */
	public static String getSequipment() {
		return sequipment;
	}
	
	/**
	 * Sendet Anzahl der Personen an die jsp-Seite, wo diese Methode aufgerufen wird.
	 * 
	 * @return Anzahl der Personen
	 */
	public static int getSnop() {
		return snop;
	}
	
	/**
	 * Sendet Statistik ueber Buchungen an die jsp-Seite, wo diese Methode aufgerufen wird.
	 * 
	 * @return mehrdimensionales Array mit Statisik ueber Buchungen
	 */
	public static int[][] getSstat(){
		return sstat;
	}
	
	/**
	 * Sendet Statistik ueber Einnahmen an die jsp-Seite, wo diese Methode aufgerufen wird.
	 * 
	 * @return Array mit Statisik ueber Einnahmen
	 */
	public static double[] getPstat(){
		return pstat;
	}
	
	/**
	 * Sendet Statistik ueber Buchungen eines bestimmten Zimmers an die jsp-Seite, wo diese Methode aufgerufen wird.
	 * 
	 * @return mehrdimensionales Array mit Statistik ueber Buchungen eines bestimmten Zimmers
	 */
	public static int[][] getOstat(){
		return ostat;
	}
	
	
	static String user;
	
	/**
	 * Sendet User an die jsp-Seite, wo diese Methode auferufen wird.
	 * 
	 * @return user
	 */
	public static String getUser(){
		return user;
	}
	
	
	
	public static ArrayList <Room> roomlist = new ArrayList <Room>();
	private static ArrayList<Booking> booklist =  new ArrayList <Booking>();
	
	/**
	 * Sendet Buchungsliste an die jsp-Seite, wo diese Methode aufgerufen wird.
	 * 
	 * @return Arrayliste mit allen Buchungen
	 */
	public static ArrayList<Booking> getBooklist(){
		return booklist;	
	}
	
	/**
	 * Sendet Liste mit allen Zimmern an die jsp-Seite, wo diese Methode aufgerufen wird.
	 * 
	 * @return Arrayliste mit allen Zimmern
	 */
	public static ArrayList <Room> getRoomlist(){
		return roomlist;
	}

	HttpSession session;
	
	/**
	 * doPost
	 * Mit request.getParameter die vom jsp uebergebenen Werte uebernommen.
	 * Da wir mehrere Submit-Button haben, holen wir uns die Werte vom jsp mittels request.getParameter("submit").
	 * Danach schauen wir welcher value der gedrueckte Submit-Button entspricht.
	 * Wir uebergeben dann mit request-getParameter() alle vorhandenen Werte des Formulars der bestimmten jsp-Seite an die Klasse Hotelmanagement.
	 * Dort werden die benoetigte Methode dann aufgerufen. 
	 * Mit der Variable check werden vom HotelManagement zurueckgelieferte jsp-Seiten uebernommen und in Anschluss daran aufgerufen.
	 * Am Anfang wird eine neue Session erstellt, falls noch keine Session vorhanden ist. 
	 * Mit session.setAttribut(String name, Objekt value) bindet man "name" mit dem Objekt value an die Sitzung. 
	 * Mit session.getAttribute(String name) wird das mit "name" verbundene Objekt geliefert.
	 * parse wird verwendet zur Konventierung in ein anderes Format.
	 */
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
		

		else if(rcv.equals("Register")){
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

		
		else if(rcv.equals("SeasonStatistic")){
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
		
		else if(rcv.equals("PriceStatistic")){
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
		
		else if(rcv.equals("OccStatistic")){
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
		
		else if(rcv.equals("MakePriceOffer")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			if(person instanceof Analyst){
				String xpriceoffer = request.getParameter("priceoffer");
				String xroomnumber = request.getParameter("rnumber");

				try{
				double priceoffer = Double.parseDouble(xpriceoffer);
				if(priceoffer > 0){
				int roomnumber = Integer.parseInt(xroomnumber);
				check = x.MakePriceOffer(priceoffer, roomnumber);
				}
				else check = "AnalystShowAllRoomsFail.jsp";
				}
				catch(NumberFormatException e){
					check = "AnalystShowAllRoomsFail.jsp";
				}
				

			}else{
				check = "index.jsp";
			}
		}
		
		else if(rcv.equals("Show all Rooms")){
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
		
		else if(rcv.equals("Show All Rooms")){
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
		
		else if(rcv.equals("ShowRating")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			
			if(person instanceof Hotelier){
				String xroomnumber = request.getParameter("roomnumber");
				sroomnumber = Integer.parseInt(xroomnumber);
			if(x.ShowRating(sroomnumber))
				check = "HotelierShowRating.jsp";
			else
				check = "HotelierInterfaceFail.jsp";
			}
		}
		
		else if(rcv.equals("Show Rating")){
			String type = (String)session.getAttribute("person");
			Person person = PersonDAO.getPersonbyUsername(type);
			
			if(person instanceof Analyst ){
				String xroomnumber = request.getParameter("roomnumber");
				sroomnumber = Integer.parseInt(xroomnumber);
			if(x.ShowRating(sroomnumber))
				check = "AnalystShowRating.jsp";
			else
				check = "AnalystInterfaceFail.jsp";
			}
		}
		
		else if(rcv.equals("Create")){
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
		
		else if(rcv.equals("SearchRoom")){
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
		
		else if(rcv.equals("EditRoom")){
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
		
		else if(rcv.equals("FinishEdit")){
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
			String rating = x.SetRating(roomnumber);
			sroomnumber = roomnumber;
			x.EditRoom(roomnumber, nop, equipment, price, rating);
			check = "HotelierInterface.jsp";
			}
			else{
				check = "index.jsp";
			}
		}
		
		else if(rcv.equals("MyBookings")){
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
		
		else if(rcv.equals("CancelBooking")){
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
		
		else if(rcv.equals("RateBooking")){
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
		
		
		else if(rcv.equals("Book")){
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
		
		else if(rcv.equals("FinishBooking")){
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
		else if(rcv.equals("Logout")){
			try
		    {      System.out.println("vswe");
		        session.removeAttribute("person");
		        session.invalidate();
		        check = "index.jsp";
		    }
		    catch (Exception e)
		    {
		    	System.out.println("nonono");
		    }
		}
		
	response.sendRedirect(check);

}
}