package com.winding_month.practice_001;

import java.util.Stack;

/**
 * 计算直方图的最大矩形面积
 * 通过给一组数字   直方图的宽都是1，高度为数组值。
 */
public class LargestRectangleInHistogram {



    public static void main(String[] args) {

        /**
         *
         *
         *    |
         *  6 -                   \
         *    |                   \
         *  5 -              \    \
         *    |              \    \
         *  4 -              \    \
         *    |              \    \
         *  3 -              \    \         \
         *    |              \    \         \
         *  2 -    \         \    \    \    \
         *    |    \         \    \    \    \
         *  1 -    \    \    \    \    \    \
         *    |    \    \    \    \    \    \
         *    |====.====.====.====.====.====.====.==
         *    0    1    2    3    4    5    6    7
         */
        int[] arr = new int[]{2,1,5,6,2,3};

        Stack<Integer> stack = new Stack<Integer>();

//        while(i < arr.length) {
//            if(stack.empty() || arr[i] > arr[stack.peek()]) {
//                                
//            }
//        }

        LargestRectangleInHistogram lr = new LargestRectangleInHistogram();
        System.out.println(lr.getArr(arr));
        
    }
    
    /**
     * 
     */
    private int[] getArr(int[] arr) {
    
    	Stack<Integer> stack = new Stack<Integer>();
    	int[] result = new int[]{};
    	
    	for(int i=0; i<arr.length - 1; i++) {
    		if(!stack.empty() && arr[stack.peek()] < arr[i]) {
    			result[stack.peek()] = i - stack.peek();
    			stack.pop();
    		}
    		stack.push(i);
    		
    	}
    	
    	return result;
    }
}
