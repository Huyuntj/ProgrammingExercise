package com.java.algorithm.BST;

import java.util.Stack;

import com.java.algorithm.utility.TreeNode;

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
    public TreeNode upsideDownBinaryTreeRecusive(TreeNode root) {
        if(root == null) return null;
        if(root.left == null) return root;
        
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
    

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
//		TreeNode node6 = new TreeNode(6);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
//		node3.left = node6;
		
		BinaryTreeUpsideDown bt  = new BinaryTreeUpsideDown();
		TreeNode newRoot = bt.upsideDownBinaryTreeRecusive(root);
		System.out.println(newRoot.val);
//		bt.printTree(newRoot);
	}

}
