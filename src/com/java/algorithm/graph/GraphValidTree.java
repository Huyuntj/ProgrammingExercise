package com.java.algorithm.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphValidTree {
//261. Graph Valid Tree
//Difficulty: Medium
//	Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
//
//	For example:
//
//	Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
//
//	Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
//
//	
	  public boolean validTreeDFS(int n, int[][] edges) {
	      List[] e = new List[n];
	      int[] visited = new int[n];
	      for(int i = 0; i<n;i++){
	          e[i] = new ArrayList<Integer>();
	      }
	      for(int[] edge : edges){
	          e[edge[0]].add(edge[1]);
	          e[edge[1]].add(edge[0]);
	      }
	      if(!dfs(0, -1, visited, e)) return false;
	      for(int i = 0; i<n ;i++){
	         if(visited[i] == 0) return false;
	      }
	      return true;
	  }
	  private boolean dfs(int cur, int parent, int[] visited, List[] e){
	      visited[cur] = 1;
	      for(Integer neighbour : (List<Integer>)e[cur]){
	          if(neighbour == parent) continue;
	          
	          if(visited[neighbour] == 1) return false;
	          
	          if(!dfs(neighbour,cur, visited, e)) return false;
	      }
	      return true;
	  }   	
  //keep track the parent node to determine if there is cycle in the graph
  //runtime: 1ms
  public boolean validTreeFasterSolution(int n, int[][] edges) {
        if (n <= 1) return true;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);
            if (x == y) return false;
            parent[y] = x;
        }

        return edges.length == n - 1;
    }

    public int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
	//union find solution
	//first make all sets and then check if two vertexes are in the same set
	//if yes, then cycle is found; else merge two sets and continue
	//at the end, if the graph is connected then only one set was left.
	//run time is more than 100ms
	//Time Complexity is O(VE)
    public boolean validTree(int n, int[][] edges) {
        //need to check if there is a loop in the tree
        //another case is to check if there is a seperate branch
        // Check 2 things: 1. whether there is loop 
        // 2. whether the number of connected components is 1
        List<Set<Integer>> sets  = makeAllSets(n);
        int setNum = n;
        for(int[] edge : edges){
            Set<Integer> set1 = findSet(sets,edge[0]);
            Set<Integer> set2 = findSet(sets,edge[1]);
            if(set1 == set2){//if two vertexes of an edge are in the same set, then cycle find
                return false;
            }
            mergeSets(set1, set2);
            n--;
        }
        //if the graph is not connected, there must be more than 1 set in the end;
        return (n == 1) ? true : false;
    }
    private List<Set<Integer>> makeAllSets(int n){
        List<Set<Integer>> sets = new ArrayList();
        for(int i = 0; i<n;i++){
            Set<Integer> set = new HashSet();
            set.add(i);
            sets.add(set);
        }
        return sets;
    }
    private Set<Integer> findSet(List<Set<Integer>> sets, int v){
        for(Set<Integer> set : sets){
            if(set.contains(v)) return set;
        }
        return null;
    }
    //merge set2 and set1 to set1
    //clear set2 and set to null;
    private void mergeSets(Set<Integer> set1, Set<Integer> set2){
        for(int i : set2){
            set1.add(i);
        }
        set2.clear();
        set2 = null;
        // return set1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphValidTree gvt = new GraphValidTree();
		int n = 6;
		int[][] edges = {{0,1},{0,2},{2,5},{3,4},{3,5}};
		System.out.println(gvt.validTree(n, edges));
	}

}
