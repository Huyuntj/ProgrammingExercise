package com.java.algorithm.BST;
//114. Medium
//Given a binary tree, flatten it to a linked list in-place.
//
//For example,
//Given
//
//         1
//        / \
//       2   5
//      / \   \
//     3   4   6
//The flattened tree should look like:
//   1
//    \
//     2
//      \
//       3
//        \
//         4
//          \
//           5
//            \
//             6
//click to show hints.
//
//Hints:
//If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
public class FlattenBTToLinkedList {
	public void flatten(TreeNode root) {
		if(root ==  null) return;
		flatterSubTree(root);
	}
	
	private TreeNode flatterSubTree(TreeNode node){
		TreeNode last = node;
		TreeNode right = node.right;
		if(node.left != null){
			node.right = node.left;
			last = flatterSubTree(node.left);
			node.left = null;
		}
		if(right != null){
			last.right = right;
			last = flatterSubTree(right);
		}
		return last;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
