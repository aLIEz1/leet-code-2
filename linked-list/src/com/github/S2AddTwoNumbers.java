package com.github;

/**
 * 两数相加
 *
 * @author ZhangFuQi
 * @date 2021/8/7 22:29
 */
public class S2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode dummyHead = new ListNode();
        dummyHead.next = listNode;
        int add = 0;
        while (l1 != null || l2 != null || add != 0) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int res = l1Val + l2Val + add;
            ListNode cur = new ListNode();
            cur.val = res % 10;
            listNode.next = cur;
            add = res / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        return dummyHead.next.next;
    }
}
