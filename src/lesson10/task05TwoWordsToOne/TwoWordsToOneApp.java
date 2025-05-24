package lesson10.task05TwoWordsToOne;

public class TwoWordsToOneApp {
    public static void main(String[] args) {
        WordsService wordsSrv = new WordsService();
        String wordOne = wordsSrv.getWord();
        String wordTwo = wordsSrv.getWord();
        System.out.println("Combination of two words is: " + wordsSrv.combineWords(wordOne, wordTwo));
    }
}
