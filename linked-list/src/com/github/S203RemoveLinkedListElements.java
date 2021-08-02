package com.github;

/**
 * 移除链表元素
 *
 * @author ZhangFuQi
 * @date 2021/8/2 16:25
 */
public class S203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead.next;
        ListNode pre = dummyHead;
        while (cur != null) {
            //当cur等于val的时候，pre不用动，cur=cur.next即可，
            // 因为此时删除了cur节点，cur节点的前一个节点仍然是原来的pre
            if (cur.val == val) {
                pre.next = cur.next;
                //当cur不等于val的时候，cur与pre同时后移
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
