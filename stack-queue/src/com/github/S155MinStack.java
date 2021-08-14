package com.github;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈
 *
 * @author ZhangFuQi
 * @date 2021/8/14 22:46
 */
public class S155MinStack {
    static class MinStack {

        Deque<Integer> stack = new ArrayDeque<>();
        LinkedList<Integer> minList = new LinkedList<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            minList.addLast(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            if (val <= minList.getLast()) {
                minList.addLast(val);
            } else {
                minList.addFirst(val);
            }
        }

        public void pop() {
            int pop = stack.pop();
            if (pop == minList.getLast()) {
                minList.removeLast();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minList.getLast();
        }
    }
}
