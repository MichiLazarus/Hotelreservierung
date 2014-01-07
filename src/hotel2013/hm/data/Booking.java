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
	
	public Booking(int bookingnumber, Date bookingstart, Date bookingend , String payment, int bnop, int broomnumber, String user){
		setBookingstart(bookingstart);
		setBookingend(bookingend);
		setPayment(payment);
		setBnop(bnop);
		setBroomnumber(broomnumber);
		setBookingnumber(bookingnumber);
		setUser(user);
		
		
	}
	public void setUser(String x){
		user = x;
	}
	
	public String getUser(){
		return user;
	}
    public int getBroomnumber(){
    	return broomnumber;
    }
 
    public void setBroomnumber(int x){
    		broomnumber = x;
    	
    }
	
	public int getBookingnumber(){
		return bookingnumber;
	}
	
	public void setBookingnumber(int x){
		
		bookingnumber = x;
		
		
	}
	
	public Date getBookingstart(){
		return bookingstart;
	}
	
	public void setBookingstart(Date i){
		bookingstart = i;
		
	}
	
	public Date getBookingend(){
		return bookingend;
	}
	
	public void setBookingend(Date x){
		bookingend = x;
		
	}
	
	public String getPayment(){
		return payment;
	}
	
	public void setPayment(String x){
		payment = x;
	}
	
	public int getBnop(){
		return bnop;
	}
	
	public void setBnop(int x){
		bnop = x;

	}
	

}

