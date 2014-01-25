/**
 * @author Hotelreservierung Gruppe 8H2
 */
package hotel2013.hm.data;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable{

	private  int bookingnumber;
	private Date bookingstart;
	private Date bookingend;
	private String payment;
	private int bnop;       // number of persons zb: 3 zimmer 2 personen
	private int broomnumber;
	private int x = 1050;
	private String user;
	private double money;
	
	public Booking(int bookingnumber, Date bookingstart, Date bookingend , String payment, int bnop, int broomnumber, String user,double money2){
		setBookingstart(bookingstart);
		setBookingend(bookingend);
		setPayment(payment);
		setBnop(bnop);
		setBroomnumber(broomnumber);
		setBookingnumber(bookingnumber);
		setUser(user);
		setMoney(money2);	
	}
	
	/**
	 * Setzt den Preis fuer ein Zimmer. 
	 * 
	 * @param x
	 * Preis fuer ein Zimmer
	 */
	public void setMoney(double x ){
		money = x;
	}
	
	/**
	 * Holt Preis eines Zimmers.
	 * 
	 * @return Preis eines Zimmers
	 */
	public double getMoney( ){
		return money;
	}
	
	/**
	 * Setzt den User.
	 * 
	 * @param x
	 * User
	 */
	public void setUser(String x){
		user = x;
	}
	
	/**
	 * Holt den User.
	 * 
	 * @return user
	 */
	public String getUser(){
		return user;
	}
	
	/**
	 * Holt Zimmernummer.
	 * 
	 * @return Zimmernummer
	 */
    public int getBroomnumber(){
    	return broomnumber;
    }
 
    /**
     * Setzt Zimmernummer.
     * 
     * @param x
     * Zimmernummer
     */
    public void setBroomnumber(int x){
    		broomnumber = x;	
    }
	
    /**
     * Holt Buchungsnummer.
     * 
     * @return Buchungsnummer
     */
	public int getBookingnumber(){
		return bookingnumber;
	}
	
	/**
	 * Setzt Buchungsnummer.
	 * 
	 * @param x
	 * Buchungsnummer
	 */
	public void setBookingnumber(int x){
		
		bookingnumber = x;	
	}
	
	/**
	 * Holt Startdatum der Buchung.
	 * 
	 * @return Startdatum der Buchung
	 */
	public Date getBookingstart(){
		return bookingstart;
	}
	
	/**
	 * Setzt Startdatum der Buchung.
	 * 
	 * @param i
	 * Startdatum der Buchung
	 */
	public void setBookingstart(Date i){
		bookingstart = i;	
	}
	
	/**
	 * Holt Enddatum der Buchung.
	 * 
	 * @return Enddatum der Buchung
	 */
	public Date getBookingend(){
		return bookingend;
	}
	
	/**
	 * Setzt Enddatum der Buchung.
	 * 
	 * @param x
	 * Enddatum der Buchung
	 */
	public void setBookingend(Date x){
		bookingend = x;	
	}
	
	/**
	 * Holt Art der Zahlung (bar oder Kreditkarte).
	 * 
	 * @return Zahlungsart
	 */
	public String getPayment(){
		return payment;
	}
	
	/**
	 * Setzt Art der Zahlung (bar oder Kreditkarte).
	 * 
	 * @param x
	 * Zahlungsart
	 */
	public void setPayment(String x){
		payment = x;
	}
	
	/**
	 * Holt Anzahl der Personen in einem Zimmer.
	 * 
	 * @return Anzahl der Personen in einem Zimmer
	 */
	public int getBnop(){
		return bnop;
	}
	
	/**
	 * Setzt Anzahl der Personen in einem Zimmer.
	 * 
	 * @param x
	 * Anzahl der Personen in einem Zimmer
	 */
	public void setBnop(int x){
		bnop = x;

	}
}

