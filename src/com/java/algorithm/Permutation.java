package com.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
	private int[] nums;

	public List<String> permute1(String s){
		List<String> res = new ArrayList<String>();
		int start = 0;
		int end = s.length()-1;
		getAllPermutations1(s.toCharArray(),res,start,end);
		return res;
	}
	public void getAllPermutations1(char[] arr, List<String> list, int start, int end){
		if(start == end){
//			System.out.println(new String(arr));
			list.add(new String(arr));
			return;
		}
		int cur = start;
		for(int i = start; i<=end; i++){
			char tmp = arr[cur];
			arr[cur] = arr[i];
			arr[i] = tmp;
			getAllPermutations1(arr,list,start+1, end);
			tmp = arr[cur];
			arr[cur] = arr[i];
			arr[i] = tmp;
		}
	}	
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null) return res;
        getAllPermutations2(nums,res, 0, nums.length-1);
        return res;
    }
    
    //for each position, we can fix one number at a time and then compute how many permutation there are for 
    //the rest positions
    public void getAllPermutations2(int[] nums, List<List<Integer>> list, int start, int end){
        if(start == end){
        	ArrayList<Integer> l = new ArrayList();
        	for(int j = 0; j<nums.length;j++){
        		l.add(nums[j]);
        	}
            list.add(l);
            return;
        }
        int cur = start;
        for(int i = start; i<=end; i++){
            int tmp = nums[i];
            nums[i] = nums[cur];
            nums[cur] = tmp;
            getAllPermutations2(nums, list, start+1, end);
            tmp = nums[i];
            nums[i] = nums[cur];
            nums[cur] = tmp;            
        }
    }	
    
    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null) return res;
        res = getAllPermutations3(nums,nums.length-1);
        return res;
    }
    
    public List<List<Integer>> getAllPermutations3(int[] nums, int end){
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	if(end == 0){   		
			ArrayList<Integer> l = new ArrayList();
			l.add(nums[end]);
			list.add(l);
    		return list;
    		
    	}
    	List<List<Integer>> res = getAllPermutations3(nums, end-1);
    	for(int i = 0 ; i< res.size();i++){
    		for(int j = 0; j<= end; j++){
    			List l = new ArrayList(res.get(i));
    			l.add(j, nums[end]);
    			list.add(l);
    		}
    	}
    	return list;
    }

	public static void main(String[] args) {
		String s = "abc";
		Permutation p = new Permutation();
//		System.out.println(p.permutationRecusive(s));
		int[] a = {1,2,3,4};
		List<List<Integer>> list = p.permute3(a);
		System.out.println(list.size());
		for(List<Integer> l : list){
			System.out.println(l);
//			for(int i = 0; i< l.size();i++){
//				System.out.print(l.get(i));
//			}
//			System.out.println();
			
		}
	
		
	}

}
