public class Rectangle extends Shape{
    private double width;
    private double length;

    public Rectangle(double width, double length){
        super("persegi panjang");
        this.width = width;
        this.length = length;
    }

    @Override
    public double area(){
        return width*length;
    }

    @Override
    public String toString(){
        return super.toString() + " of length " + length + " and width " + width;
    }
}
