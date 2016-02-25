package com.java.algorithm.BST;

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
        int max = root.val+ left>0?left:0+ right>0?right:0;
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
