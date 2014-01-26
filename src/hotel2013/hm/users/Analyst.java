/**
 * @author Hotelreservierung Gruppe 8H2
 */
package hotel2013.hm.users;

import java.util.Date;

@SuppressWarnings("serial")
public class Analyst extends Person {
	
	public Analyst(String username, String password, String fullName, String email, char sex, Date birthday){
		super(username, password, fullName, email, sex, birthday);
	}	
}
