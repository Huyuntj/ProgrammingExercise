package com.java.algorithm.dp;

import com.java.algorithm.utility.TreeNode;

public class HouseRobber {
//	198. easy
//	You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//	Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.	
    public int rob(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i = 2; i<nums.length;i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }
    /*
     * 213. House Robber II
     * Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
     */
    //need to calculate two rounds of dp starting from index 0 and 1
    public int rob2(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0) return 0;
        if(len == 1) return nums[0];
        return Math.max(max(nums,0, len-2), max(nums, 1, len-1));
        
    }
    //dp solution with O(n) solution
    private int max(int[] nums, int start, int end){
        if(start == end) return nums[start];
        int[] dp = new int[end-start+2];
        dp[0] = 0;
        dp[1] = nums[start];
        for(int i = start+1; i <= end; i++){
            int dpIdx = i-start+1;
            dp[dpIdx] = Math.max(nums[i]+dp[dpIdx-2], dp[dpIdx-1]);
        }
        return dp[end-start+1];
    }
    //same dp solution with O(1) space
    private int max2(int[] nums, int start, int end){
    	int cur=0, pre=0, pre2=0;
    	for(int i = start; i<=end; i++){
    		cur = Math.max(nums[i]+pre2, pre);
    		pre2 = pre;
    		pre = cur;
    	}
    	return cur;
    }
/*337. House Robber III Medium
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.	
 */
	
	//https://leetcode.com/discuss/91899/step-by-step-tackling-of-the-problem
    public int rob3(TreeNode root) {
        int[] res = findMax(root);
        return Math.max(res[0], res[1]);
    }
    //return an array to store two different values, which are the 
    //biggest value of current node is robbed and current node is not robbered
    //if current node is robbed, then the max should be current node.val + the grandchild value of current node
    //if current node is not robberd, then the max should be node.left + node.right
    private int[] findMax(TreeNode root){
        if(root == null) return new int[2];
        int[] left = findMax(root.left);
        int[] right = findMax(root.right);
        int[] res = new int[2];
        //root is not robbed, we can rob root's left and right now
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //root is robbed
        res[0] = root.val + left[1]+ right[1];
        return res;
        
    }
	public static void main(String[] args) {
		HouseRobber hr = new HouseRobber();
		int[] nums = {3,8,7,6,19,1};
		System.out.println(hr.rob2(nums));

	}

}
