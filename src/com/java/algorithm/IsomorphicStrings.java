package com.java.algorithm;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public static boolean solution(String s1, String s2){
		if(s1.length() == 0 && s2.length() == 0){
			return true;
		}
//		char[] char1 = s1.toCharArray();
//		char[] char2 = s2.toCharArray();
		Map<Character, Character> map1 = new HashMap<Character,Character>();
		Map<Character, Character> map2 = new HashMap<Character,Character>();
		for(int i = 0; i < s1.length(); i++){
			if(map1.get(s1.charAt(i)) == null){
				map1.put(s1.charAt(i), s2.charAt(i));				
			}
			if(map2.get(s2.charAt(i)) == null){
				map2.put(s2.charAt(i), s1.charAt(i));
			}
			if(map1.get(s1.charAt(i)) != s2.charAt(i) || map2.get(s2.charAt(i)) != s1.charAt(i))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long t1 = System.currentTimeMillis();
		
		System.out.println(IsomorphicStrings.solution("paper", "title"));
		
		long t2 =  System.currentTimeMillis();;
		System.out.println(t2-t1);
	}

}
