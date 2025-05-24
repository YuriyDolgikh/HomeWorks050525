package lesson08.task01;

import java.util.Scanner;

public class Phone {
    private String model;
    private String color;
    private boolean isSilent;

    public Phone(String model, String color, boolean isSilent) {
        this.model = model;
        this.color = color;
        this.isSilent = isSilent;
    }

    public void changeSilentMode(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'true' or 'false' to change silent mode");
        this.isSilent= scanner.nextBoolean();
        scanner.close();
    }

    public void setSilent(boolean silent) {
        isSilent = silent;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", isSilent=" + isSilent +
                '}';
    }
}
