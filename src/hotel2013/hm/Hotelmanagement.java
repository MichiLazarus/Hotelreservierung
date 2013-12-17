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
	private ArrayList <Person> personlist = new ArrayList<Person>();
	private ArrayList <Booking> bookinglist = new ArrayList<Booking>();
	private ArrayList <Room> roomlist = new ArrayList<Room>();
	
	
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
	
	public String login(String username, String password){
		
		Person person = personDAO.getPersonbyUsername(username);
		if(person == null){
			return "loginfail.jsp";
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
		
		return "index.jsp";
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
	public String ShowAllRooms(){
		
		roomlist = roomDAO.getRoomlist();
		
		
			String h = "";
			for(Room room : roomlist){
				h += room.toString();
			}
			return h; 
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
	
	
	public String CancelBooking(int bookingnumber){
		Booking booking = bookingDAO.getBookingbyBookingnumber(bookingnumber);
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
			int x = bookingDAO.getRoombyBookingnumber(bookingnumber);
			Room newRoom = roomDAO.getRoombyRoomnumber(x);
			newRoom.setRating(rating);
			roomDAO.updateRoom(newRoom);
			return "Rating sucessful";
		}
		return "Bookingnumber not availible";
	}
	
	public String Book(Date bookingstart, Date bookingend , boolean payment, int bnop, int broomnumber){
		
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
				Booking newBooking =  new Booking(bookingstart, bookingend, payment, bnop, broomnumber);
				bookingDAO.saveBooking(newBooking);
				return"Booking done";	
			}
			else {
				return "Room is occupied during this time";
			}
			
		
			
		}
	
	return "Booking not sucessfull";
	
	}
}
