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

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reversed = reverse(slow);
        while (reversed != null && normal != null) {
            ListNode normalNext = normal.next;
            ListNode reversedNext = reversed.next;
            normal.next = reversed;
            reversed.next = normalNext;
            normal = normalNext;
            reversed = reversedNext;
        }
        if (normal != null) {
            normal.next = null;
        }
        if (reversed != null) {
            reversed.next = null;
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
