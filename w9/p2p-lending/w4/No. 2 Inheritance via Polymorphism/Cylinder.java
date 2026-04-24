public class Cylinder extends Shape{
    private double heigth;
    private double radius;

    public Cylinder(double radius, double heigth){
        super("lingkaran");
        this.heigth = heigth;
        this.radius = radius;
    }

    @Override
    public double area(){
        return Math.PI * radius * radius + 2 * Math.PI * radius * heigth;
    }

    @Override
    public String toString(){
        return super.toString() + " of radius " + radius + " and heigth " + heigth;
    }
}
