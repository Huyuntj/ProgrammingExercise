package com.java.algorithm.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*133. Clone Graph Medium
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/
public class CloneGraph {
	class UndirectedGraphNode {
		 int label;
		 List<UndirectedGraphNode> neighbors;
		 UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
    public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<Integer, UndirectedGraphNode> visited = new HashMap();
        return clone(node, visited);
    }
    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        if(node == null) return null;
        
        HashMap<Integer, UndirectedGraphNode> map = new HashMap();
        ArrayDeque<UndirectedGraphNode> queue = new ArrayDeque();
        UndirectedGraphNode startNode = new UndirectedGraphNode(node.label);
        map.put(startNode.label, startNode);
        queue.offer(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode n = queue.poll();
            UndirectedGraphNode newNode = map.get(n.label);//this node must exist in the map
            for(UndirectedGraphNode neighbor : n.neighbors){
                if(map.containsKey(neighbor.label)){
                    newNode.neighbors.add(map.get(neighbor.label));
                }else{
                    UndirectedGraphNode tmp = new UndirectedGraphNode(neighbor.label);
                    newNode.neighbors.add(tmp);
                    map.put(neighbor.label, tmp);
                    queue.offer(neighbor);                    
                }
            }
        }
        return startNode;
    }
    private UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<Integer,UndirectedGraphNode> visited){
        if(visited.containsKey(node.label)) return visited.get(node.label);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        visited.put(newNode.label, newNode);
        for(UndirectedGraphNode n : node.neighbors){
            newNode.neighbors.add(clone(n, visited));
        }
        return newNode;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
