package lesson13.task04SimpleNumber;

import utils.UserInputStatic;

public class SimpleNumberApp {
    public static void main(String[] args) {
        int number = UserInputStatic.inputInt("Input an integer positive number: ");
        boolean isSimpleNumber = true;
        if (number > 3) {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    isSimpleNumber = false;
                    break;
                }
            }
        }
        System.out.println("Number " + number + " is" + (isSimpleNumber ? "" : " not") + " a simple number");
        UserInputStatic.close();
    }

}
