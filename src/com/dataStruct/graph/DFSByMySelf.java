package com.dataStruct.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSByMySelf {
	
	private int v;//No. of 
	
	private LinkedList<Integer> adj[];
	
	public DFSByMySelf(int v) {
		this.v = v;
		
		adj = new LinkedList[v];
		
		for(int i = 0 ; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int s, int w) {
		adj[s].add(w);
	}
	
	void DFSUtil(int s,boolean[] visited) {
		
		visited[s] = true;
		System.out.println(s + " ");
		Iterator<Integer> iterator = adj[s].iterator();
		while(iterator.hasNext()) {
			int n = iterator.next();
			if(!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}
	
	void DFS(int beginVertex) {
		boolean[] visited = new boolean[v];
		DFSUtil(beginVertex, visited);
	}
	
	public static void main(String[] args) {
		DFSByMySelf g = new DFSByMySelf(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		System.out.println("Following is Breadth First Traversal "+ 
                "(starting from vertex 2)"); 

		g.DFS(2);
	}
}
