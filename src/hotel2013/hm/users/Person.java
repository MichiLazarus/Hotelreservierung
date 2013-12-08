package hotel2013.hm.users;

import java.util.Date;
import java.lang.IllegalArgumentException;

public class Person {
	
	
		private String username;
		private String password;
		private String fullName;
		private String email;
		private char sex;
		private Date birthday;
			
		//KONSTRUKTOR
	
		public Person(){
				Person p;
			}
		
			//METHODEN
			
			
			public String getUsername(){
				return username;}
			
			
			public void setUsername(String username){
				if(username.length() < 26 && username.length() > 5)	this.username = username;
				else throw new IllegalArgumentException("Enter valid username");
				}
			
			
			public String getPassword(){
				return password;}
			
		
			public void setPassword(String password){
				if(password.length() > 6){
					boolean check = true;
					for(int i = 0; i < password.length(); ++i){
						if (password.charAt(i) == ' '){
							check = false;
							break;
						}
						
					}
					
					if(check == true) {
						this.password = password;
						}
					
					else {
						throw new IllegalArgumentException("Check if Password contains spaces!");
						
					}
				}
				else{
					throw new IllegalArgumentException("Password must contain at least 7 Characters");
				}
			}
			
			
			public boolean verifyPassword(String password){
				if(password.equals(this.password)){
					return true;
				}
				else {
					return false;
				}
				
				
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


