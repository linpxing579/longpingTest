package Leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution20 {

    public boolean isValid1(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stringBuilder.append(s.charAt(i));
                continue;
            }

            if (stringBuilder.length() == 0) {
                return false;
            }
            Character character = stringBuilder.charAt(stringBuilder.length() - 1);
            if (s.charAt(i) == ')' && character == '(') {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            } else if (s.charAt(i) == '}' && character == '{') {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            } else if (s.charAt(i) == ']' && character == '[') {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            } else {
                return false;
            }
        }

        return stringBuilder.length() == 0;
    }

    private HashMap<Character, Character> mappings;

    public Solution20() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (this.mappings.containsKey(c)) {

                char topElement = stack.empty() ? '#' : stack.pop();

                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }


    @Test
    public void test(){
        System.out.println(isValid("([)]"));
    }
}
