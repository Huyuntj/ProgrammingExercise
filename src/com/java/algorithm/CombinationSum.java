package com.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import com.java.algorithm.sort.SortHelper;

public class CombinationSum {
	public void DFS(int[] a, int target, List<List<Integer>> result, List<Integer> sequence, int start,
	        int sum) {
	    if (sum == target)
	        result.add(new ArrayList<Integer>(sequence));
	    else if (sum > target)
	        return;
	    else {
	    	int enter = 0;
	        for (int i = start; i < a.length; i++) {
	        	if(enter != a[i]){
		            sequence.add(a[i]);
		            sum += a[i];
		            enter = a[i];
		            DFS(a, target, result, sequence, i+1, sum);//
		            sequence.remove(sequence.size() - 1);
		            sum -= a[i];
	        	}
	        }
	    }
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
	    if (candidates == null || candidates.length == 0)
	        return new ArrayList<List<Integer>>();
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    List<Integer> sequence = new ArrayList<Integer>();
	    Arrays.sort(candidates);// 
	    DFS(candidates, target, result, sequence, 0, 0);
	    return result;
	}
	
   
    public List<List<Integer>> combinationSumDFS(int[] candidates, int target) {
    	 List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(candidates == null || candidates.length == 0 || target == 0) return res;
        Arrays.sort(candidates);
        
        for(int i = 0; i < candidates.length; i++){
        	if(i >= 1 && candidates[i] == candidates[i-1]) continue;
        	ArrayList<Integer> cur = new ArrayList<Integer>();
        	cur.add(candidates[i]);
            if(candidates[i] == target){
                res.add(cur);
                return res;
            }   
        	combinationSum(res,cur, candidates, target-candidates[i], i);
        }
        return res;
    }
    public void combinationSum(List<List<Integer>> res,ArrayList<Integer> cur,int[] candidates, int target, int startIndex){
    	 for(int i = startIndex + 1; i< candidates.length; i++){
    	        if(candidates[i] == target){
    	        	@SuppressWarnings("unchecked")
    				ArrayList<Integer> tmp = (ArrayList<Integer>)cur.clone();
    	        	tmp.add(candidates[i]);//be careful, do not add this candidate to cur
    	            res.add(tmp);
    	            return;
    	        }else if(candidates[i] > target){
    	        	return;
    	        }
	        	cur.add(candidates[i]);
	        	combinationSum(res,cur,candidates, target-candidates[i],i);
	        	cur.remove(cur.size()-1);
    	        
    	 }
        
    }
	
    public List<List<Integer>> combinationSumNonRecusive(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
       Arrays.sort(candidates);
       Stack<Integer> queue = new Stack();
       int queueSum;
       int len = candidates.length;
       for(int i = 0;i<len; i++){
           queue.push(candidates[i]);
           queueSum = candidates[i];
           int nextCandidate = candidates[i];
           while(!queue.isEmpty()){
               while(nextCandidate != -1 && target - queueSum > nextCandidate){
                   queue.push(nextCandidate);
                   queueSum += nextCandidate;
               }
               if(target - queueSum ==  nextCandidate){
                   ArrayList<Integer> list = new ArrayList();
                   list.addAll(queue);
                   list.add(nextCandidate);
                   res.add(list);
                   
               }else if(target == queueSum){
                   ArrayList<Integer> list = new ArrayList();
                   list.addAll(queue);
                   res.add(list);                    
               }
               int c = queue.pop();
               queueSum -= c;
               if(queue.isEmpty()) break;
               nextCandidate = getNextCandidate(candidates, c);
           }
       }
       return res;
    }
    
    public int getNextCandidate(int[] candidates, int cur){
        for(int i = 0; i<candidates.length - 1; i++){
            if(candidates[i] == cur) return candidates[i+1];
        }
        return -1;//last element does not have next candidates
    }
    public List<List<Integer>> combinationSumDP(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        if(target < candidates[0]) return res;
        HashMap<Integer, List<List<Integer>>> map = new HashMap();
//        List<List<Integer>> list0 = new ArrayList<List<Integer>>();
//        list0.add(new ArrayList());
//        map.put(0, list0);
        for(int i = 1; i < candidates[0];i++){
            map.put(i, new ArrayList<List<Integer>>());
        }
        for(int i = candidates[0]; i<= target; i++){
        	List<List<Integer>> tmpRes = new ArrayList();
           for(int j = 0; j<candidates.length;j++){
        	   if(i == candidates[j]){
        		   ArrayList<Integer> list = new ArrayList(); 
        		   list.add(i);
        		   tmpRes.add(list);
        	   }
        	   else if(i > candidates[j]){
                   if(map.get(i - candidates[j]).size() != 0){
                       for(List<Integer> l : map.get(i - candidates[j])){
                    	   ArrayList<Integer> list = new ArrayList(); 
                           list.add(candidates[j]);
                           list.addAll(l);
                           Collections.sort(list);
                           if(!isExist(tmpRes, list)) tmpRes.add(list);
                       }                	   
                   }
               }else{
            	   break;
               }
           }
           map.put(i,tmpRes);
        }
        return map.get(target);
    }
    public boolean isExist(List<List<Integer>> lists, List<Integer> l){
    	for(List<Integer> list : lists){
    		if(equals(list, l)) return true;  		
    	}
    	return false;
    }
    public boolean equals(List<Integer> l1, List<Integer> l2){
    	if(l1.size() != l2.size()) return false;
    	int i = 0;
    	while(i < l1.size()){
    		if(l1.get(i)!=l2.get(i)) return false;
    		i++;
    	}
    	return true;
    }
//    Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
//    Ensure that numbers within the set are sorted in ascending order.
//
//
//    Example 1:
//
//    Input: k = 3, n = 7
//
//    Output:[[1,2,4]]    
    public List<List<Integer>> combinationSum3(int k, int n) {
	    if (k == 0 || n == 0) return new ArrayList<List<Integer>>();
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    List<Integer> sequence = new ArrayList<Integer>();
	    DFS(k, n, result, sequence, 1, 0);
	    return result;        
    }
	public void DFS(int k, int n, List<List<Integer>> result, List<Integer> sequence, int start,
	        int sum) {
	    if (sum == n && k == 0)
	        result.add(new ArrayList<Integer>(sequence));
	    else if (sum > n)
	        return;
	    else {
	        for (int i = start; i <= 9; i++) {
		            sequence.add(i);
		            sum += i;
		            DFS(k-1, n, result, sequence, i+1, sum);//
		            sequence.remove(sequence.size() - 1);
		            sum -= i;
	        }
	    }
	}     
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] arr = {2,3,5,7,11};
		int[] arr2 = {1,1};
		SortHelper.printListInList(cs.combinationSum3(4, 20));
		
//		SortHelper.printListInList(cs.combinationSumDFS(arr2, 1));
//		List<List<Integer>> res = new ArrayList();
//		List<Integer> list = new ArrayList(Arrays.asList(new int[]{1,2}));
//		List<Integer> list2 = new ArrayList(Arrays.asList(new int[]{1,2}));
//		if(!res.contains(list)) res.add(list);
//		if(!res.contains(list2)) res.add(list);
//		System.out.println(res.size());
		
	}

}
