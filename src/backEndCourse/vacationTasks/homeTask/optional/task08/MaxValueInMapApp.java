package backEndCourse.vacationTasks.homeTask.optional.task08;

/*
8) Напишите метод, который получает HashMap, и возвращает Optional
   с наибольшим значением, связанным с любым ключом в HashMap.
 */

import java.util.*;

public class MaxValueInMapApp {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 4);
        map.put(2, 21);
        map.put(3, 33);
        map.put(4, 22);
        map.put(5, 6);

        printResult(map);
        printResult(new HashMap<>());
    }

    private static Optional<Integer> maxValue(Map<Integer,Integer> map){
        if(map == null || map.isEmpty()){
            return Optional.empty();
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        return Optional.of(list.getLast());
    }

    private static void printResult(Map<Integer,Integer> map){
        Optional<Integer> result = maxValue(map);
        if(result.isPresent()){
            System.out.println("Max value in the map: "+ result.get());
        }else {
            System.out.println("Map is null or empty");
        }
    }
}
