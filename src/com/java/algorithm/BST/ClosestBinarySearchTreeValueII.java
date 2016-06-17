package com.java.algorithm.BST;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import com.java.algorithm.utility.TreeNode;

//272. Closest Binary Search Tree Value II (Hard)
//Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
//
//Note:
//Given target value is a floating point.
//You may assume k is always valid, that is: k ≤ total nodes.
//You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
//Follow up:
//Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
public class ClosestBinarySearchTreeValueII {
	//
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> result = new ArrayList();
		ArrayDeque<Integer> s1 = new ArrayDeque();//predecessor, which stores all nodes whose value is smaller than target
		ArrayDeque<Integer> s2 = new ArrayDeque();//successor, which stores all node whose value is greater than target
		inorderTraverse(root, target, s1, false);
		inorderTraverse(root, target, s2, true);
		while(k-- > 0){
			if(s1.isEmpty()){
				result.add(s2.pop());
			}else if(s2.isEmpty()){
				result.add(s1.pop());
			}else if(Math.abs(s1.peek() - target)<Math.abs(s2.peek() - target)){
				result.add(s1.pop());
			}else{
				result.add(s2.pop());
			}
		}
		return result;
	}
	
	private void inorderTraverse(TreeNode root, double target, ArrayDeque<Integer> s, boolean reversed){
		if(root == null) return;
		inorderTraverse(reversed ? root.right: root.left, target, s, reversed);
		if(!reversed && root.val > target || reversed && root.val < target) return;
		s.push(root.val);
		inorderTraverse(reversed ? root.left: root.right, target, s, reversed);
	}
	//first find the closest node
	//second, in order traverse tree
	//third, find K closet nodes
	public List<Integer> closestKValuesSolution2(TreeNode root, double target, int k) {
		List<Integer> res = new ArrayList();
		List<Integer> inorder = new ArrayList();
		inOrderTraverse(root, inorder);
		int closestVal = closestValue(root, target);
		int index = inorder.indexOf(closestVal);
		int i = index -1, j = index + 1;
		res.add(closestVal);
		while(res.size() < k){
			if( i >=0 && j<inorder.size()-1){
				res.add(Math.abs(inorder.get(i)-target)  < Math.abs(inorder.get(j)-target) ? inorder.get(i--) : inorder.get(j++));
			}else if(i <0){
				res.add(inorder.get(j++));
			}else{
				res.add(inorder.get(i--));
			}
		}
		return res;
	}
	
	private int closestValue(TreeNode root, double target){
		int closestValue = root.val;
		while(root != null){
			if(root.val == target) return root.val;
			closestValue = Math.abs(root.val - target) < Math.abs(closestValue - target) ? root.val: closestValue;
			root = root.val < target ? root.right : root.left;
		}
		return closestValue;
	}
	private void inOrderTraverse(TreeNode root, List<Integer> res){
		if(root == null) return;
		inOrderTraverse(root.left, res);
		res.add(root.val);
		inOrderTraverse(root.right, res);
	}
	
   public List<Integer> closestKValuesSolution3(TreeNode root, double target, int k) {
        List<Integer> list = new ArrayList();
        closestKValuesHelper(list, root, target, k);
        return  list;
    }
    public void closestKValuesHelper(List<Integer> list, TreeNode root, double target, int k){
        if(root == null) return;
        closestKValuesHelper(list, root.left, target, k);
        int i = 0;
        while( i < list.size()
                && 
                Math.abs(target - list.get(i)) <= Math.abs(target - root.val) ){
                i++;
        }
        list.add(i, root.val);
        if(list.size() > k) list.remove(list.get(list.size()-1));
        closestKValuesHelper(list, root.right, target, k);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(7);
		root.left = node2;
		root.right = node3;
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 =  new TreeNode(4);
		node2.left = node4;
		node2.right = node5;
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(8);
		node3.left = node6;
		node3.right = node7;
		
		ClosestBinarySearchTreeValueII bst = new ClosestBinarySearchTreeValueII();
		System.out.println(bst.closestKValuesSolution2(root, 3.2, 3));
	}

}
