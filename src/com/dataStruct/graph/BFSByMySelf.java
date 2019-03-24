package com.dataStruct.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSByMySelf {
	
	private int v; //No. of vertices
	
	private LinkedList<Integer> adj[];
	
	public BFSByMySelf(int v) {
		this.v = v;
		
		adj = new LinkedList[v]; //adj 
		
		for(int i = 0; i < v;i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int s, int w) {
		adj[s].add(w);
	}
	
	void bfs(int beginVetex) {
		
		boolean[] visited = new boolean[v];
		
		visited[beginVetex] = true;
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(beginVetex);
		
		while(queue.size() != 0) {
			int s = queue.poll();
			System.out.println(s + " ");
			Iterator<Integer> iterator = adj[s].iterator();
			while(iterator.hasNext()) {
				int n = iterator.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		BFSByMySelf g = new BFSByMySelf(4);
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
