package com.github;

/**
 * 重排链表
 *
 * @author ZhangFuQi
 * @date 2021/8/7 23:57
 */
public class S143ReorderList {
    public void reorderList(ListNode head) {
        ListNode normal = head;
        ListNode reverse = head;

        reverse = reverse(reverse);
        while (normal != reverse && normal != null) {
            ListNode normalNext = normal.next;
            ListNode reverseNext = reverse.next;
            normal.next = reverse;
            reverse.next = normalNext;
            normal = normalNext;
            reverse = reverseNext;

        }
    }

    private ListNode reverse(ListNode reverse) {
        ListNode pre = null;
        ListNode cur = reverse;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
