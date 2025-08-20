package backEndCourse.lesson21.task02;

public class SumThread extends Thread {
    private int[] numbers;
    private SumProcess sumProcess;
    private boolean isFirstPart;

    public SumThread(int[] numbers, SumProcess sumProcess,  boolean isFirstPart) {
        this.numbers = numbers;
        this.sumProcess = sumProcess;
        this.isFirstPart = isFirstPart;
    }

    @Override
    public void run() {
        int startIndex = isFirstPart ? 0 : 50;
        for (int i = startIndex; i < startIndex + 50; i++) {
            sumProcess.add(numbers[i]);
        }
    }
}
