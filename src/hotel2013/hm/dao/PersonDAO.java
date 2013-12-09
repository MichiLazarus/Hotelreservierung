package hotel2013.hm.dao;


import hotel2013.hm.data.Booking;
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
import java.util.Date;



public class PersonDAO {

	private String Path;
	private ArrayList<Person> Personlist = new ArrayList<Person>();
	private InputStream in;
	private OutputStream out;
	private ObjectInputStream objInput;
	private ObjectOutputStream objOutput;
	private File f;

	/*
	 * Constructor for Serialization with Path
	 */
	public PersonDAO(String Path) {
		this.Path = Path;
		this.readFile();
	}

	/*
	 * to read all Personobjects in a file and save them into a ArrayList
	 */
	@SuppressWarnings("unchecked")
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

	/*
	 * method to create the file and save all Personobjects in there
	 */
	private void saveFile() {

		try {
			out = new FileOutputStream(this.Path);
			objOutput = new ObjectOutputStream(out);
			objOutput.writeObject(this.Personlist);
		} catch (IOException e) {
			System.err.println(e);

		}
	}

	/*
	 * method that returns the whole Personlist
	 */
	public ArrayList<Person> getPersonlist() {
		return this.Personlist;

	}

	/*
	 * method that returns an Personobject by searching for it with the Personname
	 * in the PersonobejctArraylist
	 */
	public Person getPersonbyUsername(String username)
			throws IllegalArgumentException {
		for (Person Person : this.Personlist) {

			if (Person.getUsername().equals(username)) {
				return Person;
			}
		}

		return null;
	}
	
	public void savePerson(Person person)  throws IllegalArgumentException{
		
		if (this.getPersonbyUsername(person.getUsername()) == null) {
			System.out.println(person.getUsername() + " saved");
			this.Personlist.add(person);
			this.saveFile();
		} else {
			System.out.println(person.getUsername() + " already exists");
			throw new IllegalArgumentException("Person already exists");
		}
		
			
	}


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

	public void deletePersonlist() {
		this.Personlist.clear();
	}
	



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