package com.java.algorithm;

import java.util.Arrays;

import com.java.algorithm.sort.SortHelper;

public class CoinChange {
    int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        minCoin(coins, amount, 0);
        return min;
    }
    public void minCoin(int[] coins, int amount, int number){
        if(amount == 0) {
            min = number < min ? number : min;
            return;
        }
        if(amount < coins[0]) { 
//        	min = -1;
        	return;
        
        }
        
        for(int i =0; i<coins.length;i++){
            minCoin(coins, amount - coins[i], number+1);   
        }        
    }
    
    
    public int coinChange2(int[] coins, int amount) {
        int[] store = new int[amount + 1];
        for(int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j<coins.length; j++){
                if(i == coins[j]){
                    min = min < 1 ? min : 1;
                   
                }else if(i > coins[j]){
                    if(store[i-coins[j]] != -1) {
                        min = min < (store[i-coins[j]] + 1) ? min : (store[i-coins[j]] + 1);
                    }
                }
            }
            store[i] = (min == Integer.MAX_VALUE ?  -1 : min);
        }
        SortHelper.print(store);
        return store[amount];
    }   
	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
//		System.out.println(cc.coinChange2(new int[]{1,2,5}, 20));
		System.out.println(cc.coinChange2(new int[]{ 3, 5}, 100));
//		System.out.println(cc.coinChange2(new int[]{3}, 2));
	}

}
