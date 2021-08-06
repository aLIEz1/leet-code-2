package com.github;

/**
 * 反转链表2
 *
 * @author ZhangFuQi
 * @date 2021/8/6 23:24
 */
public class S92ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode l = dummyHead;
        int count = 0;
        while (l != null) {
            if (count == left - 1) {
                break;
            }
            count++;
            l = l.next;
        }
        ListNode r = dummyHead;
        count = 0;
        while (r != null) {
            if (count == right) {
                break;
            }
            count++;
            r = r.next;
        }
        //变量能提尽量提出来，防止引用复杂出错
        ListNode tail = r.next;
        ListNode pre = l;
        ListNode headL = l.next;
        ListNode reverse = reverse(headL, tail);
        pre.next = reverse;
        headL.next = tail;
        return dummyHead.next;
    }

    private ListNode reverse(ListNode head, ListNode r) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != r) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
