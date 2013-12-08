package hotel2013.hm.usercontroller;

import hotel2013.hm.dao.PersonDAO;
import hotel2013.hm.users.Analyst;
import hotel2013.hm.users.Customer;
import hotel2013.hm.users.Hotelier;

import java.util.Date;

public class Usercontroller {

	 public class KundenController {

		 private PersonDAO dao = new PersonDAO("Persons.ser");  
		 private String username;
		 private String password; 
		 private String fullName; 
		 private String email;
		 private char sex;
		 private Date birthday;
		 
		 public void Usercontroller(){ } 
		 
		 public String saveCustomer(){ 

		 		Customer customer = new Customer(username,password,fullName,email,sex,birthday); 
		 		dao.savePerson(customer);
		 		return "Customer Saved!";
		 }
		 
		 public String saveHotelier(){ 
		 		 
		 		Hotelier hotelier = new Hotelier(username,password,fullName,email,sex,birthday); 
		 		dao.savePerson(hotelier);
		 		return "Hotelier Saved!";
		 }
		 
		 public String saveAnalyst(){ 
		 
		 		Analyst analyst = new Analyst(username,password,fullName,email,sex,birthday); 
		 		dao.savePerson(analyst);
		 		return "Analyst Saved!";
		 }
		 
	}
	
}
