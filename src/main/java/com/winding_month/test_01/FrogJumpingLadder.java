package com.winding_month.test_01;

/**
 * 青蛙跳阶梯，一次可以跳一阶或者两阶
 * 问在一个n阶梯中，有多少中跳法
 * @author Eric
 */
public class FrogJumpingLadder {

	public static void main(String[] args) {

		FrogJumpingLadder fjl = new FrogJumpingLadder();
		System.out.println(fjl.f(18));
		
	}
	
	   // 数组的大小根据具体情况来，由于int数组元素的的默认值是0
	   // 因此我们不用初始化
	   int[] arr = new int[1000];  // 巧用数组下标来优化递归函数
	   public int f(int n) {
	       if (n <= 2) {
	           return n;
	       } else {
	           if (arr[n] != 0) {
	               return arr[n];// 已经计算过，直接返回
	           } else {
	               arr[n] = f(n-1) + f(n-2);
	               return arr[n];
	           }
	       }
	   }
}
