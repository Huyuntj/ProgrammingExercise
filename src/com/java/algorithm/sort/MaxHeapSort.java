package com.java.algorithm.sort;

import java.util.Arrays;

public class MaxHeapSort {
	private int[] a;
	private int n;
	public MaxHeapSort(int[] arr){
		this.a = arr;//array index starts from 0
		n = a.length;
	}
	// Input: A: an array representing a heap, i: an array index
	// Output: The index in A of the parent of i
	// Running Time: O(1)
	public int parent(int i){
		if(i == 0) return Integer.MIN_VALUE;
		return (i-1)/2;
	}
	public int left(int i){
		if(2*i+1 <= n) return 2*i +1;
		return Integer.MAX_VALUE;
	}
	public int right(int i){
		if(2*i+2 <=n) return 2*i +2;
		return Integer.MAX_VALUE;
	}
	public int max(int i, int j){
		return a[i] > a[j]? i: j;
	}
	public boolean isLeaf(int[] a, int i){
		if((i*2 + 1) < n) return true;
		return false;
	}
	// Input: A: an array where the left and right children of i root heaps (but i may not), i: an array index
	// Output: A modified so that i roots a heap
	// Running Time: O(log n) where n = heap-size[A] − i
	public void maxHeapfy(int i){
		int left = left(i);
		int right = right(i);
		int largest = i;		
		if(left < n){
			largest = max(left, i);
		}
		if(right <n){
			largest = max(right, largest);
		}
		if(largest != i){
			swap(i, largest);
			maxHeapfy(largest);
		}
	}	
	// Input: A: an (unsorted) array
	// Output: A modified to represent a heap.
	// Running Time: O(n) where n = length[A]
	public void buildMaxHeap(){
		for(int i = (n-2)/2 ; i >= 0; i--){
			maxHeapfy(i);
		}
	}

	public void heapIncreaseKey(int i, int key) throws Exception{
		if(key < a[i]) throw new Exception("Key must be larger than a["+i +"] = " + a[i]);
		a[i] = key;
		int parentIndex = parent(i);
		while(i > 0 &&  a[parentIndex] < key){
			swap(i, parentIndex);
			i = parentIndex;
			parentIndex = parent(i); 
		}
	}
	
	public void heapSort(){
		buildMaxHeap();
		for(int i = n -1; i> 0;i--){
			swap(0, i);
			n--;//Note here: n need to decrease;
			maxHeapfy(0);
		}
	}
	// Input: A: an array representing a heap
	// Output: The maximum element of A and A as a heap with this element removed
	// Running Time: O(log n) where n =heap-size[A]
	public int heapExtractMax(){
		int max = a[0];	
		a[0] = a[n-1];
		a[n-1] = Integer.MIN_VALUE;
		n--;
		maxHeapfy(0);		
		return max;
	}
	// Input: A: an array representing a heap, key: a key to insert
	// Output: A modified to include key
	// Running Time: O(log n) where n =heap-size[A]
	public void heapInsert(int key) throws Exception{
		n = n+1;
		int[] newArray = new int[n];
		for(int i = 0; i< a.length; i++){
			newArray[i] = a[i];
		}
		newArray[n-1] = Integer.MIN_VALUE;
		this.a = newArray;
		heapIncreaseKey(n-1,key);
	}
	
	public void swap(int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] a = {5,4, 9,7,19,8,17,2,6,5,21};
		MaxHeapSort hs = new MaxHeapSort(a);		
		hs.buildMaxHeap();
		SortHelper.print(a);
		hs.heapIncreaseKey(7, 22);
		SortHelper.print(a);
//		hs.heapSort();
//		hs.heapExtractMax();
//		SortHelper.print(a,hs.n);
//		hs.heapExtractMax();
//		hs.heapInsert(10);
//		SortHelper.print(hs.a);
//		hs.heapInsert(6);
//		SortHelper.print(hs.a);
	}

}
