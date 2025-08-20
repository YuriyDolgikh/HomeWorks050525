package backEndCourse.lesson21.task03;

public class CountdownApp {
    public static void main(String[] args) throws InterruptedException {
        CountdownThread countdownThread = new CountdownThread();
        countdownThread.start();
        countdownThread.join();
        System.out.println("Let's go!");
    }
}
