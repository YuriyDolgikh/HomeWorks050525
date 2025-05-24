package lesson12.task03;

import utils.UserInputStatic;

public class WeekDaysApp {
    public static void main(String[] args) {
        int numOfDays = UserInputStatic.inputInt("Input the number '1 - 7':");
        switch (numOfDays) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6, 7:
                System.out.println("Weekend");
                break;
            default:
                System.err.println("Invalid input");
        }
    }
}
