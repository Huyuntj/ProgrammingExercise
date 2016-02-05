package com.java.algorithm.string;

import java.util.Arrays;
//Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
//
//The input string does not contain leading or trailing spaces and the words are always separated by a single space.
//
//For example,
//Given s = "the sky is blue",
//return "blue is sky the".
//
//Could you do it in-place without allocating extra space?

public class ReverseWordsInStringII {
	//first reverse each word
	//then reverse the whole word
	public void reverseWords(char[] s){
		int len = s.length;
		int start = 0, end =  0;
		for(int i = 0; i<len; i++){
			if(s[i] == ' ' || i == len-1) {//improve the last word handling
				end = (i == len -1) ?len -1: i-1;
				reverseWord(s, start, end);
				start = i + 1;
//				end = start;
			}else{
				end++;
			}			
		}
		//reverse the last word in the array
		//Note: no need to do it in this way , improve it
//		reverseWord(s, start, len-1);
		reverseWord(s, 0, len-1);
	}
	private void reverseWord(char[] s, int start, int end){
		int i = start; int j = end;
		while(i<j){
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
		
	}
	private void swap(char[] s, int left, int right, int spaceIndex){
		s[spaceIndex] = s[left];
		s[left] = s[right];
		s[right] = s[spaceIndex];
		
	}
	
	private int getFirstSpaceIndex(char[]s, int start, int end){
		for(int i = start; i<=end; i++){
			if(s[i]==' ') return i;
		}
		return -1;
	}
	
	private int getLastSpaceIndex(char[] s, int start, int end){
		for(int i = end; i>= start;i--){
			if(s[i]==' ') return i;
		}
		return -1;
	}
    public void reverseWordsTEL(char[] s) {
        int len = s.length;
        if(s == null || s.length < 3) return;
        int firstWordLen = 0;
        for(int i = 0; i<s.length;i++){
            if(s[i] == ' ') {
            	firstWordLen = i;
            	break;
            }
        }
        int start = 0;
        while(start < len - firstWordLen){
        	int oldStart = start;
            int lastSpaceIndex = lastSpaceIndex(s);
            //if there are no space in the words,which means the whole string contains just one word,
            //then no need to reverse then
            if(lastSpaceIndex == -1) return;
            
            int lastWordLen = len  - lastSpaceIndex - 1;
            //first move words from 0 to last space to next position respectively
            //for example: "I am boy" -> " I amboy";
            for(int i = lastSpaceIndex -1; i>= start; i--){
                s[i+1] = s[i];
            }
            s[start] = ' ';
            start++;
            int j = lastWordLen;
            //below while loop is to rotate the last word to the first position
            // "I amboy" to "boy I am"
            while(j > 0){
                char temp = s[len-1];//move last character to the first position " I amboy" ->"y I ambo"
                for(int i = len -2; i >= oldStart; i--){
                    s[i+1] = s[i];
                }
                s[oldStart] = temp;
                j--;
            }
            start = start + lastWordLen;
        }
    }
    //if no space in char array, return -1;
    private int lastSpaceIndex(char[] s){
        for(int j = s.length - 1; j>= 0; j--){
            if(s[j] == ' ') return j;
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsInStringII reverse = new ReverseWordsInStringII();
		String s = "the sky is blue";
		char[] arr= Arrays.copyOf(s.toCharArray(), s.length());
		reverse.reverseWords(arr);
		System.out.println(arr);
	}

}
