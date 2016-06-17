package com.java.algorithm.string;

public class ValidPalindrome {
	   public boolean isPalindrome(String s) {
	        if(s.length() == 0) return true;
	        int start = 0;
	        int end = s.length() - 1;
	        while(start < end){
	            if(!isValidCharacter(s.charAt(start))){
	                start++;
	            }else if(!isValidCharacter(s.charAt(end))){
	                end--;
	            }else{
	                char sc = Character.toLowerCase(s.charAt(start));
	                char ec = Character.toLowerCase(s.charAt(end));
	                if(sc != ec){
	                    return false;
	                }else{
	                    start++;
	                    end--;
	                }
	            }
	        }
	        return true;
	    }
		 private boolean isValidCharacter(char c){
		        return (c >= 'a' && c<='z') || (c >='A' && c<='Z') || (c>='0' && c<='9');
		 }
	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		
//		System.out.println('A' > 65);
		System.out.println(vp.isPalindrome("1b1"));
	}

}
