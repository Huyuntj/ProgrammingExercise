package com.java.algorithm.dp;

public class MinimumPathSum {
//	64. Medium
//	Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
//	Note: You can only move either down or right at any point in time.	
	//solution with only 1 dimension array as additional space
    public int minPathSumOptimized(int[][] grid) {
        //solution with one array as additional space
        if(grid == null || grid.length == 0) return 0;
        int r = grid.length; int c = grid[0].length;
        int[] res = new int[c];
        res[0] = grid[0][0];
        for(int i = 1; i < c; i++){
            res[i] = res[i-1] + grid[0][i];
        }
        for(int i = 1; i< r; i++){
            for(int j = 0; j < c; j++){
                if(j == 0){
                    res[j] += grid[i][j];
                }else{
                    res[j] = grid[i][j] + Math.min(res[j-1],res[j]);
                }
            }
        }
        return res[c-1];
    }
    
    // solution with 2 dimension array
    public int minPathSum(int[][] grid) {
        //solution with 2D array as additional space
        if(grid == null || grid.length == 0) return 0;
        int r = grid.length; int c = grid[0].length;
        int[][] pathSum = new int[r][c];
        pathSum[0][0] = grid[0][0];
        for(int i = 1; i<c; i++){
            pathSum[0][i] = pathSum[0][i-1] + grid[0][i];
        }
        for(int i = 1; i<r; i++){
            pathSum[i][0] = pathSum[i-1][0] + grid[i][0];
        }
        
        for(int i = 1; i<r; i++){
            for(int j = 1; j<c; j++){
                
                pathSum[i][j] = grid[i][j]  + Math.min(pathSum[i-1][j], pathSum[i][j-1]);
            }
        }
        
        return pathSum[r-1][c-1];
    }
	//resusive solution ETL
    public int minPathSumRecusive(int[][] grid) {
        return minSum(grid, grid.length-1, grid[0].length-1);
    }
    
    private int minSum(int[][] grid, int r, int c){
        if(r == 0 && c == 0) return grid[r][c];
        else if(r == 0) return grid[r][c] + minSum(grid, r, c-1);
        else if(c == 0) return grid[r][c] + minSum(grid, r-1, c);
        else return grid[r][c] + Math.min(minSum(grid, r-1, c), minSum(grid, r, c-1));
    }
	public static void main(String[] args) {
		int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}, {5, 3, 2}};
		System.out.println((new MinimumPathSum()).minPathSum(grid));

	}

}
