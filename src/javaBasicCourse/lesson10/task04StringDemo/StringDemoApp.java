package javaBasicCourse.lesson10.task04StringDemo;

public class StringDemoApp {
    public static void main(String[] args) {
        StringService strUtils = new StringService();
        String str = new String("I study Basic Java!");
        strUtils.printString(str);
        System.out.println("Last char of the string: '" + strUtils.getLastSymbol(str) + "'");
        System.out.println("Is the string contains substring?: " + strUtils.isContains(str, "Java"));
        System.out.println("The string with changed symbols: " + strUtils.changeSymbols(str, 'a', 'o'));
        System.out.println("To upper case: " + str.toUpperCase());
        System.out.println("To lower case: " + str.toLowerCase());
        System.out.println("Cut substring 'Java': " + str.substring(str.indexOf("Java"), str.indexOf("Java") + 4));
    }
}
