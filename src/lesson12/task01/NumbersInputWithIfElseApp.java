package lesson12.task01;

import utils.UserInputStatic;

public class NumbersInputWithIfElseApp {
    public static void main(String[] args) {
        int number = UserInputStatic.inputInt("Input the number - '1' or '2' or '3'");
        if (number==1){
            System.out.println("This is number '1'");
        } else if (number == 2) {
            System.out.println("This is number '2'");
        } else if (number == 3) {
            System.out.println("This is number '3'");
        } else {
            System.err.println("Wrong input!");
        }
        UserInputStatic.close();
    }
}
