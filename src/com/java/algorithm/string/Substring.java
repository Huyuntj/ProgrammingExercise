package com.java.algorithm.string;

public class Substring {
	//return if string b is a substring of a;
	public static boolean isSubstring(String a, String b){
		if(a == null || b == null || b.length() == 0) return false;
		boolean find = false;
		int i = 0, j = 0;
		while(i < b.length() && j < a.length()){
				if(b.charAt(i) == a.charAt(j)){
					j++;
					i++;
				}else{
					j++;
					i = 0;
				}	
		}
		if(i == b.length()){
			find = true;
		}
		return find;
	}
	public static boolean isSubstring2(String a, String b){
		if(a == null || b == null || b.length() == 0) return false;
		
		for(int i = 0; i<a.length(); i++){
			boolean notfind = false;
			for(int j = 0; j<b.length();j++){
				if(a.charAt(i+j) != b.charAt(j)){
					notfind = true;
					break;
				}
			}
			if(notfind == false){
				return true;
			}
		}
		return false;
		
	}	
	
	public static void main(String[] args){
		System.out.println(Substring.isSubstring2("I am a singer", "asinger"));
	}
}
