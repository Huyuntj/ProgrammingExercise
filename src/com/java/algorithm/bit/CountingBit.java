package com.java.algorithm.bit;

import com.java.algorithm.utility.PrintHelper;


public class CountingBit {
	//338. Counting Bit, Medium
	//Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
	//
	//Example:
	//For num = 5 you should return [0,1,1,2,1,2].
	//
	//Follow up:
	//
	//It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
	//Space complexity should be O(n).
	//Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
	//Hint:
	//
	//You should make use of what you have produced already.
	//Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
	//Or does the odd/even status of the number help you in calculating the number of 1s?	
    public static int[] countBits(int num) {
        if(num <=0) return new int[1];
        int[] dp = new int[num+1];
        dp[1] = 1;
        int idx =2;
        int pow = 1;
        while(idx <= num){
            if(idx == pow *2){
                pow = pow*2;
                dp[idx++] = 1;
            }else{
                dp[idx] = dp[pow] + dp[idx-pow];
                idx++;
            }
        }
        return dp;
    }
//    190. Reverse Bits Easy
//    Reverse bits of a given 32 bits unsigned integer.
//
//    For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
//
//    Follow up:
//    If this function is called many times, how would you optimize it?
//
//    Related problem: Reverse Integer
//

    public static int reverseBits(int n) {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i<32;i++){
            s.append(n&1);
            n = n>>>1;
        }
        return Integer.parseUnsignedInt(s.toString(),2);
    }
    
    public static int reverseBits2(int n) {
        int res = 0;
        for(int i = 0; i<32;i++){
            res = (res<<1) | ((n>>>i)&1);
//            n >>>= 1;
        }
        return res;
    }
	public static void main(String[] args) {
		int num = 2;
//		SortHelper.print(CountingBit.countBits(num));
		System.out.println(CountingBit.reverseBits2(1));
	}

}
