package com.winding_month.practice_001;

/**
 * 
 * [
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]
	帕斯卡三角型
	规律：
		第k层有k个元素
		每层第一个以及最后一个元素值为1
		对于第k（k > 2）层第n（n > 1 && n < k）个元素A[k][n]，A[k][n] = A[k-1][n-1] + A[k-1][n]
 * @author Eric
 */
public class PascalsTriangle {

	//生成帕斯卡三角形中指定的某一行  不创建新的数组
	public void generateRow(int row) {
		int[] arr = new int[row];
		
		for(int i=0; i<row; i++) {
			if(i<2) {
				arr[i] = 1;
			} else {
				arr[0] = 1;
				arr[i] = 1;
				/**
				 * 为什么要从后往前循环
				 * 假设现在数组存放的第3层的数据，[1, 3, 3, 1]，如果我们需要计算第4层的数据，
				 * 如果我们从前往后计算，譬如A[4][2]= A[3][1] + A[3][2]，也就是4，
				 * 但是因为只有一个数组，所以需要将4这个值覆盖到2这个位置，那么我们计算A[4][3]的时候就会出现问题了，
				 * 因为这时候A[3][2]不是3，而是4了。
				 * 为了解决这个问题，我们只能从后往前计算，
				 * 仍然是上面那个例子，我们实现计算A[4][3] = A[3][2] + A[3][3]，也就是6，
				 * 我们将6直接覆盖到3这个位置，但不会影响我们计算A[4][2]，
				 * 因为A[4][2] = A[3][1] + A[3][2]，已经不会涉及到3这个位置了
				 */
				for(int j=i-1; j>0; j--) {
					 arr[j] = arr[j] + arr[j-1];
				}
			}
		}
		
		for(int k=0; k<row; k++) {
			System.out.print(arr[k]);
		}
		
	}
	
	public void generate(int numRows) {
		
		int[][] vals = getArr(numRows);   //金字塔二维数组
		for(int i=0; i<numRows; i++) {
			vals[i][0] = 1;
			vals[i][i] = 1;
			
			if(i >= 2) {
				//中间部分的赋值
				for(int j=1; j<i; j++ ) {
					vals[i][j] = vals[i-1][j-1] + vals[i-1][j];
				}
			}
		}
		 
		for(int m=0; m<vals.length; m++) {
			for(int n =0; n<vals[m].length; n++) {
				System.out.print(vals[m][n]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	private int[][] getArr(int size) {
		int [][] arr ;  
		arr = new int[size][];    
		for (int i = 0; i < size; i++) {  
			arr [i] = new int[i+1];    
		}
		return arr;
	}
	
	public static void main(String[] args) {
		PascalsTriangle pt = new PascalsTriangle();
		pt.generate(5);
		
		pt.generateRow(4);
	}
}
