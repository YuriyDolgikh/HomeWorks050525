package utils;

import java.util.Scanner;

public class UserInputStatic {

    static Scanner scanner = new Scanner(System.in);

    public static String inputText(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public static int inputInt(String message){
        System.out.println(message);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public static double inputDouble(String message){
        System.out.println(message);
        double input = scanner.nextDouble();
        scanner.nextLine();
        return input;
    }

    public static void close(){
        scanner.close();
    }

    public static void skipLineSeparator(){
        scanner.nextLine();
    }
}
