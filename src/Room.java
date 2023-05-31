
public class Room {

	// Attributes
	private int countOfRoom;
	private int price; // different price each day
	private String type;
	private boolean airconditioner, balcony;
	private int roomID;
	private static int allRoomIDs = 0;
	
	// Constructors
	public Room(int countOfRoom, String type, Boolean airconditioner, Boolean balcony, int price) {
		this.countOfRoom = countOfRoom;
		this.price = price;
		this.type = type;
		this.airconditioner = airconditioner;
		this.balcony = balcony;
		allRoomIDs++;
		this.roomID = allRoomIDs;
    }

	// Getters
	public int getCountOfRoom() {
		return countOfRoom;
	}
	public int getRoomID() {
		return roomID;
	}
	public static int getAllRoomIDs() {
		return allRoomIDs;
	}
	public int getPrice() {
		return price;
	}
	public String getType() {
		return type;
	}
	public boolean isAirconditioner() {
		return airconditioner;
	}
	public boolean isBalcony() {
		return balcony;
	}
	
	// Setters
	public void setCountOfRoom(int countOfRoom) {
		this.countOfRoom = countOfRoom;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public static void setAllRoomIDs(int allRoomIDs) {
		Room.allRoomIDs = allRoomIDs;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setAirconditioner(boolean airconditioner) {
		this.airconditioner = airconditioner;
	}
	public void setBalcony(boolean balcony) {
		this.balcony = balcony;
	}
	
	// Display for addRoom command
	public static void displayRoom(String countOfRoom, String type, String aircond, String balcony, String priceof) {
		System.out.println(" addRoom;" + countOfRoom + ";" + type + ";" + aircond + ";" + balcony + ";" + priceof);
	}
	
} 
