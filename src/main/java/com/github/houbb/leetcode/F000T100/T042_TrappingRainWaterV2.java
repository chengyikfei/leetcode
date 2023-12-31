package com.github.houbb.leetcode.F000T100;

/**
 * @author d
 * @since 1.0.0
 */
public class T042_TrappingRainWaterV2 {

    public static void main(String[] args) {
        T042_TrappingRainWaterV2 v1 = new T042_TrappingRainWaterV2();

        int trap2 = v1.trap(new int[]{4,2,0,3,2,5});
        System.out.println(trap2);
    }

    /**
     * 计算
     *
     * 1. 计算 i 位置，左右两边的高度
     *
     * 2. 累加每一列的信息
     *
     * 优化思路：首先把每一位的高度处理好，通过 dp 递推。
     *
     * @param height 高度
     * @return 结果
     */
    public int trap(int[] height) {
        int n = height.length;

        // 初始化好对应的高度信息。
        int[] dpLeft = new int[n];
        dpLeft[0] = height[0];
        for(int i = 1; i < n-1; i++) {
            dpLeft[i] = Math.max(dpLeft[i-1], height[i]);
        }
        int[] dpRight = new int[n];
        dpRight[n-1] = height[n-1];
        for(int i = n-2; i >= 1; i--) {
            dpRight[i] = Math.max(dpRight[i+1], height[i]);
        }

        // 第一个，最后一列不用看。
        int sum = 0;
        for(int i = 1; i < n-1; i++) {
            int hl = dpLeft[i];
            int hr = dpRight[i];

            int h = Math.min(hl, hr);
            if(height[i] < h) {
                sum += (h - height[i]);
            }
        }
        return sum;
    }

}
