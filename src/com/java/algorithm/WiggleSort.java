package com.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class WiggleSort {
    public static void wiggleSort(int[] nums) {
        for(int i = 1; i<nums.length;i++){
            if((i%2==1 && nums[i] < nums[i-1]) || (i%2 == 0 && nums[i] > nums[i-1])){
                int tmp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = tmp;
            }
        }
    }
    //Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
//    public static void wiggleSort2(int[] nums) {
//        for(int i = 1; i<nums.length;i++){
//            if((i%2==1 && nums[i] < nums[i-1]) || (i%2 == 0 && nums[i] > nums[i-1])){
//                swap(nums,i, i-1);
//            }else if(nums[i] == nums[i-1]){//we need to find either a bigger or a smaller one to swap from the next values
//            	if(i%2 == 1){//odd index
//            		int j;
//            		for(j = i+1; j<nums.length;j++){
//            			if(nums[j] > nums[i]){
//            				swap(nums,i,j);
//            				break;
//            			}
//            		}
//            		if(j == nums.length){
//                		System.out.println("Special Judge: No expected output available.");
//                		break;            			
//            		}
//
//            	}else if(i%2 == 0){
//            		int j;
//            		for(j = i+1; j<nums.length;j++){
//            			if(nums[j] < nums[i]){
//            				swap(nums,i,j);
//            				break;
//            			}
//            		}
//            		if(j == nums.length){
//            			System.out.println("Special Judge: No expected output available.");
//            			break;          
//            		}
//            	}
//            }
//        }
//    }
    public static void swap(int[] nums, int a, int b){
    	int tmp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = tmp;
    }
    
    public static void wiggleSort2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, mid = n%2==0?n/2-1:n/2;
        int[] temp = Arrays.copyOf(nums, n);
        int index = 0;
        for(int i=0;i<=mid;i++){
            nums[index] = temp[mid-i];
            if(index+1<n)
                nums[index+1] = temp[n-i-1];
            index += 2;
        }
    }
     public static void wiggleSortN(int[] nums) {
        if(nums == null) return;
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        for(int i =0; i< tmp.length/2; i++){
            nums[i*2] = tmp[i];
        }
        int k;
        if(tmp.length % 2 != 0){//odd number
            nums[tmp.length -1] = tmp[tmp.length/2];
            k = tmp.length - 2;
            for(int j = tmp.length/2+1; j<tmp.length; j++){
                nums[k] = tmp[j];
                k -= 2;
            }            
        }else{
            k = tmp.length -1;
            for(int j = tmp.length/2; j<tmp.length; j++){
                nums[k] = tmp[j];
                k -= 2;
            }            
        }
//        for(int index = 0; index < nums.length;index++){
//        	System.out.print(nums[index] +"	");; 
//        }
    }
    public static void print(int[] nums){
		for(int i = 0 ; i<nums.length;i++)
			System.out.print(nums[i]+"	");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3, 5, 2, 1, 6, 4};
		int[] nums2 = {1, 1, 2, 2, 3, 3};
		int[] nums3= {1,2,2,1,2,1,1,1,1,2,2,2};
		WiggleSort.wiggleSort2(nums3);
		print(nums3);
	}

}
