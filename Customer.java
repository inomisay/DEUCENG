
public class Customer {
	
	// Attributes
	private int customerID;
	private String name, surname;
	private String gender;
	private Date birthdate;
	private Address address;
	private PhoneNumber phoneNumber;
	private static int countOfCustomer = 0;
	
	// Constructors
	public Customer(String name, String surname, String gender, Date birthdate, Address address, PhoneNumber phoneNumber) {
      this.name = name;
      this.surname = surname;
      this.gender = gender;
      this.birthdate = birthdate;
      this.address = address;
      this.phoneNumber = phoneNumber;
      countOfCustomer++;
      customerID = countOfCustomer;
     }

	public Customer(int customerID) {
		this.customerID = customerID;
	}

	// Getters
	public int getCustomerID() {
		return customerID;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getGender() {
		return gender;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public Address getAddress() {
		return address;
	}
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}
	public static int getCountOfCustomer() {
		return countOfCustomer;
	}
	
	// Setters
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}	
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public static void setCountOfCustomer(int countOfCustomer) {
		Customer.countOfCustomer = countOfCustomer;
	}
	
	// Display
	public String displayCustomer() {
		return name + " " + surname + "  " + gender + "  " + birthdate.displayDate() + "  " + address.getCity() + "  " + phoneNumber.displayPhone();
	}
	// Display for addCustomer command
	public static void writeCustomer(String name, String surname, String gender, String birthdate, String adress, String district, String city,String number){
		System.out.println(" addCustomer;" + name + ";" + surname + ";" + gender + ";" + birthdate + ";" + adress + ";" + district + ";" + city + ";" + number);
	}
	
}
