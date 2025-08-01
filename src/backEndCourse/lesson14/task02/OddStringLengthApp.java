package backEndCourse.lesson14.task02;

import java.util.Arrays;
import java.util.List;

public class OddStringLengthApp {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("John", "Maria", "Nicole", "Sophia", "Linda", "Maxim");

        System.out.println(strings.stream().filter(str -> str.length() % 2 != 0).toList());
    }
}
