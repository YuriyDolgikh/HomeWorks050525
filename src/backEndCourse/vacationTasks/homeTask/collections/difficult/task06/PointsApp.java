package backEndCourse.vacationTasks.homeTask.collections.difficult.task06;

/*
    6 Создать множество TreeSet и добавить в него несколько объектов класса Point, у которых есть свойства x и y.
      Затем перебрать все элементы множества и вывести на консоль только те точки, у которых x > y.
*/

import java.util.Set;
import java.util.TreeSet;

public class PointsApp {
    public static void main(String[] args) {
        Set<Point> points = new TreeSet<>();
        points.add(new Point(1, 2));
        points.add(new Point(9, 4));
        points.add(new Point(5, 3));
        points.add(new Point(4, 6));
        points.add(new Point(3, 8));
        points.add(new Point(7, 4));

        for (Point point : points) {
            if (point.getX() > point.getY()) {
                System.out.println(point);
            }
        }
    }
}
