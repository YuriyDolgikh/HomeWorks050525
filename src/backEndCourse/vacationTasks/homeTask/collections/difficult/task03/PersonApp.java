package backEndCourse.vacationTasks.homeTask.collections.difficult.task03;

/*
    3. Создать множество LinkedHashSet и добавить в него несколько объектов класса Person,
       у которых есть свойства name и age.
       Затем перебрать все элементы множества и вывести на консоль только тех людей, возраст которых меньше 30 лет.
*/

import java.util.LinkedHashSet;
import java.util.Set;

public class PersonApp {
    public static void main(String[] args) {
        Set<Person> people = new LinkedHashSet<>();
        people.add(new Person("John", 15));
        people.add(new Person("Maria", 34));
        people.add(new Person("Nicole", 48));
        people.add(new Person("Sophia", 22));
        people.add(new Person("Linda", 29));
        people.add(new Person("Alex", 30));

        for (Person person : people) {
            if (person.getAge() < 30) {
                System.out.println(person);
            }
        }

    }
}
