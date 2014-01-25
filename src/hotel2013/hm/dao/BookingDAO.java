/**
 * @author Hotelreservierung Gruppe 8H2
 */
package hotel2013.hm.dao;


import hotel2013.hm.data.Booking;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;



public class BookingDAO {

	private String Path;
	private ArrayList<Booking> Bookinglist = new ArrayList<Booking>();
	private InputStream in;
	private OutputStream out;
	private ObjectInputStream objInput;
	private ObjectOutputStream objOutput;
	private File f;

	/**
	 * Konstruktor fuer die Serialisierung mit Path
	 * @param Path
	 */
	public BookingDAO(String Path) {
		this.Path = Path;
		this.readFile();
	}

	/**
	 * Zum Lesen aller Buchungsobjekte in einem File und zum Speichern in eine Arraylist
	 */
	@SuppressWarnings("unchecked")
	public void readFile() {

		f = new File(this.Path);
		if (f.exists()) {

			try {
				this.in = new FileInputStream(this.Path);
				this.objInput = new ObjectInputStream(this.in);
				this.Bookinglist = (ArrayList<Booking>) this.objInput.readObject();

				this.objInput.close();
				this.in.close();

			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}

	}
	
	/**
	 * Methode zum erstellen des Files und zum Abspeichern aller Buchungsobjekte in das File
	 */
	private void saveFile() {

		try {
			out = new FileOutputStream(this.Path);
			objOutput = new ObjectOutputStream(out);
			objOutput.writeObject(this.Bookinglist);
		} catch (IOException e) {
			System.err.println(e);

		}
	}
	
	/**
	 * Methode, die die ganze Buchungsliste retourniert.
	 * 
	 * @return Liste aller Buchungen
	 */
	public ArrayList<Booking> getBookinglist() {
		return this.Bookinglist;
	}

	/**
	 * Methode, die ein bestimmtes Buchungsobjekt retourniert, indem es per Buchungsnummer in der Buchungsliste gesucht wird.
	 * 
	 * @param x
	 * Buchungsnummer
	 * @return Buchungsobjekt oder null
	 */
	public Booking getBookingbyBookingnumber(int x){
		for (Booking booking : this.Bookinglist) {

			if (booking.getBookingnumber()==x) {
				return booking;
			}
		}

		return null;
	}
	
	/**
	 * Methode zum Abspeichern einer Buchung. Neue Buchung wird in die Arrayliste aller Buchungen hinzugefuegt.
	 * 
	 * @param booking
	 * Objekt booking
	 */
	public void saveBooking(Booking booking) {
		
		if (this.getBookingbyBookingnumber(booking.getBookingnumber()) == null) {
			System.out.println(booking.getBookingnumber() + " saved");
			this.Bookinglist.add(booking);
			this.saveFile();
			for ( int i = 0 ; i < Bookinglist.size(); i++){
				System.out.println(Bookinglist.get(i).getBookingnumber());
			}
			System.out.println("sucess");
		} else {
			System.out.println("fail");
		}		
	}
	
	/**
	 * Methode zum Holen eines Zimmers anhand der Buchungsnummer.
	 * 
	 * @param bookingnumber
	 * Buchungsnummer
	 * @return Zimmernummer oder 0
	 */
	public int getRoombyBookingnumber(int bookingnumber){
		for( Booking booking : Bookinglist){
			if (booking.getBookingnumber() == bookingnumber){
				return booking.getBroomnumber();
			}
		}
		return 0;
	}
	
	/**
	 * Methode zum Holen eines Users anhand der Buchungsnummer.
	 * 
	 * @param number
	 * Buchungsnummer
	 * @return User oder "fail"
	 */
	public String getUserbyBookingnumber(int number){
		for(Booking booking : Bookinglist){
			if (booking.getBookingnumber() == number ){
				return booking.getUser();
			}
		}
		return "fail";
	}
	
	/**
	 * Methode zum Holen der Buchungen eines bestimmten Users.
	 * 
	 * @param user
	 * User, von dem die Buchungen geholt werden sollen.
	 * @return Arraylist mit den Buchungen
	 */
	public ArrayList<Booking> getBookingsofUsername(String user){
		ArrayList<Booking> Blist = new ArrayList<Booking>();
		for (Booking booking : Bookinglist){
			if (booking.getUser().equals(user)){
				Blist.add(booking);
				
			}
			
		}
		return Blist;
	}

	/**
	 * Methode zum Loeschen einer Buchung. Buchung wird aus der Arraylist entfernt.
	 * 
	 * @param booking
	 * Buchungsobjekt
	 */
	public void deleteBooking(Booking booking)  {
		
		boolean bookingExists = false;
		
		for(int i = 0; i < this.Bookinglist.size(); i++) {
			
			if (this.Bookinglist.get(i).getBookingnumber()==(booking.getBookingnumber())) {
				Bookinglist.remove(i);
				bookingExists = true;
				this.saveFile();
				
			
			}
		}
		
		if(bookingExists != true) {
			System.out.println("Inserted Booking to delete was not found !");
		}
		
	}

	/**
	 * Methode zum Loeschen der ganzen Buchungsliste.
	 */
	public void deleteBookinglist() {
		this.Bookinglist.clear();
	}	
}