package com.java.algorithm.BST;

import java.util.LinkedList;

public class SymmetricTree {
	   public boolean isSymmetric(TreeNode root) {
	       if(root == null) return true;
	       LinkedList<TreeNode> s1 = new LinkedList();
	       LinkedList<TreeNode> s2 = new LinkedList();
	       s1.push(root.left); s2.push(root.right);
	       while(!s1.isEmpty() && !s2.isEmpty()){
	           TreeNode node1 = s1.pop();
	           TreeNode node2 = s2.pop();
	           if(node1 == null && node2 == null) continue;
	           if((node1 == null || node2 == null) || (node1.val != node2.val)){
	               return false;
	           }else{
	               s1.push(node1.left); s1.push(node1.right);
	               s2.push(node2.right); s2.push(node2.left);
	           }
	       }
//	       if(!s1.isEmpty() || !s2.isEmpty()) return false;
//	       return true;
	       return s1.isEmpty() && s2.isEmpty();
	    }
	   public boolean isSymmetricRecusive(TreeNode root){
		   return isSymmetric(root,root);
	   }
	   //recusive solution
	    private boolean isSymmetric(TreeNode root1, TreeNode root2){
	        if(root1 == null && root2 == null) return true;
	        if(root1 == null || root2 == null) return false;
	        if(root1.val != root2.val) return false;
	        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
