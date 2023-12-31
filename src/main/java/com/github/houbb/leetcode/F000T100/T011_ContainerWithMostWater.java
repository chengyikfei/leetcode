package com.github.houbb.leetcode.F000T100;

/**
 * 方格之间保留水的面积最大。
 *
 * 1. 水墙壁的宽度忽略，相邻2个间距为下标的差。
 * 2. 不可以倾斜。
 * 3. n 至少为 2
 * 4.考虑水的流动性，高度只能等于最短的。
 *
 * 图中有一个不合理的地方（或者中间挡板是可以让水通过的），可以考虑把中间挡板直接移除。
 *
 * 简单思路：遍历穷举
 * 进阶思路：DP
 *
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-11 14:57:39
 */
public class T011_ContainerWithMostWater {

    /**
     * 计算最大面积
     *
     * 优化思路：重复计算的跳过。
     *
     * Runtime: 843 ms, faster than 5.04% of Java online submissions for Container With Most Water.
     * Memory Usage: 39.4 MB, less than 94.66% of Java online submissions for Container With Most Water.
     *
     * @param height 高度
     * @return 结果
     * @since v1
     */
    public int maxArea(int[] height) {
        int maxResult = -1;
        for(int i = 0; i < height.length; i++) {
            for(int j = 0; j < height.length; j++) {
                // 跳过自身相等的元素
                if(i == j) {
                    continue;
                }

                int hi = height[i];
                int hj = height[j];
                int min = Math.min(hi, hj);
                int x = Math.abs(j - i);
                int area = x * min;

                if(area > maxResult) {
                    maxResult = area;
                }
            }
        }

        return maxResult;
    }

}
