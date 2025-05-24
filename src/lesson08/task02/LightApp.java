package task02;

import java.util.Scanner;

public class LightApp {
    public static void main(String[] args) {
        LightService service = new LightService();
        Scanner scanner = new Scanner(System.in);
        Light light = new Light("Living room",50, false);
        System.out.println(light);
        service.printOnOffStatus(light);
        service.switchOnOff(light, scanner);
        System.out.println(light);
        service.printOnOffStatus(light);
        service.brightness(light, scanner);
        System.out.println(light);
        scanner.close();
    }
}
