package com.java.algorithm;

import java.util.Arrays;

public class MedianOfTwoSortedArray {
//	Let the two arrays be A[N] and B[M]. In the following explanation, it is assumed that N is smaller than or equal to M.
//
//	Base cases:
//	The smaller array has only one element
//	Case 1: N = 1, M = 1.
//	Case 2: N = 1, M is odd
//	Case 3: N = 1, M is even
//	The smaller array has only two elements
//	Case 4: N = 2, M = 2
//	Case 5: N = 2, M is odd
//	Case 6: N = 2, M is even
//
//	Case 1: There is only one element in both arrays, so output the average of A[0] and B[0].
//
//	Case 2: N = 1, M is odd
//	Let B[5] = {5, 10, 12, 15, 20}
//	First find the middle element of B[], which is 12 for above array. There are following 4 sub-cases.
//	…2.1 If A[0] is smaller than 10, the median is average of 10 and 12.
//	…2.2 If A[0] lies between 10 and 12, the median is average of A[0] and 12.
//	…2.3 If A[0] lies between 12 and 15, the median is average of 12 and A[0].
//	…2.4 If A[0] is greater than 15, the median is average of 12 and 15.
//	In all the sub-cases, we find that 12 is fixed. So, we need to find the median of B[ M / 2 – 1 ], B[ M / 2 + 1], A[ 0 ] and take its average with B[ M / 2 ].
//
//	Case 3: N = 1, M is even
//	Let B[4] = {5, 10, 12, 15}
//	First find the middle items in B[], which are 10 and 12 in above example. There are following 3 sub-cases.
//	…3.1 If A[0] is smaller than 10, the median is 10.
//	…3.2 If A[0] lies between 10 and 12, the median is A[0].
//	…3.3 If A[0] is greater than 10, the median is 12.
//	So, in this case, find the median of three elements B[ M / 2 – 1 ], B[ M / 2] and A[ 0 ].
//
//	Case 4: N = 2, M = 2
//	There are four elements in total. So we find the median of 4 elements.
//
//	Case 5: N = 2, M is odd
//	Let B[5] = {5, 10, 12, 15, 20}
//	The median is given by median of following three elements: B[M/2], max(A[0], B[M/2 – 1]), min(A[1], B[M/2 + 1]).
//
//	Case 6: N = 2, M is even
//	Let B[4] = {5, 10, 12, 15}
//	The median is given by median of following four elements: B[M/2], B[M/2 – 1], max(A[0], B[M/2 – 2]), min(A[1], B[M/2 + 1])
//
//	Remaining Cases:
//	Once we have handled the above base cases, following is the remaining process.
//	1) Find the middle item of A[] and middle item of B[].
//	…..1.1) If the middle item of A[] is greater than middle item of B[], ignore the last half of A[], let length of ignored part is idx. Also, cut down B[] by idx from the start.
//	…..1.2) else, ignore the first half of A[], let length of ignored part is idx. Also, cut down B[] by idx from the last.
	public int max(int a, int b){
		return a>b ? a: b;
	}
	public int min(int a, int b){
		return a<b?a : b;
	}
	public double mo2(int a, double b){
		return (a+b)/(double)2;
	}
	public double mo3(int a, int b, int c){
		return a+b+c - max(a, max(b,c)) - min(a,min(b,c));
	}
	public double mo4(int a, int b, int c, int d){
		return (a+b+c+d -max(a, max(b, max(c,d))) - min(a,min(b,min(c,d))))/(double)2.0;
	}
	public double findMedianUtil(int[] A, int N, int B[], int M){
//		int N = endA - startA + 1;
//		int M = endB - startB + 1;
		if(N == 1){
			// Case 1: If the larger array also has one element, simply call MO2()
			if(M == 1) return mo2(A[0], B[0]);
	        // Case 2: If the larger array has odd number of elements, then consider
	        // the middle 3 elements of larger array and the only element of
	        // smaller array. Take few examples like following
	        // A = {9}, B[] = {5, 8, 10, 20, 30} and
	        // A[] = {1}, B[] = {5, 8, 10, 20, 30}				
			if((M & 1) == 1){//M is odd
				return mo2(B[M/2], mo3(A[0],B[M/2-1],B[M/2+1]));
			}
	        // Case 3: If the larger array has even number of element, then median
	        // will be one of the following 3 elements
	        // ... The middle two elements of larger array
	        // ... The only element of smaller array
			return mo3(A[0], B[M/2], B[M/2-1]);
		}
		else if(N == 2){
			if(M == 2){
				return mo4(A[0], A[1], B[0], B[1]);
			}
			if((M & 1) == 1){
				return mo3(B[M/2], max(B[M/2-1], A[1]), min(B[M/2+1], A[0]));
			}
			return mo4(B[M/2], B[M/2-1], max(A[1],B[M/2-2]), min(B[M/2+1], A[0]));
		}
		int idxA = (N-1)/2 ;
		int idxB = (M-1)/2 ;
		if(A[idxA] <= B[idxB]){
			A = Arrays.copyOfRange(A, idxA, N);
		    B = Arrays.copyOfRange(B,0, idxB+1);
			return findMedianUtil(A, A.length, B, B.length);
		}
		else{
			A = Arrays.copyOfRange(A,0, idxA+1);
			B = Arrays.copyOfRange(B, idxB, M);
			return findMedianUtil(A,A.length, B, B.length);			
		}
			
	}
	public double findMedia(int[] A, int[] B){
		if(A.length <= B.length){
			return findMedianUtil(A, A.length, B,B.length);
		}
		return findMedianUtil(B, B.length, A, A.length);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 6, 7};
		int[] B = {2, 3, 4, 5, 8, 9,10};
		System.out.println(new MedianOfTwoSortedArray().findMedia(A,B));
	}

}
