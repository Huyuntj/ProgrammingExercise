package com.java.algorithm;

import java.util.Arrays;

public class PluseOne {
    public int[] plusOne(int[] digits) {
        int i;
        for(i = digits.length-1; i >= 0;i--){
            if(digits[i] < 9){
                digits[i]++;
                break;
            }else{
                digits[i] = 0;
            }
        }
        if(i == -1){
           int[] newDigits = new int[digits.length+1];
           newDigits[0] = 1;
           for(int j = 1; j< newDigits.length;j++){
               newDigits[j] = digits[j-1];
           }
           return newDigits;
        }else{
            return digits;
        }
    }
	public static void main(String[] args) {
		PluseOne po = new PluseOne();
		System.out.println(Integer.MAX_VALUE + 2);
		int [] results = po.plusOne(new int[]{2,1,4,7,4,8,3,6,4,8});
		System.out.println(Arrays.toString(results));

	}

}
