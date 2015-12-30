package com.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        if(strings == null) return null;
        List<List<String>> res = new ArrayList();
        List<String> set = new ArrayList();
        for(int i =0 ; i<strings.length; i++){
            set.add(strings[i]);
        }
//        Collections.sort(set);
        while(!set.isEmpty()){
            Iterator<String> it = set.iterator();
            String start = it.next();
            set.remove(start);
            ArrayList subList = new ArrayList();
            subList.add(start);
            for(int j =0; j<26; j++){
                String s = shift(start);
                while(set.contains(s)){
                    set.remove(s);
                    subList.add(s);
                }
                start = s;
            }  
            res.add(subList);
        }
        return res;
      
    }
    
    private String shift(String s){
        if(s == null || s.length() == 0) return s;
        char[] c = new char[s.length()];
        for(int i = 0 ; i<s.length(); i++){
            if(s.charAt(i) == 'z'){
                c[i] = 'a';
            }else{
                c[i] = (char)(s.charAt(i) + 1);                
            }

        }
        return new String(c);
    }
    
    public List<List<String>> groupStrings2(String[] strings){

        HashMap<String, List<String>> map = new HashMap();
        Arrays.sort(strings);
        for(String s : strings){
            String key = "";
            for(int i = 1; i<s.length();i++){
                key += String.format("%2d",(s.charAt(i) - s.charAt(i-1) + 26 ) % 26);
            }
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else{
            	List<String> l = new ArrayList<String>();
            	l.add(s);
                map.put(key, l);
            }
        }
        return new ArrayList<List<String>>(map.values());
      
        	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupShiftedStrings gss = new GroupShiftedStrings();
		String[]  strings = {"abc","bcd","acef", "xyz", "az", "ba", "a", "z"};
		String[]  strings2 = {"h","k","r","r","t"};

		System.out.println(gss.groupStrings2(strings2));
//		System.out.println("bcd"-"abc");
	}

}
