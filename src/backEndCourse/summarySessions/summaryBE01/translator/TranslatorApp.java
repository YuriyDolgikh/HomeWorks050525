package backEndCourse.summarySessions.summaryBE01.translator;

import utils.UserInputStatic;

import java.util.ArrayList;

public class TranslatorApp {
    public static void main(String[] args) {
        WordBase wordBase = new WordBase();
        wordBase.addWord("way", "путь");
        wordBase.addWord("way", "дорога");
        wordBase.addWord("way", "способ");
        wordBase.addWord("fly", "муха");
        wordBase.addWord("fly", "полёт");
        wordBase.addWord("screen", "эран");
        wordBase.addWord("screen", "проверять");
        wordBase.addWord("get", "получать");
        wordBase.addWord("get", "добраться");
        wordBase.addWord("can", "иметь возможность");
        wordBase.addWord("can", "консервная банка");
        System.out.println(wordBase.getVocabulary());

        String word = UserInputStatic.inputText("Enter the word to translate: ");
        ArrayList<String> translations = wordBase.getTranslations(word);
        if (translations != null) {
            System.out.println("Translations: " + translations);
        } else {
            System.out.println("No translations for the word: " + word);
        }
        System.out.println("We will remove this word:" + word);
        wordBase.removeWord(word);
        System.out.println("After removing the word:");
        System.out.println(wordBase.getVocabulary());
    }
}
