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
			roomnumber = x;
		}
		
		public void setNop(int x){
			nop = x;
		}
		
		public void setEquipment(String x){
			equipment = x;
		}
		
	
		
		public void setPrice(double x){
			price = x;
		}
		
		public void setPriceOffer(double x){
			priceoffer = x;
		}
		
		public void setRating(String x){
			rating = x;
		}
		

		
		public void setStatus(boolean x){
			status = x;
		}
}

