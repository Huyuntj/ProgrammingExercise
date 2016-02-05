package com.java.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs == null ) return null;
        if(strs.size() == 0) return "0#";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< strs.size();i++){
            sb.append(strs.get(i).length()).append("#").append(strs.get(i));
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    //0#1#a3#3##1#b
    public List<String> decode(String s) {
        if(s == null) return null;
        List<String> res = new ArrayList();
        int i = 0;
        while(i < s.length()){
           int seperatorIndex =  s.indexOf("#",i);
           int num = Integer.parseInt(s.substring(i,seperatorIndex));
           res.add(s.substring(seperatorIndex+1, seperatorIndex + num+1));
           i = seperatorIndex + num +1;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EncodeAndDecodeStrings test = new EncodeAndDecodeStrings();
		List<String> strs = Arrays.asList("", "abc", "ab", "2#");
		String s = "0#3#abc2#ab2#2#";
		System.out.println(test.encode(strs).equals(s));
//		String s = "0#3#abc2#ab2#2#";
		System.out.println(test.decode(s));
		System.out.println(s.substring(0,0));
	}

}
