package com.java.algorithm.BST;
//298. Binary Tree Longest Consecutive Sequence(Medium)
//Given a binary tree, find the length of the longest consecutive sequence path.
//
//The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
//
//For example,
//   1
//    \
//     3
//    / \
//   2   4
//        \
//         5
//Longest consecutive sequence path is 3-4-5, so return 3.
//   2
//    \
//     3
//    / 
//   2    
//  / 
// 1
//Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

import com.java.algorithm.utility.TreeNode;

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
