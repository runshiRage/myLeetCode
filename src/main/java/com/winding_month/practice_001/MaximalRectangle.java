package com.winding_month.practice_001;

import java.util.Stack;

/**
 * 求一个矩形中全部包含1的最大面积
 *     0 0 0 0
 *     1 1 1 1
 *     1 1 1 0
 *     0 1 0 0
 *
 *     ====》
 *
 *       0  0  0   0
 *      |--------|
 *      |1  1  1 | 1
 *      |1  1  1 | 0
 *      |--------|
 *       0  1  0   0
 */
public class MaximalRectangle {

    /** 将矩形的每一行转换为对应的直方图，进行直方图的最大面积计算 */



    public static void main(String[] args) {

        int[][] maxi = new int[][]{
                {0,0,1,0},
                {1,1,1,0},
                {1,1,1,1},
                {0,0,0,0}
        };

        MaximalRectangle mr = new MaximalRectangle();
        int area = mr.getMaxArea(maxi);
        System.out.println("MaximalRectangle : [" + area + "]");
    }

    private int getMaxArea(int[][] maxi) {

        int m = maxi.length;   //行
        int n = maxi[0].length;   //列

        int[][] height = new int[m][n];

        /** 构建一个高度直方图 */
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(maxi[i][j] == 0) {
                    height[i][j] = 0;
                } else {
                    /** 考虑第一行的情况 */
                    height[i][j] = (i==0)? 1 : height[i - 1][j] + 1;
                }
            }
        }

        int maxArea = 0;

        for(int i=0; i<m; i++) {
            Math.min(maxArea, largestRectangleArea(height[i]));
        }

        return maxArea;
    }


    private int largestRectangleArea(int[] arr) {
        int sum = 0;
        int i = 0;

        Stack<Integer> stack = new Stack<Integer>();

        /** 插入0是为了stack遍历的完整性 */
        stack.push(0);

        /** 注意i的变化 */
        while(i < arr.length) {
            if(stack.empty() || arr[i] > arr[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int t = stack.pop();
                sum = Math.max(sum, arr[t] * (stack.empty()? i : i-stack.peek()-1));
            }
        }
        return sum;
    }

}
