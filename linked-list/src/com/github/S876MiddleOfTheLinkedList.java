package com.github;

/**
 * 链表的中间节点
 *
 * @author ZhangFuQi
 * @date 2021/8/8 0:31
 */
public class S876MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null) {
            return slow.next;
        } else {
            return slow;
        }
    }
}
