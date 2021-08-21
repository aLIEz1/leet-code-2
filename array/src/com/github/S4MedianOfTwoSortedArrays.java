package com.github;

/**
 * 寻找两个正序数组的中位数
 *
 * @author ZhangFuQi
 * @date 2021/8/21 22:43
 */
public class S4MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m + n];
        int a = m - 1;
        int b = n - 1;
        int cur = m + n - 1;
        while (b >= 0 || a >= 0) {
            if (b == -1) {
                arr[cur] = nums1[a];
                a--;
            } else if (a == -1) {
                arr[cur] = nums2[b];
                b--;
            } else if (nums1[a] > nums2[b]) {
                arr[cur] = nums1[a];
                a--;
            } else if (nums1[a] < nums2[b]) {
                arr[cur] = nums2[b];
                b--;
            } else {
                arr[cur] = nums1[a];
                arr[cur - 1] = nums1[a];
                a--;
                b--;
                cur--;
            }
            cur--;
        }
        if ((m + n) % 2 != 0) {
            return arr[(m + n) >> 1];
        } else {
            return (double) (arr[(m + n) >> 1] + arr[(m + n - 1) >> 1]) / 2;
        }

    }

    public static void main(String[] args) {
        System.out.println(new S4MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
