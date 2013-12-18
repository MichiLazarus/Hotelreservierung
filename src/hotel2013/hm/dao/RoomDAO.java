package hotel2013.hm.dao;


import hotel2013.hm.data.Room;
import hotel2013.hm.users.Person;

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



public class RoomDAO {

	private String Path;
	private ArrayList<Room> Roomlist = new ArrayList<Room>();
	private InputStream in;
	private OutputStream out;
	private ObjectInputStream objInput;
	private ObjectOutputStream objOutput;
	private File f;

	/*
	 * Constructor for Serialization with Path
	 */
	public RoomDAO(String Path) {
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
				this.Roomlist = (ArrayList<Room>) this.objInput.readObject();

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
			objOutput.writeObject(this.Roomlist);
		} catch (IOException e) {
			System.err.println(e);

		}
	}

	/*
	 * method that returns the whole Roomlist
	 */
	public ArrayList<Room> getRoomlist() {
		return this.Roomlist;

	}

	/*
	 * method that returns an Userobject by searching for it with the username
	 * in the UserobejctArraylist
	 */
	public Room getRoombyRoomnumber(int Roomnumber)
			throws IllegalArgumentException {
		for (Room room : this.Roomlist) {

			if (room.getRoomnumber() == (Roomnumber)) {
				return room;
			}
		}

		return null;
	}
	
public String saveRoom(Room room)  throws IllegalArgumentException{
		
		if (this.getRoombyRoomnumber(room.getRoomnumber()) == null) {
			System.out.println(room.getRoomnumber() + " saved");
			this.Roomlist.add(room);
			this.saveFile();
			return "success";
		} else {
			System.out.println(room.getRoomnumber() + " already exists");
			return "failure";
		}
		
			
	}


public void deleteRoom(Room room) throws IllegalArgumentException {
		
		boolean roomExists = false;
		
		for(int i = 0; i < this.Roomlist.size(); i++) {
			
			if (this.Roomlist.get(i).getRoomnumber()==(room.getRoomnumber())) {
				Roomlist.remove(i);
				roomExists = true;
				this.saveFile();
				
			
			}
		}
		
		if(roomExists != true) {
			throw new IllegalArgumentException("Inserted Room to delete was not found !");
		}
		
	}

	public void deleteRoomlist() {
		this.Roomlist.clear();
	}
	

public void updateRoom(Room room)throws IllegalArgumentException {

		boolean personExists = false;
		
		for (Room r : this.Roomlist) {
			if (r.getRoomnumber()==(room.getRoomnumber())) {
				
				r.setRoomnumber(room.getRoomnumber());
				r.setNop(room.getNop());
				r.setEquipment(room.getEquipment());
				r.setPrice(room.getPrice());
				r.setPriceOffer(room.getPriceOffer());
				r.setRating(room.getRating());
				
				
				
				
				personExists = true;
				this.saveFile();
			} 
		}
		
		if(personExists != true) {
			throw new IllegalArgumentException("person doesnt exist!");
		}
		
	}

}