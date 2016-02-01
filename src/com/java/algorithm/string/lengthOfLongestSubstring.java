package com.java.algorithm.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {
	
//	Given a string, find the length of the longest substring without repeating 
//  characters. For example, the longest substring without repeating letters for 
//  "abcabcbb" is "abc", which the length is 3. 
//  For "bbbbb" the longest substring is "b", with the length of 1.
	
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0 ) return 0;
        int longestLen = 0;
        for(int i = 0; i< s.length();i++){
        	Set<Character> set = new HashSet();
        	int tmpLen = 0;
        	int start = i;
        	while(start<s.length()){
        		if(set.contains(s.charAt(start))){
        			break;
        		}
        		set.add(s.charAt(start));
    			tmpLen++;
    			start++;
        	}
        	longestLen = tmpLen > longestLen?tmpLen:longestLen;
        	
        }
        return longestLen;
    }
    
    public static int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0) return 0;
        int i = 0; int low = i;
//        int[] count = new int[26];
        HashMap<Character, Integer> map = new HashMap();
        int len = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(map.get(c) != null){
                map.put(c, i);
                i++;
            }else{               
            	low = map.get(c) + 1;
                i = low;
                map.clear();                        	
            }
            len = len > (i-low) ? len : (i-low);
        }
        return  len;
    }
    //4ms solution without hash map
    public static int lengthOfLongestSubstring3(String s) {
        if(s == null || s.length() == 0) return 0;
        int i = 0; int low = i;
//        int[] count = new int[26];
        HashMap<Character, Integer> map = new HashMap();
        int len = 0, maxLen = 0;
        for(; i< s.length(); i++){
            char c = s.charAt(i);
            if(map.get(c) != null){
                low = map.get(c) + 1;
                i = low;
                c = s.charAt(i);
                maxLen = len > maxLen ? len : maxLen;
                len = 0;
                map.clear();
            }
            map.put(c,i);
            len ++;
        }
        return  maxLen = len > maxLen ? len : maxLen;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcabcbb";
		String s2 = "qpxrjxkltzyx";	
		String s3 = "a";
		System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring3(s3));
//		System.out.println((char)-2);
//		System.out.println((int)' ');
	}

}
