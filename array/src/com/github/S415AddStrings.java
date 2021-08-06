package com.github;

/**
 * 字符串相加
 *
 * @author ZhangFuQi
 * @date 2021/8/6 17:35
 */
public class S415AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;

        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            //如果i大于0，则加上num1.charAt(i)-'0'否则加上0
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            //同上
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            //结果等于两个相加加上上一位的进位
            int result = x + y + add;
            //添加到结果里
            sb.append(result % 10);
            //更新下一位的进位
            add = result / 10;
            //同时收缩区间
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        sb.reverse();
        return sb.toString();
    }

}
