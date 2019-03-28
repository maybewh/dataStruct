package com.dataStruct.graph;

import java.util.Arrays;

public class MyKruskals {
	
	class Edge implements Comparable<Edge>{
		int src,dest,weight;

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	//边和顶点
	int V; //vertex
	int E; //edge
	Edge edges[]; //边的数组
	
	//union、find操作构成的
	class Subset{
		int parent; //父节点
		int rank;  //当前子集的父节点等级
	}
	
	public MyKruskals(int v,int e) {
		V = v;
		E = e;
		edges = new Edge[E];
		for(int i = 0; i < E;i++) {
			edges[i] = new Edge();
		}
	}
	
	//path compression,
	int find(Subset subsets[], int i) {
		
		if(subsets[i].parent != i) {
			subsets[i].parent = find(subsets, subsets[i].parent);
		}
		return subsets[i].parent;//该子集所有节点的parent属性均指向上一个子集的root节点
	}
	
	//union
	void union(Subset subsets[],int x, int y) {
		
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);
		
		if(subsets[xroot].rank > subsets[yroot].rank) {
			subsets[yroot].parent = xroot;  
		}else if(subsets[xroot].rank < subsets[yroot].rank) {
			subsets[xroot].parent = yroot;
		}else {
			subsets[xroot].parent = yroot;
			subsets[xroot].rank++;
		}
	}
	
	void kruskalMST() {
		Edge[] result = new Edge[V];
		
		Arrays.sort(edges);
		
		int i = 0;
		int e = 0;
		for(i = 0;i < V; i++) {
			result[i] = new Edge();
		}
		
		//初始化Subsets，V个顶点，V个subset
		Subset[] subsets = new Subset[V];
		for(i = 0; i < V;i++) {
			subsets[i] = new Subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}
		
		i = 0;
		//寻找最小边,0开始，找到符合V-1条边即可
		while(e < V -1) {
			int x = find(subsets,edges[i].src);
			int y = find(subsets,edges[i].dest);
			
			
			if(x != y) {
				result[e++] = edges[i]; 
				union(subsets, x, y);
			}
			i++;
			//else discard the edge
		}
		
		// print the contents of result[] to display 
        // the built MST 
        System.out.println("Following are the edges in " +  
                                     "the constructed MST"); 
        for (i = 0; i < e; ++i) 
            System.out.println(result[i].src+" -- " +  
                   result[i].dest+" == " + result[i].weight); 
	}
	
	public static void main(String[] args) {
		   int V = 4;  // Number of vertices in graph 
	        int E = 5;  // Number of edges in graph 
	        MyKruskals graph = new MyKruskals(V, E); 
	  
	        // add edge 0-1 
	        graph.edges[0].src = 0; 
	        graph.edges[0].dest = 1; 
	        graph.edges[0].weight = 10; 
	  
	        // add edge 0-2 
	        graph.edges[1].src = 0; 
	        graph.edges[1].dest = 2; 
	        graph.edges[1].weight = 6; 
	  
	        // add edge 0-3 
	        graph.edges[2].src = 0; 
	        graph.edges[2].dest = 3; 
	        graph.edges[2].weight = 5; 
	  
	        // add edge 1-3 
	        graph.edges[3].src = 1; 
	        graph.edges[3].dest = 3; 
	        graph.edges[3].weight = 15; 
	  
	        // add edge 2-3 
	        graph.edges[4].src = 2; 
	        graph.edges[4].dest = 3; 
	        graph.edges[4].weight = 4; 
	  
	        graph.kruskalMST(); 
	}
}
