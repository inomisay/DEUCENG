
public class Hotel {
	
	//Attributes
	private String name;
	private Double rating;	
	private Address address;
		
	//Constructor
	Hotel(String name, Address address, Double rating) {
		this.name = name;
	    this.address = address;
		this.rating = rating;
	}
		
	//Getters
	public String getName(){
		return name;
	}
	public Double getRating(){
		return rating;
	}
	Address getAddress() {
		return address;
	}
	
	//Setters
	public void setName(String name){
		this.name = name;
	}
	public void setRating(Double rating){
		this.rating = rating;
	}
	void setAddress(Address address) {
		this.address = address;
	}
}
