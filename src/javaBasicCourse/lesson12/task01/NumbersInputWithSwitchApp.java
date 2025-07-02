package javaBasicCourse.lesson12.task01;

import utils.UserInputStatic;

public class NumbersInputWithSwitchApp {
    public static void main(String[] args) {
        int number = UserInputStatic.inputInt("Input the number - '1' or '2' or '3'");
        switch (number) {
            case 1:
                System.out.println("This is number '1'");
                break;
            case 2:
                System.out.println("This is number '2'");
                break;
            case 3:
                System.out.println("This is number '3'");
                break;
            default:
                System.err.println("Wrong input!");
        }
        UserInputStatic.close();
    }
}
