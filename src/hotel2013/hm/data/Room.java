/**
 * @author Hotelreservierung Gruppe 8H2
 */
package hotel2013.hm.data;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Room implements Serializable{

		private int roomnumber;
		private int nop; //Number of Persons
		private String equipment;
		private double price;
		private double priceoffer;
		private String rating;

		public Room(int roomnumber, int nop, String equipment, double price, String rating){
			setRoomnumber(roomnumber);
			setNop(nop);
			setEquipment(equipment);
			setPrice(price);
			priceoffer = 0;
			setRating(rating);
		}
		
		/**
		 * Holt Zimmernummer.
		 * 
		 * @return Zimmernummer
		 */
		public int getRoomnumber(){
			return roomnumber;
		}
		
		/**
		 * Holt Anzahl der Personen in einem Zimmer.
		 * 
		 * @return Anzahl der Personen in einem Zimmer
		 */
		public int getNop(){
			return nop;
		}
		
		/**
		 * Holt Equipment.
		 * 
		 * @return Equipment
		 */
		public String getEquipment(){
			return equipment;
		}
		
		/**
		 * Holt Preis fuer ein Zimmer.
		 * 
		 * @return Preis fuer ein Zimmer
		 */
		public double getPrice(){
			return price;
		}
		
		/**
		 * Holt Preisvorschlag.
		 * 
		 * @return Preisvorschlag
		 */
		public double getPriceOffer(){
			return priceoffer;
		}
		
		/**
		 * Holt Rating.
		 * 
		 * @return Rating
		 */
		public String getRating(){
			return rating;
		}
		
		/**
		 * Setzt Zimmernummer
		 * 
		 * @param x
		 * Zimmernummer
		 */
		public void setRoomnumber(int x){
			roomnumber = x;	
		}
		
		/**
		 * Setzt Anzahl der Personen in einem Zimmer.
		 * 
		 * @param x
		 * Anzahl der Personen in einem Zimmer
		 */
		public void setNop(int x){
			nop = x;	
		}
		
		/**
		 * Setzt Equipment.
		 * 
		 * @param x
		 * Equipment
		 */
		public void setEquipment(String x){
			equipment = x;	
		}
		
		/**
		 * Setzt Preis fuer ein Zimmer.
		 * 
		 * @param x
		 * Preis fuer ein Zimmer
		 */
		public void setPrice(double x){
			price = x;	
		}
		
		/**
		 * Setzt Preisvorschlag.
		 * 
		 * @param x
		 * Preisvorschlag
		 */
		public void setPriceOffer(double x){
			priceoffer = x;
		}
		
		/**
		 * Setzt Rating.
		 * 
		 * @param x
		 * Rating
		 */
		public void setRating(String x){
			rating = x;
		}
		
		/**
		 * Zimmerdaten werden als String zurueckgegeben.
		 */
		public String toString(){
			String x = (roomnumber + "   " + nop +  "   " + equipment + "   " + price + "   " + priceoffer + "   " + rating);
			return x;
		}
}

