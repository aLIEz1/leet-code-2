package com.github;

/**
 * 合并两个有序链表
 *
 * @author ZhangFuQi
 * @date 2021/8/5 0:32
 */
public class S21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        if (l1 != null) {
            if (l1.val < l2.val) {
                node.val = l1.val;
                node.next = mergeTwoLists(l1.next, l2);
            } else if (l1.val > l2.val) {
                node.val = l2.val;
                node.next = mergeTwoLists(l1, l2.next);
            } else {
                node.val = l1.val;
                ListNode listNode = new ListNode(l1.val);
                node.next = listNode;
                listNode.next = mergeTwoLists(l1.next, l2.next);
            }
        }
        if (l1 == null) {
            return null;
        }
        return node;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
