package com.java.algorithm.dp;

import java.util.Arrays;

//300/334. Medium
//Given an unsorted array of integers, find the length of longest increasing subsequence.
//
//For example,
//Given [10, 9, 2, 5, 3, 7, 101, 18],
//The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
//
//Your algorithm should run in O(n2) complexity.
//
//Follow up: Could you improve it to O(n log n) time complexity?
//
//Credits:
//Special thanks to @pbrother for adding this problem and creating all test cases.
//
//Hide Company Tags
public class LongestIncreasingSubsequence {
	//Time complexity is O(n*n)
    public int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int len = 1;
        for(int i = 1; i<nums.length; i++){
            // int tmp = 1;
            for(int j = 0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            // dp[i] = tmp;
            len = Math.max(len, dp[i]);
        }
        return len;
    
    }
//Time complexity is O(nlgn)
//refer to https://www.youtube.com/watch?v=S9oUiVYEq7E&feature=youtu.be for this algorithm
    public int lengthOfLISNlgN(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = 1;int j = 0;
        int[] arr = new int[nums.length];
        arr[j] = nums[0];
        for(int i =1; i< nums.length;i++){
            if(nums[i] > arr[j]){
                arr[++j] = nums[i];
                len++;
            }else{
                int idx = binarySearch(arr,0,j, nums[i]);
                arr[idx] = nums[i];
            }
        }
        return len;
    }
    //binary search find the ceiling number of n in nums and return the index
    private int binarySearch(int[] nums, int low, int high, int n){
        if(n <= nums[low]) return low;
        
        int mid;         
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] == n) return mid;
            if(nums[mid] < n){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }

/*Smiliar problem : 334.  Increasing Triplet Subsequence(Medium)
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

	Formally the function should:
	Return true if there exists i, j, k 
	such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
	Your algorithm should run in O(n) time complexity and O(1) space complexity.
	
	Examples:
	Given [1, 2, 3, 4, 5],
	return true.
	
	Given [5, 4, 3, 2, 1],
	return false.
 * 
 * 
 */
    public boolean increasingTripletAdditionArray(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int j = 0;
        int[] arr = new int[3];
        arr[j] = nums[0];
        for(int i =1; i< nums.length;i++){
            if(nums[i] > arr[j]){
                arr[++j] = nums[i];
                if(j == 2 ) return true;
            }else{//in this branch, there are only two elements in the arr
               if(arr[0] >= nums[i]){
                   arr[0]=nums[i];
               }else{
                   arr[1]=nums[i];
               }
                
            }
        }
        return false;  
    }
    //actually additional array is not needed, we just need to store the minimum and the second minimum value
    //the above solution using an additional array, which 
//    The main idea is keep two values when check all elements in the array: the minimum value min until now and the second minimum value secondMin from the minimum value's position until now. Then if we can find the third one that larger than those two values at the same time, it must exists the triplet subsequence and return true.
//
//    What need to be careful is: we need to include the condition that some value has the same value with minimum number, otherwise this condition will cause the secondMin change its value.
    public boolean increasingTriplet(int[] nums){
    	int min = Integer.MAX_VALUE; int second= Integer.MAX_VALUE;
    	for(int num : nums){
    		if(num <= min) min = num;
    		else if(num < second) second = num;
    		else if(num > second) return true;
    	}
    	return false;
    }
    public static void main(String[] args){
    	LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
    	int[] a = {10,9,2,5,3,4};
//    	System.out.println(lis.lengthOfLIS(a));
    	System.out.println(lis.lengthOfLISNlgN(a));
    }
}
