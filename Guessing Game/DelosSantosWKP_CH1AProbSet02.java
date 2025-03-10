/**
 * @Title: GUESSING GAME PROGRAM
 * @Description:  A guessing game program that will generate a random number from 1 - 100 then 
 *                the user will guess the generated number. The players are given 5 chances to
 *                guess the number. If the player somehow cannot guess the number, the program 
 *                will ask if he/she wants to play again. After all of the the program will
 *                display the game statistics that includes the total number of games, win rate
 *                and loss percentage.
 * @Author: Willard Kent P. De los Santos (BSCS)
 */
 
//import java package utility to access Scanner class for the input/getting data from the user
import java.util.Scanner;
//import java package utility to access Random class for generating random number
import java.util.Random;

//main class or the class file name 
public class DelosSantosWKP_CH1AProbSet02
{
    //main method
	public static void main(String[] args) {
	    
	    //declare object from the scanner class to use input for getting the data from the user
	    Scanner input = new Scanner(System.in);
	    //declare object from the Random class to use rand for generating random numbers
	    Random rand = new Random();
	    
	   
		System.out.println("GUESSING GAME PROGRAM");
        System.out.println("---------------------");
        
        // variable declaration
        char ans = 'n';         // use for storing the answer of the if they wants to continue using the program
        int i = 1;              // for iteration purposes 
        int guess = 0;          // for storing the value of the guess of the user
        int game = 0;           // for counting the number of games
        double win = 0;         // for counting the number of win
        double lost = 0;        // for counting the number of loss
        int randnum = 0;        // for storing random generated numbers
        boolean won = false;    // for specifying in a condition that the user won but it has default false value to avoid bug/error
        
        //a loop that run first the following statement
        do{
            
            System.out.println("\n---------------------------------------");
            System.out.println("The computer pick a number from 1 - 100");
            System.out.println("You have 5 try to guess the number ");
            System.out.println("---------------------------------------");
            
            randnum = rand.nextInt(99)+1;; //generate a unique number each time then store it to randnum
            
            //a for loop that allows the user to guess five times
            for(i=1;i<=5;i++){
                //prompts the user to enter their guess
                System.out.print("  "+i+": Enter your guess: ");
                
                guess = input.nextInt(); //accept inputs from the user then store it to guess
                
                //determine if the guess of the user is correct
                if(guess == randnum){
                    //display that the guess is correct
                    System.out.println("\t- Your guess is CORRECT");
                    won = true; // the value of won will be true to use the variable in another condition then run the statement inside it
                    win++; //add 1 win in the win variable/iteration
                    break; //terminate the loop immediately to run the next statement
                }
                
                //the following provide clues for the user
                
                //determine if the guess is less than the generated number 
                else if(guess < randnum){
                    //display clue that the guess is low
                    System.out.println("\t- Your guess is too low");
                }
                //if neither of the two are true run the statement inside the else clause
                else{
                    //display clue that the guess is high
                    System.out.println("\t- Your guess is too high");
                }
            }
            
            //determine if the user won 
            if(won)
                System.out.println(">> You WON the game"); //display that the user won the game
            
            //if the condition is false run the statement inside the body    
            else{
            //display the generated number then prompts the user the they loss the game
            System.out.println(">> The number is " + randnum);
            System.out.println(">> You LOSS the game");
            lost++; // add 1 loss to the user/iteration
            }
            System.out.println("---------------------------------------");
            
            game++; // add 1 if the user finish 1 game /iteration
            
            //prompts the user if they want to play again
            System.out.print("\nDo you want to play again[y/n]: ");
            
            ans = input.next().charAt(0); //accept 1 Character values from the inputs of the user then store it to ans
            
            won = false; //won will be back to its default values so that there will be no bug when executing the whole game once again
            
            
            
        }while(ans=='y'); //condition to repeat the whole statement depending if the answer of the user is a character value 'y'
        
        //display the game statistics: win & loss percentage
        System.out.println("\nGame Statistics");
        System.out.println("------------------");
        System.out.println("No. of games: " + game);
        System.out.print("No. of win  : " + (int)win + " (");
        System.out.printf("%.1f)",  ((win/game)*100)); //formats the value to display 1 decimal value
        System.out.println("%)");
        System.out.print("No. of loss : " + (int)lost + " (");
        System.out.printf("%.1f)",  ((lost/game)*100)); //formats the value to display 1 decimal value
        System.out.println("%)");
        
        
        
	}
}
