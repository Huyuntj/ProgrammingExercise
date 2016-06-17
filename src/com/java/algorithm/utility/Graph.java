package com.java.algorithm.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.algorithm.utility.Graph.Vertex;

public class Graph<T> {

//	private List<Vertex> vertexes = new ArrayList<Vertex>();
    private List<Edge<T>> allEdges;
    private Map<Long,Vertex<T>> allVertex;
    boolean isDirected = false;
    
	public Graph(Integer n){
		allEdges = new ArrayList();
        allVertex = new HashMap<Long,Vertex<T>>();
        this.isDirected = isDirected;
	}
	public void addEdge(long id1,long id2){
	     Vertex<T> vertex1 = null;
	        if(allVertex.containsKey(id1)){
	            vertex1 = allVertex.get(id1);
	        }else{
	            vertex1 = new Vertex<T>(id1);
	            allVertex.put(id1, vertex1);
	        }
	        Vertex<T> vertex2 = null;
	        if(allVertex.containsKey(id2)){
	            vertex2 = allVertex.get(id2);
	        }else{
	            vertex2 = new Vertex<T>(id2);
	            allVertex.put(id2, vertex2);
	        }

	        Edge<T> edge = new Edge<T>(vertex1,vertex2,isDirected);
	        allEdges.add(edge);
	        vertex1.addAdjacentVertex(edge, vertex2);
	        if(!isDirected){
	            vertex2.addAdjacentVertex(edge, vertex1);
	        }
	}
    public Vertex<T> addSingleVertex(long id){
        if(allVertex.containsKey(id)){
            return allVertex.get(id);
        }
        Vertex<T> v = new Vertex<T>(id);
        allVertex.put(id, v);
        return v;
    }
    //This works only for directed graph because for undirected graph we can end up
    //adding edges two times to allEdges
    public void addVertex(Vertex<T> vertex){
        if(allVertex.containsKey(vertex.getId())){
            return;
        }
        allVertex.put(vertex.getId(), vertex);
        for(Edge<T> edge : vertex.getEdges()){
            allEdges.add(edge);
        }
    }    
	public List<Edge<T>> getAllEdges(){
        return allEdges;
    }
	public Collection<Vertex<T>> getAllVertex(){
	    return allVertex.values();
	
	}
	public Vertex<T> getVertex(long id){
	    return allVertex.get(id);
	}	
	
	public class Vertex<T>{
		long id;
		T data;
		private List<Edge<T>> edges = new ArrayList<Edge<T>>();
	    private List<Vertex<T>> adjacentVertex = new ArrayList<Vertex<T>>();
		public Vertex(long id){
			this.id = id;
		}
		public long getId(){
			return id;
		}
		public T getData(){
			return data;
		}
		public void setData(T d){
			data = d;
		}

	    public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
	        edges.add(e);
	        adjacentVertex.add(v);
	    }
	    
	    public String toString(){
	        return String.valueOf(id);
	    }
	    
	    public  List<Vertex<T>> getAdjacentVertexes(){
	        return adjacentVertex;
	    }
	    
	    public List<Edge<T>> getEdges(){
	        return edges;
	    }
	    public int hashCode(){
	    	final int prime = 31;
	    	int result = 1;
	    	result = result*prime + (int) (id^(id >>>32));
	    	return result;
	    }
	    public boolean equals(Object obj){
	    	if(this == null || obj == null) return false;
	    	if(this.getClass() != obj.getClass()) return false;
	    	Vertex other = (Vertex)obj;
	    	if(other.getId() != id) return false;
	    	return true;
	    }
	}
	
	class Edge<T>{
		private  boolean isDirected = false;
		private Vertex<T> v1;
		private Vertex<T> v2;
		Edge(Vertex<T> v1, Vertex<T> v2){
			this.v1 = v1;
			this.v2 = v2;
		}
		Edge(Vertex<T> v1, Vertex<T> v2, boolean isDirected){
			this.v1 = v1;
			this.v2 = v2;
			this.isDirected = isDirected;
		}		
		public Vertex<T> getVertex1(){
			return v1;
		}
		public Vertex<T> getVertex2(){
			return v2;
		}
		public boolean isDirected(){
			return isDirected;
		}
		public int hashCode(){
			final int prime = 31;
	        int result = 1;
	        result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
	        result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
	        return result;
		}
		public boolean equals(Object obj){
			if(this == obj) return true;
			if(obj == null) return false;
			if(getClass() != obj.getClass()) return false;
			Edge edge = (Edge)obj;
			if(v1==null){
				if(edge.getVertex1() != null){
					return false;
				}
			}else if(!v1.equals(edge.getVertex1())){
				return false;
			}
			if(v2==null){
				if(edge.getVertex2() != null)
					return false;
			}else if(!v2.equals(edge.getVertex2()))
				return false;
			return true;
		}
		
		public String toString(){
			return "Edge [isDirected=" + isDirected + ", vertex1=" + v1
	                + ", vertex2=" + v2 + "]";
		}
	}
}
