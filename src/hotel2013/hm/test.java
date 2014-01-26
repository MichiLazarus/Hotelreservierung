/**
 * @author Hotelreservierung Gruppe 8H2
 */
package hotel2013.hm;


import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Eine Test-Klasse, die wir erstellt haben, zum Testen des Programms.
 *
 */
public class test {

	@SuppressWarnings("unused")
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
		
//		x.registerC("testC", "uniwien", "check", "tuaefzu@zgfsrv.de", 'm', neu);
//		x.registerH("testH", "uniwien", "check", "tuaefzu@zgfsrv.de", 'm', neu);
//		x.registerA("testA", "uniwien", "check", "tuaefzu@zgfsrv.de", 'm', neu);
		x.login("testC", "uniwien");
		
		String start = "02.02.2014";
		String end = "03.02. 2014";
		Date sstart = new Date();
		Date send = new Date();
		try {
			sstart = sdf.parse(start);
			send = sdf.parse(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
//		System.out.println(x.NewOffer(12,3,"bett",120,"gut"));
//		System.out.println(x.NewOffer(24,1,"lampe",120,"so"));
//		System.out.println(x.NewOffer(25,2,"dusche",120,"gut"));
//		System.out.println(x.ShowRating(13));
		System.out.println(x.ShowRating(12));

		
		
		

	}

}
