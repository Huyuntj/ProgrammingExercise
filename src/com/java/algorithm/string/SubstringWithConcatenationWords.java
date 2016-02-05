package com.java.algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//You are given a string, s, and a list of words, words, that are all of the same length. 
//Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
//
//For example, given:
//s: "barfoothefoobarman"
//words: ["foo", "bar"]
//
//You should return the indices: [0,9].
//(order does not matter).
public class SubstringWithConcatenationWords {
	
//这道题看似比较复杂，其实思路和Longest Substring Without Repeating Characters差不多。
//因为那些单词是定长的，所以本质上和单一个字符一样。和Longest Substring Without Repeating Characters的区别只在于我们需要维护一个字典，
//然后保证目前的串包含字典里面的单词有且仅有一次。思路仍然是维护一个窗口，如果当前单词在字典中，则继续移动窗口右端，否则窗口左端可以跳到字符串下一个单词了。
//假设源字符串的长度为n，字典中单词的长度为l。因为不是一个字符，所以我们需要对源字符串所有长度为l的子串进行判断。
//做法是i从0到l-1个字符开始，得到开始index分别为i, i+l, i+2*l, ...的长度为l的单词。这样就可以保证判断到所有的满足条件的串。
//因为每次扫描的时间复杂度是O(2*n/l)(每个单词不会被访问多于两次，一次是窗口右端，一次是窗口左端)，总共扫描l次（i=0, ..., l-1)，所以总复杂度是O(2*n/l*l)=O(n)，是一个线性算法。
//空间复杂度是字典的大小，即O(m*l)，其中m是字典的单词数量	
	
	public static List<Integer> findSubstring(String S, String[] L){

        if(L==null || L.length==0) return null; 
        int n = L.length, m = L[0].length(), l=S.length();
        ArrayList<Integer> res = new ArrayList<Integer>();
         
        HashMap<String,Integer> covered = new HashMap<String,Integer>();
        for(int j=0;j<n;j++){
            if(covered.containsKey(L[j])){
                covered.put(L[j],covered.get(L[j])+1);
            }else{
                covered.put(L[j], 1);
            }
        }
        for(int i = 0; i< m; i++){
            HashMap<String,Integer> curMap = new HashMap<String,Integer>();
            int count = 0;
            int start = i;
            for(int j = i; j <= l - m ; j=j+m){
                String word = S.substring(j,j+m);
                //only if dictionary map contains current word, we need to match nexting words by moving the right window
                //otherwise we need to move forward the left window
                if(covered.containsKey(word)){
                    if(curMap.containsKey(word)){
                        curMap.put(word, curMap.get(word)+1);
                    }else{
                        curMap.put(word,1);
                    }
                    
                    if(curMap.get(word) <= covered.get(word)){
                        count++;
                    }else{//means this word appears more times than it is in the target list
                    //we have to move the left window to the new position 
                        while(curMap.get(word) > covered.get(word)){
                            String temp = S.substring(start, start+m);
                            if(curMap.containsKey(temp)){
                                curMap.put(temp,curMap.get(temp) - 1);
                                /*
                                 * Notice : here, need to check before count--;!
                                 *  
                                 */
                                if(curMap.get(temp)<covered.get(temp))
                                    count--;
                            }
                            start += m;
                        }
                    }
                    if(count == n){
                        res.add(start);
                        String prevWord = S.substring(start, start+m);
                        if(curMap.containsKey(prevWord)){
                            curMap.put(prevWord,curMap.get(prevWord) - 1);
                        }
                        count--;
                        start += m;
                    }
                }else{//this means that current word is not in the dictionary, which also means that all the previous words
                // have to be discarded
                    curMap.clear();
                    count = 0;
                    start = j + m;
                    
                }
            }
            
            
        } 

        return res;    
    
    
	}
	//my brutal force solution which is exceed time limit
    public static List<Integer> findSubstringBad(String s, String[] words) {       List<Integer> res = new ArrayList();
    if(s == null || words == null || words.length == 0) return res;
    HashMap<String, Integer> wordDict = new HashMap();
    for(int i = 0; i < words.length; i++){
        if(!wordDict.containsKey(words[i])){
            wordDict.put(words[i], 1);
        }else{
            wordDict.put(words[i], wordDict.get(words[i])+1);
        }
    }
    
    int len = words[0].length();
    int wordsLen = len * words.length;
    HashMap<String, Integer> curDict;
    int i = 0;
    while( i<= s.length() - wordsLen){
        curDict = new HashMap();
        int j;
        for(j = i; j < i+wordsLen;j=j+len){
            String word = s.substring(j, j+len);
            if(!wordDict.containsKey(word)) {
                break;
            }
            if(!curDict.containsKey(word)){
                curDict.put(word, 1);
            }else{
                curDict.put(word, curDict.get(word)+1);
            }
            if(curDict.get(word) > wordDict.get(word)){
                
                break;
            }

        }
        if(j == i + wordsLen){
            res.add(i);
        }
       
        
    }
    return res;
    }
    



    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";
//		String[] words = {"ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba"};
		String s = "barfoothefoobarman";
		String[] words = {"foo", "bar"};
		long time1 = System.currentTimeMillis();
		List<Integer> res = SubstringWithConcatenationWords.findSubstring(s, words);
		long time2 = System.currentTimeMillis();
		System.out.println(time2-time1);
		System.out.println(res);
	}

}
