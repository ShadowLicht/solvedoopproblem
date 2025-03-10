/**
 * @Title: PALINGRAM IDENTIFIER
 * @Description: A program that will check if the given phrase is 
 *               a letter palingram, word palingram and both.
 * 
 * @Author: Willard Kent P. De los Santos (BSCS)
 * @DateCreated: 9/23/2022
 */

//import java package utility to access Scanner class for the input/getting data from the user
import java.util.Scanner;

//main class or the class file name
public class WillardWKP_CH1BProbSet03 {

    //main method
    public static void main(String[] args) {

        //declare object from the scanner class to use input for getting the data from the user
        Scanner sc = new Scanner(System.in);

        //VARIABLE DECLARATION
        //to store a string values entered by user inside the variable phrase
        String phrase;
        //to store answer of user if they want to try again
        char ans;

        //Display title of program
        System.out.println("PALINGRAM IDENTIFIER");
        System.out.println("--------------------");

        //do while to execute the following series of statement then repeat base on the user inputs
        //do while is the most suitable type of loop to perform a repeatble task in the program base on the user decision
        do{
        //prompts the user to enter a phrase or sentence
        System.out.print("\n>> Enter a phrase/sentence: ");
        //get the value entered by the user then store it to phrase
        phrase = sc.nextLine();

        //call the method formatstring with the parameter of string and values of phrase then runs 
        //the series of statement inside it and store the returned value to phrase
        //this method will format the string so that it will be easy to use it in the condition
        phrase = formatstring(phrase);
        
        //this method will check if the phrase entered is a word or letter palingram or both with the parameter phrase
        checkpalingram(phrase);
        
        //prompts the user to enter 'y' to try again
        System.out.print(">> Enter 'Y' to try again: ");

        //get a 1 character value from the user then store to ans
        ans = sc.next().charAt(0);

        //this is necessary to avoid bug/error in the program that are not recognize by the compiler
        sc.nextLine();
        }while(ans=='y'||ans=='Y');
        //determine if the user enters 'y' if it returns true 
        //then it will run the series of statement inside the loop if it's false the program will terminate

        System.out.println("\n-- Program Terminated");
        
        

    }

    //A method that will not return any value
    static void checkpalingram(String phrase){
        //a storage location for the returned value of methods called
        boolean chcase1, chcase2;
        //call the method checkletter that will return boolean value then store it to chcase1
        chcase1 = checkletter(phrase);
        //call the method checkletter that will return boolean value then store it to chcase1
        chcase2 = checkword(phrase);
        
        //check if both case are true
        if(chcase1&&chcase2){
            //display that the phrase is a letter and word palingram
            System.out.println("\t-- A PALINGRAM (Letter & Word Palingram)");
        }
        //check if case1 is true
        else if(chcase1){
            //display that the phrase is a letter palingram
            System.out.println("\t-- A PALINGRAM (Letter Palingram)");
        }
        //check if case2 is true
        else if(chcase2){
            //display that the phrase is a word palingram
            System.out.println("\t-- A PALINGRAM (Word Palingram)");
        }
        //if all previous if are false display statement inside else
        else{
            //display that the phrase is not a palingram
            System.out.println("\t-- NOT A PALINGRAM");
        }

        
    }

    //A string method that will return a string value when called
    static String formatstring(String phrase){
        
        //converts each character inside the variable phrase into lowercase
        phrase = phrase.toLowerCase();
       
        //use in iteration and loop condition
        int i = 0, lim = phrase.length(); //the value of lim comes from the length of phrase
        //use as storage location
        char lett;

        //this for loop is to check every character in the string 
        //if there is a punctuation mark or special character then replace it by + temporarily
        for(i = 0; i < lim; i++){
            lett = phrase.charAt(i); //get 1 character base on the index given then store it to lett
            
            //check if the character is a letter
            if(lett>=97&&lett<=122||lett == 32){
                continue;
            }
            
            //if the condition is false
            else{
                //modify the values of phrase and replace the values of lett present in the phrase by +
                phrase = phrase.replace(lett, '+');
                
            }  
        }

        //creates a stringbuilder object word with the value of phrase
        StringBuilder words = new StringBuilder(phrase);
        
         //a while loop that will run continuously while the + is present in the string
        while(words.indexOf("+")!=-1){

        //this loop will determine the location of + in the string then delete it
        //the condition in the loop is i < words.length since 
        //in string builder when you delete a character it will also affect the size of string
        for(i = 0; i < words.length(); i++){
            lett = words.charAt(i);//get 1 character base on the index given then store it to lett
            
             //check if the character is a letter
            if(lett>=97&&lett<=122||lett == 32){
                continue;
            }
            
            //if the condition is false
            else if(i<=words.length()-1){
            //delete the existence of a character base on the postion given
            words.delete(i, i+1);
            }
            
        }}

        
        //return the value of words converted to string
        return words.toString();
    }

    //this method will check if the given parameter/phrase is a letter palingram
    static boolean checkletter(String phrase){

        //creates a stringbuilder object word with the value of phrase
        StringBuilder words = new StringBuilder(phrase);
        //use as storage location of the reverse order of phrase
        String reversew = "";
       
        //reverse word using reverse method then store it to words
        words = words.reverse();

        //convert words into string then store to reversew
        reversew = words.toString();
       
        
        
        //check if reversew is equal to phrase
        if(reversew.equals(phrase)){
            //return true when called
            return true;
        }
        //if it's not equal
        else{
            //return false when called
            return false;
        }
        

    }

    //a method that will return boolean value when called
    //then check if the parameter/phrase is a word palingram
    static boolean checkword(String phrase){
         
        //store value of phrase to words(for process use)
        String words = phrase;
        //use as storage location of the reverse order of phrase
        String revwords ="";

        //get the last index of space in words then store it to endindex
        int endindex = words.lastIndexOf(' ');
  

        //a while loop that will run continuously while there is spaces present in the string
        while(endindex!=-1){
            //extract the last word base on the given position then store it to revwords + the space
            revwords += words.substring(endindex+1) + " ";

            //modifies the values of words and remove the extracted words in it
            words = words.substring(0, endindex);

             //removes leading and trailing spaces in a string
            words = words.trim();
            //determine the new last position of spaces in the string then store it to endindex
            endindex = words.lastIndexOf(' ');

            //this condition is for the last word since it cannot be extracted because of the absence of spaces
            if(endindex==-1){
                //store the remaining words in words to revwords + space
                revwords += words + " ";
                //removes leading and trailing spaces in a string
                revwords = revwords.trim();
            }
            
        }

         //check if revwords is equal to phrase
        if(revwords.equals(phrase)){
            //return true
            return true;
        }
        //else if the previous condition is false
        else{
            //return false
            return false;
        }

    }

}
