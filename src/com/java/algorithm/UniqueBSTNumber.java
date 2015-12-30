package com.java.algorithm;

public class UniqueBSTNumber {
    public static int numTrees(int n) {
        if(n == 0 || n == 1) return 1;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += numTrees(i) * numTrees(n-1-i);
        }
        return sum;
    }
    public static int numTreesInterative(int n){
    	int[] dp = new int[n+1];
    	dp[0] = 1;
    	dp[1] = 1;
    	for(int i = 1; i <= n; i++){
    		int sum = 0;
    		for(int j = 1; j<=i; j++){
    			sum += dp[j-1]*dp[i-j];
    		}
    		dp[i] = sum;
    	}
    	return dp[n];
    }
    public static boolean isStrobogrammatic(String num) {
        //0, 8, 1, 6-9
        for(int i = 0 ; i<num.length(); i++){
            if(num.charAt(i) == '0' || num.charAt(i) == '8' 
                ||num.charAt(i) == '1'){
                    if(num.charAt(i) == num.charAt(num.length()-1-i))
                    continue;
            }else if(num.charAt(i) == '6' && num.charAt(num.length()-1-i) == '9'
                || num.charAt(i) == '9' && num.charAt(num.length()-1-i) == '6'){
                    continue;                    
            }
                return false;

        }
        return true;
    }    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(UniqueBSTNumber.numTrees(19));
//		System.out.println(UniqueBSTNumber.numTreesInterative(19));
//		String tmp = "abaaa";
//		int cur = 0;
//		int next = 1;
//		tmp = tmp.substring(0,next) + tmp.substring(next).replaceAll(tmp.charAt(cur)+"", "");
//		System.out.println(tmp);
		System.out.println(UniqueBSTNumber.isStrobogrammatic("828"));
	}

}
