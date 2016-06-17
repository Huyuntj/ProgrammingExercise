package com.java.algorithm.string;

import com.java.algorithm.utility.PrintHelper;

public class RotateArrayAndList {
//	Given a list, rotate the list to the right by k places, where k is non-negative.
//
//	For example:
//	Given 1->2->3->4->5->NULL and k = 2,
//	return 4->5->1->2->3->NULL.
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
    public ListNode rotateRight(ListNode head, int k) {

        int len = 0;
        ListNode node = head;
        while(node != null){
            node = node.next;
            len++;
        }
        if(len < 2) return head;
        
        int kk = k % len;
        if(kk == 0) return head;
        
        int i = 0;
        node = head;
        ListNode pre = null;
        ListNode newHead = null;
        while(node !=null){
            pre = node;
            node = node.next;
            // i++;
            if(++i == len - kk){ 
                newHead = node;
                pre.next = null;      
            }
        }
        pre.next = head;
        return newHead;
            
    }
//	Rotate an array of n elements to the right by k steps.
//
//	For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
//
//	Note:
//	Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//
//	[show hint]
//
//	Hint:
//	Could you do it in-place with O(1) extra space?
//	Related problem: Reverse Words in a String II
	//solution 1;
	//with extra space int[k%nums.length]
	public void rotateArray1(int[] nums, int k) {
		if(nums == null || nums.length < 2) return;
		int len = nums.length;
		int kk = k%len;
		int[] ext = new int[kk];
		for(int i = len-1; i>=0; i--){
			if(i + kk >= len){
				ext[i+kk-len] = nums[i];
			}else{
				nums[i+kk] = nums[i];
			}
		}
		for(int i = 0;i<ext.length;i++){
			nums[i] = ext[i];
		}
	}
	//solution 2 with only one extra space
	public void rotateArray2(int[] nums, int k) {
		if(nums == null || nums.length == 0) return;
		int kk = k%nums.length;
		if(kk == 0) return;
		reverse(nums,0, nums.length-1);
		reverse(nums,0, kk-1);
		reverse(nums,kk, nums.length-1);
		
	}
	private void reverse(int[] nums, int i, int j){
		while(i < j){
			swap(nums,i,j);
			i++;
			j--;
		}
	}
	private void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateArrayAndList ra = new RotateArrayAndList();
		int k = 0;
		int[] a = {1,2,3,4,5,6};
		ra.rotateArray1(a, k);
		PrintHelper.print(a);
		a = new int[]{1,2,3,4,5,6};
		ra.rotateArray2(a, k);
		PrintHelper.print(a);
		System.out.println((int)('9'));
	}

}
