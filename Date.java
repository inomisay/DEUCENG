
public class Date {
	
	// Attributes
	private String day, month, year;
	
	// Constructor
	public Date(String day, String month, String year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	// Getters
	String getDay() {
		return day;
	}
	String getMonth() {
		return month;
	}
	String getYear() {
		return year;
	}
	
	// Setters
	void setDay(String day) {
		this.day = day;
	}
	void setMonth(String month) {
		this.month = month;
	}
	void setYear(String year) {
		this.year = year;
	}
	
	public String displayDate(){
        return day + month + year;
    }
	public String displayDateForReservationList(){
        return day + "." + month + "." + year;
    }
}
