package hotel2013.hm.users;

import java.util.Date;

public class Analyst extends Person {
	
	public Analyst(String username, String password, String fullName, String email, char sex, Date birthday){
		super(username, password, fullName, email, sex, birthday);
	}
	
	public int SeasonStatistic(){
		return 0;
	}
	
	public int OccupancyStatistic(){
		return 0;
	}
	
	public int CustomerStatistic(){
		return 0;
	}
	
}
