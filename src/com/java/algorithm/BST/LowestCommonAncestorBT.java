package com.java.algorithm.BST;

import com.java.algorithm.utility.TreeNode;

//236. Lowest Coomon Ancestor of Binary Tree(Medium)
//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
//
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
//
//        _______3______
//       /              \
//    ___5__          ___1__
//   /      \        /      \
//   6      _2       0       8
//         /  \
//         7   4
//For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
public class LowestCommonAncestorBT {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode L = lowestCommonAncestor(root.left, p, q);
        TreeNode R = lowestCommonAncestor(root.right, p, q);
        if(L != null && R != null) 
            return root;
        else
            return L !=null ? L: R;
    
}
	
	
//	difficulty easy
//	Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
//	According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
//
//	        _______6______
//	       /              \
//	    ___2__          ___8__
//	   /      \        /      \
//	   0      _4       7       9
//	         /  \
//	         3   5
//	For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 
	//10ms
	public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if((root.val-p.val)*(root.val-q.val) <= 0) return root;
            if(root.val < p.val) root = root.right;
            else root = root.left;
        }
        return null;
    }
    //more than 400ms
	public TreeNode lowestCommonAncestorBSTRecusive(TreeNode root, TreeNode p, TreeNode q) {
        return (root.val-p.val)*(root.val-q.val) <= 0 ?
        		root : 
        			lowestCommonAncestorBSTRecusive(root.val<p.val?root.right:root.left,p,q);
    }
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(37);
		TreeNode node2 = new TreeNode(-34);
		TreeNode node3 = new TreeNode(-48);
		TreeNode node4 = new TreeNode(-100);
		TreeNode node5 = new TreeNode(-100);
		TreeNode node6 = new TreeNode(48);
		TreeNode node7 = new TreeNode(-54);
		TreeNode node8 = new TreeNode(-71);
		TreeNode node9 = new TreeNode(-22);
		TreeNode node10 = new TreeNode(-8);
		node1.left =  node2;
		node1.right = node3;
		node2.right = node4;
		node3.left = node5;
		node3.right = node6;
		node6.left = node7;
		node7.left = node8;
		node7.right = node9;
		node9.right = node10;
		
		LowestCommonAncestorBT bt = new LowestCommonAncestorBT();
		System.out.println(bt.lowestCommonAncestor(node1, node5, node8).val);

	}

}
