
public class PhoneNumber {
	
	// Attributes
	private String countryCode, cityCode, number;
		
	// Constructor
	public PhoneNumber(String countryCode, String cityCode, String number) {
		this.countryCode = countryCode;
		this.cityCode = cityCode;
		this.number = number;
	}
	
	// Getters
	String getCountryCode() {
		return countryCode;
	}
	String getCityCode() {
		return cityCode;
	}
	String getNumber() {
		return number;
	}
		
	// Setters
	void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	void SetNumber(String number) {
		this.number = number;
	}	
	
	public String displayPhone() {
        return countryCode + " (" + cityCode + ") " + number;
    }
	
}
