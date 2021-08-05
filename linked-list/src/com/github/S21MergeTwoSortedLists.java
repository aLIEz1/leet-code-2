package com.github;

/**
 * 合并两个有序链表
 *
 * @author ZhangFuQi
 * @date 2021/8/5 0:32
 */
public class S21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode aHead = l1;
        ListNode bHead = l2;
        ListNode listNode = new ListNode();
        if (aHead == null && bHead != null) {
            listNode.next = bHead;
            return listNode;
        }
        if (aHead != null && bHead == null) {
            listNode.next = aHead;
            return listNode;
        }
        if (aHead != null) {
            if (aHead.val > bHead.val) {
                listNode.val = bHead.val;
                bHead = bHead.next;
            } else if (aHead.val < bHead.val) {
                listNode.val = aHead.val;
                aHead = aHead.next;
            } else {
                listNode.val = aHead.val;
                ListNode next = new ListNode(aHead.val);
                listNode.next = next;
                listNode = next;
                bHead = bHead.next;
                aHead = aHead.next;
            }
            listNode.next = mergeTwoLists(aHead, bHead);
        }
        return listNode;
    }
}
