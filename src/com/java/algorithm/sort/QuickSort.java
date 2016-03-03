package com.java.algorithm.sort;

import com.java.algorithm.BST.BinarySearchTree;
public class QuickSort {
	
	public static void quickSort(int[] arr, int start, int end){
		if(start < end){
			int pIndex = getPivotIndex(arr, start, end);{
			quickSort(arr, start, pIndex-1);
			quickSort(arr, pIndex+1, end);
			}
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
		int[] arr1 = {5, 1, 3, 7, 2, 4, 8, 6, 9};
		QuickSort.quickSort(arr1, 0, arr1.length-1);
		SortHelper.print(arr1);
		
		int[] arr2 = {4,1,1};
		QuickSort.quickSort(arr2, 0, arr2.length-1);
		SortHelper.print(arr2);		
		
	}

}
