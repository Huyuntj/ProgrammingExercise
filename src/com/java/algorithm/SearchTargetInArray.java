package com.java.algorithm;

public class SearchTargetInArray {
/*
 * adjacent elements in this array are no more that 1, find the index of target element
 */
	
	public static int search(int[] a, int target){
		if(target < a[0] || target > a[a.length-1]) return -1;

		for(int i = 0; i< a.length;){
			if(target == a[i]) return i;
			
			i += (target - a[i]);
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a ={1, 1, 2, 3, 2,3, 4, 4};
		System.out.println(SearchTargetInArray.search(a, 0));
	}

}
