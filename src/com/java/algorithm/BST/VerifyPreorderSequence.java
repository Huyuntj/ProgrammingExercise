package com.java.algorithm.BST;

import java.util.LinkedList;

public class VerifyPreorderSequence {
	//better solution with time complexity O(n) and space O(1);
	//runtime is  
	public boolean verifyPreorder3(int[] preorder){
		if( preorder == null || preorder.length == 0) return true;
		int low = Integer.MIN_VALUE;
		int i = -1;
		for(int p : preorder){
			if(p < low) return false;
			while( i>= 0 && p > preorder[i]){
				low = preorder[i--];
			}
			preorder[++i] = p;
		}
		return true;
	}
	//better solution with time complexity O(n) and space O(n);
	//runtime is  28 ms
	public boolean verifyPreoder2(int[] preorder){
		if( preorder == null || preorder.length == 0) return true;
		LinkedList<Integer> stack = new LinkedList();
		int low = Integer.MIN_VALUE;
		for(int p : preorder){
			if(p < low) return false;
			while(!stack.isEmpty() && p > stack.peek()){
				low = stack.pop();
			}
			stack.push(p);
		}
		return true;
	}
	//add verification for post order here
	public boolean verifyPostorder(int[] postorder){
		if(postorder == null || postorder.length == 0) return true;
		LinkedList<Integer> stack = new LinkedList();
		int max = Integer.MAX_VALUE;
		for(int i = postorder.length-1; i>=0; i--){
			if(postorder[i] > max) return false;
			while(!stack.isEmpty() && postorder[i] < stack.peek()){
				max = stack.pop();
			}
			stack.push(postorder[i]);
		}
		return true;
	}
	//my brute force solution
//    private boolean isPreorder = true;
	//time complexity is O(n*n)
	//runtime is almost 500ms
    public boolean verifyPreorder(int[] preorder) {
    	if(preorder == null) return false;
        return isPreorder(preorder, 0, preorder.length-1);
    }
    
    private boolean isPreorder(int[] preorder, int start, int end){
        if(start >= end) return true;
        int i = start + 1;
        while(i <= end && preorder[i] < preorder[start]){
        	i++;
        }
        if(!isPreorder(preorder, start+1, i-1))
        	return false;
        
        int rightStart = i;
        while(i <= end && preorder[i] > preorder[start])
        	i++;
        if(i <=end ) return false;

        return isPreorder(preorder, rightStart, end);
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
