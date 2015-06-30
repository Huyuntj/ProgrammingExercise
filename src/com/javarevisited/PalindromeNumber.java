package com.javarevisited;

public class PalindromeNumber {
	
	public static boolean isPalindrome(int num){
		String s = String.valueOf(num);
		StringBuffer buf = new StringBuffer(s).reverse();
		return num == Integer.parseInt(buf.toString())? true: false;
	};

	public static void main(String[] args) {
		System.out.println(PalindromeNumber.isPalindrome(123453321));
	}

}
