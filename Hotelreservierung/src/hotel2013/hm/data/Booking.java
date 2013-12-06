package hotel2013.hm.data;

import java.util.Date;

public class Booking {

	private static int bookingnumber = 1000;
	private Date bookingstart;
	private Date bookingend;
	private boolean payment;
	private int bnop;       // number of persons zb: 3 zimmer 2 personen
	private int broomnumber;
	
	public Booking(Date bookingstart, Date bookingend , boolean payment, int bnop, int broomnumber){
		setBookingnumber(bookingnumber);
		setBookingstart(bookingstart);
		setBookingend(bookingend);
		setPayment(payment);
		setBnop(bnop);
		setBroomnumber(broomnumber);
		bookingnumber++;
	}
	
    public int getBroomnumber(){
    	return broomnumber;
    }
 
    public void setBroomnumber(int x){
    	if( x >999 && x < 10000  ) {
    		broomnumber = x;
    	}
    }
	
	public int getBookingnumber(){
		return bookingnumber;
	}
	
	public void setBookingnumber(int x){
		if(x > 999 && x < 10000){
		bookingnumber = x;
		}
		else throw new IllegalArgumentException("Bookingnumber must consist of exactly 4 numbers");
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

