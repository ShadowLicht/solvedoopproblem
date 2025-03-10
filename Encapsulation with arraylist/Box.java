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
public class Box {
    //fields
    private double box_length;
    private double box_width;
    private double box_height;
    private double box_volume;
    private double box_sarea;
    
    //setter
    public void setboxLength(double box_length){
        this.box_length = box_length;
    }
    
    public void setboxWidth(double box_width){
        this.box_width = box_width;
    }
    
    public void setboxHeight(double box_height){
        this.box_height = box_height;
    }
    
    public void setboxVolume(double box_volume){
        this.box_volume = box_volume;
    }
    
    public void setboxSArea(double box_sarea){
        this.box_sarea = box_sarea;
    }
    
    //getter
    public double getboxLength(double box_length){
        return this.box_length;
    }
    
    public double getboxWidth(){
        return this.box_width;
    }
    
    public double getboxHeight(){
        return this.box_height;
    }
    
    public double getboxVolume(){
       return this.box_volume;
    }
    
    public double getboxSArea(){
       return this.box_sarea;
    }
    
    //computation
    public double computeVolume(){
        
        return (this.box_height * this.box_length * this.box_width);
    }
    
    public double computeSurfaceArea(){
        
        return (2*(this.box_length * this.box_height) + 2*(this.box_length * this.box_width) + 2*(this.box_width * this.box_height));
    }
    
    //compare
    public boolean compareBox(double volume){
        if(box_volume<volume)
            return true;
        else
            return false;
    }
}
