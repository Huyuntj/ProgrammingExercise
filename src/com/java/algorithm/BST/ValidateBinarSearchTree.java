package com.java.algorithm.BST;

import com.java.algorithm.utility.TreeNode;

//98. Validate Binary Search Tree
//Difficulty: Medium
//Given a binary tree, determine if it is a valid binary search tree (BST).
//
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
public class ValidateBinarSearchTree {

    public boolean isValidBST(TreeNode root){
        return isValid(root, null, null);
    }
    
    private boolean isValid(TreeNode root, Integer min, Integer max){
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
    
	public boolean isValidBST2(TreeNode root){
        if(root == null || (root.left ==null && root.right  == null)) return true;
        if( (root.left != null && root.val > maxInLeftSubTree(root.left) || root.left == null)
            && (root.right !=null && root.val < minInRightSubTree(root.right) || root.right == null)
            && isValidBST(root.left) 
            && isValidBST(root.right))
            return true;
        return false;
    }
    
    private int maxInLeftSubTree(TreeNode node){
        while(node.right !=null){
            node = node.right;
        }
        return node.val;
    }
    private int minInRightSubTree(TreeNode node){
        while(node.left !=null)
            node = node.left;
        return node.val;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
