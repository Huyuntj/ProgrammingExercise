package com.java.algorithm.dp;

public class UniquePathII {
//	63. Medium
//	Follow up for "Unique Paths":
//
//		Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//		An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
//		For example,
//		There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
//		[
//		  [0,0,0],
//		  [0,1,0],
//		  [0,0,0]
//		]
//		The total number of unique paths is 2.
//
//		Note: m and n will be at most 100.
	   public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
	        int[] res = new int[obstacleGrid[0].length];
	        //here, please note that if there is obstacle in the first row
	        //then follwoing res all should be 0
			for(int i = 0; i<obstacleGrid[0].length; i++){
			    if(obstacleGrid[0][i] == 1){
				    break;
			    }
			    else {
			        res[i] = 1;
			    }
			}
			for(int i = 1; i < obstacleGrid.length; i++){
				for(int j = 0; j<obstacleGrid[0].length; j++){
				    if(obstacleGrid[i][j] != 0){
				        res[j] = 0;
				    }else{
				        if(j > 0){
				            res[j] = res[j-1] + res[j];
				        }
				    }
	            }
			}
			return res[obstacleGrid[0].length-1];       
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
