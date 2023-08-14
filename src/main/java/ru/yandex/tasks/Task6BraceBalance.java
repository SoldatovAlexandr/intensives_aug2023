package ru.yandex.tasks;

import java.util.Map;
import java.util.Stack;

public class Task6BraceBalance {

    private static final Map<Character, Character> brackets = Map.of(
            '(', ')', '[', ']', '{', '}'
    );

    public static boolean checkBalance(String sequence) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : sequence.toCharArray()) {
            if (brackets.containsKey(bracket)) {
                stack.push(brackets.get(bracket));
            } else {
                if (!stack.pop().equals(bracket)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void selfCheck() {
        String test1 = "[({})]{[]}";
        String test2 = "{({})}{";

        assert checkBalance(test1);
        assert !checkBalance(test2);
    }
}
