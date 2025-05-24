package lesson08.task01;

public class PhoneApp1 {
    public static void main(String[] args) {
        Phone phone = new Phone("Samsung S24", "Black", false);
        System.out.println(phone);
        phone.changeSilentMode();
        System.out.println(phone);
    }
}
