package com.algorithm4th.firstChapter;

import java.util.Iterator;

public class BagByNode<T> implements Iterable<T>{

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
	
	public void add(T item) {

		Node oldfirst =  first;
		first = new Node();
		first.t = item;
		first.next = oldfirst;
		N++;
	}
	
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class ListIterator implements Iterator<T>{
		
		Node current = first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public T next() {
			T item =  current.t;
			current = current.next;
			return item;
		}
		 
	}
	
}
