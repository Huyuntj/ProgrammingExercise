package com.java.algorithm.BST;

import java.util.ArrayList;
import java.util.List;

public class UniqueBSTII {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return generateTree(1,n);
        
    }
    
    private List<TreeNode> generateTree(int start, int end){
        if(start > end){
            List<TreeNode> list = new ArrayList();
            list.add(null);
            return list;
        }
        if(start == end){
            List<TreeNode> list = new ArrayList();
            list.add(new TreeNode(start));
            return list;
        }
        
        List<TreeNode> roots = new ArrayList();
        for(int i = start; i<=end ; i++){
            List<TreeNode> leftTrees = generateTree(start, i-1);
            List<TreeNode> rightTrees = generateTree(i+1, end);
            for(int m = 0; m < leftTrees.size(); m++){
                for(int n = 0; n<leftTrees.size(); n++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTrees.get(m);
                    root.right = rightTrees.get(n);                    
                    roots.add(root);
                }
            }
        }
        return roots;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBSTII test = new UniqueBSTII();
		System.out.println(test.generateTrees(6).size());
	}

}
