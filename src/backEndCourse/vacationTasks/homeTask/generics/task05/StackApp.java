package backEndCourse.vacationTasks.homeTask.generics.task05;

/*
    5) Создайте класс Stack, реализующий стек на основе массива или списка.
       Используйте Generics для обеспечения типобезопасности и возможности
       передачи в стек объектов разных типов.
*/

public class StackApp {
    public static void main(String[] args) {
        Stack<Integer> stackInt = new Stack<>();
        stackInt.push(345);
        stackInt.push(75);
        stackInt.push(555);
        stackInt.push(4);
        stackInt.push(999);
        stackInt.push(0);
        stackInt.push(100);
        System.out.println(stackInt);
        System.out.println(stackInt.pop());
        System.out.println(stackInt.pop());
        System.out.println(stackInt.peek());
        System.out.println(stackInt.peek());
        System.out.println(stackInt.pop());
        System.out.println(stackInt);
    }
}
