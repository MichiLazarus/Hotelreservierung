package hotel2013.hm.data;

import java.util.Date;

public class Room {

		private static  int roomnumber;
		private int nop; //Number of Persons
		private String equipment;
		private double price;
		private double priceoffer;
		private String rating;
		private boolean status;
		
		public Room(int roomnumber, int nop, String equipment, double price, String rating){
			setRoomnumber(roomnumber);
			setNop(nop);
			setEquipment(equipment);
			setPrice(price);
			priceoffer = 0;
			setRating(rating);
			status = true;
		}
		
		
		public static  int getRoomnumber(){
			return roomnumber;
		}
		
		public int getNop(){
			return nop;
		}
		
		public String getEquipment(){
			return equipment;
		}
		
		public double getPrice(){
			return price;
		}
		
		public double getPriceOffer(){
			return priceoffer;
		}
		
		public String getRating(){
			return rating;
		}
		
		
		
		public boolean getStatus(){
			return status;
		}
		
		public void setRoomnumber(int x){
			if(x <= 100 && x > 0) roomnumber = x;
			else throw new IllegalArgumentException("Roomnumber not allowed!");
		}
		
		public void setNop(int x){
			if(x < 7 && x > 0) nop = x;
			else throw new IllegalArgumentException("Max Number of Persons exceeded");	
		}
		
		public void setEquipment(String x){
			if(x != null) equipment = x;
			else throw new IllegalArgumentException("Please enter anything");
		}
		
		
		public void setPrice(double x){
			if(price > 0) price = x;
			else throw new IllegalArgumentException("Price too low");
		}
		
		public void setPriceOffer(double x){
			priceoffer = x;
		}
		
		public void setRating(String x){
			if(x.contains("fuck") || x.contains("shit") || x.contains("bitch") || x.contains("piss") || x.contains("asshole")){
			throw new IllegalArgumentException("Please don't enter swear words");
			}
			if(x != null) rating = x;
		}
		

		
		public void setStatus(boolean x){
			status = x;
		}
		
		public String toString(){
			String x = (roomnumber + "   " + nop +  "   " + equipment + "   " + price + "   " + priceoffer + "   " + rating);
			return x;
		}
}

