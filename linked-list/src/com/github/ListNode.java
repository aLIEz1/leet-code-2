package com.github;

/**
 * 链表节点
 *
 * @author ZhangFuQi
 * @date 2021/8/2 16:25
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
