package backEndCourse.lesson06.translator;

import utils.UserInputStatic;

import java.util.HashMap;
import java.util.Map;

public class TranslatorApp {
    public static void main(String[] args) {
        Map<String, String> wordBase = new HashMap<>();
        wordBase.put("way", "способ");
        wordBase.put("fly", "полёт");
        wordBase.put("screen", "эран");
        wordBase.put("get", "получать");
        wordBase.put("can", "иметь возможность");
        System.out.println(wordBase);

        String word = UserInputStatic.inputText("Enter the word to translate: ");
        String translation = wordBase.get(word);
        if (translation != null) {
            System.out.println("Translation: " + translation);
        } else {
            System.out.println("No translations for the word: " + word);
        }
        System.out.println("We will remove this word:" + word);
        wordBase.remove(word);
        System.out.println("After removing the word:");
        System.out.println(wordBase);
    }
}
