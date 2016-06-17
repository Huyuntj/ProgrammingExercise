package com.java.algorithm.BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.java.algorithm.utility.TreeNode;
//257. Binary Tree Paths(Easy)
//Given a binary tree, return all root-to-leaf paths.
//
//For example, given the following binary tree:
//
//   1
// /   \
//2     3
// \
//  5
//All root-to-leaf paths are:
//
//["1->2->5", "1->3"]
public class BTPaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        if(root == null) return res;
        Stack<String> str = new Stack();
        Stack<TreeNode> path = new Stack();
        path.push(root);
        str.push(""+root.val);
        while(!path.isEmpty()){
            TreeNode node = path.pop();
            String s = str.pop();
            if(node.left == null && node.right == null){
                res.add(s);
            }
            if(node.left != null){
                path.push(node.left);
                str.push(s + "->" + node.left.val);
            }
            if(node.right !=null){
                path.push(node.right);
                str.push(s+"->"+node.right.val);
            }
        }
        return res;
    }
    public List<String> binaryTreePathsRecusive(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root == null) return list;
        String s = "";
        printPath(root, s + root.val+"->", list);
        return list;
    }
    
    private void printPath(TreeNode root, String s, List<String> list){
        if(root.left == null && root.right == null) {
            String s1 = s.substring(0, s.length()-2);
            list.add(s1);
            return;
        }
         if(root.left != null)
             printPath(root.left,  s + root.left.val + "->", list);
         if(root.right != null)
            printPath(root.right, s + root.right.val + "->", list);
    }
}
