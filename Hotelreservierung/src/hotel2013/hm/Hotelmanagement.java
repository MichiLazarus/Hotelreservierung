package hotel2013.hm;

import hotel2013.hm.users.Analyst;
import hotel2013.hm.users.Customer;
import hotel2013.hm.users.Hotelier;
import hotel2013.hm.users.Person;

public class Hotelmanagement {
	
	private Person session;
	
	public Hotelmanagement(){
		
	}
	
	
	public void register(){
		/**
		 * Hier Daten eingeben
		 */
		
		
	}
	
	public void login(){
		/**
		 * Hier Daten eingeben
		 */
	}
	
	
	//Analyst
	public void ShowStatistic(){
		if(session instanceof Analyst){
			
		}
	}
	
	public void MakePriceOffer(){
		if(session instanceof Analyst){
			
		}
	}
	
	//Analyst & Hotelier
	public void ShowAllRooms(){
		if(session instanceof Analyst || session instanceof Hotelier){
			
		}
	}
	
	public void ShowRating(){
		if(session instanceof Analyst || session instanceof Hotelier){
			
		}
	}
	
	
	//Hotelier
	public void NewOffer(){
		if(session instanceof Hotelier){
			
		}
	}
	
	public void Edit(){
		if(session instanceof Hotelier){
			
		}
	}
	
	
	//Customer
	public void SearchRoom(){
		if(session instanceof Customer){
			
		}
	}
	
	public void CancelBooking(){
		if(session instanceof Customer){
			
		}
	}
	
	public void RateBooking(){
		if(session instanceof Customer){
			
		}
	}
	
	public void Book(){
		if(session instanceof Customer){
			
		}
	}
	
}
