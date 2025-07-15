package backEndCourse.vacationTasks.homeTask.collections.simple.task04;

/*
    4 Создать HashSet, добавить в него несколько строк и проверить, содержит ли он определенную строку.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetApp {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>(Arrays.asList("Hello", "World", "Java", "Course", "Pascal", "C++"));
        System.out.println("Words: " + words);
        String wordToCheck = "Java";
        System.out.println("Does the HashSet contain the word: " + wordToCheck + "? " + words.contains(wordToCheck));
        wordToCheck = "JavaScript";
        System.out.println("Does the HashSet contain the word: " + wordToCheck + "? " + words.contains(wordToCheck));
    }
}
