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
	
	   public static int findKthLargest(int[] nums, int k) {
	        int len = nums.length;
//	        int index = len - k;
	        
	        return quickSelect(nums, k, 0, len -1);
	       
	       
	         
	    }
	    public static int quickSelect(int[] arr, int k, int start, int end){
	    	if(start > end) return Integer.MAX_VALUE;
    		int pivotIndex = getPivotIndex(arr, start, end);
    		if(pivotIndex  == arr.length - k){
    			return arr[pivotIndex];
    		}else if(pivotIndex  < arr.length - k){
    			return quickSelect(arr, k, pivotIndex+1, end);
    		}else{
    			return quickSelect(arr, k, start, pivotIndex -1);
    		}
	    	
	    	
	    }
	    public static int getPivotIndex(int[] arr, int start, int end){
			int pivot = arr[end];
			int pIndex = start;
			for(int i = start; i < end; i++){
				if(arr[i] < pivot){
					int tmp = arr[pIndex];
					arr[pIndex] = arr[i];
					arr[i] = tmp;
					pIndex++;
				}
			}
			arr[end] = arr[pIndex];
			arr[pIndex] = pivot;
			return pIndex;
	    }
	public static void main(String[] args) {
		int[] A = {3,2,1,5,6,4};
		int[] B = {2,4,6,7,8,10,12,14};
//		System.out.println(FindKthSmallestAlgorithm.findKthSmallest(A, A.length, B, B.length, 9));
		int[] arr = new int[] {1};
		System.out.println(FindKthSmallestAlgorithm.findKthLargest(arr,1));
		
	}

}
