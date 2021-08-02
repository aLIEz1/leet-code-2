package com.github;

/**
 * 两两交换链表中的节点
 * dummyHead的妙用
 *
 * @author ZhangFuQi
 * @date 2021/8/2 21:12
 */
public class S24SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        //虚拟头节点
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead.next;
        ListNode cur = null;
        if (pre != null) {
            cur = dummyHead.next.next;
        }
        ListNode pair = dummyHead;
        while (cur != null) {
            //保存cur的next节点，因为下面要对cur.next赋值，会丢失原来的cur.next；
            ListNode next = cur.next;
            //改变指向
            cur.next = pre;
            pre.next = next;

            //改变前一个pair的后一个指针的指向
            pair.next = cur;
            //更新节点
            pair = pre;
            pre = pre.next;
            //当pre.next为空的时候，直接退出循环
            if (pre == null) {
                break;
            }
            cur = pre.next;
        }
        return dummyHead.next;
    }
}
