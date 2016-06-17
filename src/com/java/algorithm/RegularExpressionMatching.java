package com.java.algorithm;

public class RegularExpressionMatching {
//	10. Regular Expression Matching, Hard
//	Implement regular expression matching with support for '.' and '*'.
//
//	'.' Matches any single character.
//	'*' Matches zero or more of the preceding element.
//
//	The matching should cover the entire input string (not partial).
//
//	The function prototype should be:
//	bool isMatch(const char *s, const char *p)
//
//	Some examples:
//	isMatch("aa","a") → false
//	isMatch("aa","aa") → true
//	isMatch("aaa","aa") → false
//	isMatch("aa", "a*") → true
//	isMatch("aa", ".*") → true
//	isMatch("ab", ".*") → true
//	isMatch("aab", "c*a*b") → true
//    public boolean isMatch(String s, String p) {
//        
//    }
    

//    44. Wildcard matching  Hard
//    Implement wildcard pattern matching with support for '?' and '*'.
//
//    '?' Matches any single character.
//    '*' Matches any sequence of characters (including the empty sequence).
//
//    The matching should cover the entire input string (not partial).
//
//    The function prototype should be:
//    bool isMatch(const char *s, const char *p)
//
//    Some examples:
//    isMatch("aa","a") → false
//    isMatch("aa","aa") → true
//    isMatch("aaa","aa") → false
//    isMatch("aa", "*") → true
//    isMatch("aa", "a*") → true
//    isMatch("ab", "?*") → true
//    isMatch("aab", "c*a*b") → false
	
	/*
	 * T[i][j] = T[i-1][j-1]	 			if s[i] = [j] || p[j] = '?'
	 * 		   = T[i-1][j] || T[i][j-1] 	if p[j] ='*'
	 *         = false;
	 *         
	 *  when construct T array, line is s, column is p
	 *  0 line means ''
	 *  0 column means pattern ''     
	 */
	public static boolean isWildcardMatchingDP(String s, String p){
		char[] sc = s.toCharArray();
		char[] pc = p.toCharArray();
		boolean[][] T = new boolean[sc.length+1][pc.length+1];
		T[0][0] = true;
		//be careful!
		//for the first line, we need to specify this 
		for(int j = 1; j<T[0].length;j++){
			if(pc[j-1] =='*'){
				T[0][j] = T[0][j-1];
			}
		}
		for(int i = 1; i<T.length; i++){
			for(int j = 1; j<T[0].length; j++){
				if(pc[j-1]=='?'|| sc[i-1] == pc[j-1]){
					T[i][j] = T[i-1][j-1];
				}else if(pc[j-1] == '*'){
					T[i][j] = T[i-1][j] || T[i][j-1];
				}
			}
		}
		return T[sc.length][pc.length];
	}
	//for above solution, we can optimize the pattern
	//replace *** to * e.g. a***b**c ->a*b*c
	public static boolean isWildcardMatchingDPOptimized(String s, String p){
		char[] sc = s.toCharArray();
		char[] pc = p.toCharArray();
		int idx = 0;
		boolean isFirstStar = true;
		for(int i = 0; i<pc.length;i++){
			if(pc[i] == '*' ){
				if(isFirstStar){
					pc[idx++] = pc[i];
					isFirstStar = false;
				}
			}else{
				pc[idx++] = pc[i];
				isFirstStar = true;
			}
		}
		boolean[][] T = new boolean[sc.length+1][idx+1];
		T[0][0] = true;//T[0][0] means if pattern '' matches char ''
		if(idx >0 && pc[0] == '*') T[0][1] = true; // this means pattern '*' matches ''
		//also for T[i][0](i>0) means pattern '' does not match any character
		for(int i = 1; i<T.length; i++){
			for(int j = 1; j<T[0].length; j++){
				if(pc[j-1]=='?'|| sc[i-1] == pc[j-1]){
					T[i][j] = T[i-1][j-1];
				}else if(pc[j-1] == '*'){
					T[i][j] = T[i-1][j] || T[i][j-1];
				}
			}
		}
		return T[sc.length][idx];		
	}
	
	//O(n) time & O(1) space solution from leetcode discuss forum
//	Loop
//
//	keep two pointers in S and P here i and j
//
//	if S[i] == P[j] or P[j] == '?' we keep moving
//
//	if '*' exist in P then we mark the position in P as star and mark position in s as s_star
//	Loop over s until S[i] == P[star + 1] otherwise False
//	note that S = 'a' P = 'a*******' is still True So we need to loop over P to check this case
//
//	if we can compare p to the end that means True
    public static  boolean isWildcardMatching(String s, String p) {
        if(p == null || p.length() == 0) return (s == null || s.length() == 0);
        int i=0 , j=0;
        int jstar = -1;
        int istar = 0;
        while(i<s.length()){
        	if(j<p.length()&& (s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')){
        		i++;
        		j++;
        	}else if(j<p.length() && p.charAt(j)=='*'){
        		jstar = j;
        		istar = i;
        		j++;
        	}else if(jstar !=-1){
        		// this branch is for case like: s = "abebcef" ; p = "a*b*ef*";
        		//first e after b is matching e after second *, but eb after this e doesn't match ef
        		//so we need to reset j to jstar +1 and go forward in s to check further
        		j = jstar+1;
        		istar++;
        		i = istar;
        	}else{
        		return false;
        	}
        }
        //this is for the case: s ="ab"; p = "ab******";
        while(j<p.length() && p.charAt(j)=='*') j++;
        return j == p.length();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "aac";
		String p = "a***a****c**";
		System.out.println(RegularExpressionMatching.isWildcardMatching(s, p));
	}

}
