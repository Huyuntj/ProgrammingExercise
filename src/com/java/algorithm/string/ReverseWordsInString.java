package com.java.algorithm.string;
/* 151. Medium
 * Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.
 */

import java.util.Arrays;

//The differenc between 151 and 186 is that 
//there may be more than 1 space among those words.
public class ReverseWordsInString {
    public String reverseWords(String s) {
        if(s == null) return null;
        
        char[] prev = s.trim().toCharArray();
        if(prev.length  == 0) return "";
        
        reverse(prev);
        reverse(prev, 0, prev.length-1);
        return new String(cleanSpace(prev));
    }
    
    private void reverse(char[] arr){
        int p =0, q = 0;
        // int cur = 0;
        while(p<arr.length){
            if(arr[p] == ' '){
            	p++;
                continue;
            }
            q = p+1;
            while(q < arr.length && arr[q] != ' '){
                q++;
            }
            reverse(arr, p, q-1);
            p = q;
        }
        
    }
    private void reverse(char[] arr, int start, int end){
        if(start == end) return; 
        
        int p = start; 
        int q = end;
        while(p<q){
            char tmp = arr[p];
            arr[p] = arr[q];
            arr[q] = tmp;
            p++;
            q--;
        }
    }
    
	
	private char[] cleanSpace(char[] s){
	    int i = 0;
	    int len = s.length;
	    while(i < len){
	        if(s[i] == ' '){
	        	int spaceNum = 0;
	            int j = i+1;
	            int k = i+1;
	            while(j<len && s[j] == ' '){
	                j++;
	                spaceNum ++;
	            }
	            while(spaceNum > 0 && j< len){
	               s[k] = s[j];
	               s[j] = ' ';
	               k++;
	               j++;
	            }
	            len -= spaceNum;
	            
	        }
	        i++;
	    }
	    return Arrays.copyOf(s,len);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsInString rws = new ReverseWordsInString();
		System.out.println(rws.reverseWords("   a  b c     hh "));
	}

}
