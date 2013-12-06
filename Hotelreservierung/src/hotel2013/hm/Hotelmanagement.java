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
	
	
	public String register(String username, String password, String fullName, String email, char sex, Date birthday){
		Person newCustomer =  new Customer(username, password, fullName, email, sex, birthday);
		personDAO.savePerson(newCustomer);
		return "Registration succeeded";
	}
	
	public String login(String username,String password){
		personlist = personDAO.getPersonlist();
		Person person = personDAO.getPersonbyUsername(username);
		if(person.verifyPassword(password)){
			session = person;
			return "Login Success";
		}
			session = null;
			return "Password does not match Username";
	}
	
	
	//Analyst
	public void ShowStatistic(String type){
		if(session instanceof Analyst){
			if(type.contains("Season")){
				System.out.println(((Analyst) session).SeasonStatistic());
			}
			else if(type.contains("Occupancy")){
				System.out.println(((Analyst) session).OccupancyStatistic());
			}
			else if(type.contains("Customer")){
				System.out.println(((Analyst) session).CustomerStatistic());
			}
			else throw new IllegalArgumentException("No statistic available with these parameters");
		}
	}
	
	public String MakePriceOffer(double priceOffer, int roomnumber){
		if(session instanceof Analyst){
			for(Room room : roomlist){
				if(room.getRoomnumber() == roomnumber){
					room.setPriceOffer(priceOffer);
					roomDAO.updateRoom(room);
					return "Price Offer successful";
				}
			}
			return "Could not find this room";
		}
		return "No right to make a price offer";
	}
	
	//Analyst & Hotelier
	public String ShowAllRooms(){
			String h = "";
			for(Room room : roomlist){
				h += room.toString();
			}
			return h; 
	}
	
	public String ShowRating(int roomnumber){
		if(session instanceof Analyst || session instanceof Hotelier){
			for(Room room : roomlist){
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
			roomDAO.saveRoom(newRoom);
			return "New offer succeeded";
		}
		return "You do not have the permission to make a new offer";
	}
	
	public String EditRoom(int roomnumber, int nop, String equipment, double price, String rating){
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
	public void SearchRoom(){
		if(session instanceof Customer){
			
		}
	}
	
	public void CancelBooking(){
		if(session instanceof Customer){
			
		}
	}
	
	public void RateBooking(){
		if(session instanceof Customer){
			
		}
	}
	
	public void Book(){
		if(session instanceof Customer){
			
		}
	}
	
}
