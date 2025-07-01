package backEndCourse.lesson06.namesSet;

import utils.UserInputStatic;

import java.util.HashSet;
import java.util.Set;

public class NamesApp {
    public static void main(String[] args) {
        Set<Person> names = new HashSet<>();
        names.add(new Person("John"));
        names.add(new Person("Smith"));
        names.add(new Person("Williams"));
        names.add(new Person("Jones"));
        names.add(new Person("Smith"));
        names.add(new Person("Williams"));
        names.add(new Person("Gates"));
        names.add(new Person("Brown"));
        names.add(new Person("Lloyd"));
        names.add(new Person("Anderson"));

        for (Person name : names) {
            System.out.print(name.getName() + ", ");
        }
        System.out.println();

        Set<String> uniqueNames = new HashSet<>();
        for (Person name : names) {
            uniqueNames.add(name.getName());
        }
        System.out.println("Unique names: " + uniqueNames);
        System.out.println("The quantity of unique names = " + uniqueNames.size());
        String nameForCheck = UserInputStatic.inputText("Enter the name for checking: ");
        if (uniqueNames.contains(nameForCheck)) {
            System.out.println("The name is present");
        } else {
            System.out.println("The name is not present");
        }
    }
}
