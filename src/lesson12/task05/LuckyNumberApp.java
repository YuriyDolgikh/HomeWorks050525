package lesson12.task05;

import utils.UserInputStatic;

public class LuckyNumberApp {
    public static void main(String[] args) {
        char[] arr = UserInputStatic.inputText("Input four-digits number:").toCharArray();
        if (arr.length != 4) {
            System.err.println("The number you entered is not four-digits!");
            return;
        }
        if (!isDigit(arr[0]) || !isDigit(arr[1]) || !isDigit(arr[2]) || !isDigit(arr[3])) {
            System.err.println("The entered string contains invalid characters!");
            return;
        }
        System.out.println("This is " + ((arr[0] + arr[1] == arr[2] + arr[3]) ? "lucky" : "unlucky") + " number!");
        UserInputStatic.close();
    }

    private static boolean isDigit(char ch){
        return ch >= '0' && ch <= '9';
    }
}
