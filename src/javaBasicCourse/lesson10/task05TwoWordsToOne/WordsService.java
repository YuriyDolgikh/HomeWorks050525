package javaBasicCourse.lesson10.task05TwoWordsToOne;

import utils.UserInput;

public class WordsService {
    UserInput userInput =  new UserInput();

    public String getWord() {
        return userInput.inputText("Please enter your word");
    }

    public String combineWords(String word1, String word2) {
        return word1.substring(0, word1.length()/2) + word2.substring((int)Math.ceil(word2.length()/2.0));
    }
}
