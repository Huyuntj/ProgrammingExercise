package com.java.algorithm.BST;

import java.util.LinkedList;

import com.java.algorithm.utility.TreeNode;
//222 Count Complete Tree Nodes(Medium)
//Given a complete binary tree, count the number of nodes.
//
//Definition of a complete binary tree from Wikipedia:
//In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
public class CountCompleteTreeNodes {
	
	public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        if(lh == rh){
            return (1<<lh) + countNodes(root.right);
        }else{
            return (1<<rh) + countNodes(root.left);
        }
	}
    private int height(TreeNode root){
        int h = 0;
        while(root !=null){
            root = root.left;
            h++;
        }
        return h;
    }
    public int countNodesTEL(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> s1 = new LinkedList();
        LinkedList<TreeNode> s2 = new LinkedList();
        s1.add(root);
        int h = 1;
        int num = 0;
        int nodesNum = 1;
        while(!s1.isEmpty()){
            while(!s1.isEmpty()){
                TreeNode top = s1.poll();
                if(top.left == null && top.right == null){
                    return (int)Math.pow(2,h) - 1 + 2*num;
                }else if(top.right == null){
                    return (int)Math.pow(2,h) - 1 + 2*num + 1;
                }else{
                    s2.add(top.left);
                    s2.add(top.right);
                } 
                num++;
                
            }
            for(TreeNode node : s2){
                s1.add(node);
            }
            s2.clear();
            h++;
            num = 0;
                                 
        }
        return nodesNum;
    }
    //first count the nodes number of this tree
    //start to index the nodes of tree from 0, the left child is 2*i +1, right child is 2*i+2
    //if it is complete tree, current node index should be less than the count
    //otherwise it is not complete tree
    //						0	(1)
    //			
    //		 	1 (2)						2 (3)
    // 
    //   3(4)		    4(5)			             6(6)
    //
    public boolean isCompleteTree(TreeNode root, int index , int nodesNum){
    	if(root == null) return true;
    	if(index >= nodesNum) return false;
    	return isCompleteTree(root.left, index*2+1, nodesNum)
    			&& isCompleteTree(root.right, index*2+2, nodesNum);
    }
    
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(7);
		root.left = node2;
		root.right = node3;
//		TreeNode node4 = new TreeNode(1);
//		TreeNode node5 =  new TreeNode(4);
//		node2.left = node4;
//		node2.right = node5;
//		TreeNode node6 = new TreeNode(6);
//		TreeNode node7 = new TreeNode(8);
//		node3.left = node6;
//		node3.right = node7;
		
		CountCompleteTreeNodes c = new CountCompleteTreeNodes();
		System.out.println(c.countNodes(root));
	}

}
