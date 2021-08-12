package com.github;

/**
 * 回文链表
 *
 * @author ZhangFuQi
 * @date 2021/8/13 1:13
 */
public class S234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reverse = reverse(slow);

        while (reverse != null && head != null) {
            if (reverse.val != head.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
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
