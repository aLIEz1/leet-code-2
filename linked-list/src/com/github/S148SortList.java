package com.github;

/**
 * 排序链表
 *
 * @author ZhangFuQi
 * @date 2021/8/11 23:43
 */
public class S148SortList {
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode head, ListNode tail) {
        if (head == tail) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode l1 = sort(slow.next, tail);
        slow.next = null;
        ListNode l2 = sort(head, slow);
        return merge(l1, l2);

    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }


}
