package com.java.algorithm.BST;

import java.util.LinkedList;
import java.util.Queue;

//111. Easy
//Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
public class MinimumDepthofBinaryTree {
    public int minDepthBFS(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList();
        Queue<Integer> level = new LinkedList();
        int depth = 1;
        queue.offer(root);
        level.offer(depth);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            depth = level.poll();
            if(isLeaf(node)) return depth;
            if(node.left != null){
                queue.offer(node.left);
                level.offer(depth+1);
            }
            if(node.right != null){
                queue.offer(node.right);
                level.offer(depth+1);
            }
        }
        return depth;
    }
    private boolean isLeaf(TreeNode node){
        if(node == null) return false;
        return (node.left == null) && (node.right == null);
    }
    public int minDepthConcise(TreeNode root) {
        if(root == null) return 0;
        if(root.left != null && root.right!=null)
            return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
        else{
            return Math.max(minDepth(root.left),minDepth(root.right)) + 1;
        }
    }
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
