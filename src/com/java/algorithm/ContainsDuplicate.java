package com.java.algorithm;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	//erformance is bad
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            int j = i+k-1;
            if(j > nums.length-1) j =  nums.length-1;
            while( j < nums.length && (j > i)){
                if(nums[i] == nums[j]){
                    return true;
                }else{
                    j--;
                }
            }
        }
        return false;
    }
    
    public static boolean containsNearbyDuplicate2(int[] nums, int k){
    	Set<Integer> set = new HashSet<Integer>();
    	for(int i = 0; i < nums.length; i++){
    		if(i > k){
    			set.remove(nums[i-k-1]);
    		}
        	if(!set.add(nums[i])){
        		return true;
        	}
    	}
    	return false;

    }
    
    public boolean containsDuplicate(int[] nums) {
    	Set<Integer> set = new HashSet<Integer>();
    	for(int i = 0; i < nums.length; i++){
        	if(!set.add(nums[i])){
        		return true;
        	}
    	}
    	return false;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,2};
		System.out.println(ContainsDuplicate.containsNearbyDuplicate2(a, 2));
	}

}
