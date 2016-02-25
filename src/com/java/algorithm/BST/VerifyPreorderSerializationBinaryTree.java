package com.java.algorithm.BST;

import java.util.Stack;

public class VerifyPreorderSerializationBinaryTree {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length()==0) return false;
        Stack<String> cStack = new Stack();
        String[] arr = preorder.split(",");
        int i = 0;
        cStack.push(arr[i]);
        // iStack.push(0);
        while(!cStack.isEmpty()){
            // int index = iStack.pop();
            if(!cStack.pop().equals("#")){
                if((i+1) >= arr.length || (i+2) >= arr.length)
                    return false;
                cStack.push(arr[i+1]);
                cStack.push(arr[i+2]);
                i = i+2;

            }
        }
        if(i != arr.length -1){
            return false;
        }
        return true;
    }
    
	public static void main(String[] args) {
		VerifyPreorderSerializationBinaryTree bt = new VerifyPreorderSerializationBinaryTree();
		String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		String s2 = "1,#";
		String s3 = "9,#,#,1";
		System.out.println(bt.isValidSerialization(s3));;

	}

}
