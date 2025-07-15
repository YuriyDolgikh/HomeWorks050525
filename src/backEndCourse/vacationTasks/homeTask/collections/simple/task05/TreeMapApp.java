package backEndCourse.vacationTasks.homeTask.collections.simple.task05;

/*
    5 Создать TreeMap, где ключом является строка, а значением - ее длина. Вывести на экран все элементы TreeMap.
 */

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapApp {
    public static void main(String[] args) {
        List<String> words = List.of("Literally", "Ironic", "Irregardless", "Colonel", "Nonplussed", "Disinterested", "I");
        Map<String, Integer> wordsLength = new TreeMap<>();
        for (String word : words){
            wordsLength.put(word, word.length());
        }
        for (Map.Entry<String, Integer> entry : wordsLength.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
