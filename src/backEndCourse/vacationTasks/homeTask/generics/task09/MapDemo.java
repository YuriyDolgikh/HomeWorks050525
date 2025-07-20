package backEndCourse.vacationTasks.homeTask.generics.task09;

/*
    9) Создайте класс Map для хранения пар ключ-значение.
       Реализуйте методы put(), get() и remove().
       Используйте Generics для обеспечения типобезопасности
       и возможности хранения в Map объектов разных типов.
*/

public class MapDemo {
    public static void main(String[] args) {

        Map<String, Integer> map = new Map<>();

        map.put("Hello", 111);
        map.put("World", 222);
        map.put("There", 333);
        map.put("Java", 444);
        map.put("Course", 555);

        printMap(map);
        System.out.println("Remove item with key = 'Hello'");
        map.remove("Hello");
        printMap(map);
        System.out.println("Get item with key = 'Java'");
        System.out.println(map.get("Java"));
        System.out.println("Get item with key = 'Test'");
        System.out.println(map.get("Test"));

    }

    public static void printMap(Map<String, Integer> map) {
        for (Map<String, Integer>.MapItem mapItem : map.getAll()) {
            System.out.println(mapItem);
        }
    }
}
