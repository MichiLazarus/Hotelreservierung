package hotel2013.hm.users;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Customer extends Person {
	
	
	public Customer(String username, String password, String fullName, String email, char sex, Date birthday){
		super(username, password, fullName, email, sex, birthday);
	}

	
	public boolean verifyAge(){ 
		 
		Calendar birthday = Calendar.getInstance();
		birthday.setTime(getBirthday());
		int year = birthday.get(Calendar.YEAR);
		int month = birthday.get(Calendar.MONTH) +1;
		int day = birthday.get(Calendar.DAY_OF_MONTH);
		
		Calendar TimeRef = new GregorianCalendar();
		
		
		int res = TimeRef.get(Calendar.YEAR) - year;
		if((month > TimeRef.get(Calendar.MONTH)) || 
				(month == TimeRef.get(Calendar.MONTH) && 
				day > TimeRef.get(Calendar.DAY_OF_MONTH))) 
		{ res-- ; if (res >= 18){
			return true; }
		else {
			return false; }
		} if (res >= 18){
			return true; }
		else {
			return false; }

	}
}

