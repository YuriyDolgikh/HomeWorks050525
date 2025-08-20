package backEndCourse.lesson21.task01;

public class HelloApp {
    public static void main(String[] args) {
        HelloThread thread1 = new HelloThread();
        Thread thread2 = new Thread(new HelloRunnable());
        thread1.start();
        thread2.start();
    }
}
