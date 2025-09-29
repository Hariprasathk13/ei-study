/*
 * Prototype Pattern
 *  created a simple example to demonstrate prototype pattern by a cloning a existing shape 
 * it is done by a method called clone which  creates new object with copy constructor
 * 
 */

class Shape {

    private int length;
    private int breadth;
    private String color;
    private int px, py; // position in x and y

    // paramterized constructor
    public Shape(int length, int breadth, String color, int px, int py) {
        this.length = length;
        this.breadth = breadth;
        this.color = color;
        this.px = px;
        this.py = py;
    }

    // copy constructor
    public Shape(Shape shape) {
        this.length = shape.length;
        this.breadth = shape.breadth;
        this.color = shape.color;
        this.px = shape.px;
        this.py = shape.py;
    }

    @Override
    public String toString() {
        return "Shape [length=" + length + ", breadth=" + breadth + ", color=" + color + ", px=" + px + ", py=" + py
                + "]";
    }

    public Shape clone() {
        return new Shape(this);
    }

}

// client
public class PrototypePatternDemo {
    public static void main(String[] args) {

        // clonable object
        Shape rectangle_1 = new Shape(10, 20, "GREEN", 100, 150);
        System.out.println(rectangle_1);

        // rectangle2 is copyed from rectangle1
        Shape rectangle_2 = rectangle_1.clone();
        System.out.println(rectangle_2);

        // both are different objects but has same data
        System.out.println(rectangle_1 == rectangle_2); // false
    }
}
