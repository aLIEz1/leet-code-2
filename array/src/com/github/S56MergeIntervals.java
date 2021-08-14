package com.github;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 合并区间
 *
 * @author ZhangFuQi
 * @date 2021/8/14 19:45
 */
public class S56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int start = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            //这种情况对应下一个的最小值比当前i-1的最大值要大，直接添加到res中去，更新start为下一个的最小值
            if (intervals[i][0] > intervals[i - 1][1]) {
                res.add(new int[]{start, intervals[i - 1][1]});
                start = intervals[i][0];
                //这种情况说明下一个的最小值小于等于当前i-1的最大值了，这种情况需要合并区间，两个区间的最大值取最大的哪一个给i的最大值
            } else {
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            }
        }
        //加上最后一种情况
        res.add(new int[]{start, intervals[intervals.length - 1][1]});
        return res.toArray(new int[res.size()][]);
    }
}
