/**
 * @Title: MONTHLY CALENDAR MAKER
 * @Description: A program that generate a monthly calendar base on the user inputs.
 *               the program will also determine if the year entered is a leap year,
 *               thus it will change the no. of days of FEBRUARY into 29. for example
 *               the user enter 2019 and chose march and the first day of the month is
 *               friday then the program will generate a calendar for March 2019.
 *                
 * @Author: Willard Kent P. De los Santos (BSCS)
 */
 
//import java package utility to access Scanner class for the input/getting data from the user
import java.util.Scanner;

//main class or the class file name
public class DelosSantosWKP_CH1AProbSet03
{
    //main method
	public static void main(String[] args) {
	    
	    //declare object from the scanner class to use input for getting the data from the user
	    Scanner input = new Scanner(System.in);
	    
	    //declaration of variables
	    int year = 0; //storing the values of year
	    int month = 0; //storing the choice for month
	    int fday = 0; //storing the choice for first day of the month
	    int ctr = 1; //variables for displaying days/ no. of days
	    int j=0, k=0; //for iteration purposes
	    
	    String d[]= {"SU", "MO", "TU", "WE", "TH", "FR", "SA"}; //string array for the abbreviation of 7 days for display
	    
	    int daym[]= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //int array for determining no. of days in a month
	    
	    //string array for the display of month depending on the choice of user
	    String amonth[]={"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
	    
	    System.out.println("MONTHLY CALENDAR MAKER\n----------------------\n");
	    //prompts the user to enter the year
		System.out.print(">> Enter the year: ");
		year = input.nextInt(); //accept integer value for the year
		
		//determine if the year is a leap year
		if(year%4==0) 
		daym[1]=29; //if leap year then assign 29 to 2nd element of an array
		
		//prompts the user the choices for months with corresponding number
		System.out.println("\n>> Select a Month: ");
		System.out.println("\t[ 1] - JANUARY\t\t[ 7] - JULY");
		System.out.println("\t[ 2] - FEBRUARY\t\t[ 8] - AUGUST");
		System.out.println("\t[ 3] - MARCH\t\t[ 9] - SEPTEMBER");
		System.out.println("\t[ 4] - APRIL\t\t[10] - OCTOBER");
		System.out.println("\t[ 5] - MAY\t\t[11] - NOVEMBER");
		System.out.println("\t[ 6] - JUNE\t\t[12] - DECEMBER");
		
		System.out.print("\n\t- Enter your choice: ");
		month = input.nextInt(); //aceept integer value for the choice of month
		
		//prompts the user the choices on the first day of the month with corresponding number
		System.out.println("\n>> Select a First Day of the month: ");
		System.out.println("\t[1] - SUNDAY\t\t[5] - THURSDAY ");
		System.out.println("\t[2] - MONDAY\t\t[6] - FRIDAY ");
		System.out.println("\t[3] - TUESDAY\t\t[7] - SATURDAY");
		System.out.println("\t[4] - WEDNESDAY");
		
		System.out.print("\n\t- Enter your choice: ");
		fday = input.nextInt(); // accept integer value for the first day of the month
		
		input.close();
		//display the selected month and year
		System.out.print("\n\n>> "+amonth[month-1]+", "+year);
		
		System.out.println("\n\t");
		System.out.print("\t");
		
		//the following loops are for displaying the calendar
		
		//this loop will display the abbreviation of the 7 days       //SU  MO  TU  WE 
		for(k=0;k<7;k++){                                             //
		        System.out.print(d[k]+"  ");
		    }
		System.out.println("");
		
		//this for loop will display the numbers in a month starting from the 1st day 6x7 format
		for(j=0; j<6;j++){
		    System.out.print("\t");
		    
		    for(k=0;k<7;k++){
		        //determine if the day is stil not the first day 
		        if(j==0&&k<fday-1){
		            System.out.print("    "); //display blank spaces on the day before the first day 
		        }
		        
		        //if the condition above returns false value then in following statement display the numerical day value in a month 
		        else{
		            //determine if ctr is less than or equal to the no. of days in month 
		            if(ctr<=daym[month-1]){
		                System.out.printf("%02d", ctr); //formats the number if ctr is less than 10 then add 0 before the number  01 02
		                System.out.print("  ");
		                ctr++; //iterate the days to be printed
		            }
		            //if false
		            else{
		                continue; //skip rest of the statement then continue running the loop
		            }
		            
		        }
		    }
		    System.out.print("\n");
		}
		
		
		
		
	}
}
