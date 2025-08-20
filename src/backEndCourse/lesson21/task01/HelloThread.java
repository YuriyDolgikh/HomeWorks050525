package backEndCourse.lesson21.task01;

public class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello from thread 1");
            try {
                Thread.sleep(100);  // I did it to something was mixed in the result
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
