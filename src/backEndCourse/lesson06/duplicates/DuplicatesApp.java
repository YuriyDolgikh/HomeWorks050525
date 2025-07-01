package backEndCourse.lesson06.duplicates;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesApp {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Smith");
        names.add("Williams");
        names.add("Gates");
        names.add("John");
        names.add("Brown");
        names.add("Lloyd");
        names.add("Anderson");
        names.add("Smith");
        names.add("Williams");
        System.out.println("All names: " + names);

        Set<String> uniqueNames = new HashSet<>(names);
        System.out.println("Unique names: " + uniqueNames);
        uniqueNames.add("Mozart");
        uniqueNames.add("Bach");
        uniqueNames.add("Beethoven");

        List<String> newNamesList = new ArrayList<>(uniqueNames);
        System.out.println("New names list: " + newNamesList);
    }
}
