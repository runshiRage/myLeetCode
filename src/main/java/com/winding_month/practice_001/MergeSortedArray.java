package com.winding_month.practice_001;

/**
 * 合并两个有序数组
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note: You may assume that A has enough space (size that is greater or equal to m + n) 
 * to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 * @author Eric
 */
public class MergeSortedArray {

	public int[] mergeArr(int[] arrA, int[] arrB) {
		
		int cursorA = arrA.length - 1;
		int cursorB = arrB.length - 1;
		int cursorM = 0;
		int total = arrA.length + arrB.length;
		int[] arrM = new int[total];
		
		while(cursorM < total) {
			
			if(cursorA >= 0 && cursorB >= 0) {
				if(arrA[cursorA] < arrB[cursorB]) {
					arrM[cursorM] = arrB[cursorB];
					cursorB --;
				} else if(arrA[cursorA] >= arrB[cursorB]) {
					arrM[cursorM] = arrA[cursorA];
					cursorA --;
				}
			} else if(cursorA >= 0) {
				arrM[cursorM] = arrA[cursorA];
				cursorA --;
			} else if(cursorB >= 0) {
				arrM[cursorM] = arrB[cursorB];
				cursorB --;
			}
			cursorM ++;
			
		}
		return arrM;
	}
	
	public static void main(String[] args) {
		
		int[] arrA = new int[]{3,5,7,8,9,10};
		int[] arrB = new int[]{1,3,4,6,89,99,102};
		
		MergeSortedArray msa = new MergeSortedArray();
		int[] arr = msa.mergeArr(arrA, arrB);
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
}
