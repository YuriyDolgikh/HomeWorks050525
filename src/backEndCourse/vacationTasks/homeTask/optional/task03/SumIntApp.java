package backEndCourse.vacationTasks.homeTask.optional.task03;

/*
3) Напишите метод, который получает список целых чисел и
   возвращает сумму всех чисел в списке, используя Optional.
 */

import java.util.List;
import java.util.Optional;

public class SumIntApp {
    public static void main(String[] args) {
        List<Integer> list = List.of(45, 654, 65, 78, 23, 12);
        Optional<Integer> result = sum(list);
        if (result.isPresent()) {
            System.out.println("Sum = " + result.get());
        } else  {
            System.out.println("List is empty");
        }
    }

    private static Optional<Integer> sum(List<Integer> list){
        if(list.isEmpty()){
            return Optional.empty();
        }
        int sum = 0;
        for(int i: list){
            sum += i;
        }
        return Optional.of(sum);
    }
}
