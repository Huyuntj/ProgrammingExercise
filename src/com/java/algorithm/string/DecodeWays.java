package com.java.algorithm.string;

public class DecodeWays {
//	91 Decode Ways Medium
//	A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//		'A' -> 1
//		'B' -> 2
//		...
//		'Z' -> 26
//		Given an encoded message containing digits, determine the total number of ways to decode it.
//
//		For example,
//		Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
//		The number of ways decoding "12" is 2.
//
//		Show Company Tags
//		Show Tags
    public static int numDecodingsRecusive(String s) {
        if(s.length() == 0) return 0;
        return helper(s);
        
    }
    private static int helper(String s){
        if(s.length() == 1) return 1;
        if(s.charAt(0)=='1'|| s.charAt(0) =='2'){
            if(s.length() == 2) return 2;
            return helper(s.substring(1)) + helper(s.substring(2));
        }else{
            return helper(s.substring(1));
        }
    }
    
    public static int numDecodingDP(String s){
    	//if s starts with "0" return 0
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
       
        int pre1 = 1; int pre2 = 1;
        for(int i = 1; i<s.length(); i++){
        	int cur = pre1;
            if(s.charAt(i) != '0'){
                if(s.charAt(i-1) == '1' || ((s.charAt(i-1) == '2') && ((int)s.charAt(i) - 48) < 7)) {
                    pre1 +=  pre2;
                }
            }else{
                if(s.charAt(i-1) != '1' && s.charAt(i-1) != '2'){
                    return 0;
                }
                pre1 = pre2;
            }
            pre2 = cur;
        }
        return pre1;
    
    }
    
    public static int numDecodingDP2(String s){
    	if(s == null || s.length() == 0 ) return 0;
//    	int[] dp = new int[s.length()+1];
    	int prev2 = 1;//dp[0] means an empty string will have one way to decode
    	int prev1 = s.charAt(0) == '0'? 0 : 1;//dp[1] means the way to decode a string of size 1
    	for(int i = 2; i<s.length(); i++){
    		int cur = 0;
    		int first = Integer.parseInt(s.substring(i-1,i));
    		int second = Integer.parseInt(s.substring(i-2, i));
    		if(first >= 1 && first <= 9){
    			cur += prev1;
    		}
    		if(second >= 10 && second <= 26){
    			cur += prev2;
    		}
    		prev2 = prev1;
    		prev1 = cur;
    		
    	}
    	return prev1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(DecodeWays.numDecodingsRecusive("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
		System.out.println(DecodeWays.numDecodingDP2("13141"));
//		System.out.println(Integer.parseInt("000"));
	}

}
