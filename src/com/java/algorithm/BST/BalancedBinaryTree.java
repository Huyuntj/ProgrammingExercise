package com.java.algorithm.BST;
//110, Easy
//Given a binary tree, determine if it is height-balanced.
//
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

import com.java.algorithm.utility.TreeNode;

public class BalancedBinaryTree {
//	private boolean isBalanced = true;
	public boolean isBalancedWithGlobalVariant(TreeNode root){
		return height(root) >=0 ;
	}
	
	private int height(TreeNode node){
		if(node == null) return 0;
		int l = height(node.left);
		int r = height(node.right);
		if(l < 0 || r < 0 || Math.abs(l-r) > 1){
			
//			isBalanced = false;
			return -1;
		}else{
			return Math.max(l, r) + 1;
		}
		
	}
	
    public boolean isBalanced(TreeNode root) {
         return height(root,0) >= 0 ; 
    }
    private int height(TreeNode root, int height){
    	if(root == null) return height;
    	int l = height(root.left, height+1);
    	int r = height(root.right, height+1);
    	if(l < 0 || r < 0 || (l -r) > 1 || (l - r) < -1) return -1;
    	return Math.max(l, r);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
