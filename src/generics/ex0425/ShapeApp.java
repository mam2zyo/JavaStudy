package generics.ex0425;

public class ShapeApp {
    public static void main(String[] args) {
        Shape c1 = new Circle();
        Circle c2 = new Circle();

        Shape r1 = new Rectangle();
        Rectangle r2 = new Rectangle();

        ShapeManager<Shape> sm = new ShapeManager<>();

        sm.addShape(c1);
        sm.addShape(r1);
        sm.addShape(c2);
        sm.addShape(r2);

        sm.printShapes();
        System.out.println();

        ShapeManager<Circle> cm = new ShapeManager<>();
        cm.addShape((Circle) c1);
        cm.addShape(c2);

        cm.printShapes();
    }
}
