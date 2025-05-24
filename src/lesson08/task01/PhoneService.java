package lesson08.task01;

import java.util.Scanner;

public class PhoneService {
    public void changeSilentMode(Phone phone){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'true' or 'false' to change silent mode");
        phone.setSilent(scanner.nextBoolean());
        scanner.close();
    }
}
