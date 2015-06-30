package com.javarevisited;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DuplicateNumber {
	
	public static HashMap<Integer, Integer> duplicate(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		int i = 0;
		while(i < arr.length){
			if(map.get(arr[i]) == null){
				map.put(arr[i], 1);
			}else{
				map.put(arr[i], (int)map.get(arr[i]) + 1);
			}
			i++;
		}
		return map;
	};
   public static boolean checkDuplicateUsingSet(String[] input){
        List inputList = Arrays.asList(input);
        Set inputSet = new HashSet(inputList);
        if(inputSet.size()< inputList.size()){
            return true;
        };
        return false;
    };


	
	public static void main(String[] args) {
//		String[] unsorted = {"one","two","three","two"};
//		Boolean flag = DuplicateNumber.checkDuplicateUsingSet(unsorted);
//		System.out.println(flag);
		Integer[] intArray = new Integer[]{new Integer(1), new Integer(2), new Integer(3), new Integer(2)};
		List list = Arrays.asList(intArray);
		@SuppressWarnings("unchecked")
		HashSet set = new HashSet();
		System.out.println( set.add(new Integer(1)));
		System.out.println( set.add(new Integer(1)));
//		System.out.println(set.size());		
//		Iterator it = set.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());			
//		}

		
		
	}

}
