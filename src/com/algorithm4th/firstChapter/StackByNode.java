package com.algorithm4th.firstChapter;

public class StackByNode<T> {
		
	private Node first; //栈顶
	private int N; //元素的个数
	
	private class Node{
		T t;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return N;
	}
	
	public void push(T item) {
		//向栈顶添加元素
		Node oldfirst =  first;
		first = new Node();
		first.t = item;
		first.next = oldfirst;
		N++;
	}
	
	public T pop() {
		//删除栈顶的元素
		T item = first.t;
		first = first.next;
		N--;
		return item;
	}
	
	
}
