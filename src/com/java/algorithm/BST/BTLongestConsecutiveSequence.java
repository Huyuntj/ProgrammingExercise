package com.java.algorithm.BST;

public class BTLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        return Math.max(dfs(root.left, 1, root.val), dfs(root.right, 1, root.val));
        
    }
    private int dfs(TreeNode node, int count, int preVal){
        if(node == null) return count;
        if(node.val == preVal + 1){
            count++;
        }else{
            count = 1;
        }
        int left = dfs(node.left, count, node.val);
        int right = dfs(node.right, count, node.val);
        return Math.max(Math.max(left, right),count);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
