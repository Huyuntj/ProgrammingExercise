package com.java.algorithm;

import java.util.Arrays;

import com.java.algorithm.utility.PrintHelper;

public class PrimeAlgorithm {

	public static boolean isPrime(int n){
		if(n == 1) return false;
		if(n == 2 ) return true;
		int m = (int)Math.sqrt(n);
		for(int i = 3; i <= m;i = i+2){//pay attention to the condition here
			if(n%i == 0) return false;
		}
		return true;
	}
	
	public static boolean[] seive(int n){
		boolean[] prime = new boolean[n+1];
//		Arrays.fill(prime, true);
		for(int i = 0; i<=n; i++){
			prime[i] = true;
		}
		prime[0] = false;
		prime[1] = false;
		for(int i = 2; i<= (int)Math.sqrt(n); i++){
			if(prime[i]){
				for(int j = i*i; j < n; j = j+i){
					prime[j] = false;
				}				
			}

		}
		return prime;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 100000000;
		long t1 = System.currentTimeMillis();
		for(int i = 1;i<=N;i++){
//			System.out.println(PrimeAlgorithm.isPrime(87));	
			PrimeAlgorithm.isPrime(87);
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		
		t1 = System.currentTimeMillis();
		boolean[] prime = PrimeAlgorithm.seive(N);
		t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
//		SortHelper.print(prime);
	}


}
