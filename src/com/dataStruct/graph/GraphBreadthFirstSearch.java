package com.dataStruct.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphBreadthFirstSearch {
	
	private int v; //No. of vertices
	private LinkedList<Integer> adj[]; //adjacency Lists
	
	//constructor
	GraphBreadthFirstSearch(int v){
		this.v = v;
		adj = new LinkedList[v];
		for(int i = 0; i < v;++i) {
			adj[i] = new LinkedList<>();
		}
	}
	
	//fuction to add an edge into graph
	void addEdge(int v,int w) {
		
		adj[v].add(w);
	}
	
	void bfs(int s) {
		//Mark all the vertices as not visited(By default)
		boolean visited[] = new boolean[v];
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		//Create a queue for BFS
		visited[s] = true;
		queue.add(s);
		while(queue.size() != 0) {
			s = queue.poll();
			System.out.println(s + " ");
			
			//get all adjacent vertices of the dequeued vertex s
			//If a adjacent has not been visited,then mark it 
			//visited and enqueue it
			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext()) {				
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		GraphBreadthFirstSearch g = new GraphBreadthFirstSearch(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		System.out.println("Following is Breadth First Traversal "+ 
                "(starting from vertex 2)"); 

		g.bfs(2);
	}
}
