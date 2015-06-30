package com.java.algorithm;

import java.util.Arrays;

public class FindKthSmallestAlgorithm {
/*
 * please refer to webpage: http://articles.leetcode.com/2011/01/find-k-th-smallest-element-in-union-of.html
 */
	/*
	 * find the Kth smallest in sorted array A and B with positive integers
	 * assume there is no duplicate element in A & B
	 */
	public static int findKthSmallest(int[] A, int m, int[] B, int n, int k){
		if(k <= 0 || k > m+n || m <= 0 || n <=0){
			return -1;
		}
		int i = (int)((double) m/(m+n) * (k-1));
		int j = k - 1 - i;
		int ai_1 = (i == 0)? -1:A[i-1];
		int bj_1 = (j == 0)? -1:B[j-1];
		int ai = (i == m)? Integer.MAX_VALUE:A[i];
		int bj = (j == n)? Integer.MAX_VALUE:B[j];
		
		
		if(ai > bj_1 && ai < bj){
			return ai;
		}else if( bj > ai_1 && bj < ai){
			return bj;
		}

		if(ai < bj){
			return findKthSmallest(Arrays.copyOfRange(A, i+1, m), m-i-1, Arrays.copyOfRange(B, 0, j), j, k-i-1);			
		}else{
			return findKthSmallest(Arrays.copyOfRange(A,0,i), i, Arrays.copyOfRange(B, j+1, n), n-j-1, k-j-1);			
		}
		
	}
	public static void main(String[] args) {
		int[] A = {1,3,5,9,11,15};
		int[] B = {2,4,6,7,8,10,12,14};
		System.out.println(FindKthSmallestAlgorithm.findKthSmallest(A, A.length, B, B.length, 1));
	}

}
