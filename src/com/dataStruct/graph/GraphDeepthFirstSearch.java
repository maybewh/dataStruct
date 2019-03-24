package com.dataStruct.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphDeepthFirstSearch {
	
	private int v; //No. of vertices
	private LinkedList<Integer> adj[]; //Array of lists for Adjacency List Representation
	
	boolean visited[] = null;
	
	GraphDeepthFirstSearch(int initailCapacity){
		v = initailCapacity;
		adj = new LinkedList[v];
		for(int i = 0;i < v;i++) {
			adj[i] = new LinkedList<Integer>();
		}
		visited = new boolean[v];
	}
	
	//function add an edge to the graph
	void addEdge(int v,int w) {
		adj[v].add(w);
	}
	
	void dfs(int s) {
		visited[s] = true;
		System.out.println(s +" ");
		
		Iterator<Integer> iterator = adj[s].iterator();
		while(iterator.hasNext()) {
			
			int n = iterator.next();
			if(!visited[n]) {
				dfs(n);
			}
		}
		
	}
	
	public static void main(String[] args) {
		GraphDeepthFirstSearch g = new GraphDeepthFirstSearch(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.dfs(2); 
	}
	
}
