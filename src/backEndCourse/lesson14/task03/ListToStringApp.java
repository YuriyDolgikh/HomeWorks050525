package backEndCourse.lesson14.task03;

import java.util.Arrays;
import java.util.List;

public class ListToStringApp {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("John", "Maria", "Nicole", "Sophia", "Linda", "Maxim");

        System.out.println(strings.stream().reduce((accum, str) -> accum + str + ", ").orElse("Collection is empty"));
    }
}
