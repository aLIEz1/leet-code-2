package com.github;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用栈实现队列
 *
 * @author ZhangFuQi
 * @date 2021/8/7 21:33
 */
public class S232ImplementQueueUsingStacks {
    static class MyQueue {

        private final Deque<Integer> stack1;
        private Deque<Integer> stack2;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            //stack2为空
            stack2EmptyAction();
            return stack2.pop();
        }

        private void stack2EmptyAction() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }

        /**
         * Get the front element.
         */
        public int peek() {
            stack2EmptyAction();
            return stack2.peek();


        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
