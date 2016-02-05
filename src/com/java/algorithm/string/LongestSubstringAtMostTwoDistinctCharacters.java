package com.java.algorithm.string;

import java.util.HashMap;
import java.util.Map;
//Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
//
//For example, Given s = “eceba”,
//
//T is "ece" which its length is 3.
public class LongestSubstringAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 1) return 0;
        int lo = 0; int hi = 0;
        int len = 0; int maxLen = 0;
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap();
        while(hi < arr.length){
            if(map.size()<=2){
                map.put(arr[hi], hi);
                hi++;
                len++;
            }
            if(map.size() > 2){
                int leftmost = arr.length;
                for(int j : map.values()){
                    leftmost = (j<leftmost?j:leftmost);//find the most left index
                }
                map.remove(arr[leftmost]);
                lo = leftmost + 1;
                len = hi - lo;
            }
            maxLen = len > maxLen ? len : maxLen;
        }
        return maxLen;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
