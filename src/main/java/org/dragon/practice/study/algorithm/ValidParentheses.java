package org.dragon.practice.study.algorithm;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/6/3
 **/
public class ValidParentheses {
    public boolean isValid(String s) {
        char a = '(';
        char b = ')';
        char c = '[';
        char d = ']';
        char e = '{';
        char f = '}';
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == a || ch == c || ch == e) {
                stack.push(ch);
            } else if (ch == b) {
                char ch1 = stack.pop();
                if (ch1 == a) {
                    continue;
                } else {
                    return false;
                }
            } else if (ch == d) {
                char ch1 = stack.pop();
                if (ch1 == c) {
                    continue;
                } else {
                    return false;
                }
            } else if (ch == f) {
                char ch1 = stack.pop();
                if (ch1 == e) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.empty();

    }


    public boolean isValid2(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty() || stack.pop() != map.get(s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
