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

	/*
	 * Constructor for Serialization with Path
	 */
	public BookingDAO(String Path) {
		this.Path = Path;
		this.readFile();
	}

	
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

	
	private void saveFile() {

		try {
			out = new FileOutputStream(this.Path);
			objOutput = new ObjectOutputStream(out);
			objOutput.writeObject(this.Bookinglist);
		} catch (IOException e) {
			System.err.println(e);

		}
	}

	/*
	 * method that returns the whole Bookinglist
	 */
	public ArrayList<Booking> getBookinglist() {
		return this.Bookinglist;

	}

	
	public Booking getBookingbyBookingnumber(int bookingnumber)
			throws IllegalArgumentException {
		for (Booking booking : this.Bookinglist) {

			if (booking.getBookingnumber()==(bookingnumber)) {
				return booking;
			}
		}

		return null;
	}
	



public void saveBooking(Booking booking)  throws IllegalArgumentException{
	
	if (this.getBookingbyBookingnumber(booking.getBookingnumber()) == null) {
		System.out.println(booking.getBookingnumber() + " saved");
		this.Bookinglist.add(booking);
		this.saveFile();
	} else {
		System.out.println(booking.getBookingnumber() + " already exists");
		throw new IllegalArgumentException("Bookingnumber already exists");
	}
	
		
}


public void deleteBooking(Booking booking) throws IllegalArgumentException {
	
	boolean bookingExists = false;
	
	for(int i = 0; i < this.Bookinglist.size(); i++) {
		
		if (this.Bookinglist.get(i).getBookingnumber()==(booking.getBookingnumber())) {
			Bookinglist.remove(i);
			bookingExists = true;
			this.saveFile();
			
		
		}
	}
	
	if(bookingExists != true) {
		throw new IllegalArgumentException("Inserted Booking to delete was not found !");
	}
	
}

public void deleteBookinglist() {
	this.Bookinglist.clear();
}





public void updateBooking(Booking booking)throws IllegalArgumentException {

	boolean bookingExists = false;
	
	for (Booking b : this.Bookinglist) {
		if (b.getBookingnumber()==(booking.getBookingnumber())) {
			
			b.setBookingnumber(booking.getBookingnumber());
			b.setBookingstart(booking.getBookingstart());
			b.setBookingend(booking.getBookingend());
			b.setPayment(booking.getPayment());
			b.setBnop(booking.getBnop());
			
			
			bookingExists = true;
			this.saveFile();
		} 
	}
	
	if(bookingExists != true) {
		throw new IllegalArgumentException("Booking doesnt exist!");
	}
	
}


}