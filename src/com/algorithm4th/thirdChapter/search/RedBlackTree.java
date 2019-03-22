package com.algorithm4th.thirdChapter.search;

/**
 * 是一颗二叉搜索树，其性质如下：
 * 1.每个结点或是红色或是黑色
 * 2.根结点是黑色
 * 3.每个叶子结点是黑色
 * 4.如果一个结点是红色，则它的两个子结点都是黑色
 * 5.对每个结点，从该结点到其所有后代叶结点的简单路径上，均包含相同数目的黑色结点
 * 
 * 从某个结点x出发（不含该结点）到达一个叶结点的任意一条简单的路径上的黑色结点个数称为该结点的黑高（结合性质5）
 * 一棵有n个内部结点的高度至多为2lg(n+1)
 * @author admin
 *
 */
public class RedBlackTree {
	private static String RED = "red";
	private static String BLACK = "black";
	
	private Node nil = new Node(null, BLACK);
	private Node root = null;
	
	class Node{
		Integer key;
		Node left,right,parent;
		int level;
		String color;//0表示红色，1表示黑色
		
		Node(Integer key){
			this.key = key;
		}
		
		Node(Integer key,String color){
			this.key = key;
			this.color = color;
		}
		
	}
	
    public void leftRotate(Node x) {
    	
    }
    
    public void rightRotate(Node x) {
    	
    }
	
	//插入操作，伪代码将结点z着为红色 ,伪代码
	public void insert(Integer z) {
		Node node = new Node(z);
		
		Node y = null;//
		Node x = root;
		while(x != nil) {
			y = x;
			if(z < x.key)
				x = x.left;
			else
				x = x.right;
		}//这样做的目的:找到插入节点应该放的叶子结点的位置
		node.parent = y;
		if(y == null) {//判断树是否为空树
			root = node;
		}else if(z < y.key) {
			y.left = node;
		}else
			y.right = node;
		node.left = nil;
		node.right = nil;
		node.color = RED;//设为红色
		rb_insert_fix_up(node);
	}

	private void rb_insert_fix_up(Node node) {
		while(node.color.equals(RED)) {
			if(node.parent == node.parent.parent.left) {
				Node uncle = node.parent.parent.right;
				if(uncle.color.equals(RED)) {
					node.parent.color = BLACK;
					uncle.color = BLACK;
					node.parent.parent.color = RED;
					node = node.parent.parent; 
				}else if(node == node.parent.right) {
					node = node.parent;
					leftRotate(node);
				}else {
					node.parent.color = BLACK;
					node.parent.parent.color = RED;
					rightRotate(node);
				}
			}else {
				Node uncle = node.parent.parent.left;
				if(uncle.color.equals(RED)) {
					node.parent.color = BLACK;
					uncle.color = BLACK;
					node.parent.parent.color = RED;
					node = node.parent.parent;
				}else if(node == node.parent.left) {
					node = node.parent;
					rightRotate(node);
				}else {
					node.parent.color = BLACK;
					node.parent.parent.color = RED;
					leftRotate(node);
				}
			}
		}
		this.root.color =  BLACK;
	}
}
