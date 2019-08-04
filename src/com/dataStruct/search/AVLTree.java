package com.dataStruct.search;

public class AVLTree {
	
	Node root;
	
	//A utility function to get the height of the tree
	int height(Node n) {
		
		if(n == null)
			return 0;
		return n.height;
	}
	
	
}
