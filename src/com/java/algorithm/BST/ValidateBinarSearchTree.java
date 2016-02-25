package com.java.algorithm.BST;

public class ValidateBinarSearchTree {
    public boolean isValidBST(TreeNode root){
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
