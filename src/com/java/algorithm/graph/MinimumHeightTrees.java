package com.java.algorithm.graph;

import java.util.ArrayList;
import java.util.List;
//310. Minimum Height Trees
//For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
//
//Format
//The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
//
//You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
//Example 1:
//
//Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
//
//        0
//        |
//        1
//       / \
//      2   3
//return [1]
//
//Example 2:
//
//Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
//
//     0  1  2
//      \ | /
//        3
//        |
//        4
//        |
//        5
//return [3, 4]
public class MinimumHeightTrees {
	  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int[][] a = new int[n][n];
        int[]   d = new int[n];
        //initiate edge array and degree array
        for(int i = 0; i< edges.length; i++){
            int[] edge = edges[i];
            a[edge[0]][edge[1]] = 1;
            a[edge[1]][edge[0]] = 1;
            d[edge[0]]++;
            d[edge[1]]++;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        //put all nodes with in degree equals 1 to list, larger than 1 to res list
        for(int i = 0; i< d.length; i++){
            if(d[i] == 1){
                list.add(i);
            }else{
                res.add(i);
            }
        }
        int degree1Num = n - list.size();
        while(degree1Num > 2){
        	int sz = list.size();
            for(int i = 0; i< sz;i++){
                for(int j = 0; j < a[0].length;j++)
                    if(a[list.get(i)][j] == 1){
                        d[j]--;
                        if(d[j] == 1){
                            list.add(j);
                            res.remove(res.indexOf(j));
                            degree1Num--;
                        }
                    }
            }
        }
        return res;
    }

	    @SuppressWarnings({ "unchecked", "rawtypes" })
		public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
	        
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        List[] e = new List[n];
	        int[]  d = new int[n];
	        //initiate edge array and degree array
	        for(int i = 0; i<n; i++){
	            e[i] = new ArrayList<Integer>();
	        }
	        for(int i = 0; i< edges.length; i++){
	            int[] pair = edges[i];
	            e[pair[0]].add(pair[1]);
	            e[pair[1]].add(pair[0]);
	        }
	        for(int i = 0; i<n; i++){
	            d[i] =  e[i].size();
	        }
	        int remain = n;
	        
	        while(remain > 2){
	        	List<Integer> del = new ArrayList<Integer>();
	            for(int i = 0; i<n;i++){
	                if(d[i] == 1){
	                    del.add(i);
	                    d[i] = -1;
	                    remain--;
	                }
	            }
	            for(int i = 0; i<del.size();i++){
	                int leaf = del.get(i);
	                for(int j = 0; j< e[leaf].size();j++){
	                    d[(Integer) e[leaf].get(j)]--;
	                }
	            }
	        }
	        for(int i = 0; i<n; i++){
	            if(d[i] >= 0) res.add(i);
	        }
	        return res;
	    
	    }
	  public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumHeightTrees mht = new MinimumHeightTrees();
		int n = 8;
		int[][] edges = {{0,3},{1,3},{2,3},{4,3},{5,4},{4,6},{6,7}};
		int[][] edges2 = {{0,1},{0,2},{2,3},{2,4},{2,5},{4,6},{0,7},{4,8},{5,9},{7,10},{6,11},{0,12},{0,13},{3,14}};
		long t1 = System.currentTimeMillis();
		System.out.println(mht.findMinHeightTrees2(15, edges2));
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
	}

}
