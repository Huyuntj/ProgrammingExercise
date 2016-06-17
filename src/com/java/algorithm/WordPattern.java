package com.java.algorithm;

import java.util.HashMap;

//290. Easy
//Given a pattern and a string str, find if str follows the same pattern.
//
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
//
//Examples:
//pattern = "abba", str = "dog cat cat dog" should return true.
//pattern = "abba", str = "dog cat cat fish" should return false.
//pattern = "aaaa", str = "dog cat cat dog" should return false.
//pattern = "abba", str = "dog dog dog dog" should return false.
//Notes:
//You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
public class WordPattern {
	//implement with two hash maps
    public boolean wordPattern(String pattern, String str) {
        char[] p = pattern.toCharArray();
        String[] s = str.split(" ");
        if(p.length != s.length) return false;//pay attention to here
        HashMap<Character, Integer> pm = new HashMap();
        HashMap<String, Integer> sm = new HashMap();
        for(int i = 0; i< p.length; i++){
            if(pm.get(p[i]) != sm.get(s[i])){
                return false;
            }
            if(!pm.containsKey(p[i])){
                pm.put(p[i], 1);
                sm.put(s[i],1);
            }else{
                pm.put(p[i], pm.get(p[i])+1);
                sm.put(s[i], sm.get(s[i])+1);
            }
        }
        return true;
    }
    //implment with one map
    //pay attention to case "abba" && "dog dog dog dog"
    public boolean wordPattern2(String pattern, String str) {
        char[] p = pattern.toCharArray();
        String[] s = str.split(" ");
        if(p.length != s.length) return false;
        
        HashMap<Character, String> pm = new HashMap();
        for(int i = 0; i< p.length; i++){
            if(pm.containsKey(p[i])){
                if(!pm.get(p[i]).equals(s[i])) return false;
            }else{
                if(pm.containsValue(s[i])) return false;
                pm.put(p[i],s[i]);
            }
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
