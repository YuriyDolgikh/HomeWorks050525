package backEndCourse.lesson21.task02;

public class SumApp {
    public static void main(String[] args) throws InterruptedException {

        SumProcess sumProcess = new SumProcess();

        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        SumThread sumThread1 = new SumThread(numbers, sumProcess, true);
        SumThread sumThread2 = new SumThread(numbers, sumProcess, false);

        sumThread1.start();
        sumThread2.start();

        sumThread1.join();
        sumThread2.join();

        System.out.println("Sum = " + sumProcess.getSum());
    }
}
