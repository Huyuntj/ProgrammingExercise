package com.java.algorithm.bit;

public class NumberOf1Bits {
//	191. Number of 1 bit. Easy
//	Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
//
//	For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
//
//	Credits:
//	Special thanks to @ts for adding this problem and creating all test cases.
   public static int hammingWeightWithLong(int n) {
//        if(n == Integer.MAX_VALUE) return 1;
	   long ln = ((long) n) & 0xffffffffL; 
        int count = 0;
//        if(n<0 && n>=Integer.MIN_VALUE){
//            count++;
//            n = -n;
//        }
        while(ln != 0){
            count = (ln%2 == 1) ? (count+1): count;
            ln /= 2;
        }
        return count;
    }
   public static int hammingWeight(int n) {	   
       int count = 0;
       while(n!=0){
          count += n & 1 ;
          n >>>=1;
       }
       return count;
       
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;
		System.out.println(NumberOf1Bits.hammingWeight(n));
		System.out.println(Integer.toBinaryString(n));
		System.out.println(-1/2);
	}

}
