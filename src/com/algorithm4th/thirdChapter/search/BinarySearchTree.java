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
	/**
	 * 用一棵以v为根的子树来替换一棵以u为根的子树时，结点u的双亲变为结点v的双亲，最后成为v成为u的双亲
	 * @param root
	 * @param u
	 * @param v
	 */
	public void transplant(Node root,Node u,Node v) {
/*		//伪代码
		if(u.parent == null) //u是T的树根
			root = v;
		else if(u == u.parent.left) 
			u.parent.left = v;
		else
			 u.parent.right = v;
		if(v != null)
			v.parent = u.parent;*/
		if(root == u)
			root = v;
		else if(u == root.left)
			root.left = v;
		else
			root.right = v;
		if(v != null)
			v = u; //并没有处理v.left和v.right的更新，需要调用者来处理
	}
	
	public void deleteKey(int key) {
		delete(root,key);
	}
	
	/**
	 * 此处并不适用算法导论的实现，使用geeksforgeeks上的
	 * https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
	 */
	public Node delete(Node root,int key) {
		//1.树是否为空
		if(root == null)
			return root;
		//2.先找到key所在的地方
		if(key < root.key)
			root.left = delete(root.left, key);
		else if(key > root.key)
			root.right = delete(root.right,key);
		//3.key对应的结点没有孩子或key对应的结点只有一个孩子
		if(root.left == null)
			return root.right;
		else if(root.right == null)
			return root.left;
		//5.key有两孩子,那么key的后继一定在其右子树上,由于key要小于其右子树上的值，故一定在结点右孩子的左子树上，且该结点的左孩子为null
		else {
			root.key = minValue(root.right,key);
			root.right = delete(root.right, key);
		}
		return root;
	}
	public int minValue(Node node, int  key) {
		int min = key;
		while(node.left != null) {
			min = node.left.key;
			node = node.left;
		}
		return min;
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
