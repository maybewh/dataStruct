package com.algorithm4th.thirdChapter.search;

/**
 * 二叉搜索树
 * @author admin
 *
 */
public class BinarySearchTree {
	
	class Node{
		int key;
		Node left,right;
		
		public Node(int item) {
			key = item;
			left = right = null;
		}
	}
	
	Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	void insert(int key) {
		root = insertRec(root,key);
	}

	private Node insertRec(Node root, int key) {
		//若为空，则返回一个新结点
		if(root == null) {
			root =  new Node(key);
			return root;
		}
		if(key < root.key) {
			root.left = insertRec(root.left, key); //继续延伸
		}
		if(key > root.key) {
			root.right = insertRec(root.right, key);//继续延伸
		}
		//若key与根结点值一样，则直接返回
		return root;
	}
	
	void inorder() {
		inorderRec(root);
	}

	private void inorderRec(Node root2) {
		if(root2 != null) {
			inorderRec(root2.left);
			System.out.println(root2.key);
			inorderRec(root2.right);
		}
	}
	
	//search
	public Node recursiveSearch(Node root,int key) {
		if(root == null || root.key == key) 
			return root;
		if(key < root.key)
			return recursiveSearch(root.left, key);
		
		return recursiveSearch(root.right, key);
		
	}
	
	public Node iterativeSearch(Node root,int key) {
		
		while(root != null && root.key != key) {
			if(key < root.key)
				root = root.left;
			if(key > root.key)
				root = root.right;
		}
		return root;
	}
	
	//二叉搜索树，删除节点
	/**
	 * 1.如果z没有孩子结点，简单的将它删除，并修改它的父节点，用null表示它的孩子
	 * 2.如果z只有一个孩子，那么将孩子提到树中z的位置，并修改z的父节点，用z的孩子替换z
	 * 3.有两个孩子，z的后继一定在右子树上，找到z的后继y，z原来右子树部分成为y右子树，其左子树成为y的左子树
	 *   对3的情况再加讨论
	 *   1)z没有左孩子，将右孩子替换z的位置
	 *   2)z只有一个孩子，即为其左孩子(同时有右孩子)，将左孩子移到z处
	 *   3)有两个孩子，若y是z的右孩子，则用y替换z。否则，y位于z的右子树但并不是y的右孩子。在这种情况下，先用y的右孩子替代y，然后再用y替代z
	 * @param args
	 */
	public void transplant(BinarySearchTree tree,Node u,Node v) {
		
	}
	public static void main(String[] args) {
		 BinarySearchTree tree = new BinarySearchTree(); 
		  
	        /* Let us create following BST 
	              50 
	           /     \ 
	          30      70 
	         /  \    /  \ 
	       20   40  60   80 */
	        tree.insert(50); 
	        tree.insert(30); 
	        tree.insert(20); 
	        tree.insert(40); 
	        tree.insert(70); 
	        tree.insert(60); 
	        tree.insert(80); 
	  
	        // print inorder traversal of the BST 
	        //tree.inorder(); 
	        Node node = tree.iterativeSearch(tree.root, 70);
	        System.out.println(node.key+" "+ node.left.key +" " + node.right.key);
	}
}
