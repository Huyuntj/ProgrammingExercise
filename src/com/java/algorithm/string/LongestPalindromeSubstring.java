package com.java.algorithm.string;

import com.java.algorithm.utility.PrintHelper;

//Given a string S, find the longest palindromic substring in S. 
//You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
public class LongestPalindromeSubstring {
//	基本思路是对于每个子串的中心（可以是一个字符，或者是两个字符的间隙，比如串abc,中心可以是a,b,c,或者是ab的间隙，bc的间隙）往两边同时进行扫描，直到不是回文串为止。
//	假设字符串的长度为n,那么中心的个数为2*n-1(字符作为中心有n个，间隙有n-1个）。
//	对于每个中心往两边扫描的复杂度为O(n),所以时间复杂度为O((2*n-1)*n)=O(n^2),空间复杂度为O(1)，	
	public String longestPalindromeFromCenter(String s){
		if(s == null || s.length() == 0) return "";
		int len = s.length();
		int max = 0;
		String res = "";
		for(int i = 0; i<s.length();i++){
			String temp = isPalindromeCenter(s,i);
			if(temp.length() >res.length()){
				res = temp;
			}
		}
		return res;
	}
	private String isPalindromeCenter(String s, int i){
		//take i as the palindrome word center, there are two cases
		//one is taking i as the only one center; another is taking i as the left center, i+1 as the right center
		String res = "";
		int left = i, right = i;
		int n = 2;
		while(n > 0){
			left = i;
			if(n%2 == 0){
				right =i;
			}else{
				right = i+1;
			}
			while(left >= 0 && right <= s.length()-1&& s.charAt(left) == s.charAt(right)){
				left--;
				right++;
			}
			String temp = s.substring(left+1, right);
			if(temp.length() > res.length()){
				res = temp;
			}
			n--;
		}
		return res;

	}
//	这道题是比较常考的题目，求回文子串，一般有两种方法。 第一种方法比较直接，实现起来比较容易理解。
//	基本思路是对于每个子串的中心（可以是一个字符，或者是两个字符的间隙，比如串abc,中心可以是a,b,c,或者是ab的间隙，bc的间隙）往两边同时进行扫描，直到不是回文串为止。
//	假设字符串的长度为n,那么中心的个数为2*n-1(字符作为中心有n个，间隙有n-1个）。
//	对于每个中心往两边扫描的复杂度为O(n),所以时间复杂度为O((2*n-1)*n)=O(n^2),空间复杂度为O(1)，代码如下
	public String solutionFromCodeGanker(String s){
	    if(s == null || s.length()==0)
	        return "";
	    String res = "";
	    for(int i = 0 ; i<2*s.length() -1; i++){
	    	int left = i/2;
	    	int right = i/2;
	    	if(i%2==1) right++;
	    	String temp = lengthOfPalindrome(s, left, right);
	    	if(temp.length() > res.length())
	    		res = temp;
	    }
	    return res;
	}
	private String lengthOfPalindrome(String s, int left, int right)
	{
	    
	    while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
	    {
	        left--;
	        right++;
	    }
	    return s.substring(left+1,right);
	}
//	而第二种方法是用动态规划，思路比较复杂一些，但是实现代码会比较简短。
//	基本思路是外层循环i从后往前扫，内层循环j从i当前字符扫到结尾处。过程中使用的历史信息是从i+1到n之间的任意子串是否是回文已经被记录下来，所以不用重新判断，只需要比较一下头尾字符即可。
//	这种方法使用两层循环，时间复杂度是O(n^2)。而空间上因为需要记录任意子串是否为回文，需要O(n^2)的空间	
	public String solutionFromCodeGanker2(String s){
		if(s == null || s.length() == 0 ) return "";
		int len  = s.length();
		String res = "";
		boolean[][] plain = new boolean[len][len];
		for(int i = len-1; i>=0; i--){
			for(int j = i; j<len;j++){
				if((s.charAt(i) == s.charAt(j)) && ( (j-i) < 2 || plain[i+1][j-1])){
					plain[i][j] = true;
					if(res.length() < (j -i +1)){
						res = s.substring(i,j+1);
					}
				}
			}
		}
		PrintHelper.print(plain);
		return res;
	}
	//my solution
	//O(n*n*n) ETL
    public String longestPalindrome(String s) {
        String longestPalString = "";
        int len = s.length();
        if(s == null || len == 0) return longestPalString;
        
        int lo = 0;
        for(int i = 0; i<len; i++){
            lo = i;
            int hi = len - 1;
            String temp = "";
            while(hi >= lo){
                if(isPalindrome(s,lo, hi)){
                    temp = s.substring(lo, hi+1);
                    break;
                }else if(isPalindrome(s,lo+1, hi)){
                    temp = s.substring(lo+1, hi+1);
                    break;
                }else if(isPalindrome(s,lo, hi -1)){
                    temp = s.substring(lo, hi);
                    break;
                }
               hi--;
            }  
            longestPalString = temp.length() > longestPalString.length() ? temp :longestPalString;
        }

        return longestPalString;
            
    }
    private boolean isPalindrome(String s, int lo, int hi){
        while(hi >= lo){
            if(s.charAt(hi) != s.charAt(lo)) return false;
            hi--;
            lo++;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "addbdda";
		System.out.println(new LongestPalindromeSubstring().solutionFromCodeGanker2(s));
	}

}
