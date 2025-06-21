package backEndCourse.lesson01.inheritance.task2;

public class ShapeDemo {
    public static void main(String[] args) {
        Shape circle = new Circle(10);
        Shape rectangle = new Rectangle(10, 15);
        Shape triangle = new Triangle(18, 12, 15);
        System.out.printf("Area of circle is %.2f: \n", circle.calculateArea());
        System.out.printf("Area of rectangle is %.2f: \n", rectangle.calculateArea());
        System.out.printf("Area of triangle is %.2f: \n", triangle.calculateArea());
    }
}
