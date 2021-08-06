package com.github;

/**
 * 合并两个有序数组
 *
 * @author ZhangFuQi
 * @date 2021/8/6 20:05
 */
public class S88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1;
        int b = n - 1;
        int cur = m + n - 1;
        while (b >= 0 || a >= 0) {
            if (b == -1) {
                nums1[cur] = nums1[a];
                a--;
            } else if (a == -1) {
                nums1[cur] = nums2[b];
                b--;
            } else if (nums1[a] > nums2[b]) {
                nums1[cur] = nums1[a];
                a--;
            } else if (nums1[a] < nums2[b]) {
                nums1[cur] = nums2[b];
                b--;
            } else {
                nums1[cur] = nums1[a];
                nums1[cur - 1] = nums1[a];
                a--;
                b--;
                cur--;
            }
            cur--;
        }
    }
}
