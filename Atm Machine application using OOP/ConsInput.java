import java.util.Scanner;

public class ConsInput {

    public static Scanner input = new Scanner(System.in);

    public static String getStrinp() {
        return input.nextLine();
    }

    public static int getIntinp() {
        return input.nextInt();
    }

    public static double getDouinp() {
        return input.nextDouble();
    }

    public static char getCharinp() {
        return input.next().charAt(0);
    }

    public static String skipl() {
        return input.nextLine();
    }
}
