/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Student
 */
import java.util.Scanner;
import java.util.ArrayList;
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
        int i = 0;
        
        ArrayList<Box> boxes = new ArrayList<>();
        Box box = new Box();
        
        System.out.println("Enter the 3 dimension of box");
        
        for(i=0;i<3;i++){
            System.out.println("Box " + (i+1) +":");
            box = getBoxData();
            boxes.add(box);
        }
        displayBoxData(boxes);
        
        
        
    }
    
     static Box getBoxData() {
         
            Box b = new Box();
            
            
            System.out.print("Enter the length: ");
            b.setboxLength(ConsInput.getDouinp());
            System.out.print("Enter the width: ");
            b.setboxWidth(ConsInput.getDouinp());
            System.out.print("Enter the height: ");
            b.setboxHeight(ConsInput.getDouinp());
            b.setboxVolume(b.computeVolume());
            b.setboxSArea(b.computeSurfaceArea());
            
            return b;
               
     }
     static void displayBoxData(ArrayList<Box> boxes){
         
         System.out.print("\n\n");
         int i = 1;
         
         
         for(Box b: boxes){
             System.out.println("\nBox " + i +": ");
             System.out.println("Volume:" + b.getboxVolume());
             System.out.println("Surface Area:" + b.getboxSArea());
             i++;
         }
         System.out.print("\n");
         if(boxes.get(0).compareBox(boxes.get(1).getboxVolume())&& boxes.get(0).compareBox(boxes.get(2).getboxVolume())){
             System.out.println("Smallest Capacity: Box 1");
             if(boxes.get(1).compareBox(boxes.get(2).getboxVolume()))
             System.out.println("Largest Capacity: Box 3");
             else
             System.out.println("Largest Capacity: Box 2"); 
         }
         else if(boxes.get(1).compareBox(boxes.get(0).getboxVolume())&& boxes.get(1).compareBox(boxes.get(2).getboxVolume())){
             System.out.println("Smallest Capacity: Box 2");
             if(boxes.get(0).compareBox(boxes.get(2).getboxVolume()))
             System.out.println("Largest Capacity: Box 3");
             else
             System.out.println("Largest Capacity: Box 1"); 
         }
         else if(boxes.get(2).compareBox(boxes.get(0).getboxVolume())&& boxes.get(2).compareBox(boxes.get(1).getboxVolume())){
             System.out.println("Smallest Capacity: Box 3");
             if(boxes.get(0).compareBox(boxes.get(1).getboxVolume()))
             System.out.println("Largest Capacity: Box 2");
             else
             System.out.println("Largest Capacity: Box 1"); 
         }
         
         
     }
    
    
    
    
}
