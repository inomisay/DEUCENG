
public class Address {
	
	// Attributes
	private String addressText, district, city;
	
	// Constructor
	public Address(String addressText, String district, String city) {
		this.addressText = addressText;
		this.district = district;
		this.city = city;
	}
			
	// Getters
	String getAddressText() {
		return addressText;
	}
	String getDistrict() {
		return district;
	}
	String getCity() {
		return city;
	}

	// Setters
	void setAddressText(String addressText) {
		this.addressText = addressText;
	}
	void setDistrict(String district) {
		this.district = district;
	}
	void setCity(String city) {
		this.city = city;
	}
	
	public String displayAddress() {
        return addressText + ";" + district + ";" + city;
    }

}
