import java.util.Scanner;

public class ConsoleInput{

    //input
    public static double getUserInput(){

        return new Scanner(System.in).nextDouble();
    }

    public static char getCharacterUserInput(){
        return new Scanner(System.in).next().charAt(0);
    }


}