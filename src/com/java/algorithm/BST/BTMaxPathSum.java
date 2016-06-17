package com.java.algorithm.BST;

import com.java.algorithm.utility.TreeNode;

//124. Binary Tree Maximum Path Sum(Hard)
//Given a binary tree, find the maximum path sum.
//
//For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.
//
//For example:
//Given the below binary tree,
//
//       1
//      / \
//     2   3
//Return 6.
//这道题是求树的路径和的题目，不过和平常不同的是这里的路径不仅可以从根到某一个结点，而且路径可以从左子树某一个结点，
//然后到达右子树的结点，就像题目中所说的可以起始和终结于任何结点。在这里树没有被看成有向图，而是被当成无向图来寻找路径。
//因为这个路径的灵活性，我们需要对递归返回值进行一些调整，而不是通常的返回要求的结果。
//在这里，函数的返回值定义为以自己为根的一条从根到子结点的最长路径（这里路径就不是当成无向图了，必须往单方向走）。
//这个返回值是为了提供给它的父结点计算自身的最长路径用，而结点自身的最长路径（也就是可以从左到右那种）则只需计算然后更新即可。
//这样一来，一个结点自身的最长路径就是它的左子树返回值（如果大于0的话），加上右子树的返回值（如果大于0的话），再加上自己的值。
//而返回值则是自己的值加上左子树返回值，右子树返回值或者0（注意这里是“或者”，而不是“加上”，因为返回值只取一支的路径和）。
//在过程中求得当前最长路径时比较一下是不是目前最长的，如果是则更新。
//算法的本质还是一次树的遍历，所以复杂度是O(n)。而空间上仍然是栈大小O(logn)。
public class BTMaxPathSum {
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int[] a= new int[1];
        a[0] = Integer.MIN_VALUE;
        maxPath(root, a);
        return a[0];
    }
    
    private int maxPath(TreeNode root, int[] a){
        if(root == null) return 0;
        int left= maxPath(root.left, a);
        int right = maxPath(root.right,a);
        int max = root.val+ left>0 ?left : 0 + right>0 ? right:0;
        if(max > a[0]) a[0] = max;
        return root.val + Math.max(left, Math.max(0,right));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		BTMaxPathSum sum = new BTMaxPathSum();
		sum.maxPathSum(root);
	}

}
