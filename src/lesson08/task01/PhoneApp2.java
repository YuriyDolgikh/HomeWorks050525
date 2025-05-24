package lesson08.task01;

public class PhoneApp2 {
    public static void main(String[] args) {
        Phone phone = new Phone("iPhone 14 Pro MAX", "Rose", false);
        PhoneService service = new PhoneService();
        System.out.println(phone);
        service.changeSilentMode(phone);
        System.out.println(phone);
    }
}
