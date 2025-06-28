package backEndCourse.summarySessions.summaryBE01.translator;

import java.util.ArrayList;
import java.util.HashMap;

public class WordBase {

    private final HashMap<String, ArrayList<String>> vocabulary;

    public WordBase() {
        this.vocabulary = new HashMap<>();
    }

    public void addWord(String word, String translation) {
        if (vocabulary.containsKey(word)) {
            vocabulary.get(word).add(translation);
        } else {
            ArrayList<String> translations = new ArrayList<>();
            translations.add(translation);
            vocabulary.put(word, translations);
        }
    }

    public ArrayList<String> getTranslations(String word) {
        return vocabulary.get(word);
    }

    public HashMap<String, ArrayList<String>> getVocabulary() {
        return vocabulary;
    }

    public void removeWord(String word) {
        vocabulary.remove(word);
    }
}
