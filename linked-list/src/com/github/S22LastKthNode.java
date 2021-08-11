package com.github;

/**
 * 链表中倒数第k个节点
 *
 * @author ZhangFuQi
 * @date 2021/8/11 21:43
 */
public class S22LastKthNode {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (k-- > 0 && fast != null) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }
}
