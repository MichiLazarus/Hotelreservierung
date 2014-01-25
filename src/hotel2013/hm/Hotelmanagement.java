/**
 * @author Hotelreservierung Gruppe 8H2 
 */
package hotel2013.hm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import hotel2013.hm.dao.BookingDAO;
import hotel2013.hm.dao.PersonDAO;
import hotel2013.hm.dao.RoomDAO;
import hotel2013.hm.data.Booking;
import hotel2013.hm.data.Room;
import hotel2013.hm.users.Analyst;
import hotel2013.hm.users.Customer;
import hotel2013.hm.users.Hotelier;
import hotel2013.hm.users.Person;

public class Hotelmanagement {
	
	private Person session = null;
	private PersonDAO personDAO = new PersonDAO("Persons.ser");
	private BookingDAO bookingDAO = new BookingDAO("Bookings.ser");
	private RoomDAO roomDAO = new RoomDAO("Rooms.ser");	
	private ArrayList <Booking> bookinglist = new ArrayList<Booking>();
	private ArrayList <Room> roomlist = new ArrayList<Room>();
	static int bookingnrcounter = 1000;
	
	
	public Hotelmanagement(){
		
	}
	
	/**
	 * Registriert einen neuen Customer und wird persistent gespeichert. 
	 * Zusaetzlich wird geschaut, dass der registrierte Customer ueber 18 Jahre alt ist.
	 * 
	 * @param username
	 * Der eingegebene Username
	 * @param password
	 * Das eingegebene Passwort
	 * @param fullName
	 * Der eingegebene vollstaendige Name
	 * @param email
	 * Die eingegebene E-Mail
	 * @param sex
	 * Das eingegebene Geschlecht
	 * @param birthday
	 * Das eingegebene Geburtsdatum
	 * @return passende jsp-Seite
	 */
	public String registerC(String username, String password, String fullName, String email, char sex, Date birthday){
	

		Person newCustomer =  new Customer(username, password, fullName, email, sex, birthday);
			 
		long difference = new Date().getTime() - birthday.getTime();
		long age = (((((difference / 1000 )/60)/60)/24)/365);
		if(age > 17){

		if(personDAO.savePerson(newCustomer))
		return "index.jsp";
		else
		return "registerfail.jsp";
		}
		return "registerfail.jsp";
	}
	
	/**
	 * Registriert einen neuen Hotelier und wird persistent gespeichert. 
	 * 
	 * @param username
	 * Der eingegebene Username
	 * @param password
	 * Das eingegebene Passwort
	 * @param fullName
	 * Der eingegebene vollstaendige Name
	 * @param email
	 * Die eingegebene E-Mail
	 * @param sex
	 * Das eingegebene Geschlecht
	 * @param birthday
	 * Das eingegebene Geburtsdatum
	 * @return passende jsp-Seite
	 */
	public String registerH(String username, String password, String fullName, String email, char sex, Date birthday){

		Person newHotelier =  new Hotelier(username, password, fullName, email, sex, birthday);
		if(personDAO.savePerson(newHotelier))
		return "index.jsp";
		else
		return "registerfail.jsp";
	}
	
	/**
	 * Registriert einen neuen Analysten und wird persistent gespeichert. 
	 * 
	 * @param username
	 * Der eingegebene Username
	 * @param password
	 * Das eingegebene Passwort
	 * @param fullName
	 * Der eingegebene vollstaendige Name
	 * @param email
	 * Die eingegebene E-Mail
	 * @param sex
	 * Das eingegebene Geschlecht
	 * @param birthday
	 * Das eingegebene Geburtstag
	 * @return passende jsp-Seite
	 */
	public String registerA(String username, String password, String fullName, String email, char sex, Date birthday){

		Person newAnalyst =  new Analyst(username, password, fullName, email, sex, birthday);
		if(personDAO.savePerson(newAnalyst))
		return "index.jsp";
		else
		return "registerfail.jsp";
	}
	
	/**
	 * Besorgt die Buchungsliste eines bestimmten Users.
	 * 
	 * @param user
	 * User, dessen Buchungsliste gewuenscht ist
	 * @return Buchungsliste eines bestimmten Users
	 */
	public ArrayList<Booking> getBooklist(String user){
		ArrayList<Booking> Blist = bookingDAO.getBookingsofUsername(user);
		return Blist;
	}
	
	/**
	 * Login. Es wird ueberprueft ob der Username vorhanden ist und ob das Passwort uebereinstimmt.
	 * Arraylist bookinglist ist dazu da, um bei einem Serverneustart die Buchungsnummer an der richtigen Stelle fortzusetzen.
	 * 
	 * @param username
	 * Der eingegebene Username beim Login
	 * @param password
	 * Das eingegebene Passwort beim Login
	 * @return Objekt person oder null
	 */
	public Person login(String username, String password){
		
		Person person = personDAO.getPersonbyUsername(username);
		if(person == null){
			return null;
		}
		bookinglist = bookingDAO.getBookinglist();
		int x = 1000;
		if(!bookinglist.isEmpty()){
		for(Booking booking : bookinglist){
			x = booking.getBookingnumber();
			bookingnrcounter = x;
		}
		}
			if(person.verifyPassword(password)){
			return person;
			
//			if(person instanceof Customer)
//				return "CustomerInterface.jsp";
//			if(person instanceof Hotelier)
//				return "HotelierInterface.jsp";
//			if(person instanceof Analyst)
//				return "AnalystInterface.jsp";
		}
		
		return null;
	}
	
	/**
	 * Es wird ein gewuenschtes Jahr als Parameter uebergeben und die dazugehoerige Statistik soll angezeigt werden. 
	 * Dazu wird die Buchungsliste aller Buchungen vom BookingDAO benötigt. Es wird ein mehrdimensionales Array erstellt.
	 * Darin werden die Anzahl der Buchungen, sowie die Personenanzahl reingeschrieben für jedes einzelne Monat.
	 * Nur fuer den Analysten.
	 * 
	 * @param refyear
	 * Jahr, zu der die Statistik angezeigt werden soll
	 * @return mehrdimensionale Arraylist mit der zum Jahr passenden Statistik der Buchungen
	 */
	//Analyst
	public int [][]SeasonStatistic(int refyear){
		//if(session instanceof Analyst){
				bookinglist = bookingDAO.getBookinglist();
				
				int [][] season= new int [2][12];
				System.out.println("test");				
				
				for(Booking booking : bookinglist){
					Date start = booking.getBookingstart();
					Calendar timeref = Calendar.getInstance();
					timeref.setTime(start);
					int year = timeref.get(Calendar.YEAR);
					int month = timeref.get(Calendar.MONTH) +1;
					
					System.out.println(month);
					if(refyear == year){
						if(month == 1){
							season[0][0] += 1;
							season[1][0] += booking.getBnop();
						}
						else if(month == 2){
							season[0][1] += 1;
							season[1][1] += booking.getBnop();
						}
						else if(month == 3){
							season[0][2] += 1;
							season[1][2] += booking.getBnop();
						}
						else if(month == 4){
							season[0][3] += 1;
							season[1][3] += booking.getBnop();
						}
						else if(month == 5){
							season[0][4] += 1;
							season[1][4] += booking.getBnop();
						}
						else if(month == 6){
							season[0][5] += 1;
							season[1][5] += booking.getBnop();
						}
						else if(month == 7){
							season[0][6] += 1;
							season[1][6] += booking.getBnop();
						}
						else if(month == 8){
							season[0][7] += 1;
							season[1][7] += booking.getBnop();
						}
						else if(month == 9){
							season[0][8] += 1;
							season[1][8] += booking.getBnop();
						}
						else if(month == 10){
							season[0][9] += 1;
							season[1][9] += booking.getBnop();
						}
						else if(month == 11){
							season[0][10] += 1;
							season[1][10] += booking.getBnop();
						}
						else if(month == 12){
							season[0][11] += 1;
							season[1][11] += booking.getBnop();
						}
					}
				}
				
				return season;
		}
	
	/**
	 * Es wird ein gewuenschtes Jahr als Parameter uebergeben und die dazugehoerige Statistik soll angezeigt werden. 
	 * Dazu wird die Buchungsliste aller Buchungen vom BookingDAO benötigt. Es wird ein Array erstellt.
	 * Darin werden die Einnahmen pro Monat reingeschrieben.
	 * Nur fuer den Analysten.
	 * 
	 * @param refyear
	 * Jahr, zu der die Statistik angezeigt werden soll
	 * @return Arraylist mit der zum Jahr passenden Statistik der Einnahmen pro Monat
	 */
	public double []PriceStatistic(int refyear){
		//if(session instanceof Analyst){
				bookinglist = bookingDAO.getBookinglist();
				
				double [] pricestat = new double [36];
				System.out.println("test");
				
				for(Booking booking : bookinglist){
					Date start = booking.getBookingstart();
					Calendar timeref = Calendar.getInstance();
					timeref.setTime(start);
					int year = timeref.get(Calendar.YEAR);
					int month = timeref.get(Calendar.MONTH) +1;
					System.out.println(month);
					if(refyear == year){
						if(month == 1){
							pricestat[0] += booking.getMoney();
							if(booking.getPayment().equals("Bar"))
								pricestat[12] += 1;
							else pricestat[13] += 1;
							
						}
						else if(month == 2){
							pricestat[1] += booking.getMoney();
							if(booking.getPayment().equals("Bar"))
								pricestat[14] += 1;
							else pricestat[15] += 1;
						}
						else if(month == 3){
							pricestat[2] += booking.getMoney();
							if(booking.getPayment().equals("Bar"))
								pricestat[16] += 1;
							else pricestat[17] += 1;
						}
						else if(month == 4){
							pricestat[3] += booking.getMoney();
							if(booking.getPayment().equals("Bar"))
								pricestat[18] += 1;
							else pricestat[19] += 1;
						}
						else if(month == 5){
							pricestat[4] += booking.getMoney();
							if(booking.getPayment().equals("Bar"))
								pricestat[20] += 1;
							else pricestat[21] += 1;
						}
						else if(month == 6){
							pricestat[5] += booking.getMoney();
							if(booking.getPayment().equals("Bar"))
								pricestat[22] += 1;
							else pricestat[23] += 1;
						}
						else if(month == 7){
							pricestat[6] += booking.getMoney();
							if(booking.getPayment().equals("Bar"))
								pricestat[24] += 1;
							else pricestat[25] += 1;
						}
						else if(month == 8){
							pricestat[7] += booking.getMoney();
							if(booking.getPayment().equals("Bar"))
								pricestat[26] += 1;
							else pricestat[27] += 1;
						}
						else if(month == 9){
							pricestat[8] += booking.getMoney();
							if(booking.getPayment().equals("Bar"))
								pricestat[28] += 1;
							else pricestat[29] += 1;
						}
						else if(month == 10){
							pricestat[9] += booking.getMoney();
							if(booking.getPayment().equals("Bar"))
								pricestat[30] += 1;
							else pricestat[31] += 1;
						}
						else if(month == 11){
							pricestat[10] += booking.getMoney();
							if(booking.getPayment().equals("Bar"))
								pricestat[32] += 1;
							else pricestat[33] += 1;
						}
						else if(month == 12){
							pricestat[11] += booking.getMoney();
							if(booking.getPayment().equals("Bar"))
								pricestat[34] += 1;
							else pricestat[35] += 1;
						}
					}
				}
				return pricestat;
		}
	
	/**
	 * Es wird ein gewuenschtes Jahr als Parameter uebergeben und die dazugehoerige Statistik soll angezeigt werden. 
	 * Dazu wird die Buchungsliste aller Buchungen vom BookingDAO benötigt. Es wird ein mehrdimensionales Array erstellt.
	 * Darin werden die Anzahl der Buchungen für ein bestimmtes Zimmer reingeschrieben.
	 * Nur fuer den Analysten.
	 * 
	 * @param refyear
	 * Jahr, zu der die Statistik angezeigt werden soll
	 * @return mehrdimensionale Arraylist mit der zum Jahr passenden Statistik, wie oft ein bestimmte Zimmer gebucht wurde
	 */
	public int [][]OccupancyStatistic(int refyear){
		roomlist = roomDAO.getRoomlist();
		bookinglist = bookingDAO.getBookinglist();
		
		int ocstat [][] = new int [roomlist.size()+1][3];
		int i = 0;
		String equipment;

		for ( Room room : roomlist){
			ocstat [i][0] = room.getRoomnumber();
			equipment = room.getEquipment();
			
			if(equipment.equals("Superior Suite")) ocstat[i][2] = 1;
				else if(equipment.equals("Business Suite")) ocstat[i][2] = 2;
				else if(equipment.equals("High Class Room")) ocstat[i][2] = 3;
				else if(equipment.equals("Economy Class Room")) ocstat[i][2] = 4;
			++i;
		}
		for (int b = 0; b < i ; b++ ){
		for (Booking booking : bookinglist){
			if ( b < i){
				if(booking.getBroomnumber() == ocstat [b][0]){
					ocstat [b][1] +=1;
				}
			}
		}
		}
		ocstat [roomlist.size()][0] = i;

		return ocstat;
		}

	/**
	 * Hier koennen Preisvrschlaege vom Analysten für ein bestimmtes Zimmer vorgeschlagen werden.
	 * Nur fuer den Analysten.
	 * 
	 * @param priceOffer
	 * Der vorgeschlagene Preis
	 * @param roomnumber
	 * Die Raumnummer, bei der ein Preisvorschlag gemacht wird
	 * @return passende jsp-Seite
	 */
	public String MakePriceOffer(double priceOffer, int roomnumber){
//		if(session instanceof Analyst){
			roomlist = roomDAO.getRoomlist();
			for(Room room : roomlist){
				if(room.getRoomnumber() == roomnumber){
					room.setPriceOffer(priceOffer);
					roomDAO.updateRoom(room);
					return "AnalystInterfaceSucess.jsp";
				}
			}
			return "AnalystInterfacePriceofferfail.jsp";
		}
//		return "AnalystInterfacePriceofferfail.jsp";
//	}
	
	/**
	 * Liefert alle erstellten Zimmer.
	 * Nur fuer den Analysten und den Hotelier.
	 * 
	 * @return Arraylist mit allen Zimmern
	 */
	//Analyst & Hotelier
	public ArrayList<Room> ShowAllRooms(){
		
		roomlist = roomDAO.getRoomlist();
		ArrayList <Room> roomlist = new ArrayList<Room>();
		for ( Room room : roomlist){
				roomlist.add(room);
		}
		return roomlist;
		
	}
	
	/**
	 * 
	 * @param roomnumber
	 * 
	 * @return "Could not find this room" 
	 */
	public String SetRating(int roomnumber){
		roomlist = roomDAO.getRoomlist();

			for(Room room : roomlist){
				
				if(room.getRoomnumber() == roomnumber){
					return room.getRating();
				}
			}
			return "Could not find this room";
	}
	
	/**
	 * Rating für ein bestimmtes Zimmer wird angezeigt.
	 * 
	 * @param roomnumber
	 * Die Raumnummer, fuer die das Rating angezeigt werden soll
	 * @return true, wenn Raumnummer existiert oder false, falls Raumnummer nicht vorhanden
	 */
	public boolean ShowRating(int roomnumber){
		roomlist = roomDAO.getRoomlist();

			for(Room room : roomlist){
				
				if(room.getRoomnumber() == roomnumber){
					return true;
				}
			}
			return false;
	}
	
	//Hotelier
	public String NewOffer(int roomnumber, int nop, String equipment, double price, String rating){
//		if(session instanceof Hotelier){
			Room newRoom =  new Room(roomnumber, nop, equipment, price, rating);
			String check = roomDAO.saveRoom(newRoom);
			
			if(check.equals("success"))
				return "HotelierInterfaceNewOffer.jsp";
			else 
				return "HotelierInterfaceFail.jsp";
		}
		
//		return "HotelierInterfaceFail.jsp";
//	}
	
	public String EditRoom(int roomnumber, int nop, String equipment, double price, String rating){
	
		roomlist = roomDAO.getRoomlist();
		
//		if(session instanceof Hotelier){
			for(Room room : roomlist){
				if(room.getRoomnumber() == roomnumber){
					Room newRoom = new Room(roomnumber, nop, equipment, price, rating);
					roomDAO.updateRoom(newRoom);
					return "Edit successful";
				}
			}
			return "Room not found";
		}
//		return "You do not have the permission to edit a room";
//	}
	
	
	//Customer
	
	
	public String CancelBooking(int xbookingnumber){
		
		Booking booking = bookingDAO.getBookingbyBookingnumber(xbookingnumber);
		if(booking == null){
			return "CustomerInterfaceFail.jsp";
		}
		
		
		else{
					
					bookingDAO.deleteBooking(booking);
					return "CustomerInterfaceSucess.jsp";
				}
	}
	
	public String RateBooking(int bookingnumber , String rating){
		System.out.println(bookingnumber + rating);
//		if(session instanceof Customer){
			int x = bookingDAO.getRoombyBookingnumber(bookingnumber);
			if(x != 0){
			System.out.println(x);
			Room newRoom = roomDAO.getRoombyRoomnumber(x);
			newRoom.setRating(rating);
			roomDAO.updateRoom(newRoom);
			return "CustomerInterfaceSucess.jsp";
			}
			else{
				return "CustomerInterfaceFail.jsp";
			}
		}
//		return "CustomerInterfaceFail.jsp";
//	}
	
	public String Book(Date bookingstart, Date bookingend , String payment, int bnop, int broomnumber, String user,long day){
		
		bookinglist = bookingDAO.getBookinglist();
		roomlist = roomDAO.getRoomlist();
		Date dateNow = new Date();
		
//		if(session instanceof Customer){
			
		if(bookingstart.before(dateNow)){
			return "CustomerBookFail.jsp";
		}
		if(bookingend.before(dateNow)){
			return "CustomerBookFail.jsp";
		}
		if(bookingend.before(bookingstart) || bookingend.equals(bookingstart)){
			return "CustomerBookFail.jsp";
		}
		
			boolean works = true;
			for (Booking booking : bookinglist){
				if (booking.getBroomnumber()==broomnumber){	
					if((booking.getBookingstart().after(bookingstart)||booking.getBookingstart().equals(bookingstart))
							&&(booking.getBookingend().before(bookingend)||booking.getBookingend().equals(bookingend))){
						works = false;
						break;
					}
				}
			}
			if(works == true){
				Room room = roomDAO.getRoombyRoomnumber(broomnumber);
					if(room.getNop() >= bnop){
						double money = day * room.getPrice();
	
				Booking booking = new Booking(bookingnrcounter, bookingstart,  bookingend , payment,bnop, broomnumber, user , money );
				bookingDAO.saveBooking(booking);
				
				bookingnrcounter++;
				
				return"CustomerBookSuccess.jsp";
					}
			}
			
//			else {
//				return "CustomerBookFail.jsp";
//			}
//			
//		
//			
//		}
	
	return "CustomerBookFail.jsp";
	
	}
	
	public ArrayList<Room> SearchRoom(double price , String equipment, int nop ){
		roomlist = roomDAO.getRoomlist();
		ArrayList <Room> rlist = new ArrayList<Room>();
		if(equipment.equals("Default") && price == 0){
			for ( Room room : roomlist){
				if ( room.getNop() >= nop){
					rlist.add(room);	
				}
		}
		}
		else if(equipment.equals("Default")){
			for ( Room room : roomlist){
				if ( room.getPrice() <= price && room.getNop() >= nop){
					rlist.add(room);	
				}
		}
		}
		else if(price == 0){
			for ( Room room : roomlist){
				if (room.getEquipment().equals(equipment) && room.getNop() >= nop){
					rlist.add(room);	
				}
			}
		}
		
		else{
		for ( Room room : roomlist){
			if ( room.getPrice() <= price && room.getEquipment().equals(equipment) && room.getNop() >= nop){
				rlist.add(room);	
			}
		}
		}
		return rlist;
		
	}
	
}
