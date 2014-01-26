/**
 * @author Hotelreservierung Gruppe 8H2
 */
package hotel2013.hm.users;

import java.util.Date;
import java.io.Serializable;
import java.lang.IllegalArgumentException;

@SuppressWarnings("serial")
public class Person implements Serializable{
	
	
		private String username;
		private String password;
		private String fullName;
		private String email;
		private char sex;
		private Date birthday;
			
		//KONSTRUKTOR
	
		public Person(String username,String password,String fullName,String email,char sex,Date birthday){
				this.username = username;
				this.password = password;
				this.fullName = fullName;
				this.email = email;
				this.sex = sex;
				this.birthday = birthday;
			}
		
			//METHODEN
			
			/**
			 * Holt Usernamen.
			 * 
			 * @return Username
			 */
			public String getUsername(){
				return username;}
			
			/**
			 * Setzt Usernamen, wobei geschaut wird, dass der Username laenger als 5, aber kuerzer als 26 Zeichen ist.
			 * 
			 * @param username
			 * Username
			 * @throws IllegalArgumentException
			 */
			public void setUsername(String username){
				if(username.length() < 26 && username.length() > 5)	this.username = username;
				else throw new IllegalArgumentException("Enter valid username");
				}
			
			/**
			 * Holt Passwort
			 * 
			 * @return Passwort
			 */
			public String getPassword(){
				return password;}
			
			/**
			 * Setzt Passwort, wobei geschaut wird, dass das Passwort laenger als 6 Zeichen ist und keine Leerzeichen enthaelt.
			 * 
			 * @param password
			 * Passwort
			 * @throws IllegalArgumentException
			 */
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
			
			/**
			 * Ueberprueft, ob das Passwort uebereinstimmt.
			 * 
			 * @param password
			 * Passwort
			 * @return true, wenn es uebereinstimmt oder false, wenn es nicht uebereinstimmt
			 */
			public boolean verifyPassword(String password){
				if(password.equals(this.password)){
					return true;
				}
				else {
					return false;
				}	
			}
			
			/**
			 * Holt vollstaendigen Namen.
			 * 
			 * @return vollstaendiger Name
			 */
			public String getFullName(){return fullName;}
			
			/**
			 * Setzt vollstaendigen Namen.
			 * 
			 * @param fullName
			 * Vollstaendiger Name
			 * @throws IllegalArgumentException
			 */
			public void setFullName(String fullName){
				if(fullName != null){
				this.fullName = fullName;
				}
				else {
					throw new IllegalArgumentException("Enter Valid Name!");
				}
			}
			
			/**
			 * Holt E-Mail.
			 * 
			 * @return E-Mail
			 */
			public String getEmail(){
				return email;}
			
			/**
			 * Setzt E-Mail
			 * 
			 * @param email
			 * E-Mail
			 * @throws IllegalArgumentException
			 */
			public void setEmail(String email){
				if(email != null){
					this.email = email;
				}
				else {
					throw new IllegalArgumentException(" Enter valid E-Mail address!");
				}
			}
			
			/**
			 * Holt Geschlecht.
			 * 
			 * @return Geschlecht
			 */
			public char getSex(){return sex;}
			
			/**
			 * Setzt Geschlecht, wobei Grossbuchstaben zu Kleinbuchstaben umgewandelt werden und nur "m" oder "w" akzeptiert wird.
			 * 
			 * @param sex
			 * Geschlecht
			 * @throws IllegalArgumentException
			 */
			public void setSex(char sex){ 
				sex = Character.toLowerCase(sex);
				if(sex == 'm' || sex == 'f'){
					this.sex = sex;
				}
				else{
					throw new IllegalArgumentException("Gender false");
				}
			}
			
			/**
			 * Holt Geburtsdatum.
			 * 
			 * @return Geburtsdatum
			 */
			public Date getBirthday(){return birthday;}
			
			/**
			 * Setzt Geburtsdatum, dass vor dem heutigen Tag sein muss.
			 * 
			 * @param birthday
			 * Geburtstag
			 * @throws IllegalArgumentException
			 */
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


