package com.java.algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class IPRestore {
    public List<String> restoreIpAddresses2(String s) {
       List<String> res = new ArrayList<String>();
       restore(res, "", s, 0);
       return res;
   }
   
   private void restore(List<String> res, String tmp,  String s, int segNum){
       if(segNum > 4 || segNum == 4 && s.length() > 0) return;
       if(segNum == 4 && s.equals("")){
           res.add(tmp.substring(0,tmp.length() -1));
           return;
       } 
       
       for(int i = 1; i< 4; i++){
    	   if(i <= s.length()){
	           String str = s.substring(0, i);
	           if(str.startsWith("0") && str.length() > 1
	               || Integer.parseInt(str) > 255){
	                   continue;
	           }
	           tmp += str + "." ;
	           if(i <= s.length()) {
	        	   restore(res, tmp, s.substring(i), segNum+1);
	               tmp = tmp.substring(0, tmp.length() - i - 1);  
	           }
     
    	   }
       }
   }	
    public List<String> restoreIpAddresses(String s) {
    	List<List<Integer>> tmRes = new ArrayList<List<Integer>>();
    	List<String> res = new ArrayList<String>();
		List<Integer> tmp = new ArrayList<Integer>();
		restore(tmRes, tmp, s.length());
		for(List<Integer> list : tmRes){
			int start = 0;
			StringBuffer sb = new StringBuffer();
			for(Integer i : list){
				String str = s.substring(start, start+i);
				start += i;
				if(str.startsWith("0") && str.length() > 1
						|| Integer.parseInt(str) > 255){
					sb = null;
					break;
				}
				sb.append(str).append(".");				
			}
			if(sb != null){
				res.add(sb.substring(0, sb.length()-1));
			}
		}
		return res;
    }
    public void restore(List<List<Integer>> res, List<Integer> tmp, int num){
        if(tmp.size() > 4 || tmp.size() == 4 && num > 0) return;
        
        if(tmp.size() == 4 && num == 0){
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = 1; i < 4; i++){
            tmp.add(i);
            restore(res, tmp, num-i);
            tmp.remove(tmp.size() -1);         
        }
    }
    
    public void test(int n) {
		System.out.println("n = " + n);
	} 
    private boolean isValid(String s1){
        if((s1.startsWith("0") && s1.length() == 1) ||
            (!s1.startsWith("0") && s1.length() <= 3 && Integer.parseInt(s1) <=255)){
                return true;
            }
        return false;
    }   
    public List<String> restoreIpAddressesIterative(String s) {
        List<String> res = new ArrayList<String>();
      //   restore(res, "", s, 0);
      //   return res;
      
          for(int a = 1; a <=3; a++)
              for(int b = 1; b <=3; b++)
                  for(int c = 1; c<=3; c++){
                      // int d = s.length() - a - b -c;
                      if(a+b+c < s.length()){
                          String s1 = s.substring(0,a);
                          String s2 = s.substring(a,a+b);
                          String s3 = s.substring(a+b, a+b+c);
                          String s4 = s.substring(a+b+c);
                          if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                              res.add(s1 +"." + s2 + "." + s3 + "." + s4);
                          }
                      }
                  }
                  
          return res;
      }    
	public static void main(String[] args) {
		IPRestore ipRestore  = new IPRestore();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
//		ipRestore.restore(res, tmp, 11);
//		System.out.println(res);
		boolean[] c = new boolean[1] ;
		System.out.println(c[0]);
	}

}
