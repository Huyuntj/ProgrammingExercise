package com.javarevisited;

public class StringReverse {
	public  static void main(String[] args){
		  //original string
	    String str = "Sony is going to introduce Internet TV soon";
	    System.out.println("Original String: " + str);
	    
	    String reverseStr = new StringBuffer(str).reverse().toString();
	    System.out.println(reverseStr);
	    
	    System.out.println(StringReverse.reverseRecursively(str));
	    
	}

    public static String reverse(String str) {
        StringBuilder strBuilder = new StringBuilder();
        char[] strChars = str.toCharArray();

        for (int i = strChars.length - 1; i >= 0; i--) {
            strBuilder.append(strChars[i]);
        }

        return strBuilder.toString();
    }

    public static String reverseRecursively(String str) {

        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);

    }

}
