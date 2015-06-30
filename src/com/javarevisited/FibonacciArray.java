package com.javarevisited;

import java.util.Arrays;

public class FibonacciArray {

	public static int[] FibonacciArray(int len){
		int[] array = new int[len];
		array[0] = 1;
		array[1] = 1;
		for(int i = 2; i< len; i++){
			array[i] = array[i-1] + array[i-2];
		};
		return array;
	};
	public static int FibonacciRecusive(int i){
		if(i ==1 || i == 0){
			return 1;
		}else{
			return FibonacciRecusive(i-2) + FibonacciRecusive(i-1);
		}
	};
	public static int Fibonacci(int i){
		int f1, f2, f;
		if(i == 0 || i == 1){
			return 1;
		};
		f1=f2=f=1;
		for(int j=2; j<= i; j++){
			f = f1+f2;
			f1=f2;
			f2=f;
		};
		return f;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(FibonacciArray.FibonacciArray(10)));
		
		System.out.println(FibonacciArray.FibonacciRecusive(9));
		
		System.out.println(FibonacciArray.Fibonacci(9));
		
	}

}
