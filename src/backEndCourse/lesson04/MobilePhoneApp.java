package backEndCourse.lesson04;

import java.util.ArrayList;

public class MobilePhoneApp {
    public static void main(String[] args) {

        ArrayList<MobilePhone> phones = new ArrayList<>();
        printPhones(phones);

        System.out.println("Add one new phone to the collection");
        phones.add(new MobilePhone("Apple", "iPhone 14 Pro Max"));
        printPhones(phones);

        System.out.println("Add 4 new phones to the collection");
        phones.add(new MobilePhone("Samsung", "Galaxy S25"));
        phones.add(new MobilePhone("Apple", "iPhone 13"));
        phones.add(new MobilePhone("LG", "G7 ThinQ"));
        phones.add(new MobilePhone("Samsung", "Galaxy A56s"));
        printPhones(phones);

        System.out.println("Remove the phone from the collection by index '2'");
        phones.remove(2);

        System.out.println("Remove the phone from the collection by object 'Apple iPhone 13'");
        phones.remove(new MobilePhone("LG", "G7 ThinQ"));
        printPhones(phones);
    }

    private static void printPhones(ArrayList<MobilePhone> phones) {
        System.out.println("Phones collection:");
        if (phones.isEmpty()) {
            System.out.println("Phones collection is empty.");
        } else {
            for (MobilePhone phone : phones) {
                System.out.println(phone);
            }
        }
        System.out.println("---------------------------------");
    }
}
