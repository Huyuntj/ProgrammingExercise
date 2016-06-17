package com.java.algorithm.dp;

public class UniquePaths {
//	62. Medium
//	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//	How many possible unique paths are there?
//
//
//	Above is a 3 x 7 grid. How many possible unique paths are there?
//
//	Note: m and n will be at most 100.	
	public int uniquePaths(int m, int n) {
		int[] res = new int[n];
		for(int i = 0; i<n; i++){
			res[i] = 1;
		}
		for(int i = 1; i < m; i++){
			for(int j = 1; j<n; j++){
				res[j] = res[j-1] + res[j];
			}
		}
		return res[n-1];
	}
    public int uniquePathsRecusive(int m, int n) {
        if(m == 0 && n == 0) return 1;
        int[] sum = new int[1];
        uniquePaths(m, n, 0, 0, sum);
        return sum[0];
    }
    private void uniquePaths(int m, int n, int i, int j, int[] sum){
        if(i == m-1 && j == n-1) {
             sum[0]++;
             return;
        }
        if(i == m-1)  {
            uniquePaths(m,n, i, j+1, sum);
        }else if(j == n-1){
            uniquePaths(m,n, i+1, j, sum);
        }else{
            uniquePaths(m,n, i+1, j, sum);
            uniquePaths(m, n, i, j+1, sum);
        }
        
    }
	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		System.out.println(up.uniquePaths(23, 12));
		long t1 = System.currentTimeMillis();
		System.out.println(up.uniquePathsRecusive(23, 12));
		System.out.println(System.currentTimeMillis() - t1);
	}

}
