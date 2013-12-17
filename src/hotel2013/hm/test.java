package hotel2013.hm;


import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import hotel2013.hm.data.Room;

public class test {

	public static void main(String[] args) {
		
		
		Hotelmanagement x = new Hotelmanagement();
		String birthday = "12.02.1992";
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date neu = null;
		try {
			neu = sdf.parse(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		x.registerH("tester", "uniwien", "check", "tuaefzu@zgfsrv.de", 'm', neu);
		
		x.login("tester", "uniwien");
//		x.NewOffer(12,3,"bett",120,"gut");
//		x.NewOffer(13,5,"stuhl",120,"ned");
//		x.NewOffer(14,1,"lampe",120,"so");
//		x.NewOffer(15,2,"dusche",120,"gut");
		
		System.out.println(x.ShowRating(14));
		

	}

}
