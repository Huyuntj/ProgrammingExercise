package com.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {
//    public static String alienOrder(String[] words) {
//    	if(words  == null || words.length == 0) return "";
//    	if(words.length == 1) return words[0];
//    	int maxLen = 0;
//        for(int i = 0;i < words.length;i++){
//        	maxLen = words[i].length() > maxLen ? words[i].length() : maxLen;
//        }
//        List<String> sList = new ArrayList();
//        for(int i = 0; i<maxLen; i++){
//        	String s = "";
//        	for(int j =0 ; j<words.length;j++){
//        		if(i < words[j].length()){
//        			char c  = words[j].charAt(i);
//        			if(s.indexOf(c) == -1){
//        				s += c;
//        			}
//        		}
//        		
//        	}
//        	sList.add(s);
//        }
//        String res = sList.get(0);
//        for(int i = 1; i<sList.size(); i++){
//        	res = merger(res,sList.get(i));
//        	if(res == null) return "";
//        }
//        return res;
//    }
//    private static String merger(String s1, String s2){
//        String s = "";
//        int len1 = s1.length();
//        int len2 = s2.length();
//        int i = 0, j=0;
//        int sameAt = -1; 
//        while(i<len1){
//            char s1c = s1.charAt(i);
//            if(sameAt >=0 ){
//            	j = sameAt;
//            }else{
//            	j = 0;
//            }
//            
//            while(j < len2){
//                char s2c = s2.charAt(j);
//                if(s1c == s2c){
//                    for(int k = sameAt +1; k < j; k++){
//                        s += s2.charAt(k);
//                    }
//                    s += s1c;                    
//                    sameAt = j;
//                    break;
//                }
//                j++;
//                
//            }
//            if(j == len2){
//                s += s1c;
//            }
//            i++;
//        }
//        if(sameAt == -1){
//        	s += s2;
//        }
//        for( i = 0; i<s.length();i++){
//        	char c = s.charAt(i);
//        	if(s.indexOf(c) != s.lastIndexOf(c)){
//        		return  null;
//        	}
//        }
//        return s;
//    }
	
    private final int N = 26;
    public String alienOrder(String[] words) {
        int[] degree = new int[N];
        List<Set<Integer>> list = new ArrayList();
        buildGraphy(words,degree,list);
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i< N; i++){
            if(degree[i] == 0){
                q.add(i);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()){
            int index = q.poll();
            res.append((char)('a'+index));
            for(Integer charInt : list.get(index)){
                if(--degree[charInt] == 0){
                    q.add(charInt);
                }
            }
        }
        for(int d : degree){
            if(d > 0) return "";
        }
        return res.toString();
    }
    
    public void buildGraphy(String[] words, int[] degree, List<Set<Integer>> adj){
        for(int i = 0; i< N; i++){
            adj.add(new HashSet<Integer>());
        }
        Arrays.fill(degree, -1);
        for(int i = 0 ; i< words.length;i++){
            for(char c : words[i].toCharArray()){
                if(degree[c - 'a'] < 0) degree[c - 'a'] = 0;
            }
            if(i > 0){
                String w1 = words[i-1];
                String w2 = words[i];
                int len = w1.length() < w2.length()? w1.length(): w2.length();
                for(int j = 0 ; j<len; j++){
                    char c1 = w1.charAt(j); char c2 = w2.charAt(j);
                    if(c1 != c2){
                        degree[c2-'a']++;
                        if(!adj.get(c1-'a').contains(c2-'a')){
                            adj.get(c1-'a').add(c2-'a');
                        }
                        break;
                    }
                }
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"wrt",  "wrf", "er", "ett", "rftt"};
		String[] words2 = {"za","zb","ca","cb"};
		System.out.println(new AlienDictionary().alienOrder(words));
	}

}
