package com.java.algorithm.BST;
//270. Closest Binary Search Tree Value(Easy)
//Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
//
//Note:
//Given target value is a floating point.
//You are guaranteed to have only one unique value in the BST that is closest to the target.
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
    	int closetVal = root.val;
    	while(root != null){
    		if(root.val == target) return root.val;
    		closetVal = Math.abs(root.val - target) < Math.abs(closetVal - target) ? root.val : closetVal;
    		root = (target > root.val)? root.right:root.left;
    	}
    	return closetVal;
    }

}
