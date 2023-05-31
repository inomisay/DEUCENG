# DEUCENG

# Project:  DEUCENG Hotel Simulation

The aim of the project is to develop a simple Hotel Management System. 

# General Information
 
The software helps the staff to manage all activities in hotel DEUCENG. It is used to manage the records of employees, customers, the states of the rooms, and reservation operations.

# Information on Hotel Management Structures

 
* **Hotel
 
The information about the hotel, such as name, foundation date, address, phone number, and the number of stars will be managed by the software. 

* **Room**
 
Hotel DEUCENG is small with few rooms (max. 30). It has various types of rooms; including regular, deluxe, and suite. Rooms may or may not have some properties such as air-conditioning and a balcony. Each room type has different prices for each day. 

* **Staff**

The hotel staff consists of maximum 50 employees to fulfill different tasks. There are 3 types of staff; administrator, receptionist and housekeeper. There must be at least one employee for each type to run the hotel. The information about the staff, such as name, birth date, gender, address, phone number, job, and salary will be managed by the software.

* **Customer**
 
The software is used to manage the records of customers, including name, contact address, and phone number.

* **Reservation**
 
It keeps the reservation details of the customers such as customer-id, room-id, date of arrival, and date of departure. It is expected to make a reservation between 01.01.2024 and 31.12.2024. 

In addition to the aforementioned data; address (text, district, city), phone (country code, city code, number), and date (day, month, year) information will be stored in a structured format.    

System Operations
 
The software will take the commands from "commands.txt" file. All ID attributes (i.e., room-id, employee-id, customer-id) must be automatically assigned by starting from 1.

When a reservation request is given, if the request is met, the reservation is approved; otherwise, it will be ignored. 

In the search operation, the program will find and print the customer names that correspond to a given pattern. The pattern can contain only one star (*) symbol, or one-or-more question mark (?) symbol, but not both of them. For example: Zey* or Zey???. 

While the symbol (?)  corresponds to only one letter, the symbol (*) corresponds to zero or more letters. 


# Statistics
 
The software will display the following statistics:
•	The most reserved room 
•	The best customer in terms of the duration of stay
•	The net profit over the year   
Profit = Income  -  12 * SalaryExpenses  -  12 * ConstantExpenses
Constant Expense: 10,000 TL per month  
•	Monthly occupancy rate of the hotel


# Simulation of Customer Satisfaction
 
For each day; a housekeeper can fully clean only 3 rooms. 
DailyCustomerSatisfaction = 3 / NumberOfCustomers 
Daily customer satisfaction must be equal to or less than 100%.

<img width="987" alt="Screen Shot 2023-05-31 at 15 15 38" src="https://github.com/inomisay/DEUCENG/assets/98346164/6a9b7a45-9898-4eab-ad4b-405f81d8388d">
<img width="586" alt="Screen Shot 2023-05-31 at 15 17 15" src="https://github.com/inomisay/DEUCENG/assets/98346164/a06440ad-1eee-4913-b1d8-eec6f27d2482">
<img width="530" alt="Screen Shot 2023-05-31 at 15 17 28" src="https://github.com/inomisay/DEUCENG/assets/98346164/00a10b7a-99fb-4a1d-a0f9-779f6c26c09c">



