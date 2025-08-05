package backEndCourse.lesson15.task03;

import utils.UserInputStatic;

public class StringParsingApp {
    public static void main(String[] args) {
        String inputString = UserInputStatic.inputText("Input the integer number:");
        try {
            int number = Integer.parseInt(inputString);
            System.out.println("Number = " + number);
        }catch (NumberFormatException e){
            System.out.println("The input is not an integer number");
        }
    }
}
