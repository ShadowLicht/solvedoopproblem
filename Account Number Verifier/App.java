/**
 * @Title: ACCOUNT NUMBER VERIFIER
 * @Description: A program that will accept a number of string account numbers
 * 				 then verify each account number if it is valid or invalid. An
 * 				 Account is valid if the sum of 1st, 2nd, 5th, and 7th digit is
 * 				 equal to the last digit. Otherwise if the account number contains
 * 				 any character aside from digit, not an 8 digit, and the sum is not
 * 				 equal to the last/8th digit then it us consider invalid. After that, 
 * 				 it will display the number of valid and invalid account numbers.
 * 				
 * 
 * @Author: Willard Kent P. De los Santos (BSCS)
 * @DateCreated: 9/23/2022
 */

 //import java package utility to access Scanner class for the input/getting data from the user
 import java.util.Scanner;

 //main class or the class file name
 public class App
 {
     //main method
     public static void main(String[] args) {
          //declare object from the scanner class to use input for getting the data from the user
         Scanner sc = new Scanner(System.in);
         //VARIABLE DECLARATION
 
         //storage location for storing integer number
         int snum = 0, sum = 0, len = 0, num = 0, lastnum = 0;
         //counter variable for valid and invalid
         int val = 0, inval = 0;
         //iteration purposes
         int i = 0, j = 0, strlen = 0;
         //temporary storage for character value
         char strchar = ' ';
         //storage location for storing string value
         String lsum = "";
         //variable for account number
         String acctnum = "";
 
         //display title
         System.out.println("ACCOUNT NUMBER VERIFIER");
         System.out.println("----------------------- ");
         
         //prompts the user on how many account numbers to be verified
         System.out.print(">> Enter the numbers of account numbers to be verified: ");
         //get an integer input from the user then store to num
         num = sc.nextInt();
         
         //a for loop that run the series of statement base on the number of account numbers to be verified
         for(i = 0; i<num; i++){
         //prompts the user to enter an 8 digit number
         System.out.print("\n>> Enter an 8-digit account number: ");
         acctnum = sc.next(); //receive an input in string then store it to acctnum
 
         //get the length of acctnum then store it to strlen
         strlen = acctnum.length();
 
         //check if the acctnumber is an 8 digit number
         if(strlen==8){
         //condition is true
 
         //a for loop that get the sum of 1st, 2nd, 5th and 7th digit then compare it to the value of last digit
         for(j = 0; j<8; j++){
             strchar = acctnum.charAt(j); //get 1 character base on the index given then store it to strchar
             
             //determine if each character in the string is consider as digit
             if(strchar>=48&&strchar<=57){
                 //this will convert the each digit extracted in the acctnum to integer using parseInt then store it to snum
             snum = Integer.parseInt(acctnum.substring(j, j+1));
             
             //check if the digit is the 1st or 2nd or 5th or 7th digit (or since I use or operator)
             if(j == 0 || j==1 || j==4 || j==6){
                 //condition is true 
 
                 sum+=snum; //add the value of snum to sum
                
                 continue;
             }
             
             //this if statement is to determine if snum holds the last digit
             if(j==7){
 
                 //convert the value of sum to string then store it to lsum
                 lsum = Integer.toString(sum);
 
                 //get the length of lsum the store it to len
                 len = lsum.length();
 
                 //extract the last digit in the lsum and convert it into integer then store it to lastnum
                 lastnum = Integer.parseInt(lsum.substring(len-1, len)); //1 5
 
                 //check if the sum is equal to the last or 8th digit
                 if(lastnum == snum){
                 val++;//iterate val or the valid
                 //display the account number is valid
                 System.out.println("\t-- "+ acctnum +" is valid account number");
                 }
                 else{
                 inval++;//iterate inval or the invalid
                 //display the account number is invalid
                 System.out.println("\t-- "+ acctnum +" is invalid account number");
                 }
             }
             
            }
 
            //else if the acct number contain other character aside from digit
            else{
                inval++;//iterate inval or the invalid
                //display the account number is invalid
                System.out.println("\t-- "+ acctnum +" is invalid account number");
 
                break;//terminate the loop immediately
            }
            
         }
         
         }
 
         //else if the length is not equal to 8 or it is not an 8 digit account number
         else{
             inval++;
             System.out.println("\t-- "+ acctnum +" is invalid account number");
         }
         
         
         }
         
         //display the number of valid and invalid account numbers
         System.out.println("\n\n-- No. of Valid Account Number(s): " + val);
         System.out.println("-- No. of Invalid Account Number(s): " + inval);
         
     }
 }
 