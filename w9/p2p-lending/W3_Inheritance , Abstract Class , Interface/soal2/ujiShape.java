public class ujiShape {
    public static void main(String[] args) {
        Shape s1 = new Shape("red", false);
        System.out.println(s1.toString()); // Akan memanggil toString milik Shape

        Circle c1 = new Circle(5.0, "blue", true);
        System.out.println(c1.toString());
        System.out.println("Area Circle: " + c1.getArea());

        Rectangle r1 = new Rectangle(2.0, 4.0, "yellow", false);
        System.out.println(r1.toString());
        System.out.println("Perimeter Rectangle: " + r1.getParimeter());

        Square sq1 = new Square(3.0, "purple", true);
        System.out.println(sq1.toString());
        System.out.println("Area Square: " + sq1.getArea());
        
        sq1.setWidth(5.0);
        System.out.println("Setelah sisi diubah menjadi 5.0:");
        System.out.println(sq1.toString());
        System.out.println("Area Square baru: " + sq1.getArea());
    }
}