import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
	
	// Table of data for rooms

	static String[][] table = new String[1000][1000];

    static int[] salaries=new int[100]; // stores the salaries of the employee's.
    static int[] roomprices=new int[100]; // stores the prices of the rooms.
    static int[] roomamounts=new int[100]; // stores the amount of rooms to be reserved.
    static int[] roomno=new int[100]; //stores the room id's.
    static String[] enterdate=new String[100]; //stores enter date.
    static String[] exitdate=new String[100]; //stores exit date.
	
	public static void main(String[] args){
		
		// Reading from the file
		String filePath = "commands.txt";
		String contents = null;
		try {
			contents = new String(Files.readAllBytes(Paths.get(filePath)));
			contents = contents.toLowerCase();
			String[] line = contents.split("\\r?\\n");
			
			for(int i = 0; i < line.length; i++) {
				  line[i] = line[i].trim();// to avoid 8000"____" bugs
				  String[] entries = line[i].split(";");
				  for(int j = 0; j < entries.length; j++) {
					  table[i][j] = entries[j];
				  }
			}
		} catch (IOException e){
			System.out.println("no " + e.getMessage());
			return;
			}

		// ***********************************************************
		Managing managing = new Managing();
		Staff newStaff;
		Customer newCustomer;
		Reservation newReservation;
		
		int i = 0, j = 1, t = 0, a = 0, b = 1;

		System.out.println();
		System.out.println(" -------WELCOME TO HOTEL DEUCENG-------");
		System.out.println();
		System.out.println();
		
		while(table[i][0] != null) {
			if(table[i][0].equals("addroom")) { // ADD ROOM
				if(table[i][2].equals("regular") || table[i][2].equals("deluxe") || table[i][2].equals("suite")) {
					
					Room.displayRoom(table[i][1], table[i][2], table[i][3], table[i][4], table[i][5]);
					int countOfRoom = Integer.parseInt(table[i][1]); // room number
					boolean b1 = Boolean.parseBoolean(table[i][3]); // properties air condition
					boolean b2 = Boolean.parseBoolean(table[i][4]); // properties balcony
					int price = Integer.parseInt(table[i][5]); // price 
					managing.addRoom(countOfRoom,table[i][2], b1, b2, price); // table[i][2] : room type
					
					roomamounts[b] = countOfRoom;
					roomprices[b] = price;
					b++;
				}
			}
			if(table[i][0].equals("addemployee")) { // ADD EMPLOYEE
				//Staff.writestaff(table[i][1], table[i][2], table[i][3], table[i][4], table[i][5], table[i][6], table[i][7], table[i][8], table[i][9], table[i][10]);
				Staff.writeStaff(table[i][1], table[i][2], table[i][3], table[i][4], table[i][5], table[i][6], table[i][7], table[i][8], table[i][9], table[i][10]);

				String name = table[i][1]; // employee name
				String surname = table[i][2]; // employee surname
				String gender = table[i][3]; // employee gender
				String day = table[i][4].substring(0, 2); // employee birth day
				String month = table[i][4].substring(2,3); // employee birth month
				String year = table[i][4].substring(3); // employee birth year
				String text = table[i][5]; // employee address text
				String district = table[i][6]; // employee address district
				String city = table[i][7]; // employee address city
				String phoneCountryCode = table[i][8].substring(0, 3); // employee phone number country code
				String phoneCityCode = table[i][8].substring(3,6); // employee phone number city code
				String phoneNumber = table[i][8].substring(6); // employee phone number number
				String job = table[i][9]; // employee jobs
				int salary = Integer.parseInt(table[i][10]); // employee salary 
				Date birthDate = new Date(day, month, year);
				Address address = new Address(text, district, city);
				PhoneNumber phone = new PhoneNumber(phoneCountryCode, phoneCityCode, phoneNumber);
				//String name, String surname, String gender, Date birthDate, Address address, String job, PhoneNumber phone, int salary
				newStaff = new Staff(name, surname, gender, birthDate, address, job, phone, salary);
				managing.addEmployee(newStaff);
				
				salaries[a] = salary;
				a++;
			  }
			  if(table[i][0].equals("addcustomer")) { // ADD CUSTOMER
				  
				  Customer.writeCustomer(table[i][1], table[i][2], table[i][3], table[i][4], table[i][5], table[i][6], table[i][7], table[i][8]);

				  String name = table[i][1]; // customer name
				  String surname = table[i][2]; // customer surname
				  String gender = table[i][3]; // customer gender
				  String[] Bday_date = table[i][4].split("[.]"); // customer birthday
				  String text = table[i][5]; // customer address text
				  String district = table[i][6]; // customer address district
				  String city = table[i][7]; // customer address city
				  String phoneCountryCode = table[i][8].substring(0, 3); // customer phone number country code
				  String phoneCityCode = table[i][8].substring(3,6); // customer phone number city code
				  String phoneNumber = table[i][8].substring(6); // customer phone number number
				  
				  Date birthDate = new Date(Bday_date[0], Bday_date[1], Bday_date[2]);
				  Address address = new Address(text, district, city);
				  PhoneNumber phone = new PhoneNumber(phoneCountryCode, phoneCityCode, phoneNumber);
					  
				  //String name, String surname, String gender, Date birthDate, Address address, PhoneNumber phone
				  newCustomer = new Customer(name, surname, gender, birthDate, address, phone);

				  managing.addCustomer(newCustomer);	
				}
			  if(table[i][0].equals("addreservation")) { // ADD RESERVATION
				  
				  Reservation.writeReservation(table[i][1], table[i][2], table[i][3], table[i][4]);
				  
				  int customerIDs = Integer.parseInt(table[i][1]); // reservation customer id for name and surname
				  int roomNumbers = Integer.parseInt(table[i][2]); // reservation room id
				  String[] start = table[i][3].split("[.]"); // reservation date
				  String[] end = table[i][4].split("[.]"); // reservation date
				  
				  
				  if(roomNumbers <= Room.getAllRoomIDs()) {
					  
					  if(Managing.controlDate_Arrival_Departure(start[0], start[1], start[2],end[0], end[1], end[2])) {
						  
							 Date arrivalDate = new Date(start[0], start[1], start[2]);
							 Date departureDate = new Date(end[0], end[1], end[2]);
							 newReservation = new Reservation(customerIDs, roomNumbers, arrivalDate, departureDate);
							 managing.addReservation(newReservation);
							  
						  }
				  }
				  // ***********************************************************

				  // Days and months
				  int monthsinhotel, daysinhotel;
				  int dayy, monthh, yearr;
				  int day1, month1;
				  //departure
				  String[] sepdep = table[i][4].split("[.]");
				  day1 = Integer.parseInt(sepdep[0]); month1 = Integer.parseInt(sepdep[1]);
				  //arrival
				  String[] separr = table[i][3].split("[.]");
				  dayy = Integer.parseInt(separr[0]); monthh = Integer.parseInt(separr[1]); yearr = Integer.parseInt(separr[2]);
				  
				  if((monthh > month1)||(monthh == month1 && dayy > day1)) {
						int copy = dayy;
						dayy = day1;
						day1 = copy;
						int copy1 = monthh;
						monthh = month1;
						month1 = copy1;
					}
				    monthsinhotel = month1 - monthh;
					if(monthsinhotel == 0) daysinhotel = day1 - dayy;
					else {
					    daysinhotel = Statistics.dayinbetween(monthh, monthsinhotel ,dayy, yearr, day1);
					}
					
					int neededNumber = Integer.parseInt(table[i][1]);
					int neededID=Integer.parseInt(table[i][2]);
				    roomno[j-1]=neededID;
				    enterdate[j-1]=table[i][3];
				    exitdate[j-1]=table[i][4];
				    j++;

			  }
			  if(table[i][0].equals("deleteemployee")) { // DELETE EMPLOYEE
				  	
				  int employeeID = Integer.parseInt(table[i][1]); 
				  
				  managing.deleteEmployee(employeeID);
				  
			  }
			  if(table[i][0].equals("listrooms")) { // LIST ROOMS
				  System.out.println();
				  System.out.println("    ****List Rooms****");
				  System.out.println();
				  managing.ListRooms();	
				  System.out.println();
			  }
			  if(table[i][0].equals("listemployees")) { // LIST EMPLOYEES
				  System.out.println();
				  System.out.println("    ****List Employees****");
				  System.out.println();
				  managing.listEmployees();
				  System.out.println();
			  }
			  if(table[i][0].equals("listcustomers")) { // LIST CUSTOMERS
				  System.out.println();
				  System.out.println("    ****List Customers****");
				  System.out.println();
				  managing.customerList();
				  System.out.println();
			  }
			  if(table[i][0].equals("listreservations")) {// LIST RESERVATIONS
				  System.out.println();
				  System.out.println("    ****List Reservations****");
				  System.out.println();
				  managing.reservationList();
				  System.out.println();
			  }
			  if(table[i][0].equals("searchcustomer")) { // SEARCH CUSTOMERS
				  System.out.println();
				  System.out.println("    ****Searched Customers:" +"("+ table[i][1]+ ")" + "****");
				  System.out.println();
				  managing.searchCustomer(table[i][1].toString());
				  System.out.println();
			  }
			  if(table[i][0].equals("searchroom")) { // SEARCH ROOM
				  System.out.println();
				  System.out.println("    ****Searched Rooms" + "(" +table[i][1] + ";" + table[i][2] + ")****" );
				  System.out.println();
				  String[] start = table[i][1].split("[.]"); // reservation date
				  String[] end = table[i][2].split("[.]"); // reservation date
				  if(managing.controlDate_Arrival_Departure(start[0],start[1],start[2],end[0],end[1],end[2])) {
					  
					  managing.searchRoom(table[i][1], table[i][2]);
				  }
				  System.out.println();
			  }
			  if(table[i][0].equals("statistics")) { // STATISTICS
				  System.out.println();
				  System.out.println("    ****Statistics****");
				  System.out.println();
				  Statistics.firststat();
				  System.out.println();
				  Statistics.secondstat();
				  System.out.println();
				  Statistics.thirdstat();
				  System.out.println();
				  Statistics.fourthstat();
				  System.out.println();
			  }
			  if(table[i][0].equals("simulation")) { // SIMULATION
				  System.out.println();
				  System.out.println(table[i][0]+";"+table[i][1]+";"+table[i][2]);
				  System.out.println();
				  System.out.println("    ****Simulation****");
				  System.out.println();
				  String[]startdate=table[i][1].split("[.]");// split day,month and year
				  String[]enddate=table[i][2].split("[.]");//  split day,month and year
				  Date simstart=new Date(startdate[0],startdate[1],startdate[2]);//We use the information from the date
				  Date simend=new Date(enddate[0],enddate[1],enddate[2]);//We use the information from the date
				  managing.Simulation(simstart, simend);
				  System.out.println();
			  }
			  
			  i++;		  		  
		  }
	}

	static int[] getSalaries() {
		return salaries.clone();
	}
	static int[] getRoomPrices() {
		return roomprices.clone();
	}
	static int[] getAmounts() {
		return roomamounts.clone();
	}
	static int[] getRoomNo() {
		return roomno.clone();
	}
	static String[] getEnterDate() {
		return enterdate;
	}
	static String[] getExitDate() {
		return exitdate;
	}
}