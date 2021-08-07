package com.github;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 有效的括号
 *
 * @author ZhangFuQi
 * @date 2021/8/8 1:20
 */
public class S20ValidParentheses {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(arr[i]);
                }
            } else if (arr[i] == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(arr[i]);
                }
            } else if (arr[i] == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(arr[i]);
                }
            } else {
                stack.push(arr[i]);
            }
        }
        return stack.isEmpty();
    }
}
