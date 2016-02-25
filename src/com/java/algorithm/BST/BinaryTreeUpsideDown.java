package com.java.algorithm.BST;

import java.util.Stack;

public class BinaryTreeUpsideDown {
//	Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
//
//	For example:
//	Given a binary tree {1,2,3,4,5},
//	    1
//	   / \
//	  2   3
//	 / \
//	4   5
//	return the root of the binary tree [4,5,2,#,#,3,1].
//	   4
//	  / \
//	 5   2
//	    / \
//	   3   1  
	//in place move
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode prev = null;//prev node means previous root node
        TreeNode right = null;//current right sibling node of root node
        while(root != null){
            TreeNode next = root.left;
            root.left = right;
            right = root.right;
            root.right = prev;
            prev = root;
            root = next;
        }
        return prev;
    }
	//solution with stack
    public TreeNode upsideDownBinaryTreeStack(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> s = new Stack();
        while(root != null){
            s.push(root);
            root = root.left;
        }
        root = s.peek();
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            if(!s.isEmpty()){
                TreeNode top = s.peek();           
                node.left = top.right;
                node.right = top;                  
            }else{
                node.left = null;
                node.right = null;
            }

        }
        return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println('1' - 48);
	}

}
