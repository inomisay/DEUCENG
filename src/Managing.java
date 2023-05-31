import java.util.Arrays;
import java.util.Random;

public class Managing {

	// Rooms
	private Room[] rooms =  new Room[30];
	
	// Date controls of the room
	public static void Controldates(String[][] table,int k)
	{
		String[] enter = Main.getEnterDate();
		String[] exit = Main.getExitDate();
		int[] roomno=Main.getRoomNo();
		int count1 = -1;
		String[] transfer1 = new String[enter.length];
		for (String s: enter) {
			if(s != null) {
				transfer1[++count1] = s;
			}
		}
		enter = Arrays.copyOf(transfer1,count1+1);
		Object[][][][] control = new Object[enter.length+1][enter.length+1][enter.length+1][enter.length+1];
		for(int i1 = 0; i1<enter.length; i1++) {
	    	control[i1 + 1][0][0][0] = true;
	    	control[0][i1 + 1][0][0] = enter[i1];
	    	control[0][0][i1 + 1][0] = exit[i1];
	    	control[0][0][0][i1 + 1] = roomno[i1];
	    	
	    }
		for(int i1 = 0; i1 < enter.length; i1++) {
	    	for(int j1 = i1 + 1; j1 < enter.length; j1++) {
	    	    if(control[0][0][0][i1 + 1] == control[0][0][0][j1 + 1]) {
	    		    if(control[0][i1 + 1][0][0].equals(control[0][j1 + 1][0][0])||control[0][0][i1 + 1][0].equals(control[0][0][j1 + 1][0])) {
	    		    	control[j1+1][0][0][0] = false;
	    		    }
	    	    }
	    	}
	    }    
	}
		
		
	// adding rooms
	public void addRoom(int countOfRoom, String type, Boolean airconditioner, Boolean balcony, int price) {
		int instantNumberOfRooms = 0;
		for(int i = 0; i < rooms.length ; i++){
			if (rooms[i] == null) {
				for(int j = 0; j < countOfRoom; j++) {	
					if ( (i + j < 30) && (rooms[i + j] == null)) {
						Room newRoom = new Room(countOfRoom,type,airconditioner,balcony,price);
						rooms[i + j] = newRoom;
						}
					}
				i += countOfRoom;
				break;
				}
			else {
				instantNumberOfRooms += 1; 
			}
			}
		if(instantNumberOfRooms == 30) {
			System.out.println(" You can not add new room because count of room is 30");
			
		}
	}
	// listing rooms
	public void ListRooms() {

		for(int i = 0; i < rooms.length; i++) {
			if (rooms[i] != null) {
				
				if(rooms[i].isAirconditioner() == false && rooms[i].isBalcony() == false) {		
				  System.out.println(" Room #" + (rooms[i].getRoomID()) + "  " + rooms[i].getType() + "  no-air condition" + "  no-balcony  " + rooms[i].getPrice());
				}
				if(rooms[i].isAirconditioner() == true && rooms[i].isBalcony() == false) {		
					System.out.println(" Room #" + (rooms[i].getRoomID()) + "  " + rooms[i].getType() + "  air condition" + "  no-balcony  " + rooms[i].getPrice());
				}
				if(rooms[i].isAirconditioner() == false && rooms[i].isBalcony() == true) {		
					System.out.println(" Room #" + (rooms[i].getRoomID()) + "  " + rooms[i].getType() + "  no-air condition" + "  balcony  " + rooms[i].getPrice());
				}
				if(rooms[i].isAirconditioner() == true && rooms[i].isBalcony() == true) {		
					System.out.println(" Room #" + (rooms[i].getRoomID()) + "  " + rooms[i].getType() + "  air condition" + "  balcony  " + rooms[i].getPrice());
				}

			}
			
		}
	}

	//*********************************
	
	// Staff
	
	// Attributes
	private Staff[] staffTable = new Staff[50];
	
	// Show List Employee
	public void listEmployees() {
		for(int i = 0; i < staffTable.length ; i++){
			if (staffTable[i] != null) {
			System.out.println(" Employee #" + (staffTable[i].getStaffID()) + " " + staffTable[i].display());
			}
		}
	}
	
	// Add new Employee
	public void addEmployee(Staff newStaff) {
		int instantNumberOfEmployees = 0;
		for(int i = 0; i < staffTable.length ; i++){
			if (staffTable[i] == null){
				boolean canAdd = false;
				if(Staff.getAdministrator() <= 48){canAdd = true;}
				else if(Staff.getReceptionist() <= 48){canAdd = true;}
				else if(Staff.getHousekeeper() <= 48){canAdd = true;}
				
				if(canAdd){
				staffTable[i] = newStaff;
				break;
				}	
			}else {
				instantNumberOfEmployees += 1;
			}
			if(instantNumberOfEmployees == 50) {
				System.out.println(" You can not add new employee because count of employee is 50");
			}
			
		}
	}
			
	// Delete Employee
	public void deleteEmployee(int employeeId){
		int rightEmployeeId = (employeeId - 1);
		boolean canDelete = false;
		if((staffTable[rightEmployeeId].getJob().equals("admin")) && (Staff.getAdministrator() >= 1)){canDelete = true;}
		else if((staffTable[rightEmployeeId].getJob().equals("receptionist")) && (Staff.getReceptionist() >= 1)){canDelete = true;}
		else if((staffTable[rightEmployeeId].getJob().equals("housekeeper")) && (Staff.getHousekeeper() >= 1)){canDelete = true;}
		
		if(canDelete)
		staffTable[rightEmployeeId] = null;
		
	}
		
	//*********************************

	// Customer
	private static Customer[] customerTable = new Customer[1000];
			
	// Show List Employee
	public void customerList() {
		for(int i = 0; i < customerTable.length ; i++){
			if (customerTable[i] != null) {
			System.out.println(" Customer #" + (customerTable[i].getCustomerID()) + " " + customerTable[i].displayCustomer());
			}
		}
	}	
		
	// Adding a new Customer
	public void addCustomer(Customer newCustomer) {
		for(int i = 0; i < customerTable.length ; i++){
			if (customerTable[i] == null) {
				customerTable[i] = newCustomer;
				break;
			}
		}
	}
		
	// Search Customer
	public void searchCustomer(String pattern) {
		char[] wordsArray = new char[pattern.length()];
		
		for(int i = 0 ; i < pattern.length(); i++) {
			wordsArray[i] = pattern.charAt(i);
		}
		
		String nameStr = ""; 
		int countOfQuestionMarks = 0;
		char searchType = '1'; 
		for(int i = 0 ; i < pattern.length(); i++) {
		
			if((wordsArray[i] != '?') && (wordsArray[i] != '*')){
				
				nameStr += String.valueOf(wordsArray[i]);	
			}
			else if(wordsArray[i] == '?' ) {
				countOfQuestionMarks++;
				searchType = '?';
			}
			else if(wordsArray[i] == '*' ){
				searchType = '*';
			}
		}

		
		if(searchType == '*') {

			for(int i = 0 ; i < customerTable.length; i++) {
				if(customerTable[i] != null) {
					String customer = customerTable[i].getName().substring(0, nameStr.length());
					if(nameStr.equals(customer)){
						
						System.out.println(" Customer #" + customerTable[i].getCustomerID() + "  " + customerTable[i].getName() + " " + customerTable[i].getSurname()+ "  " + customerTable[i].getGender() + "  " + customerTable[i].getBirthdate().displayDate() + "  " + customerTable[i].getAddress().getCity() + "  " +  customerTable[i].getPhoneNumber().displayPhone());
					}
				}
			}
		}
		else if(searchType == '?'){
			for(int i = 0 ; i < customerTable.length; i++) {
				if(customerTable[i] != null) {
					String customer = customerTable[i].getName().toLowerCase().substring(0, nameStr.length());
					
					if((nameStr.equals(customer)) && ((nameStr.length() + countOfQuestionMarks) == customerTable[i].getName().length())){
						
						System.out.println(" Customer #" + customerTable[i].getCustomerID() + "  " + customerTable[i].getName() + " " + customerTable[i].getSurname() + "  " + customerTable[i].getGender() + "  " + customerTable[i].getBirthdate().displayDate() + "  " + customerTable[i].getAddress().getCity() + "  " +  customerTable[i].getPhoneNumber().displayPhone());
					}
				}
				
			}
		}
	}
	
	//*********************************

	// Reservation
	private static Reservation[] reservationTable = new Reservation[1000];
	private char[][] checkDays = new char[30][366];

	// Show List Reservation
	public void reservationList() {
		for(int i = 0 ; i < reservationTable.length; i++) {
			if(reservationTable[i] != null) {
				System.out.println(" Room #" + reservationTable[i].getRoom_ID() + " " + customerTable[reservationTable[i].getCustomer_ID() - 1].getName() + " " + customerTable[reservationTable[i].getCustomer_ID() - 1].getSurname() + " " + reservationTable[i].displayReservation());

			}
		}

	}
		
	// Adding a new Reservation
	public void addReservation(Reservation newReservation) {
		
		int dayArr = Integer.parseInt(newReservation.getDateArrival().getDay());  		// this part is that contains all date information to use them easily.
		int monthArr = Integer.parseInt(newReservation.getDateArrival().getMonth());
		int dayDep = Integer.parseInt(newReservation.getDateDeparture().getDay());
		int monthDep = Integer.parseInt(newReservation.getDateDeparture().getMonth());
		
		boolean didAdd = true;  // to check first condition is happen or not
		int jj = 0;
		while(jj < reservationTable.length && didAdd){ // this while is using to find any reservation is there in reservationTable.
			if(reservationTable[jj] != null) {
				if(newReservation.getRoom_ID() == reservationTable[jj].getRoom_ID()){ // to find reservation that room IDs is same.
					

					int	numOfRevDay = 0; // total day customer will stay at hotel.
					int fromFrontNumOfDay = 0; // the number of days since the first day of the year
					for(int m = monthArr; m <= monthDep; m++) { 
							
						if(m == monthArr && m == monthDep) {//if start month and finish month is same, in this part we calculate numOfRevDay and fromFrontNumOfDay separately to avoid bugs.

							
							if(m == 1) {
								fromFrontNumOfDay += dayArr;
							}else if(m == 2) {
								fromFrontNumOfDay += 31 + dayArr;
							}else if(m == 3) {
								fromFrontNumOfDay += 60 + dayArr;
							}else if(m == 4) {
								fromFrontNumOfDay += 91 + dayArr;
							}else if(m == 5) {
								fromFrontNumOfDay += 121 + dayArr;
							}else if(m == 6) {
								fromFrontNumOfDay += 152 + dayArr;
							}else if(m == 7) {
								fromFrontNumOfDay += 182 + dayArr;
							}else if(m == 8) {
								fromFrontNumOfDay += 213 + dayArr;
							}else if(m == 9) {
								fromFrontNumOfDay += 244 + dayArr;
							}else if(m == 10) {
								fromFrontNumOfDay += 274 + dayArr;
							}else if(m == 11) {
								fromFrontNumOfDay += 305 + dayArr;
							}else{
								fromFrontNumOfDay += 335 + dayArr;
							}

							numOfRevDay += dayDep - dayArr;
							
						
						}else if(m == monthArr) { //If the starting month is equal to the "m" in "for", it still calculates the days separately.
							
							int maxDays;
							
							if(m == 1) {
								maxDays = 31;
								numOfRevDay += maxDays - dayArr +1;
								fromFrontNumOfDay += dayArr;
							}else if(m == 2) {
								maxDays = 29;
								numOfRevDay += maxDays - dayArr +1;
								fromFrontNumOfDay += 31 + dayArr;
							}else if(m == 3) {
								maxDays = 31;
								numOfRevDay += maxDays - dayArr +1;
								fromFrontNumOfDay += 60 + dayArr;
							}else if(m == 4) {
								maxDays = 30;
								numOfRevDay += maxDays - dayArr +1;
								fromFrontNumOfDay += 91 + dayArr;
							}else if(m == 5) {
								maxDays = 31;
								numOfRevDay += maxDays - dayArr +1;
								fromFrontNumOfDay += 121 + dayArr;
							}else if(m == 6) {
								maxDays = 30;
								numOfRevDay += maxDays - dayArr +1;
								fromFrontNumOfDay += 152 + dayArr;
							}else if(m == 7) {
								maxDays = 31;
								numOfRevDay += maxDays - dayArr +1;
								fromFrontNumOfDay += 182 + dayArr;
							}else if(m == 8) {
								maxDays = 31;
								numOfRevDay += maxDays - dayArr +1;
								fromFrontNumOfDay += 213 + dayArr;
							}else if(m == 9) {
								maxDays = 30;
								numOfRevDay += maxDays - dayArr +1;
								fromFrontNumOfDay += 244 + dayArr;
							}else if(m == 10) {
								maxDays = 31;
								numOfRevDay += maxDays - dayArr +1;
								fromFrontNumOfDay += 274 + dayArr;
							}else if(m == 11) {
								maxDays = 30;
								numOfRevDay += maxDays - dayArr +1;
								fromFrontNumOfDay += 305 + dayArr;
							}else{
								maxDays = 31;
								numOfRevDay += maxDays - dayArr +1;
								fromFrontNumOfDay += 335 + dayArr;
							}
						
							
						}else if(m == monthDep) { //If the finishing month is equal to the "m" in "for", it still calculates the days separately.
							
							numOfRevDay += dayDep - 1;
							
							
						}else { // for the intermediate months
							
							
							int maxDays;
							
							if(m == 1) {
								maxDays = 31;
								numOfRevDay += maxDays;
							}else if(m == 2) {
								maxDays = 29;
								numOfRevDay += maxDays;
							}else if(m == 3) {
								maxDays = 31;
								numOfRevDay += maxDays;
							}else if(m == 4) {
								maxDays = 30;
								numOfRevDay += maxDays;
							}else if(m == 5) {
								maxDays = 31;
								numOfRevDay += maxDays;
							}else if(m == 6) {
								maxDays = 30;
								numOfRevDay += maxDays;
							}else if(m == 7) {
								maxDays = 31;
								numOfRevDay += maxDays;
							}else if(m == 8) {
								maxDays = 31;
								numOfRevDay += maxDays;
							}else if(m == 9) {
								maxDays = 30;
								numOfRevDay += maxDays;
							}else if(m == 10) {
								maxDays = 31;
								numOfRevDay += maxDays;
							}else if(m == 11) {
								maxDays = 30;
								numOfRevDay += maxDays;
							}else{
								maxDays = 31;
								numOfRevDay += maxDays;
							}
						}
					}
					boolean canAdd = true;
					for(int r = fromFrontNumOfDay - 1 ; r < numOfRevDay + fromFrontNumOfDay - 1; r++) { // in here , reservation days is checked by if condition to avoid day conflict
						
						if(checkDays[newReservation.getRoom_ID() - 1][r] == '*') {
							
							canAdd = false;
							break;
						}	
					}
					didAdd = canAdd;
					if(canAdd) { // if there isn't any day conflict, we add '*' in char[30][366] array. thanks to this array we can check reservation day.
						for(int r = fromFrontNumOfDay - 1 ; r < numOfRevDay + fromFrontNumOfDay - 1; r++) {
						
						checkDays[newReservation.getRoom_ID() - 1][r] = '*';
						}
						
						for(int l = 0 ; l < reservationTable.length ; l++) {
							if(reservationTable[l]== null) {
								reservationTable[l] = newReservation;
								break;
							}
							
						}
					}

				}
			}
			jj++ ;
		}
		if(didAdd) {//If a reservation has been added in the first part, we check it with "if" so that it does not come to this part. 
			for(int i = 0; i< reservationTable.length; i++) {

				int	numOfRevDay = 0;
				int fromFrontNumOfDay = 0;
				for(int m = monthArr; m < monthDep + 1; m++) {
						
					if(m == monthArr && m == monthDep) {
						
						if(m == 1) {
							fromFrontNumOfDay += dayArr;
						}else if(m == 2) {
							fromFrontNumOfDay += 31 + dayArr;
						}else if(m == 3) {
							fromFrontNumOfDay += 60 + dayArr;
						}else if(m == 4) {
							fromFrontNumOfDay += 91 + dayArr;
						}else if(m == 5) {
							fromFrontNumOfDay += 121 + dayArr;
						}else if(m == 6) {
							fromFrontNumOfDay += 152 + dayArr;
						}else if(m == 7) {
							fromFrontNumOfDay += 182 + dayArr;
						}else if(m == 8) {
							fromFrontNumOfDay += 213 + dayArr;
						}else if(m == 9) {
							fromFrontNumOfDay += 244 + dayArr;
						}else if(m == 10) {
							fromFrontNumOfDay += 274 + dayArr;
						}else if(m == 11) {
							fromFrontNumOfDay += 305 + dayArr;
						}else{
							fromFrontNumOfDay += 335 + dayArr;
						}

						numOfRevDay += dayDep - dayArr;
						
					
					}else if(m == monthArr) {
						
						int maxDays;
						
						if(m == 1) {
							maxDays = 31;
							numOfRevDay += maxDays - dayArr +1;
							fromFrontNumOfDay += dayArr;
						}else if(m == 2) {
							maxDays = 29;
							numOfRevDay += maxDays - dayArr +1;
							fromFrontNumOfDay += 31 + dayArr;
						}else if(m == 3) {
							maxDays = 31;
							numOfRevDay += maxDays - dayArr +1;
							fromFrontNumOfDay += 60 + dayArr;
						}else if(m == 4) {
							maxDays = 30;
							numOfRevDay += maxDays - dayArr +1;
							fromFrontNumOfDay += 91 + dayArr;
						}else if(m == 5) {
							maxDays = 31;
							numOfRevDay += maxDays - dayArr +1;
							fromFrontNumOfDay += 121 + dayArr;
						}else if(m == 6) {
							maxDays = 30;
							numOfRevDay += maxDays - dayArr +1;
							fromFrontNumOfDay += 152 + dayArr;
						}else if(m == 7) {
							maxDays = 31;
							numOfRevDay += maxDays - dayArr +1;
							fromFrontNumOfDay += 182 + dayArr;
						}else if(m == 8) {
							maxDays = 31;
							numOfRevDay += maxDays - dayArr +1;
							fromFrontNumOfDay += 213 + dayArr;
						}else if(m == 9) {
							maxDays = 30;
							numOfRevDay += maxDays - dayArr +1;
							fromFrontNumOfDay += 244 + dayArr;
						}else if(m == 10) {
							maxDays = 31;
							numOfRevDay += maxDays - dayArr +1;
							fromFrontNumOfDay += 274 + dayArr;
						}else if(m == 11) {
							maxDays = 30;
							numOfRevDay += maxDays - dayArr +1;
							fromFrontNumOfDay += 305 + dayArr;
						}else{
							maxDays = 31;
							numOfRevDay += maxDays - dayArr +1;
							fromFrontNumOfDay += 335 + dayArr;
						}
					
						
					}else if(m == monthDep) {
						
						numOfRevDay += dayDep - 1;
						
						
					}else { // for mid month
						
						
						int maxDays;
						
						if(m == 1) {
							maxDays = 31;
							numOfRevDay += maxDays;
						}else if(m == 2) {
							maxDays = 29;
							numOfRevDay += maxDays;
						}else if(m == 3) {
							maxDays = 31;
							numOfRevDay += maxDays;
						}else if(m == 4) {
							maxDays = 30;
							numOfRevDay += maxDays;
						}else if(m == 5) {
							maxDays = 31;
							numOfRevDay += maxDays;
						}else if(m == 6) {
							maxDays = 30;
							numOfRevDay += maxDays;
						}else if(m == 7) {
							maxDays = 31;
							numOfRevDay += maxDays;
						}else if(m == 8) {
							maxDays = 31;
							numOfRevDay += maxDays;
						}else if(m == 9) {
							maxDays = 30;
							numOfRevDay += maxDays;
						}else if(m == 10) {
							maxDays = 31;
							numOfRevDay += maxDays;
						}else if(m == 11) {
							maxDays = 30;
							numOfRevDay += maxDays;
						}else{
							maxDays = 31;
							numOfRevDay += maxDays;
						}
					}
				}
				
				for(int r = fromFrontNumOfDay - 1 ; r < numOfRevDay + fromFrontNumOfDay - 1; r++) { // in this part, we add reservation directly because there isn't any reservation that room IDs are same

					checkDays[newReservation.getRoom_ID() - 1][r] = '*';
					}
				
				for(int l = 0 ; l < reservationTable.length ; l++) {
					if(reservationTable[l]== null) {
						reservationTable[l] = newReservation;
						break;
					}
					
				}
				break;
			}
		}
	}
	
	
	
	
	
	//SearchRoom
	int[][] availableRooms = new int[30][367]; // to store information of room and reservation.
	public void searchRoom(String startDate, String endDate){
		
		String[] start = startDate.split("[.]");
		String[] end = endDate.split("[.]");
		
		int startDay, startMonth, endDay, endMonth;
		
		startDay = Integer.parseInt(start[0]);
		startMonth = Integer.parseInt(start[1]);
		endDay = Integer.parseInt(end[0]);
		endMonth = Integer.parseInt(end[1]);
		
		
		for(int i= 0 ; i < availableRooms.length ; i++){ //  The first "for" loop retrieves the "Room" information, while the second "for" loop takes the reserved room information from the "checkDay" array and transfers it to the "available Rooms" array.
			if(rooms[i] != null) {
				availableRooms[i][0] = rooms[i].getRoomID();
			}
			for(int j = 1; j < availableRooms[1].length; j++) {
				if(checkDays[i][j-1] == '*') {
					availableRooms[i][j] = 1;
				}else {
					availableRooms[i][j] = 0;
				}
				
			}

		}// this section to determine on which day of the year and where the reservation will begin
		int	numOfRevDay = 0;
		int fromFrontNumOfDay = 0;
		
		for(int m = startMonth; m < endMonth + 1; m++) {
			
			if(m == startMonth && m == endMonth) {
				
				if(m == 1) {
					fromFrontNumOfDay += startDay;
				}else if(m == 2) {
					fromFrontNumOfDay += 31 + startDay;
				}else if(m == 3) {
					fromFrontNumOfDay += 60 + startDay;
				}else if(m == 4) {
					fromFrontNumOfDay += 91 + startDay;
				}else if(m == 5) {
					fromFrontNumOfDay += 121 + startDay;
				}else if(m == 6) {
					fromFrontNumOfDay += 152 + startDay;
				}else if(m == 7) {
					fromFrontNumOfDay += 182 + startDay;
				}else if(m == 8) {
					fromFrontNumOfDay += 213 + startDay;
				}else if(m == 9) {
					fromFrontNumOfDay += 244 + startDay;
				}else if(m == 10) {
					fromFrontNumOfDay += 274 + startDay;
				}else if(m == 11) {
					fromFrontNumOfDay += 305 + startDay;
				}else{
					fromFrontNumOfDay += 335 + startDay;
				}

				numOfRevDay += endDay - startDay;
				
			
			}else if(m == startMonth) {
				
				int maxDays;
				
				if(m == 1) {
					maxDays = 31;
					numOfRevDay += maxDays - startDay +1;
					fromFrontNumOfDay += startDay;
				}else if(m == 2) {
					maxDays = 29;
					numOfRevDay += maxDays - startDay +1;
					fromFrontNumOfDay += 31 + startDay;
				}else if(m == 3) {
					maxDays = 31;
					numOfRevDay += maxDays - startDay +1;
					fromFrontNumOfDay += 60 + startDay;
				}else if(m == 4) {
					maxDays = 30;
					numOfRevDay += maxDays - startDay +1;
					fromFrontNumOfDay += 91 + startDay;
				}else if(m == 5) {
					maxDays = 31;
					numOfRevDay += maxDays - startDay +1;
					fromFrontNumOfDay += 121 + startDay;
				}else if(m == 6) {
					maxDays = 30;
					numOfRevDay += maxDays - startDay +1;
					fromFrontNumOfDay += 152 + startDay;
				}else if(m == 7) {
					maxDays = 31;
					numOfRevDay += maxDays - startDay +1;
					fromFrontNumOfDay += 182 + startDay;
				}else if(m == 8) {
					maxDays = 31;
					numOfRevDay += maxDays - startDay +1;
					fromFrontNumOfDay += 213 + startDay;
				}else if(m == 9) {
					maxDays = 30;
					numOfRevDay += maxDays - startDay +1;
					fromFrontNumOfDay += 244 + startDay;
				}else if(m == 10) {
					maxDays = 31;
					numOfRevDay += maxDays - startDay +1;
					fromFrontNumOfDay += 274 + startDay;
				}else if(m == 11) {
					maxDays = 30;
					numOfRevDay += maxDays - startDay +1;
					fromFrontNumOfDay += 305 + startDay;
				}else{
					maxDays = 31;
					numOfRevDay += maxDays - startDay +1;
					fromFrontNumOfDay += 335 + startDay;
				}
			
				
			}else if(m == endMonth) {
				
				numOfRevDay += endDay - 1;
				
				
			}else { // for mid month
				
				
				int maxDays;
				
				if(m == 1) {
					maxDays = 31;
					numOfRevDay += maxDays;
				}else if(m == 2) {
					maxDays = 29;
					numOfRevDay += maxDays;
				}else if(m == 3) {
					maxDays = 31;
					numOfRevDay += maxDays;
				}else if(m == 4) {
					maxDays = 30;
					numOfRevDay += maxDays;
				}else if(m == 5) {
					maxDays = 31;
					numOfRevDay += maxDays;
				}else if(m == 6) {
					maxDays = 30;
					numOfRevDay += maxDays;
				}else if(m == 7) {
					maxDays = 31;
					numOfRevDay += maxDays;
				}else if(m == 8) {
					maxDays = 31;
					numOfRevDay += maxDays;
				}else if(m == 9) {
					maxDays = 30;
					numOfRevDay += maxDays;
				}else if(m == 10) {
					maxDays = 31;
					numOfRevDay += maxDays;
				}else if(m == 11) {
					maxDays = 30;
					numOfRevDay += maxDays;
				}else{
					maxDays = 31;
					numOfRevDay += maxDays;
				}
			}
		}

		for(int i = 0 ; i < availableRooms.length ; i++) { // available days is checked by code to determine available reservation days
			boolean willWrite = true;
			for(int j = fromFrontNumOfDay; j < fromFrontNumOfDay + numOfRevDay; j++) {
				if(availableRooms[i][j] == 1 || availableRooms[i][0] == 0) {
					willWrite = false;
					break;
				}else {
					willWrite = true;
				}
			
				//if(availableRooms[i][j] != '*');	
			}
			if(willWrite && rooms[availableRooms[i][0] - 1] != null) { // here, if reservation date is available, rooms and its information is wrote screen.
				System.out.print(" Room" + " #" + rooms[availableRooms[i][0] - 1].getRoomID() + " " + rooms[availableRooms[i][0] - 1].getType() + " ");
				if(rooms[ availableRooms[i][0] - 1].isAirconditioner()) {
					System.out.print("aircondition ");
				}
				else {
					System.out.print("no-air condition ");
				}
				if(rooms[availableRooms[i][0] - 1].isBalcony()) {
					System.out.print("balcony ");
				}else {
					System.out.print("no-balcony ");
				}
				System.out.print(rooms[availableRooms[i][0] - 1].getPrice());
				System.out.println();
			}
		}
	}

	
	
	
	// Date Control for Reservation
	public static boolean controlDate_Arrival_Departure(String day, String month, String year, String day1, String month1, String year1) {
		
		boolean flage = true;
		if (Integer.parseInt(year) == 2024) {
			if (Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 12) {// checking month range
				
				int maxDays;
				
				if(Integer.parseInt(month) == 1) {// checking day range
					maxDays = 31;
				}else if(Integer.parseInt(month) == 2) {
					maxDays = 29;
				}else if(Integer.parseInt(month) == 3) {
					maxDays = 31;
				}else if(Integer.parseInt(month) == 4) {
					maxDays = 30;
				}else if(Integer.parseInt(month) == 5) {
					maxDays = 31;
				}else if(Integer.parseInt(month) == 6) {
					maxDays = 30;
				}else if(Integer.parseInt(month) == 7) {
					maxDays = 31;
				}else if(Integer.parseInt(month) == 8) {
					maxDays = 31;
				}else if(Integer.parseInt(month) == 9) {
					maxDays = 30;
				}else if(Integer.parseInt(month) == 10) {
					maxDays = 31;
				}else if(Integer.parseInt(month) == 11) {
					maxDays = 30;
				}else{
					maxDays = 31;
				}
				if (Integer.parseInt(day) > 0 && Integer.parseInt(day) <= maxDays) {
				}else {
					flage = false;
					System.out.println(" Wrong day!");
				}

			}
			else {
				flage = false;
				System.out.println(" Wrong month!");}
		}
		else {
			flage = false;
			System.out.println(" Wrong year!");}

		boolean flage1 = true;
		if (Integer.parseInt(year1) == 2024 ) {
			if (Integer.parseInt(month1) >= 1 && Integer.parseInt(month1) <= 12) {
				
				int maxDays1;
				
				if(Integer.parseInt(month1) == 1) {
					maxDays1 = 31;
				}else if(Integer.parseInt(month1) == 2) {
					maxDays1 = 29;
				}else if(Integer.parseInt(month1) == 3) {
					maxDays1 = 31;
				}else if(Integer.parseInt(month1) == 4) {
					maxDays1 = 30;
				}else if(Integer.parseInt(month1) == 5) {
					maxDays1 = 31;
				}else if(Integer.parseInt(month1) == 6) {
					maxDays1 = 30;
				}else if(Integer.parseInt(month1) == 7) {
					maxDays1 = 31;
				}else if(Integer.parseInt(month1) == 8) {
					maxDays1 = 31;
				}else if(Integer.parseInt(month1) == 9) {
					maxDays1 = 30;
				}else if(Integer.parseInt(month1) == 10) {
					maxDays1 = 31;
				}else if(Integer.parseInt(month1) == 11) {
					maxDays1 = 30;
				}else{
					maxDays1 = 31;
				}
				if (Integer.parseInt(day1) > 0 && Integer.parseInt(day1) <= maxDays1) {
				}else {
					flage1 = false;
					System.out.println(" Wrong day!");
				}

			}
			else {
				flage1 = false;
				System.out.println(" Wrong month!");}
		}
		else {
			flage1 = false;
			System.out.println(" Wrong year!");}
		
		if(flage && flage1) {
			
			if(Integer.parseInt(month) == Integer.parseInt(month1)) {
				if(Integer.parseInt(day) < Integer.parseInt(day1)) {
					return true;
				}else {
					System.out.println(" logical day error!");
					return false;
				}
				
			}else {
				if(Integer.parseInt(month) < Integer.parseInt(month1)) {
					return true;
				}
				else {
					System.out.println(" logical month error!");
					return false;
				}
			}
			

		}else {
			return false;
		}
	}

	
	//*********************************

	//Simulation
	
		public String TextEdit(int number)//in order for the parts that write edit to appear properly on the values ​​written on the screen
		{
			if(number<10)
				return number+"    ";
			else if(number>9&&number<100)
				return number+"   ";
			else
				return number+"";
		}
		
		public String EditSatisfaction(int number)
		{
			if(number<10)		
				return number+"%"+"   ";		
			if(number>9&&number<100)
				return number+"%"+"  ";
			else
				return number+"%"+" ";
				
		}
		
		int months[]= {31,28,31,30,31,30,31,31,30,31,30,31};//last day of months
		int a=1;//A little trick to print the "Customer:" text
		
		public void SimulationCustomer(int day,int endday,int month )//To calculate the number of customers
		{						
			for(int j=day;j<=endday;j++)
			{
				int customernumber1=0;
				for(int k=0;k<reservationTable.length;k++)
				{
					if(reservationTable[k]!=null)
					{
						//Information was taken from reservationtable
						  int restartday=Integer.parseInt(reservationTable[k].getDateArrival().getDay());
						  int resendday=Integer.parseInt(reservationTable[k].getDateDeparture().getDay());
						  int restartmonth=Integer.parseInt(reservationTable[k].getDateArrival().getMonth());
						  int resendmonth=Integer.parseInt(reservationTable[k].getDateDeparture().getMonth());
						  for(int l=restartmonth;l<=resendmonth;l++)
						  {
							  if(restartmonth==resendmonth)
							  {
								  for(int m=restartday;m<resendday;m++)
								  {
									  if(m==j&&l==month)
										  customernumber1++;
								  }
							  }
							  else
							  {
								  if(l==restartmonth)
								  {
									  for(int m=restartday;m<=months[l-1];m++)
									  {
										  if(m==j&&l==month)
											  customernumber1++;
									  }
								  }
								  else if(l==resendmonth)
								  {
									  for(int m=1;m<resendday;m++)
									  {
										  if(m==j&&l==month)
											  customernumber1++;
									  }
								  }
								  else
								  {
									  for(int m=1;m<=months[l-1];m++)
									  {
										  if(m==j&&l==month)
											  customernumber1++;
									  }
								  }
							  }
						  }					  
					}
				}		
				if(a==1)
				{
					System.out.println();
					System.out.print("Customer       :   ");
					a++;
				}	
				System.out.print(TextEdit(customernumber1));			
			}
		}	
		
		double totalsatisfaction=0; //To calculate the amount of satisfaction
		int count=0; //To calculate the amount of satisfaction
		// The reason they are out of the function is that in cases 
		//where the simulation interval is more than 1 month, they will visit this function more than once.
		int b=1;
		
		public void SimulationSatisfaction(int day,int endday,int month)//Satisfaction Calculating
		{			
			for(int j=day;j<=endday;j++)
			{
				int customernumber1=0;
				for(int k=0;k<reservationTable.length;k++)
				{
					if(reservationTable[k]!=null)
					{					
						  int restartday=Integer.parseInt(reservationTable[k].getDateArrival().getDay());
						  int resendday=Integer.parseInt(reservationTable[k].getDateDeparture().getDay());
						  int restartmonth=Integer.parseInt(reservationTable[k].getDateArrival().getMonth());
						  int resendmonth=Integer.parseInt(reservationTable[k].getDateDeparture().getMonth());
						  for(int l=restartmonth;l<=resendmonth;l++)
						  {
							  if(restartmonth==resendmonth)
							  {
								  for(int m=restartday;m<resendday;m++)
								  {
									  if(m==j&&l==month)
										  customernumber1++;
								  }
							  }
							  else
							  {
								  if(l==restartmonth)
								  {
									  for(int m=restartday;m<=months[l-1];m++)
									  {
										  if(m==j&&l==month)
											  customernumber1++;
									  }
								  }
								  else if(l==resendmonth)
								  {
									  for(int m=1;m<resendday;m++)
									  {
										  if(m==j&&l==month)
											  customernumber1++;
									  }
								  }
								  else
								  {
									  for(int m=1;m<=months[l-1];m++)
									  {
										  if(m==j&&l==month)
											  customernumber1++;
									  }
								  }
							  }
						  }					  
					}								
				}
				if(b==1)
				{
					System.out.println();
					System.out.print("Satisfaction   :   ");
					b++;
				}				
				double satisfaction=0;
				if(customernumber1==0)
					satisfaction=100;
				else
					satisfaction=(3/(double)customernumber1)*100;
				
				if(satisfaction>100)
					satisfaction=100;
				totalsatisfaction+=satisfaction;
				count++;
				System.out.print(EditSatisfaction((int)satisfaction));				
			}
		}
		
		public void Simulation(Date startdate,Date enddate) {		//Main Simulation Function
			//Because of it is defined as string in Date class and 
			//we need to use these dates in for loops, we converted it to integer.
		     int startyear=Integer.parseInt(startdate.getYear());
			 int startmonth=Integer.parseInt(startdate.getMonth());
			 int startday=Integer.parseInt(startdate.getDay());
			 int endyear=Integer.parseInt(enddate.getYear());
			 int endmonth=Integer.parseInt(enddate.getMonth());
			 int endday=Integer.parseInt(enddate.getDay());		 
			boolean flag=true;
			while(flag==true)
			{
				//Checking for day mistakes,month mistakes or year mistakes.
				if(startyear!=endyear|| (startyear!=2024||endyear!=2024)) {
					flag=false;
					System.out.println("The year that can be simulated must cover the year 2024");
					break;
				}
				if(startyear==endyear&&startmonth>endmonth) {
					flag=false;
					System.out.println("The months in the file were entered incorrectly.");
					break;
				}
				if(startyear==endyear&&startmonth==endmonth&&startday>endday) {
					flag=false;
					System.out.println("The days are entered incorrectly in the file.");
				}
				// For Days
				System.out.print("Day            :   ");
				if(startmonth==endmonth)
				{				
					for(int i=startday;i<=endday;i++)
						System.out.print(TextEdit(i));									
				}
				if(startmonth!=endmonth)
				{
					for(int i=startmonth;i<=endmonth;i++)
					{
						if(i==startmonth)
						{
							for(int j=startday;j<=months[i-1];j++)
								System.out.print(TextEdit(j));
						}
						else if(i==endmonth) {
							for(int j=1;j<=endday;j++)
								System.out.print(TextEdit(j));
						}
						else {
							for(int j=1;j<=months[i-1];j++) 
								System.out.print(TextEdit(j));						
						}						
					}
				}			
				//For Customers
				for(int i=startmonth;i<=endmonth;i++)
				{
					if(startmonth==endmonth)				
						SimulationCustomer(startday,endday,i);																							
					else {
						if(i==startmonth)					
							SimulationCustomer(startday,months[startmonth-1],i);					
						else if(i==endmonth)											
							SimulationCustomer(1,endday,i);					
						else											
							SimulationCustomer(1,months[i-1],i);
						
					}
				}	
				//For Satisfaction
				for(int i=startmonth;i<=endmonth;i++)
				{
					if(startmonth==endmonth)
						SimulationSatisfaction(startday,endday,i);																							
					else {
						if(i==startmonth)					
							SimulationSatisfaction(startday,months[startmonth-1],i);					
						else if(i==endmonth)										
							SimulationSatisfaction(1,endday,i);					
						else											
							SimulationSatisfaction(1,months[i-1],i);					
					}
				}	
				//if there are other simulations in the text, 
				//we need the initial state of these values, so we revert these values ​​last.
				a=1;
				b=1;
				double average=totalsatisfaction/count;
				totalsatisfaction=0;
				count=0;
				System.out.println();
				System.out.print("Average Satisfaction = "+String.format("%.2f", average)+"%");
				break;
			}		
		}		
		
	//*********************************

	// GETTER SETTER
	public Room[] getRooms() {
		return rooms;
	}

	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}

	public Staff[] getStaffTable() {
		return staffTable;
	}

	public void setStaffTable(Staff[] staffTable) {
		this.staffTable = staffTable;
	}

	public static Customer[] getCustomerTable() {
		return customerTable.clone();
	}

	public void setCustomerTable(Customer[] customerTable) {
		this.customerTable = customerTable;
	}

	public static Reservation[] getReservationTable() {
		return reservationTable.clone();
	}

	public void setReservationTable(Reservation[] reservationTable) {
		this.reservationTable = reservationTable;
	}
}
