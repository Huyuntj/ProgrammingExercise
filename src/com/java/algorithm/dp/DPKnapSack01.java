package com.java.algorithm.dp;

import com.java.algorithm.utility.PrintHelper;

public class DPKnapSack01 {

	int[] wt;
	int[] v;
	int n;
	int w;
	public DPKnapSack01(){
		
	}
	public DPKnapSack01( int[] wt, int[] v){
		this.wt = wt;
		this.v = v;
	}
	
	public int max(int a, int b){
		return a>b ? a:b;
	}
	public int knapSackRecusive(int n, int w){
		if(n == 0 || w == 0) return 0;
		if(wt[n-1] > w){
			return knapSackRecusive(n-1, w);
		}else{
			return max(knapSackRecusive(n-1,w), v[n-1] + knapSackRecusive(n-1, w-wt[n-1]));
		}
	}
	
	public int knapSack(int n, int W, int[] wt, int[] v){
		int[][] dp = new int[n+1][W+1];
		for(int i = 0 ; i<= n; i++){//i is the product index
			for(int w = 0; w<= W; w++){//j is any weight between 0 to w
				if(i == 0 || w == 0) dp[i][w] = 0;
				else if(wt[i-1] > w){
					dp[i][w] = dp[i-1][w];
				}else{
					dp[i][w] = max(dp[i-1][w], v[i-1] + dp[i-1][w-wt[i-1]]);
				}
			}
		}
//		SortHelper.print(dp);
		return dp[n][W];
	}
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return -1;
        int maxProfit = 0;
        int minBuyPrice = prices[0];
        int potentialMinBuyPrice = prices[0];
        for(int i = 1 ; i < prices.length; i++){
            if(prices[i] < potentialMinBuyPrice ){
                potentialMinBuyPrice = prices[i];
                if(maxProfit == 0){
                	minBuyPrice = potentialMinBuyPrice;
                	continue;
                }
            }
            if(potentialMinBuyPrice == minBuyPrice && prices[i] - minBuyPrice > maxProfit){
                maxProfit = prices[i] - minBuyPrice;
            }else if(potentialMinBuyPrice < minBuyPrice  && prices[i]-potentialMinBuyPrice > maxProfit){
                maxProfit = prices[i]-potentialMinBuyPrice;
                minBuyPrice = potentialMinBuyPrice;
            }
        }
        return maxProfit;
    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wt = {1,1,1};
		int[] v = {10,20,30};
		DPKnapSack01 dp = new DPKnapSack01(wt,v);
//		System.out.println(dp.knapSackRecusive(3, 2));
//		System.out.println(dp.knapSack(3,2,wt,v));
		int[] prices = {2,0,3,1,4,7,8,0,11,12};
		int[] prices2 = {4, 1,2};
		int[] prices3 = {4,7,1,2,11};
		System.out.println(dp.maxProfit(prices));
		System.out.println(dp.maxProfit(prices2));
		System.out.println(dp.maxProfit(prices3));
	}

}
