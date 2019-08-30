package com.winding_month.practice_001;

import java.util.Arrays;

/**
 * 图的搜索：
 * 广度优先算法  BFS  需要消耗大量内存  只适用与深度不深且子节点不多的树  能查找最短路径
 *      广度优先搜索旨在面临一个路口时，把所有的岔路口都记下来，
 *      然后选择其中一个进入，然后将它的分路情况记录下来，
 *      然后再返回来进入另外一个岔路，并重复这样的操作
 *
 * 深度优先算法  DFS  占用内存小  但不能查找最短路径
 * TODO  待完善的算法  根本没体现图的用处
 */
public class BinaryTreeLevelOrderTraversal {

    /** 匹配标志 */
    boolean isFound = false;

    public static void main(String[] args) {

        int[][] graph = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {100,14,15,34}};
        int[][] used = new int[4][4];

        BinaryTreeLevelOrderTraversal btlot = new BinaryTreeLevelOrderTraversal();
        btlot.DFSFindTarget(graph, used, 0, 0, 34);
    }

    private void DFSFindTarget(int[][] graph, int[][] used, int x, int y, int target) {

        /** 控制坐标的方向 */
        int[] wx = {-1, 0, 1, 0};
        int[] wy = {0, -1, 0, 1};

        if(graph[x][y] == target) {
            System.out.println("found the target! is : [" + x + "], [" + y + "]");
            for(int i=0; i<used.length; i++) {
                System.out.println("used id : " + Arrays.toString(used[i]));
            }
            isFound = true;
            return;
        }

        for(int i=0; i<4; i++) {
            if(x+wx[i] < 0 || x+wx[i] >= 4 || y+wy[i] < 0 || y+wy[i] >= 4) {
                continue;
            }
            /** 遍历四个方向， 为被走过的各自并且目标还未被查找 */
            if(used[x+wx[i]][y+wy[i]] == 0 && !isFound) {
                /** 设置为走过 */
                used[x+wx[i]][y+wy[i]] = 1;
                DFSFindTarget(graph, used, x+wx[i], y+wy[i], target);
                used[x+wx[i]][y+wy[i]] = 0;
            }
        }



    }


}
