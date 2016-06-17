package com.java.algorithm.string;

public class EditDistance {
//	72. Edit Distance Hard
//	Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
//
//	You have the following 3 operations permitted on a word:
//
//	a) Insert a character
//	b) Delete a character
//	c) Replace a character
    public int minDistance(String word1, String word2) {
        
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int[][] dp = new int[c1.length+1][c2.length+1];
        //also can just use two array to store the status instead of 2-dimension array
        dp[0][0] = 0;
        for(int i = 1; i<=c2.length;i++){
            dp[0][i] = dp[0][i-1] + 1;
        }
        for(int i = 1; i<=c1.length;i++){
            dp[i][0] = dp[i-1][0] + 1;
        }
        for(int i = 1; i<= c1.length; i++){
            for(int j =1; j<= c2.length; j++){
                if(c1[i-1] == c2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[c1.length][c2.length];
    }
//	161 One Edit Distance Medium
//	Given two strings S and T, determine if they are both one edit distance apart.
    public static boolean isOneEditDistance(String s, String t) {
    	if(Math.abs(s.length() - t.length()) > 1) return false;
    	if(s.length() == t.length()) return isSameLength(s,t);
    	if(s.length() > t.length()) return isNotSameLength(s, t);
    	else return isNotSameLength(t,s);
    }
    private static boolean isSameLength(String s, String t){
    	int i = 0;
    	int diff = 0;
    	while(i<s.length()){
    		if(s.charAt(i) != t.charAt(i)){
    			diff++;
    		}
    		i++;
    	}
    	return (diff == 1);
    }
    //s length is larger than t
    private static boolean isNotSameLength(String s, String t){
    	int i = 0;
    	while(i<t.length()){
    		if(s.charAt(i) != t.charAt(i)) break;
    		i++;
    	}
    	if(i != t.length()){
    		return s.substring(i+1).equals(t.substring(i));
    	}
    	return true;
    }

	public static void main(String[] args) {
		System.out.println(EditDistance.isOneEditDistance("ac", "bbc"));

	}

}
