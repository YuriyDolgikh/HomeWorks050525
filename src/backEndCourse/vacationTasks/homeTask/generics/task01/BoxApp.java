package backEndCourse.vacationTasks.homeTask.generics.task01;

/*
1) Создайте класс Box для хранения любых объектов и реализуйте методы
   get() и put() для чтения и записи объектов в коробку.
   Используйте Generics для обеспечения типобезопасности.
*/

public class BoxApp {
    public static void main(String[] args) {

        Box<Integer> boxInt = new Box<>();
        boxInt.put(10);
        boxInt.put(34);
        boxInt.put(89);
        boxInt.put(100);
        boxInt.put(1000);

        printBox(boxInt);

        Box<String> boxStr = new Box<>();
        boxStr.put("Hello");
        boxStr.put("World");
        boxStr.put("Java");
        boxStr.put("Course");
        boxStr.put("Pascal");

        printBox(boxStr);

    }

    private static void printBox(Box<?> box) {
        for (int i = 0; i < box.size(); i++) {
            System.out.println("Box[" + i + "] = " + box.get(i));
        }
    }
}
