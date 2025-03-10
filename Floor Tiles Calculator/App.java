/**
 * @Title: FLOOR TILES CALCULATOR PROGRAM
 * @Description: A program that will calculate the number of N x N tiles  
 *               needed based on the given dimension of the floor. The program
 *               will accept a value in centimeter for the dimension of 
 *               tiles and meter for the dimension of floor.
 * 
 * @Author: Willard Kent P. De los Santos (BSCS)
 * @DateCreated: 10/15/2022
 */
import static java.lang.System.out;
public class App {
    public static void main(String[] args) throws Exception {
        //variable declaration
        char ans;
        //declare object (constructor)
        Dimension tile = new Dimension();
        Dimension floor = new Dimension();
        //do while loop to repeat the whole process whenever the user wants to
        do{
            //input of values to the field in the object
            out.println("Enter Dimension of Tile:");
            tile = genDimension();
            out.println("\n\nEnter Dimension of Floor:");
            floor = genDimension();

            //display of outputs
            out.print("\n" + getNoTiles(tile, floor));
            out.print(" ("+tile.getLength()+" x "+tile.getWidth());
            out.print(") cm Tiles needed for the floor dimension (");
            out.println(floor.getLength()+" x "+floor.getWidth()+") m");

            //for the decision of user if they wants to try again
            out.print("\n\nEnter 'Y' or 'y' to try again:" );
            ans = ConsoleInput.getCharacterUserInput();
            out.println();
        }while(ans=='Y'||ans=='y');
    }

    //For the inputs/setter
    static Dimension genDimension(){
        Dimension d = new Dimension();
        out.println("Meter(m) for floor & Centimeter(cm) for tile");
        out.print(">> Enter the length:");
        d.setLength(ConsoleInput.getUserInput());
        out.print(">> Enter the width:");
        d.setWidth(ConsoleInput.getUserInput());

        return d;
    }
    //compute the no of tiles then round it off base on the given area in the constructor
    //return an integer values when called
    static int getNoTiles(Dimension tile, Dimension floor){
        return (int)Math.ceil(floor.getArea()/(tile.getArea()/10000));
    }

}
