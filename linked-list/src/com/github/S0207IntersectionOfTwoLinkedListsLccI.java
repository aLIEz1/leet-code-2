package com.github;

/**
 * 链表相交
 *
 * @author ZhangFuQi
 * @date 2021/8/2 21:45
 */
public class S0207IntersectionOfTwoLinkedListsLccI {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int sizeA = 0;
        int sizeB = 0;
        ListNode cur = a;
        while (cur != null) {
            sizeA++;
            cur = cur.next;
        }
        cur = b;
        while (cur != null) {
            sizeB++;
            cur = cur.next;
        }
        if (sizeA < sizeB) {
            //交换a b链表，让a 变成长的那个
            ListNode tempL = a;
            a = b;
            b = tempL;

            int temp = sizeA;
            sizeA = sizeB;
            sizeB = temp;
        }
        //对齐两个链表
        int gap = sizeA - sizeB;
        while (a != null) {
            if (gap == 0) {
                break;
            }
            gap--;
            a = a.next;
        }
        while (a != null && b != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }

}
