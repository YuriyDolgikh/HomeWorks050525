package backEndCourse.lesson09.task1;

import java.util.*;

public class WordsApp {
    public static void main(String[] args) {
        List<String> words = List.of("john", "worm", "Smith", "big", "Williams", "Jones", "ares", "apple",
                "jog", "Brown", "Davis", "Miller", "stack", "Thomas", "Jackson", "White");

        Map<Character, Set<String>> naturalOrderInMapNaturalInGroups = new LinkedHashMap<>();
        Map<Character, Set<String>> alphabeticOrderInMapNaturalInGroups = new TreeMap<>();
        Map<Character, Set<String>> naturalOrderInMapSortedInGroups = new LinkedHashMap<>();
        Map<Character, Set<String>> alphabeticOrderInMapSortedInGroups = new TreeMap<>();
        for (String word : words) {
            addWord(naturalOrderInMapNaturalInGroups, word, false);
            addWord(alphabeticOrderInMapNaturalInGroups, word, false);
            addWord(naturalOrderInMapSortedInGroups, word, true);
            addWord(alphabeticOrderInMapSortedInGroups, word, true);
        }
        System.out.println("Natural order in map, natural order in groups:");
        printWords(naturalOrderInMapNaturalInGroups);
        System.out.println();
        System.out.println("Alphabetic order in map, natural order in groups:");
        printWords(alphabeticOrderInMapNaturalInGroups);
        System.out.println();
        System.out.println("Natural order in map, sorted in groups:");
        printWords(naturalOrderInMapSortedInGroups);
        System.out.println();
        System.out.println("Alphabetic order in map, sorted in groups:");
        printWords(alphabeticOrderInMapSortedInGroups);
    }

    private static void addWord(Map<Character, Set<String>> wordsByGroups, String word, boolean isSortedInGroup) {
        char firstLetter = word.toUpperCase().charAt(0);
        if (wordsByGroups.containsKey(firstLetter)) {
            wordsByGroups.get(firstLetter).add(word);
        } else {
            Set<String> wordList;
            if (isSortedInGroup) {
                wordList = new TreeSet<>(String::compareToIgnoreCase);
            } else {
                wordList = new LinkedHashSet<>();
            }
            wordList.add(word);
            wordsByGroups.put(firstLetter, wordList);
        }
    }

    private static void printWords(Map<Character, Set<String>> groupedWords) {
        for (Map.Entry<Character, Set<String>> entry : groupedWords.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
