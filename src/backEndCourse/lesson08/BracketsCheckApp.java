package backEndCourse.lesson08;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketsCheckApp {
    public static void main(String[] args) {

        String[] stringsForTest = {
                "(){}[]",
                "({})",
                "{([]([])}",
                "{([([([])])]([{}]))}",
                "{[([([])])]([{}]))}",
        };

        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');

        for (String arrayElement : stringsForTest) {
            System.out.println(isCorrectBracket(arrayElement, pairs) ? "Correct" : "Incorrect");
        }
    }

    private static boolean isCorrectBracket(String stringLine, Map<Character, Character> pairs) {
        if (stringLine == null ||
                stringLine.isEmpty() ||
                stringLine.length() % 2 != 0 ||
                pairs.containsKey(stringLine.charAt(0))) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char ch : stringLine.toCharArray()) {
            if (pairs.containsValue(ch)) {
                stack.push(ch);
            } else if (pairs.containsKey(ch)) {
                if (stack.empty() || stack.pop() != pairs.get(ch)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
