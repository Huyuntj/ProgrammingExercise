package com.java.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

//239. Hard
//Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//
//For example,
//Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//Therefore, return the max sliding window as [3,3,5,5,6,7].
//
//Note: 
//You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
//
//Follow up:
//Could you solve it in linear time?
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length-k+1];
        int j = 0;
        Deque<Integer> dq =  new ArrayDeque();
        for(int i = 0; i<nums.length;i++){
            //this is to guaranter the slidng window has k elements
            if(!dq.isEmpty() && dq.peek() < (i-k+1)){
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i - k + 1 >= 0){
                 res[j++] = nums[dq.peek()];
            }
           
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = new char[3];
		System.out.println(arr);

	}

}
