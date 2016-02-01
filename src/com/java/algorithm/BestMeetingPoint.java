package com.java.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BestMeetingPoint {
	//brilliant 2ms solutions
	public int minTotalDistance2(int[][] grid) {
	    int m = grid.length, n = grid[0].length;
	    int[] I = new int[m], J = new int[n];
	    for (int i=0; i<m; ++i)
	        for (int j=0; j<n; ++j)
	            if (grid[i][j] == 1) {
	                ++I[i];
	                ++J[j];
	            }
	    int total = 0;
	    for (int[] K : new int[][]{ I, J }) {
	        int i = 0, j = K.length - 1;
	        while (i < j) {
	            int k = Math.min(K[i], K[j]);
	            total += k * (j - i);
	            if ((K[i] -= k) == 0) ++i;
	            if ((K[j] -= k) == 0) --j;
	        }
	    }
	    return total;
	}
    public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        
        List<Integer[]> points = new ArrayList();
        List<Integer> xOnes = new ArrayList();
        for(int j = 0; j < grid[0].length;j++){
            for(int i = 0; i< grid.length; i++){
                if(grid[i][j] == 1){
                    points.add(new Integer[]{i,j});
                    xOnes.add(j);
                }
            }
        }
        
        List<Integer>  yOnes = new ArrayList();
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == 1){
                    yOnes.add(i);
                }
            }
        }  
        
        int[] mediumPoint = {xOnes.get(xOnes.size()/2), yOnes.get(yOnes.size()/2)};
        int distance = 0;
        for(Integer[] point : points){
            distance += Math.abs(mediumPoint[0] - point[0]) + Math.abs(mediumPoint[1] - point[1]);
        }
        return distance;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
