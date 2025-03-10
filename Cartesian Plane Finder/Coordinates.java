import java.util.Scanner;

public class Coordinates {

        //FIelds
        private double xcoor;
        private double ycoor;
        private double distance;

        //Setter Method
        public void setXcoor(double xcoor){
                this.xcoor = xcoor;
        }

        public void setYcoor(double ycoor){
                this.ycoor = ycoor;
        }
        
        //Getter Methods
        public double getXcoor(){
                return this.xcoor;
        }

        public double getYcoor(){
                return this.ycoor;
        }
        
        //a constructor that computes the distance and return a double values
        public double getDistance(){

            distance=Math.sqrt((xcoor*xcoor)+(ycoor*ycoor));

            return distance;
        }
        //a constructor that determine the quadrant and return an integer values
        public int getQuadrant(){

            if (xcoor > 0 && ycoor > 0)
            return 1;
 
            else if (xcoor < 0 && ycoor > 0)
            return 2;
 
            else if (xcoor < 0 && ycoor < 0)
            return 3;
 
            else if (xcoor > 0 && ycoor < 0)
            return 4;

            else if (xcoor == 0 && ycoor > 0)
            return 5;
 
            else if (xcoor == 0 && ycoor < 0)
            return 6;
 
            else if (ycoor == 0 && xcoor < 0)
            return 7;
 
            else if (ycoor == 0 && xcoor > 0)
            return 8;

            else
            return 0;
        }

        //Compare the coordinate if it is equal to the given coordinates of an object
        public int compareInput(Coordinates xy){
            if(this.xcoor != xy.getXcoor() && this.ycoor != xy.getYcoor())
                return 1;
            else if((this.xcoor == xy.getXcoor() && this.ycoor != xy.getYcoor()) || (this.ycoor == xy.getYcoor() && this.xcoor != xy.getXcoor()))
                return 1;
            else
                return 0;
        }
        //Compare the coordinate if it is equal to the origin
        public int compareToOrigin(){
            if(xcoor !=0 && ycoor !=0)
                return 1;
            else if((xcoor == 0 && ycoor !=0) || (ycoor == 0 && xcoor !=0))
                return 1;
            else
                return 0;
        }

        
        //Compare the distance of coordinate to determine which is the nearest or farthest to the point of origin
        public int compareDistance(Coordinates xy){
            if(this.distance < xy.getDistance())
            return -1;
            else if(this.distance > xy.getDistance())
            return 1;
            else
            return 0;
        }
      
}
