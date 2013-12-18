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
		
//		x.registerC("test1", "uniwien", "check", "tuaefzu@zgfsrv.de", 'm', neu);
//		x.registerH("test2", "uniwien", "check", "tuaefzu@zgfsrv.de", 'm', neu);
		
		x.login("test1", "uniwien");
//		x.NewOffer(12,3,"bett",120,"gut");
		String start = "02.02.2014";
		String end = "03.02.2014";
		Date sstart = new Date();
		Date send = new Date();
		try {
			sstart = sdf.parse(start);
			send = sdf.parse(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(x.Book(sstart,send,true,1,24));
		System.out.println(x.Book(sstart,send,true,1,25));
//		System.out.println(x.NewOffer(24,1,"lampe",120,"so"));
//		System.out.println(x.NewOffer(25,2,"dusche",120,"gut"));
		
//		System.out.println(x.ShowRating(13));
//		System.out.println(x.ShowAllRooms());
		

	}

}
