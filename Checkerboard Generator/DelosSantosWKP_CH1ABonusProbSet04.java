/**
 * @Title: N x N CHECKERED BOARD MAKER
 * @Description: A simple checkered board maker that will generate a board
 *               base on the user input. The input Range between 1 - 20. 
 * 
 * @Author: Willard Kent P. De los Santos (BSCS)
 */

//import java package utility to access Scanner class for the input/getting data from the user
import java.util.Scanner;

//main class or the class file name
public class DelosSantosWKP_CH1ABonusProbSet04 {
    
    //main method
    public static void main(String[] args) {
        
        //declare object from the scanner class to use input for getting the data from the user
        Scanner input = new Scanner(System.in);
        
        //declaration of variables
        int i = 0, j = 0,k=0, l=0; //these variables are all for iteration purposes
        int num = 0; //for storing the value of the size of the checkerboard
        
        System.out.println("N x N CHECKERED BOARD MAKER\n---------------------------\n");
        //prompts the user for the value of n
        System.out.print("Enter a value for N: ");
        num = input.nextInt();  //accept integer value then store it to num
        
        if(num>=1&&num<=20){
            
            // a loop for printing the checkerboard line by line
        
            //the reason why the num is multiply to 2 then added 1 is for the border and the board elements 
            for(j = 1; j<=(num*2+1);j++){
            
                //the purpose of the if else is to print the border design alternately base on the result of modulo division
                if(j%2==1){
                
                //this will print the border element or the line pattern
                    for(i = 0; i<=num; i++){
                        System.out.print("+");      //+---+---+
                        for(k = 0; k<3&&i<num; k++){
                        System.out.print("-");
                        }
                    }
                
                }
                //if the j is even then it will print the board elements █ 
                else{
                    //another if else statement to print █ in each line alternately and line by line
                
                    //l%2 will determine if it will display first ███ in the following line 
                    if(l%2==0){
                        for(i = 0; i<=num; i++){
                    
                            System.out.print("|");
                    
                            for(k = 0; k<3&&i<num; k++){
                            
                                //this if statement is for displaying ███ alternately
                                if(i%2==0)
                                    /*this will formate the value in the statement and 
                                    convert it into unicode since the ascii value 219 is not recognize  ███ */ 
                                    System.out.printf("%c", 0x2588);  
                                else 
                                    System.out.print(" ");// this will print blank spaces when you display ███ previously
                            }
                    
                        }
                    }

                    //if the condition is false then it will print first blank spaces followed ███ in the following line 

                    // ███|   |███
                    //    |███    |
                    else 
                    {
                        for(i = 0; i<=num; i++){
                    
                            System.out.print("|");
                    
                            for(k = 0; k<3&&i<num; k++){
                        
                                if(i%2==1)
                                    /*this will formate the value in the statement and 
                                    convert it into unicode since the ascii value 219 is not recognize*/
                                    System.out.printf("%c", 0x2588);
                                else 
                                    System.out.print(" ");// this will print blank spaces when you display ███ previously
                            }
                    
                        }
                    
                    }
               
                    l++; //iteration to determine whether its time to print first ███ or blank spaces
                }
            
                System.out.println("");//to add new line after printing the border or the board elements
            

            }
    
        }
        
    }

}