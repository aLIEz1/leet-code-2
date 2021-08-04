package com.github;

/**
 * K个一组翻转链表
 *
 * @author ZhangFuQi
 * @date 2021/8/2 22:37
 */
public class S25ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            //如果剩下的节点不足k个，直接返回
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        //此时b已经是指向k+1节点了，反转a 到 b之间的节点并返回，返回的节点类似下面
        // <-b  c->......->a->null
        ListNode reverse = reverse(a, b);
        //再让a的next等于递归的b的反转链表
        a.next = reverseKGroup(b, k);
        //最后返回直接返回reverse
        return reverse;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
