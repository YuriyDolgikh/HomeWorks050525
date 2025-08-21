package backEndCourse.lesson21.task02;

public class SumProcess {

    private int sum = 0;

    public synchronized void add(int number) {
        sum += number;
    }

    public int getSum() {
        return sum;
    }
}
