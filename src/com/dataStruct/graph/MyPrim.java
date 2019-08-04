package com.dataStruct.graph;

public class MyPrim {
	
	int[] parent; //�洢���ѡ�����ڵ�i����صĽڵ㣬����������Ľ��
	boolean[] mstSet;//�����Ƿ���ѡȡ
	int key[]; //�洢δѡ��Ľڵ�����ѡ��Ľڵ�֮��ߵ���Сֵ
	int V; //no. of vertex
	
	public MyPrim(int v) {
		V = v;
		mstSet = new boolean[V];
		key = new int[V];
	}
	
	
	void primMST(int graph[][]) {
		
		//��ʼ��key[]��mstSet[]����
		for(int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		
		//�ӵ�һ���ڵ㿪ʼ�����Խ�key[0]��Ϊ0�������޸����Ƿ�ѡ��ı�ʶ
		key[0] = 0;
		parent[0] = -1; //��һ���ڵ㣬Ϊ�������ĸ�
		
		for(int i = 0 ; i < V - 1; i++) {
			
			//1. ���ҵ���С��Ȩֵ����ѡȡ�Ľڵ��δѡȡ�Ľڵ�֮����С��Ȩֵ
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
		
		//1.�ȳ�ʼ����Сֵ
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
