package backEndCourse.lesson14.task08;

import java.util.ArrayList;
import java.util.List;

public class AverageSalaryApp {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 30, "Male", 2500));
        persons.add(new Person("Mary", 25, "Female", 1600));
        persons.add(new Person("Peter", 23, "Male", 2700));
        persons.add(new Person("David", 40, "Male", 1800));
        persons.add(new Person("Sarah", 28, "Female", 1900));
        persons.add(new Person("Tom", 21, "Male", 2000));
        persons.add(new Person("Helen", 35, "Female", 2100));

        double filteredPersons = persons.stream().filter(p -> p.getGender().equals("Male"))
                .filter(p -> p.getAge() >= 25 && p.getAge() <= 40)
                .mapToInt(Person::getSalary)
                .average()
                .orElse(0);

        System.out.println("Average salary of male persons between 25 and 40 years old is: " + filteredPersons);
    }
}
