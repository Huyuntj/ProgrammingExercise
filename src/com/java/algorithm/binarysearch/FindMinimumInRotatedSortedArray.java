package com.java.algorithm.binarysearch;

public class FindMinimumInRotatedSortedArray {
	//153. Easy; 154. Medium
	//duplicates are not allowed
    public static int findMin(int[] nums) {
        int i = 0;
        for(; i<= nums.length-2;i++){
            if(nums[i+1]<nums[i]) return nums[i+1];
        }
        return nums[0];
    }

	public static int findMax(int[] arr){
		int i = 1;
		for(; i<arr.length;i++){
			if(arr[i-1] > arr[i]) return arr[i-1];
		}
		return arr[i-1];
	}
	
    public  static int findMinBinarySearch(int[] nums) {
        int low = 0; int hi = nums.length-1;
        while(low < hi){
        	int mid = (low+hi)/2;
        	if(nums[mid] > nums[hi]){
        		low = mid+1;
        	}else if(nums[mid] < nums[hi]){
        		hi = mid;
        	}else{
        		hi--;
        	}
        }
        return nums[hi];
    }

// 33. Hard
//    Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//    You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//    You may assume no duplicate exists in the array.    
    public static int search(int[] nums, int target) {
        int lo = 0; int hi = nums.length-1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(target == nums[mid]) return mid;
            else if(nums[lo] <= nums[mid]){//left side is sorted
            	if(target < nums[mid] && target >= nums[lo]) {
            		hi = mid -1;
            	}else{
            		lo = mid + 1;
            	}
            }else if(nums[mid] <= nums[hi]){//right side is sorted
            	if(target<= nums[hi] && target > nums[mid]){
            		lo = mid + 1;
            	}else{
            		hi = mid - 1;
            	}
            }
        }
        return -1;
        
    }
    //recursive method
    public int search(int[] nums, int lo, int hi, int target){
        if(lo > hi) return -1;
        int mid = (lo+hi)/2;
        if(nums[mid] == target) return mid;
        if(nums[lo] <= nums[mid]){// left side is sorted
            if(target<nums[mid]&& target >=nums[lo]){//target is in the left side
                return search(nums,lo, mid -1, target);
            }else{
                return search(nums,mid+1, hi, target);
            }
        }else if(nums[mid] <= nums[hi]){
            if(target<=nums[hi] &&target >nums[mid]){
                return search(nums,mid+1, hi, target);
            }else{
                return search(nums,lo, mid-1, target);
            }
        }
        return -1;
    }
//    154. Medium
//    Follow up for "Find Minimum in Rotated Sorted Array":
//    	What if duplicates are allowed?
//
//    	Would this affect the run-time complexity? How and why?
//    	Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//    	(i.e., 0 1 2 4 5 6 7 might become  5 6 7 0 1 2 3 ).
//
//    	Find the minimum element.
//
//    	The array may contain duplicates.
//    public int findMin2(int[] nums) {
//        
//    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5, 6, 7, 0, 1, 2,3};
//		int[] nums2 = {3,3, 1, 1, 2};
		int[] nums2 = {1};
		System.out.println(FindMinimumInRotatedSortedArray.search(nums2, 1));
	}

}
