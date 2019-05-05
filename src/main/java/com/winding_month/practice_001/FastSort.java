package com.winding_month.practice_001;

import java.util.Arrays;

public class FastSort {


    public static void main(String[] args) {
        int[] a = new int[]{49,38,65,97,76,13,27};
        FastSort fs = new FastSort();
        fs.sort(a, 0, 6);
        System.out.println(Arrays.toString(a));
    }

    public void sort(int a[], int low, int high){
        int i=low;
        int j=high;
        int key=a[low];

        if (low < high){
            while(i<j){ // 此处的while循环结束，则完成了元素key的位置调整
                while(i<j&&key<=a[j]){
                    j--;
                }
                a[i]=a[j];
                while(i<j&&key>=a[i]){
                    i++;
                }
                a[j]=a[i];
                a[i]=key;  //此处不可遗漏/
            }
            sort(a,low,i-1);
            sort(a,i+1,high);
        }
    }
}
