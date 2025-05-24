package lesson10.task04StringDemo;

public class StringService {

    public void printString(String str) {
        System.out.println(str);
    }

    public char getLastSymbol(String str) {
        return str.charAt(str.length() - 1);
    }

    public boolean isContains(String str, String pattern){
        return str.contains(pattern);
    }

    public String changeSymbols(String str, char charFrom, char charTo){
        return str.replace(charFrom, charTo);
    }
}
