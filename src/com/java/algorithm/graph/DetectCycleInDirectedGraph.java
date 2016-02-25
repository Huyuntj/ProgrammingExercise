package com.java.algorithm.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.java.algorithm.graph.Graph.Vertex;

public class DetectCycleInDirectedGraph<T> {
	//using whiteset represents	unvisited vertex; greyset represents visiting; blackset represents visited
	
	public boolean hasCycle(Graph<Integer> graph){
		Set<Vertex> whiteSet = new HashSet<Vertex>();
		Set<Vertex> greySet  = new HashSet();
		Set<Vertex> blackSet = new HashSet();
		
		//add all vertexes to white set at the first beginning
		for(Vertex v : graph.getAllVertex()){
			whiteSet.add(v);
		}
		
		while(whiteSet.size() > 0){
			Vertex current = whiteSet.iterator().next();
			if(dfs(current, whiteSet, greySet, blackSet))
				return true;
		}
		return false;
	}
	
	private boolean dfs(Vertex cur, Set<Vertex> whiteSet, Set<Vertex> greySet, Set<Vertex> blackSet){
		//move current vertex from white set to grey set and then explore it;
		moveVertex(cur, whiteSet, greySet);
//		List<Graph<Integer>.Vertex<Integer>> vertexesList = ;
		for(Graph<Integer>.Vertex<Integer> neighbor : (List<Graph<Integer>.Vertex<Integer>>)cur.getAdjacentVertexes()){
			//if in the black set means already explored so continue
			if(blackSet.contains(neighbor)) continue;
			//if in grey set then cycle found
			if(greySet.contains(neighbor)) return true;
			if(dfs(neighbor, whiteSet, greySet, blackSet)){
				return true;
			}
		}
		//move current from grey set to black set when done exploring;
		moveVertex(cur, greySet, blackSet);
		return false;
	}
	
	private void moveVertex(Vertex v, Set<Vertex> org, Set<Vertex> des){
		org.remove(v);
		des.add(v);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
