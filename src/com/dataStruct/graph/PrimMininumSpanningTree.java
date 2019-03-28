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
	void printMST(int parent[], int n, int graph[][]) {
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
			//Pick the mininum key vertex from the set of vertices
			//not yet included in MST
			int u = minKey(key,mstSet);
			
			//Add the picked vertex to MST set
			mstSet[u] = true;
			
			//Update key value and parent index of the adjacent
			//vertices of the picked vertex.Consider only those vertices 
			//which are not yet included in MST
			for(int i = 0; i < v; i++) {
				//graph[u][i] is non zero only for adjacent vertices of m
				//mstSet[i] vertices is false for vertices not yet included in MST
				//Update the key only if graph[u][i] is smaller than key[i]
				if(graph[u][i] != 0 && mstSet[i] == false && graph[u][i] < key[i]) {
					parent[i] = u;
					key[i] = graph[u][i];
				}
			}
		}
		
		printMST(parent,v,graph);
	}
	
	public static void main(String[] args) {
		 PrimMininumSpanningTree t = new PrimMininumSpanningTree(); 
	       /* int graph[][] = new int[][] {{0, 6, 1, 5, 0, 0}, 
	                                    {6, 0, 5, 0, 3, 0}, 
	                                    {1, 5, 0, 5, 6, 4}, 
	                                    {5, 0, 5, 0, 0, 2}, 
	                                    {0, 3, 6, 0, 0, 6},
	                                    {0, 0, 4, 2, 6, 0}}; */
		 int graph1[][] = new int[][] {{0, 2, 0, 6, 0}, 
             {2, 0, 3, 8, 5}, 
             {0, 3, 0, 0, 7}, 
             {6, 8, 0, 0, 9}, 
             {0, 5, 7, 9, 0}};
	 
	        // Print the solution 
	        //t.primMST(graph); 
	        
	        System.out.println();
	        t.primMST(graph1);
	}
}
