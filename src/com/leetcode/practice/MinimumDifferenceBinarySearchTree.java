package com.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * 根据二叉树的特点，左子树的数小于根的值，右子树的值大于根的值，且最小差值一定是在根和其孩子的差值，
 * @author admin
 *
 */
public class MinimumDifferenceBinarySearchTree {

	class Node {
		int val;
		Node left, right;

		Node(int x) {
			val = x;
		}
	}
	List<Integer> list = new ArrayList<>();  
	
	public int getMinimumDifference(Node root) {
		theInOrderTraversal(root);
		int min = list.get(list.size() - 1);
		for (int i = 0; i < list.size() - 1; i++) {
			Integer first = list.get(i);
			Integer second = list.get(i + 1);
			int temp = Math.abs(first - second);
			min = temp < min ? temp : min;
		}
		return min;
	}
	
	public void theInOrderTraversal(Node root){
		
		if(root.left != null)
			theInOrderTraversal(root.left);
		list.add(root.val);
		if(root.right != null)
			theInOrderTraversal(root.right);
	}
}
