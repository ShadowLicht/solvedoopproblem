
/**
 * @Title: UNION AND INTERSECTION OF SETS
 * @Description: A program that accept integer to set a specific number of elements 
 *               (with a minimum of 5) in each set. Each element must be in the range
 *               of 1 - 100. After the user inputted all the elements in each set. The 
 *               program will display each set and their union and intersection.
 *               
 * @Author: Willard Kent P. De los Santos (BSCS)
 * @DateCreated: 11/12/2022
 */
//import necessary library in the program
import java.util.*;

public class App {

    // declare Scanner input in global scope to be able to access it anywhere in
    // this class
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // declaration of two sets Integer Arraylist
        ArrayList<Integer> set1 = new ArrayList<>();
        ArrayList<Integer> set2 = new ArrayList<>();

        // this will be the storage for getting the number of elements in each set
        int eset1 = 0, eset2 = 0;

        // display title
        System.out.println("UNION and INTERSECTION OF SETS");
        System.out.println("------------------------------");

        // a loop that will run continuously until the input is >= 5
        do {
            System.out.print("Enter the number of elements in the 1st Set (Minimum of 5): ");
            eset1 = input.nextInt();

        } while (eset1 < 5);

        // calls the method getElem with the parameter of integer and an Arraylist to
        // get the elements from the user
        getElem(eset1, set1);

        // a loop that will run continuously until the input is >= 5
        do {
            System.out.print("\nEnter the number of elements in the 2nd Set (Minimum of 5): ");
            eset2 = input.nextInt();
        } while (eset2 < 5);

        // calls the method getElem with the parameter of integer and an Arraylist to
        // get the elements from the user
        getElem(eset2, set2);

        // this will display each set
        System.out.print("\n1st Set: ");
        // calls the method that will display the set
        dispSet(set1);
        System.out.print("2nd Set: ");
        // calls the method that will display the set
        dispSet(set2);

        // calls the method that will get the union of set and then display it
        // it has two integer Arraylist as parameter
        UnionSet(set1, set2);
        // calls the method that will get the intersection of set and then display it
        // it has two integer Arraylist as parameter
        IntersectSet(set1, set2);

        input.close();
    }

    // this is a method that get the elements from the user
    static void getElem(int inp, ArrayList<Integer> set) {
        int num = 0;
        int c = 0;
        System.out.print("Enter a number from 1 to 100\n");
        for (int i = 0; i < inp; i++) {
            do {
                if (c >= 1)
                    System.out.println("Invalid input!");

                System.out.print("Enter a number: ");
                num = input.nextInt();
                c++;
            } while (num < 1 || num > 100);
            c = 0;
            set.add(num);
        }
    }

    // this is a method that display the set
    static void dispSet(ArrayList<Integer> set) {
        System.out.print(" {");
        for (int i = 0; i < set.size(); i++) {

            if (i == set.size() - 1)
                System.out.println(set.get(i) + "}");
            else
                System.out.print(set.get(i) + ", ");
        }
    }

    // this is a method that get the union of the set
    static void UnionSet(ArrayList<Integer> set1, ArrayList<Integer> set2) {

        // for iteration purpose
        int i = 0;

        // declare set as linkedhashset to easily merge two sets
        // linkedhashset must contain unique element
        // so when we merge the two sets it ignores duplication
        Set<Integer> set = new LinkedHashSet<>(set1);
        set.addAll(set2);

        // declare arraylist union with the value of set which has the merged elements
        // of the two sets
        ArrayList<Integer> union = new ArrayList<>(set);

        // sort the elements in the arraylist in ascending order
        Collections.sort(union);

        // display the union of sets
        System.out.print("Union of Sets: {");
        for (i = 0; i < union.size(); i++) {
            if (i == union.size() - 1)
                System.out.println(union.get(i) + "}");
            else
                System.out.print(union.get(i) + ", ");
        }
    }

    // this is a method that get the intersection of the set
    static void IntersectSet(ArrayList<Integer> set1, ArrayList<Integer> set2) {
        // declare intersect as integer arraylist
        ArrayList<Integer> intersect = new ArrayList<>();

        // a loop that only stop until it reaches the last element of the arraylist
        // it also get the element in the arraylist then store it to n
        for (Integer n : set1) {
            // check if n exist in set2
            if (set2.contains(n)) {
                // this conclude intersection hence add n to arraylist intersect
                intersect.add(n);
            }
        }

        // sort the elements in the arraylist in ascending order
        Collections.sort(intersect);

        // display the intersection of sets
        System.out.print("Intersection of Sets: {");
        for (int i = 0; i < intersect.size(); i++) {
            if (i == intersect.size() - 1)
                System.out.println(intersect.get(i) + "}");
            else
                System.out.print(intersect.get(i) + ", ");
        }
    }
}
