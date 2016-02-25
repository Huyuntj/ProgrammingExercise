package com.java.algorithm.string;

public class AddBinary {
//	Given two binary strings, return their sum (also a binary string).
//
//			For example,
//			a = "11"

//			Return "100".	
	//better solution without too many condition branch
	//really smart one!!
    public String addBinaryOptimal(String a, String b) {
        if(a == null || b == null) return a==null?b:a;
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = a.length()-1, j = b.length() -1; i>= 0|| j>=0 || carry >0; i--, j--){
            int sum = 0;
            sum += (i>=0) ? (a.charAt(i) - 48) : 0;
            sum += (j>=0) ? (b.charAt(j) - 48) : 0;
            sum += carry;
            carry = sum / 2;
            sum %= 2;
            sb.insert(0,sum);
        }

        return sb.toString();
    }
	public String addBinary(String a, String b) {
        if((a == null||a.length() == 0) && (b == null || b.length() == 0)) return "";
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        int l1 = a.length() - 1;
        int l2 = b.length() - 1;
        int inc = 0;
        StringBuilder sb = new StringBuilder();
        while(l1 >= 0 && l2>= 0){
            int sum = (a.charAt(l1--) - 48) + (b.charAt(l2--) - 48) + inc;
            inc = sum / 2 ; 
            sum = sum % 2;
            sb.insert(0,sum);
        }

        while(l1 >=0){
            sb.insert(0, (a.charAt(l1) - 48 + inc)%2);
            inc = (inc + a.charAt(l1) - 48)/2;
            l1--;
        }

        while(l2 >=0){
            sb.insert(0, (b.charAt(l2) - 48 + inc)%2);
            inc = (inc + b.charAt(l2) - 48)/2;
            l2--;
        }            
        if(inc == 1)
            sb.insert(0,'1');

        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
