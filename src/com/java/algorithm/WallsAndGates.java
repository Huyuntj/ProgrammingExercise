package com.java.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates {
	private static final int WALL = -1;
	private static final int GATE = 0;
	private static final int EMPTY = Integer.MAX_VALUE;
	private static final List<int[]> DIRECTIONS = Arrays.asList(
			new int[]{1, 0},
			new int[]{-1,0},
			new int[]{0, 1},
			new int[]{0, -1}
			);
	//solution1 starts from each empty point, calculate the nearest distance to the Gate with 
	//Breadth-first-search with 0(mn) complexity
	//with m*n points ,the O(m*n*m*n);
	public void BFSSolution(int[][] rooms){
		for(int i = 0 ; i< rooms.length;i++){
			for(int j = 0 ; j<rooms[0].length;j++){
				if(rooms[i][j] == EMPTY){
					rooms[i][j] = distanceToNearestGate(rooms, i,j);
				}
			}
		}
		
	}
	public int distanceToNearestGate(int[][] rooms, int startRow, int startCol){
		int m = rooms.length ;
		int n = rooms[0].length ;
		int[][] distance = new int[m][n];		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[]{startRow, startCol});
		while(!queue.isEmpty()){
			int[] point = queue.poll();
			int row = point[0];
			int col = point[1];
			for(int[] direction : DIRECTIONS ){
				int r = row + direction[0];
				int c = col + direction[1];
				if(r >= m || r<0 || c >=n || c<0 || rooms[r][c] == WALL || distance[r][c] != 0){
					continue;
				}
				distance[r][c] = distance[row][col] + 1;
				if(rooms[r][c] == GATE){
					return distance[r][c];
				}
				queue.offer(new int[]{r,c});
			}			
		}
		return Integer.MAX_VALUE;
	}
	
	//starts from every gate
	//Since BFS guarantees that we search all rooms of distance d before searching rooms of distance d + 1,
	//the distance to an empty room must be the shortest.
	//time complexity is O(mn);
	//Once we set a room's distance, we are basically marking it as visited, which means each room is visited at most once. 
	//Therefore, the time complexity does not depend on the number of gates and is O(mn).
	public void BFSolution2(int[][] rooms){
		int m = rooms.length;
		int n = rooms[0].length;
		
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int i = 0 ; i< m; i++){
			for(int j = 0; j<n; j++){
				if(rooms[i][j] == GATE){
					queue.offer(new int[]{i,j});
				}
			}
		}
		while(!queue.isEmpty()){
			int[] point = queue.poll();
			int row = point[0];
			int col = point[1];
			for(int[] direction: DIRECTIONS){
				int r = row + direction[0];
				int c = col + direction[1];
				//here pay attention to condition rooms[r][c] != EMPTY
				if(r >= m || r<0 || c >=n || c<0 || rooms[r][c] == WALL || rooms[r][c] != EMPTY){
					continue;
				}	
				rooms[r][c] = rooms[row][col] + 1;
				queue.offer(new int[]{r,c});
			}
		}		
	}


	
	public void DFSolution(int[][] rooms) {
	    if(rooms == null || rooms.length == 0) return;
	    int m = rooms.length, n = rooms[0].length;

	    // start from gates
	    // use dfs to fill nearby rooms with distances
	    for(int i = 0; i < m; i++) {
	        for(int j = 0; j < n; j++) {
	            if(rooms[i][j] == 0) {
	                dfs(rooms, m, n, i, j);
	            }              
	        }
	    }
	}

	public void dfs(int[][] rooms, int m, int n, int i, int j) {
	    int distance = rooms[i][j];
	    for(int[] dir : DIRECTIONS) {
	        int x = i + dir[0];
	        int y = j + dir[1];
	        // skip when out of boundary or smaller distance exists
	        if(x < 0 || x >= m || y < 0 || y >= n || rooms[x][y] <= distance) continue;
	        rooms[x][y] = distance + 1;
	        dfs(rooms, m, n, x, y);
	    }
	}
	public static void main(String[] args) {
		WallsAndGates wg = new WallsAndGates();
		int[][] rooms = new int[][]{
			{EMPTY, WALL, GATE, EMPTY},
			{EMPTY, EMPTY, EMPTY, WALL},
			{EMPTY, WALL, EMPTY, WALL},
			{GATE, WALL, EMPTY,EMPTY}
			
		};		
		wg.BFSolution2(rooms);
		for(int i = 0; i< rooms.length; i++){
			for(int j =0; j< rooms.length; j++){
				System.out.print(rooms[i][j] + "	");
				
			}
				System.out.println();
		}
		
	}

}
