
public class Dimension {
    //fields in class
    private double length;
    private double width;
    private double area;

     //Setter Method

     public void setLength(double length){
        this.length = length;
    }

    public void setWidth(double width){
        this.width = width;
    }

    //Getter Methods
    public double getLength(){
        return this.length;
    }

    public double getWidth(){
        return this.width;
    }
    //compute and return the area when called
    public double getArea(){
        area = this.length * this.width;
        return area;
    }

}
