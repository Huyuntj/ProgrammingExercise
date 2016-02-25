package com.java.algorithm.BST;

public class ConstructTreeWithDifferentOrders {
	public TreeNode buildTreeFromInorderPreorder(int[] inorder, int[] preorder){
		if(inorder == null || preorder == null) return null;
		return constructTreeFromInorderPretorder(inorder,0,inorder.length-1,preorder,0);
	}
	private TreeNode constructTreeFromInorderPretorder(int[] inorder, int start, int end, int[] preorder, int rootIdx){
		if(start > end) return null;
		int i = start;
		while(inorder[i] != preorder[rootIdx]) i++;
		TreeNode root = new TreeNode(preorder[rootIdx]);
		root.left = constructTreeFromInorderPretorder(inorder, start,i-1, preorder, rootIdx+1);
		root.right = constructTreeFromInorderPretorder(inorder, i+1, end, preorder, rootIdx + i-start+1);
		return root;
	}
	
    public TreeNode buildTreeFromInorderPostorder(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null) return null;
        TreeNode root = constructTreeFromInorderPostorder(inorder, 0, inorder.length-1, postorder,  postorder.length-1);
        return root;
    }
    
    private TreeNode constructTreeFromInorderPostorder(int[] inorder, int start, int end, int[] postorder, int rootIdx){
        if(start > end) return null;
        int i;
        for(i = 0; i<=inorder.length-1; i++){
            if(inorder[i] == postorder[rootIdx])
                break;
        }
        
        TreeNode left = constructTreeFromInorderPostorder(inorder,start,i-1,postorder,rootIdx-end+i-1);
        TreeNode right = constructTreeFromInorderPostorder(inorder,i+1,end, postorder,rootIdx-1);
        TreeNode root = new TreeNode(postorder[rootIdx]);
        root.left = left;
        root.right = right;
        return root;
    }
	public static void main(String[] args) {
		int[] inorder = {1,3,2};
		int[] postorder = {3,2,1};
		ConstructTreeWithDifferentOrders ct = new ConstructTreeWithDifferentOrders();
		System.out.println(ct.buildTreeFromInorderPostorder(inorder, postorder).val);

	}

}
