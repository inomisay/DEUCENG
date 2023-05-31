
public class Staff {

	// Attributes
	private String name, surname, gender, job; //administrator, receptionist and housekeeper. at list 1.
	private Date birthdate;
	private Address address;
	private PhoneNumber phone;
	private int salary, stuffNumber; // max 50 Employees
	private static int countOfStaff, administrator, receptionist, housekeeper = 0;
	private int staffID;
	
	// Constructor
	public Staff(String name, String surname, String gender, Date birthdate, Address address, String job, PhoneNumber phone, int salary) {
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.birthdate = birthdate;
		this.address = address;
		this.phone = phone;
		this.job = job;
		this.salary =salary;
		countOfStaff++;
		if(job.equals("administrator")) administrator++;
		else if(job.equals("receptionist")) receptionist++;
		else housekeeper++;
		staffID = countOfStaff;
		}
	
	// Getters
	public static int getAdministrator() {
		return administrator;
	}
	public static int getReceptionist() {
		return receptionist;
	}
	public static int getHousekeeper() {
		return housekeeper;
	}
	public static int getCountOfStaff() {
		return countOfStaff;
	}
	public int getStaffID() {
		return staffID;
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
	public String getJob() {
		return job;
	}
	public PhoneNumber getPhoneNumber() {
		return phone;
	}
	public int getSalary() {
		return salary;
	}
	public int getStuffNumber() {
		return stuffNumber;
	}
	
	// Setters
	public static void setHousekeeper(int housekeeper) {
		Staff.housekeeper = housekeeper;
	}
	public static void setReceptionist(int receptionist) {
		Staff.receptionist = receptionist;
	}
	public static void setAdministrator(int administrator) {
		Staff.administrator = administrator;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public static void setCountOfStaff(int countOfStaff) {
		Staff.countOfStaff = countOfStaff;
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
	public void setPhoneNumber(PhoneNumber phone) {
		this.phone = phone;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setStuffNumber(int stuffNumber) {
		this.stuffNumber = stuffNumber;
	}

	// Display
	public String display() {
		return  name + " " + surname + "  " + gender + "  " + birthdate.displayDate() + "  " + job;
	}
	// Display for addEmployee command
	public static void writeStaff(String name, String surname, String gender, String birthdate, String address, String district, String city, String job, String phone, String salary) {
		System.out.println(" addEmployee;" + name + ";" + surname + ";" + gender + ";" + birthdate + ";" + address + ";" + district + ";" + city + ";" + job + ";" + phone + ";" + salary);
	}
	
}

