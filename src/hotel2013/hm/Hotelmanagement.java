package hotel2013.hm;

import java.util.ArrayList;
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
	
	public String login(String username, String password){
		
		Person person = personDAO.getPersonbyUsername(username);
		if(person == null){
			return "LoginFail.jsp";
		}
			if(person.verifyPassword(password)){
			session = person;
			
			if(person instanceof Customer)
				return "CustomerInterface.jsp";
			if(person instanceof Hotelier)
				return "HotelierInterface.jsp";
			if(person instanceof Analyst)
				return "AnalystInterface.jsp";
		}
		
		return "LoginFail.jsp";
	}
	
	
	//Analyst
	public int ShowStatistic(String type){
		if(session instanceof Analyst){
			if(type.contains("Season")){
				return ((Analyst) session).SeasonStatistic();
			}
			else if(type.contains("Occupancy")){
				return ((Analyst) session).OccupancyStatistic();
			}
			else if(type.contains("Customer")){
				return ((Analyst) session).CustomerStatistic();
			}
			else throw new IllegalArgumentException("No statistic available with these parameters");
		}
		return 0;
	}
	
	public String MakePriceOffer(double priceOffer, int roomnumber){
		
		roomlist = roomDAO.getRoomlist();

		if(session instanceof Analyst){
			for(Room room : roomlist){
				if(room.getRoomnumber() == roomnumber){
					room.setPriceOffer(priceOffer);
					roomDAO.updateRoom(room);
					return "AnalystInterfaceSucess.jsp";
				}
			}
			return "AnalystInterfacePriceofferfail.jsp";
		}
		return "AnalystInterfacePriceofferfail.jsp";
	}
	
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
		
		
		
		if(session instanceof Analyst || session instanceof Hotelier){
			System.out.println("test2");
			for(Room room : roomlist){
				System.out.println("test");
				if(room.getRoomnumber() == roomnumber){
					return room.getRating();
				}
			}
			return "Could not find this room";
		}
		return "You do not have the permission to watch ratings";
	}
	
	
	//Hotelier
	public String NewOffer(int roomnumber, int nop, String equipment, double price, String rating){
		if(session instanceof Hotelier){
			Room newRoom =  new Room(roomnumber, nop, equipment, price, rating);
			String check = roomDAO.saveRoom(newRoom);
			
			if(check.equals("success"))
				return "HotelierInterfaceNewOffer.jsp";
			else 
				return "HotelierInterfaceFail.jsp";
		}
		
		return "HotelierInterfaceFail.jsp";
	}
	
	public String EditRoom(int roomnumber, int nop, String equipment, double price, String rating){
	
		roomlist = roomDAO.getRoomlist();
		
		if(session instanceof Hotelier){
			for(Room room : roomlist){
				if(room.getRoomnumber() == roomnumber){
					Room newRoom = new Room(roomnumber, nop, equipment, price, rating);
					roomDAO.updateRoom(newRoom);
					return "Edit successful";
				}
			}
			return "Room not found";
		}
		return "You do not have the permission to edit a room";
	}
	
	
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
		if(session instanceof Customer){
			System.out.println("test1");
			int x = bookingDAO.getRoombyBookingnumber(bookingnumber);
			Room newRoom = roomDAO.getRoombyRoomnumber(x);
			newRoom.setRating(rating);
			roomDAO.updateRoom(newRoom);
			return "CustomerInterfaceFail.jsp";
		}
		return "CustomerInterfaceSucess.jsp";
	}
	
	public String Book(Date bookingstart, Date bookingend , String payment, int bnop, int broomnumber, String user){
		
		bookinglist = bookingDAO.getBookinglist();
		if(session instanceof Customer){
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
				Booking booking = new Booking(bookingnrcounter, bookingstart,  bookingend , payment,bnop, broomnumber, user );
				bookingDAO.saveBooking(booking);
				
				bookingnrcounter++;
				
				return"CustomerBookSuccess.jsp";	
			}
			else {
				return "CustomerBookFail.jsp";
			}
			
		
			
		}
	
	return "BookFail.jsp";
	
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
