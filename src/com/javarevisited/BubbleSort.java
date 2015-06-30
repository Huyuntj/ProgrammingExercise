package com.javarevisited;

import java.util.Arrays;

public class BubbleSort {

	public static void Sort(int[] array){
		for(int i = 0; i < array.length; i++){
			for(int j = 1; j < array.length - i; j++){
				if(array[j-1] > array[j]){
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] unsorted = {32, 39,21, 45, 23, 3};
		BubbleSort.Sort(unsorted);
		System.out.println(Arrays.toString(unsorted));
	}

}
