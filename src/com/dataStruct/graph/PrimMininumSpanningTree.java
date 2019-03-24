package com.dataStruct.graph;

/**
 * Prim算法--最小生成树
 * We use a boolean array mstSet[] to represent the set of vertices included in MST.
 * If a value mstSet[v] is true,then vertex v is included in MST,otherwise not.
 * Array key[] is used to store key values of all vertices.Another array parent[] to 
 * store indexes of parent nodes in MST.The parent array is the output array which is used
 * to show the constructed MST. 
 * @author 王晖
 *
 */
public class PrimMininumSpanningTree {
	
	//Number of vertices in the graph
	private static final int v = 5;
	
	//A utility function to find the vertex with mininum key
	//value,from the set of vertices not yet included in MST.
	int minKey(int key[],boolean[] mstSet) {
		
		//initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;
		
		for(int i = 0; i < v;i++) {
			if(mstSet[i] == false && key[i] < min) {
				min = key[i];
				min_index = i;
			}
		}
		return min_index;
	}
	
	//A utility function to print the constructed MST stored in parent[]
	void printMTS(int parent[], int n, int graph[][]) {
		System.out.println("Edge \tWeight");
		for(int i = 1; i < v; i++) {
			System.out.println(parent[i] +"-"+i +"\t" + graph[i][parent[i]]);
		}
	}
	
	void primMST(int graph[][]) {
		
		//Array to store constructed MST
		int parent[] = new int[v];
		
		//Key values used to pick mininum weight edge in cut
		int key[] = new int[v];
		
		//To present set of vertices not yet included in MST
		boolean mstSet[] = new boolean[v];
		
		//Initialize all keys as INFINITE
		for(int i = 0; i < v;i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		
		//Always include first 1st vertex in MST
		key[0] = 0; //Make key 0 so that this vertex is picked as first vertex
		parent[0] = -1; //First node is always root of MST.
		
		//The MST will have v vertices
		for(int count = 0; count < v - 1; count++) {
			
		}
	}
}
