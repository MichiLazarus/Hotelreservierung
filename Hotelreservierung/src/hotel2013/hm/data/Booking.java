package hotel2013.hm.data;

import java.util.Date;

public class Booking {

	private int bookingnumber;
	private Date bookingstart;
	private Date bookingend;
	private boolean payment;
	private int bnop;       // number of persons zb: 3 zimmer 2 personen
	
	
	public Booking(int bookingnumber,Date bookingstart, Date bookingend , boolean payment, int bnop){
		setBookingnumber(bookingnumber);
		setBookingstart(bookingstart);
		setBookingend(bookingend);
		setPayment(payment);
		setBnop(bnop);
	}
	
	
	public int getBookingnumber(){
		return bookingnumber;
	}
	
	public void setBookingnumber(int x){
		if(x > 999 && x < 10000){
		bookingnumber = x;
		}
	}
	
	public Date getBookingsart(){
		return bookingstart;
	}
	
	public void setBookingstart(Date x){
		bookingstart = x;
	}
	
	public Date getBookingend(){
		return bookingend;
	}
	
	public void setBookingend(Date x){
		bookingend = x;
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
		bnop=x;
	}
	
}

