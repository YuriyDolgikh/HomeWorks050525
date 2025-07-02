package javaBasicCourse.lesson21.task2Average;

public class Average {
    public double getAverage(double[] sourceArray) {
        double result = 0;
        for (double value : sourceArray) {
            result += value;
        }
        return result / sourceArray.length;
    }
}
