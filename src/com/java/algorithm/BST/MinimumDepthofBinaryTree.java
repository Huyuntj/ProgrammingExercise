package com.java.algorithm.BST;

public class MinimumDepthofBinaryTree {
//	Given a binary tree, find its minimum depth.
//
//	The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return depth(root, 1);
    }
    
    private int depth(TreeNode node, int dep){
        if(node.left == null && node.right == null) return dep;
        int l = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
        if(node.left != null) l = depth(node.left, dep+1);
        if(node.right != null) r = depth(node.right, dep+1);
        
        return l<r?l:r;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
