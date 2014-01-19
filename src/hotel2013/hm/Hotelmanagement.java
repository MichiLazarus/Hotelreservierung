package hotel2013.hm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

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
			
	public String registerC(String username, String password, String fullName, String email, char sex, Date birthday){
	

		Person newCustomer =  new Customer(username, password, fullName, email, sex, birthday);
		if(personDAO.savePerson(newCustomer))
		return "index.jsp";
		else
		return "registerfail.jsp";
	}
	
	public String registerH(String username, String password, String fullName, String email, char sex, Date birthday){

		Person newHotelier =  new Hotelier(username, password, fullName, email, sex, birthday);
		if(personDAO.savePerson(newHotelier))
		return "index.jsp";
		else
		return "registerfail.jsp";
	}
	
	public String registerA(String username, String password, String fullName, String email, char sex, Date birthday){

		Person newAnalyst =  new Analyst(username, password, fullName, email, sex, birthday);
		if(personDAO.savePerson(newAnalyst))
		return "index.jsp";
		else
		return "registerfail.jsp";
	}
	public ArrayList<Booking> getBooklist(String user){
		ArrayList<Booking> Blist = bookingDAO.getBookingsofUsername(user);
		return Blist;
	}
	
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
	
	
	//Analyst
	public int [][]ShowStatistic(String type, int refyear){
		//if(session instanceof Analyst){
			if(type.equals("Season")){
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
			//}
//			else if(type.contains("Occupancy")){
//				return ((Analyst) session).OccupancyStatistic();
//			}
//			else if(type.contains("Customer")){
//				return ((Analyst) session).CustomerStatistic();
//			}
//			else throw new IllegalArgumentException("No statistic available with these parameters");
//		}
		}
		int [][] hallo= new int[2][12];
		return hallo;
	}
	
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
	
	//Analyst & Hotelier
	public ArrayList<Room> ShowAllRooms(){
		
		roomlist = roomDAO.getRoomlist();
		ArrayList <Room> roomlist = new ArrayList<Room>();
		for ( Room room : roomlist){
				roomlist.add(room);
		}
		return roomlist;
		
	}
	
	public String ShowRating(int roomnumber){
		
		roomlist = roomDAO.getRoomlist();
		
		
		
//		if(session instanceof Analyst || session instanceof Hotelier){
			
			for(Room room : roomlist){
				
				if(room.getRoomnumber() == roomnumber){
					return room.getRating();
				}
			}
			return "Could not find this room";
		}
//		return "You do not have the permission to watch ratings";
//	}
	
	
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
	
	public String Book(Date bookingstart, Date bookingend , String payment, int bnop, int broomnumber, String user){
		
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

				Booking booking = new Booking(bookingnrcounter, bookingstart,  bookingend , payment,bnop, broomnumber, user );
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
