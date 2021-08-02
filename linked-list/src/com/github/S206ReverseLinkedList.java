package com.github;

/**
 * 反转链表
 *
 * @author ZhangFuQi
 * @date 2021/8/2 21:03
 */
public class S206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
