package com.github;

/**
 * 合并K个升序链表
 *
 * @author ZhangFuQi
 * @date 2021/8/6 23:59
 */
public class S23MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode ans = null;
        for (int i = lists.length - 1; i >= 0; i--) {
            ans = merge(ans, lists[i]);
        }
        return ans;
    }

    private ListNode merge(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        } else if (a.val < b.val) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }
}
