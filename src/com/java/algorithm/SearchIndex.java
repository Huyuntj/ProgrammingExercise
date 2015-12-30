package com.java.algorithm;

public class SearchIndex {

    public static int searchInsert(int[] nums, int target){
        int index = getSearchIndex(nums,0,nums.length-1,target);
        System.out.println(index);
        if(nums[index] < target) return index + 1;
        else return index;
    }
    
    public static int getSearchIndex(int[] nums, int low, int high, int target){
        if(low == high) return low;
        int middle = (low+high)/2;
        if(target > nums[middle] ){
            return getSearchIndex(nums,middle+1, high, target);
        }else{
            return getSearchIndex(nums,low, middle, target);
        }
    }
    
    public static void main(String[] args){
    	int[] nums = new int[]{1,3,5,6};
    	System.out.println(SearchIndex.searchInsert(nums, 7));
    }
}
