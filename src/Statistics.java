import java.util.Arrays;

public class Statistics {
	static int amount = 0;
	
	public static int[] MostDays() //This is function that returns an array of the days customer have spent in the hotel.
	{
		  Reservation[] reservations=Managing.getReservationTable(); //Clones the reservation table from the Managing class.
		  
		  int[] dayy=new int[reservations.length]; //stores arrival day.
		  int[] monthh=new int[reservations.length]; //stores arrival month.
		  int[] yearr=new int[reservations.length]; //stores arrival year.
		  int[] day1=new int[reservations.length]; //stores departure day.
		  int[] month1=new int[reservations.length]; //stores departure month.
		  int[] monthsinhotel=new int[reservations.length]; //store how many months a customer has spent in the hotel.
		  int[] daysinhotel=new int[reservations.length]; //stores how many days a customer has spent in the hotel.
		  String[] sepdep=new String[reservations.length]; //stores the whole departure date as a string.
		  String[] separr=new String[reservations.length]; //stores the whole arrival date as a string.
		  for(int i=0; i<reservations.length; i++)
		  {
			  if(reservations[i]!=null)
			  {
				   sepdep = reservations[i].getDateDeparture().displayDateForReservationList().split("[.]"); //splits the departure date from the reservation table from the Managing class.
				   separr = reservations[i].getDateArrival().displayDateForReservationList().split("[.]"); //splits the arrival date from the reservation table from the Managing class.
			  
		           day1[i] = Integer.parseInt(sepdep[0]); month1[i] = Integer.parseInt(sepdep[1]); 
		           dayy[i] = Integer.parseInt(separr[0]); monthh[i] = Integer.parseInt(separr[1]); yearr[i] = Integer.parseInt(separr[2]);
		 
		           monthsinhotel[i] = month1[i] - monthh[i]; //calculates the months customers have spent in the hotel.
		           
			       if(monthsinhotel[i] == 0) daysinhotel[i] = day1[i] - dayy[i]; //if the reservation is in the same month it calculates the days spent in the hotel just by subtracting the arrival day from the departure day.
			       else {
			          daysinhotel[i] = Statistics.dayinbetween(monthh[i], monthsinhotel[i] ,dayy[i], yearr[i], day1[i]); //if the reservation isn't in the same month it calculates the days spent in the hotel by using the dayinbetween function.
			       }
		       }
		  }
			return daysinhotel.clone();
	}
	public static void months(Object[][][] a) //This function gets an array from the fourtstat function and displays the fourth statistic.
	{
		amount=Room.getAllRoomIDs(); //gets the total amount of rooms that has been added.
		String[] enterdates=new String[a.length]; //stores the arrival dates.
		String[] exitdates=new String[a.length]; //stores the departure dates.
		int[] enterdays=new int[100]; //stores the arrival days.
		int[] entermonths=new int[100]; //stores the arrival months
		int[] exitdays=new int[100]; //stores the departure days.
		int[] exitmonths=new int[100]; //stores the departure months.
		int[][] months= new int[13][100]; //stores the twelve months and the room numbers of the rooms that are reserved that month.
		
		
		for(int i=0; i<a.length-1; i++)
		{
			
			enterdates[i]=(String) a[i+1][0][0];
			String[] sepdep=enterdates[i].split("[.]"); //splits the arrival dates.
			enterdays[i]=Integer.parseInt(sepdep[0]); //stores the arrival days as integers.
			entermonths[i]=Integer.parseInt(sepdep[1]); //stores the arrival months as integers.
			
			exitdates[i]=(String) a[0][i+1][0];
			String[] sep=exitdates[i].split("[.]"); //splits the departure dates.
			exitdays[i]=Integer.parseInt(sep[0]); //stores the departure days as integers.
			exitmonths[i]=Integer.parseInt(sep[1]); //stores the departure months as integers.
			
		   
			for(int j=0; j<12; j++)
			{
				for(int k=0; k<100; k++)
				{
					months[j][0]=j+1;
					
					if(months[j][0]<=exitmonths[k]&&months[j][0]>=entermonths[k])
					{
						months[j][k+1]=(int)a[0][0][k+1];
					}
				}
			}
		}
		
		 int[][] daysnmonths=new int[13][100];
		 
		 for(int i=0; i<13; i++)
		 {
			  daysnmonths[i][0]=i+1;
			  for(int j=1; j<100; j++)
			  {
				  if(months[i][0]>=entermonths[j-1]&&months[i][0]<=exitmonths[j-1])
				  {
					 
					 if(entermonths[j-1]==exitmonths[j-1])
					 {
						 daysnmonths[i][j]=exitdays[j-1]-enterdays[j-1]+1;
					 }
					 else
					 {
						 if(entermonths[j-1]!=exitmonths[j-1]&&(i+1)<exitmonths[j-1])
						 {
						   daysnmonths[i][j]=daysinmonths(daysnmonths[i][0],2024);
						 }
					     if(months[i][0]==entermonths[j-1])
					     {
						   daysnmonths[i][j]=daysinmonths(daysnmonths[i][0],2024)-enterdays[j-1]+1;
					     }
					     if(months[i][0]==exitmonths[j-1])
					     {
						   daysnmonths[i][j]=exitdays[j-1];
					     }
					 }
				  }
			  }
		 }
		 
		 double ratio[] = new double[months.length];
		 int[] numerator=new int[months.length];
		 int[] denominatorc=new int[months.length];
		 int[] denominator=new int[months.length];
		 for(int i=0; i<months.length; i++)
		 {
			 numerator[i]=0;
			 denominatorc[i]=amount;
			 denominator[i]=0;
		     for(int j=1; j<100; j++)
		     {
		    		
		    		if(daysnmonths[i][j]!=0)
		    		{
		    			numerator[i]+=daysnmonths[i][j];
		    		}
		     }
		     for(int j=1; j<100; j++)
		     {
		    		if(denominatorc[i]!=0)
		    		{
		    			denominator[i]=denominatorc[i]*daysinmonths(i+1,2024);
		    		}
		     }
	      }
		 int sol = 0;
		 String[] display=new String[denominator.length];
         for(int i=0; i<denominator.length; i++)
         {
        	  if(denominator[i]!=0)
        	  {
        		  int ax=numerator[i];
        		  int bx=denominator[i];
        		  
        		  sol=(ax*100)/(bx);
        		  ratio[i]=sol;
        	  }
         }
        
         for(int i=0; i<denominator.length; i++)
         {
        	  display[i]=Double.toString(ratio[i]);
        	  String[] format=display[i].split("[.]");
        	  display[i]=format[0]+"%";
         }
 
		 for(int i=0; i<12; i++)
		 {
			 System.out.print("    " +(i+1)+"-) "+ display[i]+" ");
		 }
	}
	public static int daysinmonths(int a,int b) // This function returns the amount of days in the desired month.
	{
		int output = 0;
		if(a==2) {
			if(b%4!=0) {
				 output=28;
			}
			else output=29;
		}
		if(a==1||a==3||a==5||a==7||a==8||a==10||a==12) output=31;
		if(a==4||a==6||a==9||a==11) output=30;
		
		return output;
	}
	public static int dayinbetween(int m, int b, int d, int y,int d1) // This function returns the amount of day difference between two dates.
	{
		int dayleft=daysinmonths(m,y)-d;
		int dayprior=d1;
		int x=0;
		int z=1;
		while(m+z<m+b)
		{
			x+=daysinmonths(m+z,y);
			z++;
		}
		return x+dayleft+dayprior;
	}
	public static String formatPrices( int b) // This function formats prices so that they have ',' in every thousands place.
	{
		int s1, e1,s2,e2;
	    String a=Integer.toString(b);
	    String firstPart;
	    String SecondPart;
	    String display = "";
	    String fi;
	    if(a.length()>3)
	    {
	        s1=0;
	        e2=a.length();
	        s2=e2-3;
	        e1=s2;
	    
		    firstPart=a.substring(s1,e1);
		    SecondPart=a.substring(s2, e2);
		    fi=a.substring(0,1);
		    
		    if(firstPart.length()>3&&!(fi.equals("-")))
		    {
			   String f=firstPart.substring(0,firstPart.length()-3);
			   String e=firstPart.substring(firstPart.length()-3,firstPart.length());
			   firstPart=f+","+e;
		    }
		    display=firstPart+","+SecondPart;
	    }
	    else
	    {
	    	display=a;
	    }
		    return display;
	}
	public static String[] formatPricesinArray( String[]b) //This function formats prices in a string array so that they have ',' in every thousands place.
	{
		int s1, e1,s2,e2;
	    String firstPart;
	    String SecondPart;
		String[] display=new String[b.length];
	    for(int i=0; i<b.length; i++)
	    {
	    	if(b[i].length()>3)
	    	{
	    	   s1=0;
	    	   e2=b[i].length();
		       s2=e2-3;
		       e1=s2;
			   firstPart=b[i].substring(s1,e1);
			   SecondPart=b[i].substring(s2, e2);
			   if(firstPart.length()>3)
			   {
				  String f=firstPart.substring(0,firstPart.length()-3);
				  String e=firstPart.substring(firstPart.length()-3,firstPart.length());
				  firstPart=f+","+e;
			   }
			   display[i]=firstPart+","+SecondPart;
	    	}
	    	else
	    	{
	    		display[i]=b[i];
	    	}
	    }
	    return display.clone(); 
	}
	public static void displayIncome(String[]a, String b) //This function displays income values in a desired way.
	{
		
		for(int i=0; i<a.length; i++)
		{
			if(i==0)
				System.out.print(" 3-)Income = "+a[i]+" + ");
			if(i!=a.length-1&&i!=0)
			    System.out.print(a[i]+" + ");
			if(i==a.length-1)
				System.out.print(a[i]+" = "+b+"\n");
		}
	}
	public static void firststat() //This function displays the first statistic.
	{
		Reservation[] reservations=Managing.getReservationTable();
        int[] roomno=new int[reservations.length];
        
        for(int i=0; i<reservations.length; i++)
        {
        	if(reservations[i]!=null)
        	{
        	  roomno[i]=reservations[i].getRoom_ID();
        	}
        }
		
		int[][] months= new int[100][2];
		
		
		int[] tr=MostDays();
		for(int i=0; i<100; i++)
		{
			months[i][0]=roomno[i];
			months[i][1]=tr[i];
		}
		for(int i=0; i<100; i++)
		{
			//System.out.println(months[i][0]+" "+months[i][1]);
		}
		
		int roomsndays[][]=new int[100][2];
		for(int i=0; i<100; i++)
		{
			roomsndays[i][0]=months[i][0];
			roomsndays[i][1]=months[i][1];
			
		}
		
		for(int i=0; i<100; i++)
		{
			for(int j=1; j<100; j++)
			{
				if(roomsndays[i][0]==roomsndays[j][0]&&i!=j)
				{
					roomsndays[i][0]=0;
					roomsndays[j][1]+=roomsndays[i][1];
					roomsndays[i][1]=0;
				}
			}
		}
		
		Arrays.sort(roomsndays, (a, b) -> b[1] - a[1]);
		
		for(int i=0; i<100; i++)
		{
			//System.out.println(roomsndays[i][0]+" "+roomsndays[i][1]);
		}
		
		
		System.out.println(" 1-)The most reserved room = Room #"+roomsndays[0][0]);
	}
	public static void secondstat() //This function displays the second statistic.
	{
		
		Customer[] customers=Managing.getCustomerTable();
		Reservation[] reservations=Managing.getReservationTable();
		Object[][]d=new Object[customers.length][2];
		int[]a=MostDays();
		int [][] numbers=new int[customers.length][2];
		Object [][] roomxcust=new Object[customers.length][2];
		for(int i=0; i<customers.length; i++)
		{
			numbers[i][0]=a[i];
			if(customers[i]!=null)
			{
				d[i][0]=customers[i].getName()+" "+customers[i].getSurname();
				d[i][1]=customers[i].getCustomerID();
						
			}
			if(reservations[i]!=null)
			{
				numbers[i][1]=reservations[i].getRoom_ID();	
				roomxcust[i][0]=reservations[i].getRoom_ID();
				roomxcust[i][1]=reservations[i].getCustomer_ID();
			}
		}
		
		for(int i=0; i<100; i++)
		{
			for(int j=0; j<100; j++)
			{
				if((Object)numbers[i][1]==roomxcust[j][1])
				{
					roomxcust[i][0]=numbers[i][0];
				}
			}
		}
		
		for(int i=0; i<100; i++)
		{
			for(int j=0; j<100; j++)
			{
				if(roomxcust[i][1]==d[j][1])
				{
					roomxcust[i][1]=d[j][0];
				}
			}
		}
		

		int transfer[]=new int[customers.length];
		for(int i=0; i<100; i++)
		{
			if(roomxcust[i][0]!=null)
			{
				transfer[i]=(int)roomxcust[i][0];
			}
			
			for(int j=1; j<100; j++)
			{
				if(roomxcust[i][1]==roomxcust[j][1]&&i!=j)
				{
					transfer[i]+=transfer[j];
				}
			}
		}
		
		for(int i=0; i<100; i++)
		{
			roomxcust[i][0]=transfer[i];
		}
		
		int max=0;
		for(int i=0; i<100; i++)
		{
			max=(int) roomxcust[i][0];
			for(int j=1; j<100; j++)
			{
				if ((int)roomxcust[j][0] > max)
	                max = (int) roomxcust[j][0];
			}
		}
		
		String name="";
		for(int i=0; i<100; i++)
		{
			if((int)roomxcust[i][0]==max)
			{
				name=(String) roomxcust[i][1];
			}
		}
		
		for(int i=0; i<100; i++)
		{
			//System.out.println(roomxcust[i][1]+" "+roomxcust[i][0]);
		}
		
		
		System.out.println(" 2-)The best customer = "+name+" --------> "+max);
	}
	public static void thirdstat() //This function displays the third statistic.
	{
		int[] roomno=Main.getRoomNo();
		int[] prices=Main.getRoomPrices();
		int[] noofrooms=Main.getAmounts();
        int[][] noxprices=new int[roomno.length+1][roomno.length+1];
        int[] daysspent=MostDays();
        
        for(int i=0; i<noofrooms.length; i++) //Assigning the values in noofrooms and prices array to an new 2d array to connect them.
        {
        	noxprices[i+1][0]=noofrooms[i];
        	noxprices[0][i+1]=prices[i];
        }
        	
        int[] pr=new int[100];
        int[][] idxpr=new int[100][2];
        int z=0;
        for(int i=0; i<100;i++)
        {
            for(int j=i; j<noxprices[i][0]+i; j++)
        	{
        		pr[z]=noxprices[0][i];
        		z++;
        	}
        }
        
        int[][] iddxpr=new int[100][2];
        for(int i=0; i<100;i++)
        {
        	iddxpr[i][0]=roomno[i];
            idxpr[i][0]=(i+1);
            idxpr[i][1]=pr[i];
        }
        for(int i=0; i<100;i++)
        {
        	if(idxpr[i][1]==0)
        	{
        		idxpr[i][0]=0;
        	}
        }
        
        for(int i=0; i<100; i++)
        {
        	for(int j=0; j<100; j++)
        	{
        	   if(iddxpr[i][0]==idxpr[j][0])
        	   {
        		  iddxpr[i][1]=idxpr[j][1];
        	   }
        	}
        }
       
        int zt=0;
        for(int i=0; i<100; i++)
        {
        	if(iddxpr[i][0]!=0)
        	{
        		zt++;
        	}
        }
        int[] income=new int[100];
        
        int TotalIncome=0;
        for(int i=0; i<100; i++)
        {
        	income[i]=iddxpr[i][1]*daysspent[i];
        	TotalIncome+=income[i];
        }
        
        int[] refined1=new int[zt];
        int count1=-1;
        for(int i=0; i<zt; i++)
        {
        	if(income[i]!=0)
        	{
        		refined1[++count1]=income[i];
        	}
        }
        income=Arrays.copyOf(refined1, count1+1);
        
        String transfer[]=new String[income.length];
        String formattedIncome[]= new String[income.length];
        for(int i=0; i<income.length; i++)
        {
        	transfer[i]=Integer.toString(income[i]);
        }
        formattedIncome=formatPricesinArray(transfer);
        
		int constantExpenses=10000*12;
		int[] salaries=Main.getSalaries();
		int total=0;
		for(int i=0; i<100; i++) 
		{
			total+=(salaries[i]*12); 
		}
		int profit=TotalIncome-total-constantExpenses;
		
		String displaySalary=formatPrices(total);
		String displayExpenses=formatPrices(constantExpenses);
		String displayTotalIncome=formatPrices(TotalIncome);
		String displayProfit=formatPrices(profit);

		displayIncome(formattedIncome, displayTotalIncome);
		System.out.println("    Salary = "+displaySalary);
		System.out.println("    Constant expenses = "+displayExpenses);
		System.out.println("    Profit = "+displayTotalIncome+" - "+displaySalary+" - "+displayExpenses+" = "+displayProfit );
		
	}
	public static void fourthstat() //This function creates the array that is used in the months function to display the fourth statistic.
	{
		Reservation[] reservations=Managing.getReservationTable();
		String[] enter=new String[reservations.length];
        String[] exit=new String[reservations.length];
        int[] roomno=new int[reservations.length];
        
        for(int i=0; i<reservations.length; i++)
        {
        	if(reservations[i]!=null)
        	{
        	  enter[i]=reservations[i].getDateArrival().displayDateForReservationList();
        	  exit[i]=reservations[i].getDateDeparture().displayDateForReservationList();
        	  roomno[i]=reservations[i].getRoom_ID();
        	}
        }
		
		int count1=-1;
		String[] transfer1=new String[enter.length];
		for (String s: enter)
		{
			if(s!=null)
			{
				transfer1[++count1]=s;
			}
		}
		enter=Arrays.copyOf(transfer1,count1+1);
		
	    Object[][][] control=new Object[enter.length+1][enter.length+1][enter.length+1];
	    
	    for(int i1=0; i1<enter.length; i1++)
	    {
	    	control[i1+1][0][0]=enter[i1];
	    	control[0][i1+1][0]=exit[i1];
	    	control[0][0][i1+1]=roomno[i1];
	    	
	    }
	    
		System.out.println(" 4-)Monthly occupancy rate");
		months(control);
	}
}