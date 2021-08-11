package com.github;

/**
 * 删除排序链表中的重复元素2
 *
 * @author ZhangFuQi
 * @date 2021/8/11 21:20
 */
public class S82RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode l = head;
        ListNode r = head.next;
        while (r != null) {
            if (l.val != r.val) {
                r = r.next;
                pre = l;
                l = l.next;
            } else {
                while (r != null && l.val == r.val) {
                    r = r.next;
                }
                pre.next = r;
                l = pre;
            }
        }
        return dummyHead.next;
    }
}
