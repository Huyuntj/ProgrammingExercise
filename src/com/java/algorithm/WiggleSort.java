package com.java.algorithm;

import java.util.Arrays;

public class WiggleSort {
    public static void wiggleSort(int[] nums) {
        if(nums == null) return;
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        for(int i =0; i< tmp.length/2; i++){
            nums[i*2] = tmp[i];
        }
        int k;
        if(tmp.length % 2 != 0){//odd number
            nums[tmp.length -1] = tmp[tmp.length/2];
            k = tmp.length - 2;
            for(int j = tmp.length/2+1; j<tmp.length; j++){
                nums[k] = tmp[j];
                k -= 2;
            }            
        }else{
            k = tmp.length -1;
            for(int j = tmp.length/2; j<tmp.length; j++){
                nums[k] = tmp[j];
                k -= 2;
            }            
        }
        for(int index = 0; index < nums.length;index++){
        	System.out.print(nums[index] +"	");; 
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,3};
		WiggleSort.wiggleSort(nums);

	}

}
