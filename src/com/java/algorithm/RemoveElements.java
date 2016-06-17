package com.java.algorithm;

import com.java.algorithm.utility.PrintHelper;

public class RemoveElements {
//  27. Easy
//	Given an array and a value, remove all instances of that value in place and return the new length.
//
//	The order of elements can be changed. It doesn't matter what you leave beyond the new length.
	   public static int removeElement(int[] nums, int val) {
	        if(nums== null || nums.length==0) return 0;
	        int lastIndex = nums.length-1;
	        for(int i = nums.length-1; i>=0; i--){
	            if(nums[i]== val){
	                for(int j = i+1; j<=lastIndex;j++){
	                    nums[j-1] = nums[j];
	                }
	                lastIndex--;
	            }
	        }
	        return lastIndex+1;
	    }
//	   203. Easy
//	   Remove all elements from a linked list of integers that have value val.
//
//	   Example
//	   Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
//	   Return: 1 --> 2 --> 3 --> 4 --> 5
	   public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		}
	    public static ListNode removeElements(ListNode head, int val) {
	        if(head == null) return null;
	        while(head.val == val) {
	            head = head.next;
	            if(head == null) return null;
	        }
	        // if(head == null) return head;
	        // while(head != null && head.val == val) head = head.next;
	        // if(head == null) return head;
	        ListNode p = head;
	        while(p.next !=null){
	            if(p.next.val == val){
	                p.next = p.next.next;
	            }else{
	                p = p.next;
	            }
	        }
	        return head;
	    }	  
	
//	    283. Move Zeroes. Easy
//	    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//	    For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
//
//	    Note:
//	    You must do this in-place without making a copy of the array.
//	    Minimize the total number of operations.
	    public static void moveZeroes(int[] nums) {
	    	int zeroNum = 0;
	        for(int i = 0; i<nums.length; i++){
	        	if(nums[i]== 0){
	        		zeroNum++;
	        		continue;
	        	}
	        	if(zeroNum>0){
	        		nums[i-zeroNum] = nums[i];
	        		nums[i] = 0;
	        	}
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,0, 2, 3, 0,0, 4,0, 5,0};
		RemoveElements.moveZeroes(nums);
		PrintHelper.print(nums);
	}

}
