package com.java.algorithm;

import java.util.Arrays;

public class MathRelevant {
	//Greatest Common Divisor
	//assume that a and b cannot both be 0
	public static  int GCD(int a, int b){
		if(b == 0) return a;
		return GCD(b, a%b);
	}
	//Lowest Common Multiple
	public static int LCM(int a, int b){
		return (a * b) / GCD(a,b);
	}
	
	// 4325 stands for 5 + 2 x 10 + 3 x 10 x 10 + 4 x 10 x 10 x 10
	//1011 in binary stands for 1 + 1 x 2 + 0 x 2 x 2 + 1 x 2 x 2 x 2 = 1 + 2 + 8 = 11
	//assume base is from 0 to 10
	public static int toDecimal(int n, int b){
		int multiply = 1;
		int res = 0;
		while(n > 0){
			res += n%10 * multiply;
			n /= 10;
			multiply *= b;
		}
		return res;
	} 
	//if b is above 10,
	public static String toDecimal2(int n, int b){
		String chars = "0123456789ABCDEFGHIJ";
		String res = "";
		while(n >0){
			res = chars.charAt(n%b) + res;
			n /= b;
		}
		return res;
	}
	//4/9 - 1/6 = 4*2/9*2 - 1*3/6*3 = 5/18
	public static int[] addFractions(int[] a, int[] b){
		int lcm = LCM(a[1], b[1]);
		int[] c = {a[0]*lcm/a[1] - b[0]*lcm/b[1],lcm};
		return c;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(MathRelevant.GCD(4, 6));
//		System.out.println(MathRelevant.toDecimal2(35, 2));
		int[] c = MathRelevant.addFractions(new int[]{0,9},new int[]{1,6});
		System.out.print(c[0] + " " + c[1]);
	}

}
