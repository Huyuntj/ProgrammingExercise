package com.java.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponentsNumberInUndirectedGrap {
	/*
	 * union method, merge two vertex in one edge to a group with root id
	 * with path compression
	 */
	   public int countComponents(int n, int[][] edges) {
	        int count = n;
	        int[] root = new int[n];
	        for(int i = 0; i<n; i++){
	            root[i] = i;
	        }
	        for(int[] e : edges){
	            int r1 = findRoot(e[0], root);
	            int r2 = findRoot(e[1], root);
	            if(r1 != r2){
	                root[r1] = r2;
	                count --;
	            }
	        }
	        return count;
	    }
	    private int findRoot(int v, int[] root){
	        while(root[v] != v){
	            v = root[root[v]];
	        }
	        return root[v];
	    }
	    /*
	     * DSF to solve this problem
	     */
	    public int countComponentsDFS(int n, int[][] edges) {
	        List[] list = new List[n];
	        int[] visited = new int[n];
	        
	        for(int i = 0; i< n; i++){
	            list[i] = new ArrayList<Integer>();
	        }
	        //initial edges for each vertex, for example edges[0] ={1,2}
	        //means vertex 1 and vertex 2 are connected;
	        for(int i = 0; i<edges.length; i++){
	            int v1 = edges[i][0];
	            int v2 = edges[i][1];
	            list[v1].add(v2);
	            list[v2].add(v1);
	        }
	        int connectedNum = 0;
	        for(int i = 0;i<n; i++){
	            if(visited[i] == 0){
	                dfs(i,-1, visited, list);
	                connectedNum++;
	            }
	        }
	        return connectedNum;
	    }
	    private void dfs(int current, int parent, int[] visited, List[] edges){
	        visited[current] = 1;
	        for(Integer neighbour : (List<Integer>)edges[current]){
	            if(neighbour == parent) continue;
	            if(visited[neighbour] == 1) continue;
	            dfs(neighbour, current, visited, edges);
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
