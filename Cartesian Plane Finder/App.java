/**
 * @Title: Cartesian Point Program
 * @Description: A program that will determine/display the quadrants of given three points
 *               and check/display which is/are the nearest and farthest to the origin.
 *               With restraint that the coordinate must not be equal to the origin and 
 *               previous/other coordinates entered.   
 * 
 * @Author: Willard Kent P. De los Santos (BSCS)
 * @DateCreated: 10/15/2022
 */
import static java.lang.System.out;

public class App {
    public static void main(String[] args) throws Exception {

        //Variables
        boolean enear = false, efar = false;
        char ans;

        //do while loop to repeat the whole process whenever the user wants to
        do{
        //Declare object xy1 (constructor)
        out.println("The First Coordinates"); 
        Coordinates xy1 = genCoordinates();
        
        //check if the values entered in the field is equal to the points of origin
        while(xy1.compareToOrigin()==0){
        out.print("\nPlease enter valid values\n");
        xy1 = genCoordinates();
        }
        //Declare object xy2 (constructor)
        out.println("\nThe Second Coordinates");
        Coordinates xy2 = genCoordinates();

        //check if the values entered in the field is equal to the points of origin 
        //and checked if it is equal to the previus points
        while(xy2.compareToOrigin()==0||xy2.compareInput(xy1)==0){
        out.print("\nPlease enter valid values");
        xy2 = genCoordinates();
        }

        //Declare object xy3 (constructor)
        out.println("\nThe Third Coordinates");
        Coordinates xy3 = genCoordinates();

        //check if the values entered in the field is equal to the points of origin 
        //and checked if it is equal to the previus and first coordinates
        while(xy3.compareToOrigin()==0||xy3.compareInput(xy1)==0||xy3.compareInput(xy2)==0){
        out.print("Please enter valid values");
        xy3 = genCoordinates();
        }


        //Display values and data of Coordinate
        out.println("\n\nThe First Coordinates");
        displayCoor(xy1);
        getQuad(xy1);
        getDist(xy1);

        //Display values and data of Coordinate
        out.println("\n\nThe Second Coordinates");
        displayCoor(xy2);
        getQuad(xy2);
        getDist(xy2);

        //Display values and data of Coordinate
        out.println("\n\nThe Third Coordinates");
        displayCoor(xy3);
        getQuad(xy3);
        getDist(xy3);

        //Find the nearest point to the origin
        if(xy1.compareDistance(xy2) < 0 && xy1.compareDistance(xy3) < 0){
            out.println("\nNearest to the origin");
            displayCoor(xy1);
        }
        else if(xy2.compareDistance(xy1) < 0 && xy2.compareDistance(xy3) < 0){
            out.println("\nNearest to the origin");
            displayCoor(xy2);
        }
        else if(xy3.compareDistance(xy1) < 0 && xy3.compareDistance(xy2) < 0){
            out.println("\nNearest to the origin");
            displayCoor(xy3);
        }
        else{
            enear = true;
        }


        //checked if there is equal distance and checked if it is the nearest
        if(xy1.compareDistance(xy2) == 0 && xy1.compareDistance(xy3) < 0){
            out.println("\n\nNearest to the origin");
            displayCoor(xy1);
            displayCoor(xy2);  
        }
        else if(xy2.compareDistance(xy3) == 0 && xy3.compareDistance(xy1) < 0){
            out.println("\n\nNearest to the origin");
            displayCoor(xy2);
            displayCoor(xy3);  
        }
        else if(xy1.compareDistance(xy3) == 0 && xy1.compareDistance(xy2) < 0){
            out.println("\n\nNearest to the origin");
            displayCoor(xy1);
            displayCoor(xy3);  
        }
        //if all the distance of coordinates are equal
        else if(enear){
            out.println("\nThere is no nearest to the Origin");
        }

        //Find the farthest point to the origin
        if(xy1.compareDistance(xy2) > 0 && xy1.compareDistance(xy3) > 0){
            out.println("\n\nFarthest to the origin");
            displayCoor(xy1);
            
        }
        else if(xy2.compareDistance(xy1) > 0 && xy2.compareDistance(xy3) > 0){
            out.println("\n\nFarthest to the origin");
            displayCoor(xy2);  
        }
        else if(xy3.compareDistance(xy1) > 0 && xy3.compareDistance(xy2) > 0){
            out.println("\n\nFarthest to the origin");
            displayCoor(xy3);
        }
        else{
            efar = true;
        }
        
        
        //checked if there is equal distance and checked if it is the farthest
        if(xy1.compareDistance(xy2) == 0 && xy1.compareDistance(xy3) > 0){
            out.println("\n\nFarthest to the origin");
            displayCoor(xy1);
            displayCoor(xy2);  
        }
        else if(xy2.compareDistance(xy3) == 0 && xy3.compareDistance(xy1) > 0){
            out.println("\n\nFarthest to the origin");
            displayCoor(xy2);
            displayCoor(xy3);  
        }
        else if(xy1.compareDistance(xy3) == 0 && xy1.compareDistance(xy2) > 0){
            out.println("\n\nFarthest to the origin");
            displayCoor(xy1);
            displayCoor(xy3);  
        }
        //if all the distance of coordinates are equal
        else if(efar){
            out.println("\nThere is no Farthest to the Origin");
        }

        //for the decision of user if they wants to try again
        System.out.print("\n\nEnter 'Y' or 'y' to try again:" );
        ans = ConsoleInput.getCharacterUserInput();
        System.out.println();
        enear = false;
        efar = false;
    }while(ans=='Y'||ans=='y');

    }

    //For the inputs/setter
    static Coordinates genCoordinates(){
        Coordinates xy = new Coordinates();
        out.print(">> Enter the X coordinate:");
        xy.setXcoor(ConsoleInput.getUserInput());
        out.print(">> Enter the Y coordinate:");
        xy.setYcoor(ConsoleInput.getUserInput());

        return xy;
    }

    //get the values/coordinates
    static void displayCoor(Coordinates xy){
        out.print("\tCoordinate: (" + xy.getXcoor() + ", " + xy.getYcoor() + ")");
    }

    //Determine the quadrants of points
    static void getQuad(Coordinates xy){
        switch(xy.getQuadrant()){
            case 1: 
                out.println(" lies in First quadrant");
                break;
            case 2: 
                out.println(" lies in Second quadrant");
                break;
            case 3: 
                out.println(" lies in Third quadrant");
                break;
            case 4: 
                out.println(" lies in Fourth quadrant");
                break;
            case 5:
                out.println(" lies at positive y axis");
                break;
            case 6:
                out.println(" lies at negative y axis");
                break;
            case 7:
                out.println(" lies at negative x axis");
                break;
            case 8:
                out.println(" lies at positive x axis");
                break;
            default:
                out.println(" not found");
        }
    }

    //get the distance of the given coordinates to the origin
    static void getDist(Coordinates xy){
        out.printf("\tDistance: %.2f%n", xy.getDistance());
    }

    
}
