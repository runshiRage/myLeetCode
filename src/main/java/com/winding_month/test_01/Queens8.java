package com.winding_month.test_01;

/**
 * 八皇后问题
 * 八皇后问题是一个以国际象棋为背景的问题：如何能够在 8×8 的国际象棋棋盘上放置八个皇后，
 * 使得任何一个皇后都无法直接吃掉其他的皇后？为了达到此目的，任两个皇后都不能处于同一条横行、纵行或斜线上。
 * @author Eric
 */
public class Queens8 {

	int[] arr = new int[]{0,0,0,0,0,0,0,0,0};
	int n=8, cnt=0;
	
	/** 用于回溯条件判断
	 *  k[] 表示位置数组， a表示第几个皇后 */
	private boolean isConflict(int k[], int a) {
		for(int i=1; i<=n; ++i) {
			for(int j=0; j<=i-1; ++j) {
				if((arr[i]==arr[j]) || (Math.abs(arr[i]-arr[j]) == (i-j))) {
					return false;
				}
			}
		}
		return true;	
	}
	
	/** 第m个皇后 */
	public void isQueen(int m){
		int k=0;
		
		/** 递归结束 */
		if(m>n) {
			for (; k <= n; ++k) {
				System.out.println(arr[k]); 
			}
		} else {
			for(; k<=n; ++k) {
				arr[m] = k;
				if(isConflict(arr, m)) {
					isQueen(m+1);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Queens8 q8 = new Queens8();
		q8.isQueen(0);
	}
}
