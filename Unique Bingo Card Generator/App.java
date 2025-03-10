
/**
 * @Title: BINGO TICKET GENERATOR
 * @Description: A program that will generate a BINGO ticket
 *               which consists of four unique bingo cards. 
 * 
 * @Author: Willard Kent P. De los Santos (BSCS)
 * @DateCreated: 11/12/2022
 */
import java.util.Random;
import java.util.ArrayList;

public class App {

    // Declaration of four ArrayList for the four bingo cards
    // it is similar to 2d array
    public static ArrayList<ArrayList<Integer>> Card1 = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> Card2 = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> Card3 = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> Card4 = new ArrayList<ArrayList<Integer>>();

    // An arraylist that store generated number to ensure that the number is unique
    // in one bingo card
    public static ArrayList<Integer> unique = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        System.out.println("\nBINGO TICKET GENERATOR");
        System.out.println("----------------------\n");

        // Add 5 arraylist to each card which represent the 5 letters in bingo
        for (int l = 0; l < 5; l++) {
            Card1.add(new ArrayList<Integer>());
            Card2.add(new ArrayList<Integer>());
            Card3.add(new ArrayList<Integer>());
            Card4.add(new ArrayList<Integer>());
        }

        // calls the method gencard to generate cards
        genCard(Card1);
        genCard(Card2);
        genCard(Card3);
        genCard(Card4);

        // this method display 2 cards each base on the parameter
        displayCard(Card1, Card2);
        System.out.println();
        System.out.println();
        displayCard(Card3, Card4);
    }

    public static void genCard(ArrayList<ArrayList<Integer>> Card) {

        Random rand = new Random();

        // num is for storing generated number
        int num = 0;
        // k is for setting the paramater in rand method, i and j for iteration purpose
        int k = 1, i = 0, j = 0;

        for (i = 0; i < 5; i++) {

            for (j = 0; j < 5; j++) {

                // this is basically to skip the free part in the bingo cards
                if (i == 2 && j == 2) {
                    // this will add 0 temporarily to the free part
                    Card.get(i).add(j, 0);
                    // k will be iterated by 15 to proceed to the next letter
                    k += 15;
                    // to skip the rest of the statements below
                    continue;
                }

                // generate a random number in each letter then store it to num
                num = rand.nextInt(15) + k;

                // this will check if the generated number is unique
                // it will call the boolean method isunique that returns boolean value to
                // satisfy the condition
                // this while loop will not end until a unique number is generated
                while (isUnique(num, i, unique)) {
                    // if the number is not unique then the program will generated a new number
                    num = rand.nextInt(15) + k;
                }
                // this will add the number to the arraylist unique
                // unique is an arraylist that only store unique generated number necessary for
                // checking the if tbe next number generated is distinct
                unique.add(num);
                // k will be iterated by 15 to proceed to the next letter
                k += 15;
                // add the number to the card
                Card.get(i).add(j, num);
            }
            // after the loop k will be equal to 1 to generate number from letter b again
            k = 1;
        }

        // 1 24 35 50 67

        // after generating 1 bingo cards the program will remove all the elements in
        // unique for it to become reusable in the next bingo cards
        unique.removeAll(unique);
    }

    /// a method that check the uniqueness of number
    public static boolean isUnique(int num, int i, ArrayList<Integer> unique) {
        // an if statement that check if the arraylist unique contains the generated
        // number
        // I use or operator on this one to generate number as long as one of the
        // condition is true
        // this will also check if the generated number exist in the specific row in the
        // previous card to avoid repetition
        if (unique.contains(num) || Card1.get(i).contains(num) || Card2.get(i).contains(num)
                || Card3.get(i).contains(num))
            return true;
        else
            return false;
    }

    // a method that dusplay two cards at the sametime
    public static void displayCard(ArrayList<ArrayList<Integer>> fCard1, ArrayList<ArrayList<Integer>> fCard2) {
        int i = 0, j = 0;

        System.out.println("+----+----+----+----+----+\t+----+----+----+----+----+");
        System.out.println("| B  | I  | N  | G  | O  |\t| B  | I  | N  | G  | O  |");

        for (i = 0; i < 5; i++) {
            // display border/pattern
            System.out.println("+----+----+----+----+----+\t+----+----+----+----+----+");
            System.out.print("| ");
            // this for loop display each row of the card
            for (j = 0; j < 5; j++) {
                // check if the position is in the free part to display fr
                if (fCard1.get(i).get(j) == 0)
                    // display fr
                    System.out.print("FR | ");
                else
                    // display each number in a row in a card
                    System.out.printf("%02d | ", fCard1.get(i).get(j));

            }
            System.out.print("\t");
            System.out.print("| ");
            // this for loop display each row of the card
            for (j = 0; j < 5; j++) {
                // check if the position is in the free part to display fr
                if (fCard1.get(i).get(j) == 0)
                    // display fr
                    System.out.print("FR | ");
                else
                    // display each number in a row in a card
                    System.out.printf("%02d | ", fCard2.get(i).get(j));

            }
            System.out.println();
        }
        System.out.println("+----+----+----+----+----+\t+----+----+----+----+----+");

    }

}