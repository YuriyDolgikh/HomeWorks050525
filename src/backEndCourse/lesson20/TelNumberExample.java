package backEndCourse.lesson20;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelNumberExample {

    public static void main(String[] args) {

        String telNumber = "(+123) 1234567";

        String regexInternational ="\\(\\+\\d{3}\\)\\s\\d{7}";

        Pattern patternInternational = Pattern.compile(regexInternational);

        Matcher matcherInternational = patternInternational.matcher(telNumber);

        System.out.println(telNumber + " is correct? " + matcherInternational.matches());
    }
}
