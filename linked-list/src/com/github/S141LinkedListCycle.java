package com.github;

/**
 * 环形链表
 *
 * @author ZhangFuQi
 * @date 2021/8/5 23:56
 */
public class S141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //自己注意点循环终止条件，本题唯一的容易出错的点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
