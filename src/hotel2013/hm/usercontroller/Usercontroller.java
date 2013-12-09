package hotel2013.hm.usercontroller;

import hotel2013.hm.dao.PersonDAO;
import hotel2013.hm.users.Analyst;
import hotel2013.hm.users.Customer;
import hotel2013.hm.users.Hotelier;

import java.util.Date;

public class Usercontroller {

		 private PersonDAO dao = new PersonDAO("Persons.ser");  
		 private String username;
		 private String password; 
		 private String fullName; 
		 private String email;
		 private char sex;
		 private Date birthday;
		 
		 public Usercontroller(){ } 
		 
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
		 
		 
		 
		 
		 
		 
		 
		 
		 public String getUsername(){
				return username;}
			
			
		 public void setUsername(String username){
			if(username.length() < 26 && username.length() > 5)	this.username = username;
			else throw new IllegalArgumentException("Enter valid username");
		 }
			
			
		 public String getPassword(){
		 	 return password;}
		
	
		 public void setPassword(String password){
					this.password = password;
		}
		 
		 public String getFullName(){return fullName;}
			
			
			public void setFullName(String fullName){
				if(fullName != null){
				this.fullName = fullName;
				}
				else {
					throw new IllegalArgumentException("Enter Valid Name!");
				}
			}
			
			
			public String getEmail(){
				return email;}
			
			public void setEmail(String email){
				if(email != null){
					this.email = email;
				}
				else {
					throw new IllegalArgumentException(" Enter valid E-Mail address!");
				}
			}
			
			public char getSex(){return sex;}
			
			public void setSex(char sex){ 
				sex = Character.toLowerCase(sex);
				if(sex == 'm' || sex == 'f'){
					this.sex = sex;
				}
				else{
					throw new IllegalArgumentException("Gender false");
				}
			}
			
			
			public Date getBirthday(){return birthday;}
			
			public void setBirthday(Date birthday){
				Date dateNow = new Date();
				if(birthday.before(dateNow)){
					this.birthday = birthday;
				}
				else{
					throw new IllegalArgumentException("Date not possible");
				}
				
			}
		 
		 
		 
	}

