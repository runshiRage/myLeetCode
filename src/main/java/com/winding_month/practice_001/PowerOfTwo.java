package com.winding_month.practice_001;

/**
 * 判断一个数是不是2的整数幂
 * 2的整数次幂对应的二进制是只有0个或1个1；
 */
public class PowerOfTwo {

    private boolean isPowerOfTwo(int n) {
        if(n < 0) {
            return false;
        }

        boolean isHasOne = false;

        while(n > 0) {
            /** 位与运算 */
            if((n & 1) == 1 ? true : false) {

                if(isHasOne) {
                    return false;
                } else {
                    isHasOne = true;
                }
            }
            /** 二进制右移 */
            n >>= 1;
        }
        return isHasOne;
    }

    public static void main(String[] args) {
        PowerOfTwo pot = new PowerOfTwo();
        boolean isPOT = pot.isPowerOfTwo(9);
        System.out.println(isPOT);
    }
}
