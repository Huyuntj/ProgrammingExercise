package com.java.algorithm.BST;

import com.java.algorithm.utility.TreeNode;

public class ConvertListToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return convertToBST(nums, 0, nums.length-1);
    }
    
    private TreeNode convertToBST(int[] nums, int lo, int hi){
        if(lo > hi) return null;
        
        int mid = (lo+hi+1)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convertToBST(nums, lo, mid -1);
        root.right = convertToBST(nums, mid + 1, hi);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.next.val);
        ListNode temp = slow.next.next;
        slow.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(temp);
        return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
