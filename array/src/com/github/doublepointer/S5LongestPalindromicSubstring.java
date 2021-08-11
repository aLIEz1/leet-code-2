package com.github.doublepointer;

/**
 * 最长回文子串
 *
 * @author ZhangFuQi
 * @date 2021/8/10 18:19
 */
public class S5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int maxLen = 0;
        String ans = "";
        for (int i = 0; i < arr.length; i++) {
            //字符串奇数个
            String s1 = palindrome(s, i, i);
            //字符串偶数个
            String s2 = palindrome(s, i, i + 1);
            ans = ans.length() > s1.length() ? ans : s1;
            ans = ans.length() > s2.length() ? ans : s2;
        }
        return ans;
    }

    private String palindrome(String s, int l, int r) {
        //中心扩展，相等就向两边阔开，直到不相等为止，注意边界条件
        while (l >= 0 && r < s.length() && s.charAt(r) == s.charAt(l)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        System.out.println(new S5LongestPalindromicSubstring().longestPalindrome("babad"));
    }
}
