package backEndCourse.lesson02.task2;

public class ShapesDemo {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(10, 15);
        Rectangle rectangle2 = new Rectangle(25, 5);
        Rectangle rectangle3 = new Rectangle(18, 13);
        Circle circle1 = new Circle(10);
        Circle circle2 = new Circle(15);
        Circle circle3 = new Circle(12);

        Shape[] shapes = {rectangle1, rectangle2, rectangle3, circle1, circle2, circle3};
        printAreas(shapes);
    }

    private static void printAreas(Shape[] shapes){
        for (Shape shape : shapes) {
            System.out.printf(shape.getClass().getSimpleName() + ": Area = %.2f\n", shape.getArea());
        }
    }
}
