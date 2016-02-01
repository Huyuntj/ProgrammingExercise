package com.java.algorithm.sort;

import java.util.Arrays;

import com.java.algorithm.BinarySearchTree;

public class MergeSort {
	
	//runtime complexity O(nlogN)
	public static void mergeSort(int[] arr, int start, int end){
		if(start >= end) return;
		
		int mid = (start+end)/2;
		int[] left = Arrays.copyOfRange(arr, 0, mid+1);
		int[] right = Arrays.copyOfRange(arr,mid+1, end+1);
		mergeSort(left, 0,left.length-1);
		mergeSort(right, 0, right.length-1);
		sort(arr, left, right);
		
	}
	public static void sort(int[] arr, int[] left, int[] right){
		int i = 0,j = 0, k = 0;
		while(i < left.length && j< right.length){
			if(left[i] <= right[j]){
				arr[k++] = left[i++];
			}else{
				arr[k++] = right[j++];
			}
		}
		while(i < left.length){
			arr[k++] = left[i++];
		}
		while(j < right.length){
			arr[k++] = right[j++];
		}
	}
	public static void main(String[] args) {
		int[] arr1 = {5, 1, 3, 4, 2, 4, 8, 6, 9};
		MergeSort.mergeSort(arr1, 0, arr1.length-1);
		SortHelper.print(arr1);
		
		int[] arr2 = {1,2,3,4,5,6,7};
		MergeSort.mergeSort(arr2, 0, arr2.length-1);
		SortHelper.print(arr2);
		
	}

}
