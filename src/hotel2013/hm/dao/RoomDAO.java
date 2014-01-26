/**
 * @author Hotelreservierung Gruppe 8H2
 */
package hotel2013.hm.dao;


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



public class RoomDAO {

	private String Path;
	private ArrayList<Room> Roomlist = new ArrayList<Room>();
	private InputStream in;
	private OutputStream out;
	private ObjectInputStream objInput;
	private ObjectOutputStream objOutput;
	private File f;

	/**
	 * Konstruktor fuer die Serialisierung mit Path
	 * @param Path
	 */
	public RoomDAO(String Path) {
		this.Path = Path;
		this.readFile();
	}

	/**
	 * Zum Lesen aller Zimmernobjekte in einem File und zum Speichern in eine Arraylist
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

	/**
	 * Methode zum erstellen des Files und zum Abspeichern aller Zimmernobjekte in das File
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

	/**
	 * Methode, die die ganze Zimmernliste retourniert.
	 * 
	 * @return Liste aller Zimmer
	 */
	/*
	 * method that returns the whole Roomlist
	 */
	public ArrayList<Room> getRoomlist() {
		return this.Roomlist;

	}

	/**
	 * Methode, die ein bestimmtes Zimmer retourniert, indem es per Zimernummer in der Zimmernliste gesucht wird.
	 * 
	 * @param Roomnumber
	 * Raumnummer
	 * @return Zimmerobjekt oder null
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
	
	/**
	 * Methode zum Abspeichern eines Zimmers. Neues Zimmer wird in die Arrayliste aller Zimmer hinzugefuegt.
	 * 
	 * @param room
	 * Objekt room
	 * @return "success", wenn Zimmer(nummer) noch nicht existiert oder "failure", falls Zimmer(nummer) schon existiert
	 * @throws IllegalArgumentException
	 */
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

	/**
	 * Methode zum Loeschen eines Zimmers. Zimmer wird aus der Arraylist entfernt.
	 * 
	 * @param room
	 * Objekt room
	 * @throws IllegalArgumentException
	 */
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

	/**
	 * Methode zum Loeschen der ganzen Personenliste.
	 */
	public void deleteRoomlist() {
		this.Roomlist.clear();
	}
	
	/**
	 * Methode zum Updaten eines Zimmers.
	 * 
	 * @param room
	 * Objekt room
	 * @throws IllegalArgumentException
	 */
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