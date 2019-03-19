package com.winding_month.practice_001;

/**
 * 计算一个轮转的数组中的最小值,
 * 给定的数组是轮转有序的
 * [7,2,3,5,6]
 * [5,6,7,2,3]
 *
 */
public class FindMinimumInRotatedSortedArray {


    private int getMin(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }
        if(arr.length == 1) {
            return arr[0];
        }
        if(arr.length == 2) {
            Math.min(arr[0], arr[1]);
        }

        int start = 0;
        int end = arr.length-1;

        while(start < end-1) {  //减一是为了能达到临界点   不然条件永远成立   毕竟一个头一个尾 两个点不可能重叠

            /** 表示数组按照从小到大的顺序排列着 */
            if(arr[start] < arr[end]) {
                return arr[start];
            }

            int mid = (int)Math.ceil((start + end) / 2);

            if(arr[start] > arr[mid]) {
                end = mid;
            } else if (arr[start] < arr[mid]) {
                start = mid;
            }
            /** 如果数组中有重复的元素，只需要将开始指针继续偏移即可 */
            else {
            	start ++;
            }
        }

        return Math.min(arr[start], arr[end]);
    }
    
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();
        int [] arr = new int[]{7,2,3,5,6};
        int min = f.getMin(arr);
        System.out.println(min);
    }

}
