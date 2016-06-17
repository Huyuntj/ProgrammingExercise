package com.java.algorithm.BST;

import com.java.algorithm.utility.TreeNode;

public class CountUnivalueSubtrees {
//250.Medium
//	Given a binary tree, count the number of uni-value subtrees.
//
//	A Uni-value subtree means all nodes of the subtree have the same value.
//
//	For example:
//	Given binary tree,
//	              5
//	             / \
//	            1   5
//	           / \   \
//	          5   5   5
//	return 4.	
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
    
        isUnivalSubtrees(root,count);
        return count[0];
    }
    
    private boolean isUnivalSubtrees(TreeNode root, int[] count){
        if(root == null) return true;
        boolean left = isUnivalSubtrees(root.left, count);
        boolean right = isUnivalSubtrees(root.right, count);
        if(left && right && 
            (root.left ==  null || (root.val == root.left.val)) && (root.right == null || (root.right.val == root.val)))
        {
            count[0]++;
            return true;
        }
        return false;
    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
