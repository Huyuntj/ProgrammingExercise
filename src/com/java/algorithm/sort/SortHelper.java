package com.java.algorithm.sort;

import java.util.List;

public class SortHelper {
    public static void print(int[] nums){
		for(int i = 0 ; i<nums.length;i++)
			System.out.print(nums[i]+"	");
		System.out.println();
    }
    
    public static void print(int[] nums, int len){
    	if(len > nums.length) len = nums.length;
    	for(int i = 0; i < len -1; i++){
    		System.out.print(nums[i]+"	");
    	}
    	System.out.println();
    }
    public static void print(int[][] m){
    	for(int i = 0; i<m.length;i++){
    		for(int j = 0; j< m[0].length;j++){
    			System.out.print(m[i][j]+"\t");
    		}
    		System.out.println();
    	}
    }
    public static void printListInList(List<List<Integer>> res){
    	if(res == null || res.size() == 0){
    		System.out.println("res list is empty!");
    		return;
    	}
    	for(List<Integer> list: res){
    		for(Integer i: list){
    			System.out.print(i + "\t");
    		}
    		System.out.println();
    	}
    }


	public static void print(boolean[][] m) {
    	for(int i = 0; i<m.length;i++){
    		for(int j = 0; j< m[0].length;j++){
    			System.out.print(m[i][j]+"\t");
    		}
    		System.out.println();
    	}
		
	}

}
