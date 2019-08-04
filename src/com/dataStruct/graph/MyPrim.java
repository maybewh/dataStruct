package com.dataStruct.graph;

public class MyPrim {
	
	int[] parent; //存储最后选择的与节点i，相关的节点，用于输出最后的结果
	boolean[] mstSet;//顶点是否已选取
	int key[]; //存储未选择的节点与已选择的节点之间边的最小值
	int V; //no. of vertex
	
	public MyPrim(int v) {
		V = v;
		mstSet = new boolean[V];
		key = new int[V];
	}
	
	
	void primMST(int graph[][]) {
		
		//初始化key[]和mstSet[]集合
		for(int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		
		//从第一个节点开始，所以将key[0]设为0，并将修改其是否选择的标识
		key[0] = 0;
		parent[0] = -1; //第一个节点，为生成树的根
		
		for(int i = 0 ; i < V - 1; i++) {
			
			//1. 先找到最小的权值，已选取的节点和未选取的节点之间最小的权值
			int min = minKey();
			
			mstSet[min] = true;
			
			for(int u = 0; u < V;u++) {
				
				if(mstSet[u] == false && graph[min][u] != 0 && graph[min][u] < key[u]){
					key[u] = graph[min][u];
					parent[u] = min;
				}
			}
		}
		printMST(graph);
	}


	private void printMST(int[][] graph) {
		
	}


	private int minKey() {
		
		//1.先初始化最小值
		int min = Integer.MAX_VALUE, min_index = -1;
		
		for(int i = 0; i < V; i++) {
			if(mstSet[i] == false && key[i] < min) {
				min = key[i];
				min_index = i;
			}
		}
		return min_index;
	}
	
}
