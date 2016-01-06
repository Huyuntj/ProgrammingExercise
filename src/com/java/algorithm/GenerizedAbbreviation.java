package com.java.algorithm;

import java.util.ArrayList;
import java.util.List;

public class GenerizedAbbreviation {
	
	 public List<String> generateAbbreviations2(String word) {
		 List<String> list = generateAbbre(word, 0);
		 return list;
	 }
	public List<String> generateAbbre(String s, int index){
		List<String> l = new ArrayList();
		if(index == s.length()-1){
			l.add(s.length()-index+"");
			l.add(s.charAt(index)+"");
			return l;
		}
		List<String> tmp = generateAbbre(s,index+1);
		for(String r : tmp){
			l.add(s.charAt(index)+ r);
			l.add("1"+r);
		}
		return l;
	}
	
	
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        int len = word.length();
        res.add(len==0 ? "" : String.valueOf(len));
        System.out.println("current word is: "+word);
        for(int i = 0 ; i < len ; i++){
        	System.out.println("current loop at : " + i);
        	List<String> tmp = generateAbbreviations(word.substring(i+1));
        	System.out.println("right string: " + tmp);
            for(String right : tmp){
                String leftNum = i > 0 ? String.valueOf(i) : "";
                res.add( leftNum + word.substring(i,i + 1) + right );
            }
        }
        
        System.out.println("current loop result is: " + res);
        System.out.println();
        return res;
    }
    public List<String> generateAbbreviations3(String word){
        List<String> ret = new ArrayList<String>();
        backtrack(ret, word, 0, "", 0);

        return ret;
    }

    private void backtrack(List<String> ret, String word, int pos, String cur, int count){
        if(pos==word.length()){
            if(count > 0) cur += count;
            ret.add(cur);
        }
        else{
            backtrack(ret, word, pos + 1, cur, count + 1);
            backtrack(ret, word, pos+1, cur + (count>0 ? count : "") + word.charAt(pos), 0);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerizedAbbreviation ga = new GenerizedAbbreviation();
		List<String> list = ga.generateAbbreviations3("word");
		System.out.println(list.size());
		System.out.println(list);
	}

}
