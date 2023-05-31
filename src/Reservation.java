
public class Reservation {

	// Attributes
	private int customer_ID;
	private int room_ID;
	private Date dateArrival, dateDeparture;
	
	// Constructor
	public Reservation(int customer_ID, int room_ID, Date arrivalDate, Date departureDate) {
	      this.room_ID = room_ID;
	      this.customer_ID = customer_ID;
	      this.dateArrival = arrivalDate;
	      this.dateDeparture = departureDate;
	      }

	// Getters
	public int getCustomer_ID() {
		return customer_ID;
	}
	public int getRoom_ID() {
		return room_ID;
	}
	public Date getDateArrival() {
		return dateArrival;
	}
	public Date getDateDeparture() {
		return dateDeparture;
	}
	
	// Setters
	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;	
	}
	public void setRoom_ID(int room_ID) {
		this.room_ID = room_ID;
	}
	public void setDateArrival(Date dateArrival) {
		this.dateArrival = dateArrival;
	}
	public void setDateDeparture(Date dateDeparture) {
		this.dateDeparture = dateDeparture;
	}

	// Display
	public String displayReservation() {
		return dateArrival.displayDate() + "  " + dateDeparture.displayDate();
	}
	
	// Display for addReservation command
	public static void writeReservation(String customerid, String roomid, String arivdate, String depdate ) {
		System.out.println(" addreservation;" + customerid + ";" + roomid + ";" + arivdate + ";" + depdate);
	}
		
	
}
