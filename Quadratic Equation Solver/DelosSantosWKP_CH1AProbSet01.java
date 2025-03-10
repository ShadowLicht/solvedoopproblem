/**
 * @Title: Quadratic Equation & Quadratic Formula
 * @Description: In mathematics, the best way to solve a quadratic equation (ax2 + bx + c = 0)is by using the quadratic
 *               formula:x = −b ± √bଶ − 4ac2a Using the discriminant (b2-4ac), we can determine the possible type of 
 *               answers:When (b2-4ac) is positives, there are two possible values for x. When (b2-4ac)is zero, there 
 *               is one possible value for x. And when (b2-4ac), the values of xare imaginary (Imaginary Roots).
 *               Write a program that will ask a user to entera value for a, b, and c. Then check if the input is a 
 *               quadratic equation (a isnot equal to 0). If valid, compute and display the possible values of x
 *               (roundoff in 2 decimal places). The program must also handle multiple sets of inputand number the
 *               sets from 1 to N.
 * @Author: Willard Kent P. De los Santos (BSCS)
 */


//import java package utility to access Scanner class for the input/getting data from the user
import java.util.Scanner;

//main class or the class file name 
public class DelosSantosWKP_CH1AProbSet01
{
    //main method
	public static void main(String[] args) {
	    
	    //declare object from the scanner class to use input for getting the data from the user
	    Scanner input = new Scanner(System.in);
		try{
	    
	    //variable declaration
	    int numinputs = 0; // to determine the number of inputs the user wants to be processed
	 
	    int i = 1; // for iteration purposes
	    
	    int a = 0, b = 0, c = 0; // storage location for the values of a, b, c from the QUADRATIC EQUATION
	    
	    double x1 = 0, x2 = 0, x = 0; //storage location for the values of roots of QUADRATIC EQUATION
	    double deter; // storage location for the discriminant/determinant of the QUADRATIC EQUATION
	    
	    //prompts the user for input
	    System.out.println("QUADRATIC EQUATION & QUADRATIC FORMULA");
	    System.out.println("--------------------------------------");
	    System.out.print("Enter the number of inputs to be processed: ");
	    
	    numinputs = input.nextInt(); //get the value entered by the user then store it to num inputs
	    
	    //a for loop to repeat the following statement base on the number of inputs specified by the user
	    for(i = 1; i<=numinputs; i++){
	    
	    //prompts the user for the inputs of a, b, and c    
	    System.out.println("\nInput " + i +":");
		System.out.print("Enter a value for A, B, & C (A B C): ");
		
		//get the values entered by the user then store it to variable a, b, and c
		a = input.nextInt(); 
		b = input.nextInt(); 
		c = input.nextInt();

				
		//display the Quadratic Equation
		System.out.println(">> Q.E.: " + a + "x^2 + " + b + "x + " + c + " = 0");
		
		//if statement that will determine if the inputs of the user are valid
		if(a!=0)
        {
            deter = b * b - 4 * a * c; //assignment statement that will calculate the discriminant
            
            //display the discriminant
            System.out.print("Discriminant: " + deter);
		    /*determine if the discriminant is greater than 0 then run the statement inside the body
		    if true then there are two possible root values*/
		    if(deter>0){
		        
		        x1 = (-b + Math.sqrt(deter)) / (2 * a); //calculate the value of the 1st root then store it to x1
                x2 = (-b - Math.sqrt(deter)) / (2 * a); //calculate the value of the 2nd root then store it to x2
                
                //display the result/values of the roots
                System.out.print("\n>> X1 = ");
		        System.out.printf("%.2f",  x1); //formats the value of x1 to display 2 decimal values
		        System.out.print(", X2 = ");
		        System.out.printf("%.2f",  x2); //formats the value of x2 to display 2 decimal values
		    }
		    
		    /*determine if the discriminant is eaual to 0
		    if true then there is only 1 root value*/
		    else if (deter==0){
		        
		        x = -b / (2 * a); //calculate the value of the root
		        
		        //display the value of the root
		        System.out.print("\n>> X = ");
		        //formats the value of x to display 2 decimal values
		        System.out.printf("%.2f",  x);
		    }
		    //if neither of the two is true then the root value is imaginary
		    else{
		        System.out.print("\n>> X = IMAGINARY ");
		    }
		}
		
		//else clause if the inputs are invalid
		else{
		    System.out.print(">> INVALID: It is not a Quadratic Equation ");
		}
		System.out.println("");
		
	    }

	}finally{
		input.close();
	}
		
	}
	
}
