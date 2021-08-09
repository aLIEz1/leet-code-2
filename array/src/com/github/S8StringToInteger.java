package com.github;

/**
 * 字符串转换整数
 *
 * @author ZhangFuQi
 * @date 2021/8/8 21:10
 */
public class S8StringToInteger {
    public int myAtoi(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                continue;
            }
            if (!flag && (arr[i] == '-' || arr[i] == '+')) {
                sb.append(arr[i]);
                flag = true;
            }
        }

        return 0;

    }
}
