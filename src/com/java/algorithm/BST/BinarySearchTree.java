package com.java.algorithm.BST;

public class BinarySearchTree {
	class Node{
		private int value;
		private Node left;
		private Node right;
		
		public Node(int value){
			this.value = value;
		}
		public Node(int value, Node l, Node r){
			this.value = value;
			this.left = l;
			this.right = r;
		}
	}
	public static boolean isBinarySearchTree(Node root){
		return IsBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private static boolean IsBstUtil(Node root, int minValue, int maxValue){
		if(root == null) return true;
		if(root.value > minValue && root.value < maxValue 
				&&
				IsBstUtil(root.left, minValue, root.value)
				&&
				IsBstUtil(root.right, root.value, maxValue)){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Node node1 = bst. new Node(1);
		Node node2 = bst.new Node(2);
		Node root = bst. new Node(3,node1, node2);
		System.out.println(BinarySearchTree.isBinarySearchTree(root));
	}

}
