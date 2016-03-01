package com.java.algorithm.BST;
//333. Largest BST Subtree
//Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
//
//Note:
//A subtree must include all of its descendants.
//Here's an example:
//    10
//    / \
//   5  15
//  / \   \ 
// 1   8   7
//The Largest BST Subtree in this case is the highlighted one. 
//The return value is the subtree's size, which is 3.
//Hint:
//
//You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
//Follow up:
//Can you figure out ways to solve it with O(n) time complexity?
public class LargestBSTSubtree {
	   //avoid use global variant
    // int maxSubTreeSize = 0;
    class Result{
        int size;
        int min;
        int max;
        public Result(int size, int min, int max){
            this.size = size;//if size is negative number, means tree with current root is not valid BST, and the number stores the maximum valid BST size
            this.min = min;
            this.max = max;
        }
    }
    
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        
        return Math.abs(BSTSubtree(root).size);
        
    }
    private Result BSTSubtree(TreeNode root){
        if(root == null) return new Result(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        Result left = BSTSubtree(root.left);
        Result right = BSTSubtree(root.right);
        if(left.size <0 || right.size< 0 ||root.val < left.max || root.val > right.min){
            //this branch means it is not a valid BST
            return new Result(Math.max(Math.abs(left.size), Math.abs(right.size)) * (-1), Integer.MAX_VALUE,Integer.MIN_VALUE);
        }else{
            // int size = left.size+right.size+1;
            // maxSubTreeSize = Math.max(maxSubTreeSize, size);
            return new Result(left.size+right.size+1, Math.min(root.val,left.min), Math.max(root.val,right.max));
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
