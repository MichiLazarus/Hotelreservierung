package hotel2013.hm.data;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable{

	private  int bookingnumber;
	private Date bookingstart;
	private Date bookingend;
	private boolean payment;
	private int bnop;       // number of persons zb: 3 zimmer 2 personen
	private int broomnumber;
	private int x = 1050;
	
	public Booking(int bookingnumber, Date bookingstart, Date bookingend , boolean payment, int bnop, int broomnumber){
		setBookingstart(bookingstart);
		setBookingend(bookingend);
		setPayment(payment);
		setBnop(bnop);
		setBroomnumber(broomnumber);
		setBookingnumber(bookingnumber);
		
		
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
		Date dateNow = new Date();
		if(i.after(dateNow) || i.equals(dateNow)) bookingstart = i;
		else throw new IllegalArgumentException("Please enter valid Date");
	}
	
	public Date getBookingend(){
		return bookingend;
	}
	
	public void setBookingend(Date x){
		if(x.after(bookingstart)) bookingend = x;
		else throw new IllegalArgumentException("Bookinend must be after Bookingstart");
	}
	
	public boolean getPayment(){
		return payment;
	}
	
	public void setPayment(boolean x){
		payment = x;
	}
	
	public int getBnop(){
		return bnop;
	}
	
	public void setBnop(int x){
		bnop = x;

	}

}

