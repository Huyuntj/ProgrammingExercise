package com.java.algorithm.string;

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsK {

	//O(n) solution
    public static int maxSubArrayLen(int[] nums, int k) {
    	HashMap<Integer, Integer> map = new HashMap();
    	int sum = 0;
    	int max = 0;
        for(int i = 0; i<nums.length; i++){
        	sum += nums[i];
        	if(sum == k){
        		max = i+1;//if sum == k, then i+1 must be the max value 
        	}else{
        		if(map.containsKey(sum-k)){
        			max = Math.max(max,(i - map.get(sum-k)));
        		}
        	}
        	//have to notice that, we should put the sum of first concurrence to make sure the sub array is the longest
        	if(!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1, -1, 5, -2, 3};
		int[] nums2 = {-2, -1, 2, 1};
		int[] nums3 = {1,0,-1};
		System.out.println(MaximumSizeSubarraySumEqualsK.maxSubArrayLen(nums1, 3));
		System.out.println(MaximumSizeSubarraySumEqualsK.maxSubArrayLen(nums2, 1));
		System.out.println(MaximumSizeSubarraySumEqualsK.maxSubArrayLen(nums3, -1));
	}

}
