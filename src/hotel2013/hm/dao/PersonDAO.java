/**
 * @author Hotelreservierung Gruppe 8H2
 */
package hotel2013.hm.dao;



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




public class PersonDAO {

	private String Path;
	private static ArrayList<Person> Personlist = new ArrayList<Person>();
	private InputStream in;
	private OutputStream out;
	private ObjectInputStream objInput;
	private ObjectOutputStream objOutput;
	private File f;

	/**
	 * Konstruktor fuer die Serialisierung mit Path
	 * @param Path
	 */
	public PersonDAO(String Path) {
		this.Path = Path;
		this.readFile();
	}

	/**
	 * Zum Lesen aller Personenobjekte in einem File und zum Speichern in eine Arraylist
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public void readFile() {

		f = new File(this.Path);
		if (f.exists()) {

			try {
				this.in = new FileInputStream(this.Path);
				this.objInput = new ObjectInputStream(this.in);
				this.Personlist = (ArrayList<Person>) this.objInput.readObject();

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
	 * Methode zum erstellen des Files und zum Abspeichern aller Personenobjekte in das File
	 */
	@SuppressWarnings("static-access")
	private void saveFile() {

		try {
			out = new FileOutputStream(this.Path);
			objOutput = new ObjectOutputStream(out);
			objOutput.writeObject(this.Personlist);
		} catch (IOException e) {
			System.err.println(e);

		}
	}

	/**
	 * Methode, die die ganze Personenliste retourniert.
	 * 
	 * @return Liste aller Personen
	 */
	@SuppressWarnings("static-access")
	public ArrayList<Person> getPersonlist() {
		return this.Personlist;
	}

	/**
	 * Methode, die ein bestimmtes Personenobjekt retourniert, indem es per Usernamen in der Personenliste gesucht wird.
	 * 
	 * @param username
	 * Username
	 * @return Personenojekt oder null
	 */
	public static Person getPersonbyUsername(String username)
			throws IllegalArgumentException {
		for (Person person : Personlist) {

			if (person.getUsername().equals(username)) {
				return person;
			}
		}
		return null;
	}
	
	/**
	 * Methode zum Abspeichern einer Person. Neue Person wird in die Arrayliste aller Personen hinzugefuegt.
	 * 
	 * @param person
	 * Objekt person
	 * @return true, wenn die Person noch nicht existiert und zur Arraylist hinzugefuegt wurde oder false, falls die Person schon existiert
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("static-access")
	public boolean savePerson(Person person)  throws IllegalArgumentException{
		
		if (this.getPersonbyUsername(person.getUsername()) == null) {
			System.out.println(person.getUsername() + " saved");
			this.Personlist.add(person);
			this.saveFile();
			return true;
		} else {
			return false;
		}		
	}

	/**
	 * Methode zum Loeschen einer Person. Person wird aus der Arraylist entfernt.
	 * 
	 * @param person
	 * Objekt person
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("static-access")
	public void deletePerson(Person person) throws IllegalArgumentException {
		
		boolean personExists = false;
		
		for(int i = 0; i < this.Personlist.size(); i++) {
			
			if (this.Personlist.get(i).getUsername().equals(person.getUsername())) {
				Personlist.remove(i);
				personExists = true;
				this.saveFile();
				
			
			}
		}
		
		if(personExists != true) {
			throw new IllegalArgumentException("Inserted Person to delete was not found !");
		}	
	}

	/**
	 * Methode zum Loeschen der ganzen Personenliste.
	 */
	@SuppressWarnings("static-access")
	public void deletePersonlist() {
		this.Personlist.clear();
	}
	
	/**
	 * Methode zum Updaten einer Person.
	 * 
	 * @param person
	 * Objekt person
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("static-access")
	public void updatePerson(Person person)throws IllegalArgumentException {

		boolean personExists = false;
		
		for (Person p : this.Personlist) {
			if (person.getUsername().equals(person.getUsername())) {
				
				p.setUsername(person.getUsername());
				p.setPassword(person.getPassword());
				p.setFullName(person.getFullName());
				p.setEmail(person.getEmail());
				p.setSex(person.getSex());
				p.setBirthday(person.getBirthday());
				
				
				personExists = true;
				this.saveFile();
			} 
		}
		
		if(personExists != true) {
			throw new IllegalArgumentException("person doesnt exist!");
		}
		
	}
}