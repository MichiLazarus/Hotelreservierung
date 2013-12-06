package hotel2013.hm.dao;

import hotel2013.hm.data.Booking;
import hotel2013.hm.data.Room;

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

	/*
	 * to read all Userobjects in a file and save them into a ArrayList
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

	/*
	 * method to create the file and save all Userobjects in there
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

	/*
	 * method that returns the whole Roomlist
	 */
	public ArrayList<Booking> getRoomlist() {
		return this.Bookinglist;

	}

	/*
	 * method that returns an Userobject by searching for it with the username
	 * in the UserobejctArraylist
	 */
	public Booking getBookingbyBookingnumber(int bookingnumber)
			throws IllegalArgumentException {
		for (Booking booking : this.Bookinglist) {

			if (booking.getBookingnumber() == (bookingnumber)) {
				return booking;
			}
		}

		return null;
	}
}
