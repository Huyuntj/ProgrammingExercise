package com.java.algorithm.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

//Given a string, find the length of the longest substring without repeating 
//characters. For example, the longest substring without repeating letters 
//for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring 
//is "b", with the length of 1.
public class LongestSubstringWithoutRepeatingCharacters {
	   
	public int lengthOfLongestSubstring(String s) {
	        if(s == null || s.length() == 0) return 0;
	        int i = 0; int low = i;
//	        int[] count = new int[26];
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
//  This solution is from Code Ganker's blog	
//	这道题用的方法是在LeetCode中很常用的方法，对于字符串的题目非常有用。 
//	首先brute force的时间复杂度是O(n^3), 对每个substring都看看是不是有重复的字符，找出其中最长的，复杂度非常高。优化一些的思路是稍微动态规划一下，每次定一个起点，然后从起点走到有重复字符位置，
//	过程用一个HashSet维护当前字符集，认为是constant操作，这样算法要进行两层循环，复杂度是O(n^2)。 
//	最后，我们介绍一种线性的算法，也是这类题目最常见的方法。基本思路是维护一个窗口，每次关注窗口中的字符串，在每次判断中，左窗口和右窗口选择其一向前移动。
//	同样是维护一个HashSet, 正常情况下移动右窗口，如果没有出现重复则继续移动右窗口，如果发现重复字符，则说明当前窗口中的串已经不满足要求，继续移动有窗口不可能得到更好的结果，
//	此时移动左窗口，直到不再有重复字符为止，中间跳过的这些串中不会有更好的结果，因为他们不是重复就是更短。
//	因为左窗口和右窗口都只向前，所以两个窗口都对每个元素访问不超过一遍，因此时间复杂度为O(2*n)=O(n),是线性算法。空间复杂度为HashSet的size,也是O(n).	
	public int lengthOfLongestSubstring2(String s) {  
	    if(s==null || s.length()==0)  
	        return 0;  
	    HashSet<Character> set = new HashSet<Character>();  
	    int max = 0;  
	    int walker = 0;  
	    int runner = 0;  
	    while(runner<s.length())  
	    {  
	        if(set.contains(s.charAt(runner)))  
	        {  
	            if(max<runner-walker)  
	            {  
	                max = runner-walker;  
	            }  
	            while(s.charAt(walker)!=s.charAt(runner))  
	            {  
	                set.remove(s.charAt(walker));  
	                walker++;  
	            }  
	            walker++;  
	        }  
	        else  
	        {  
	            set.add(s.charAt(runner));  
	        }  
	        runner++;  
	    }  
	    max = Math.max(max,runner-walker);  
	    return max;  
	}  
	
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; ++j) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(ans, j - i );
            map.put(s.charAt(j), j );
        }
        return ans;
    }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(test.lengthOfLongestSubstring3("abcbcad"));
	}

}
