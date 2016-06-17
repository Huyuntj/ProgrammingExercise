package com.java.algorithm;

import java.util.ArrayList;
import java.util.List;
//60. Permutation Sequence Medium
//The set [1,2,3,…,n] contains a total of n! unique permutations.
//
//By listing and labeling all of the permutations in order,
//We get the following sequence (ie, for n = 3):
//
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"
//Given n and k, return the kth permutation sequence.
//
//Note: Given n will be between 1 and 9 inclusive.
public class PermutationSequence {
	//notice: start from k-1 and (n-1)!
    public String getPermutationOptimizedSolution(int n, int k) {
        int fact = 1;
        for(int i = 2; i<n;i++){
            fact *= i;
        }
        List<Integer> list = new ArrayList();
        for(int i=1; i<=n;i++){
            list.add(i);
        }
        int rank = k-1;
        StringBuilder sb = new StringBuilder();
        for(int i = n-1;i>=1;i--){
            int index = rank / fact;
            sb.append(list.remove(index));
            rank %= fact;
            fact /= i;
        }
        sb.append(list.get(0));
        return sb.toString();
    }
	
    public static String getPermutation(int n, int k) {
        int[] p = new int[]{1,1,2,6,24,120,720,5040,40320,362880};
        List<Integer> l = new ArrayList();
        for(int i = 1; i<=n; i++){
        	l.add(i);
        }
        StringBuffer res = new StringBuffer();
        while(k>0){
//        	int value = 1;
        	int i;
        	for( i = n; i>=1; i--){
        		if(p[i] < k){
        			break;
        		}
        	}
        	while(i != l.size()-1){//need to add in order
        		res.append(l.get(0));
        		l.remove(0);       		
        	}
        	int divide = k / p[i];
        	if(k % p[i] > 0){
        		divide = divide + 1;
        	}
      
        	res.append(l.get(divide-1));
        	l.remove(divide-1);
        	
        	k = k % p[i];

        }
        int len = l.size();
        while(len > 0){
        	res.append(l.get(len-1)); 
        	len--;
        }
        
        return res.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(PermutationSequence.getPermutation(5, 72));
		System.out.println((int)'A');
	}

}
