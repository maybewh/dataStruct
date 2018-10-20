package com.algorithm4th.firstChapter;

public class StackByNode<T> {
		
	private Node first; //ջ��
	private int N; //Ԫ�صĸ���
	
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
		//��ջ�����Ԫ��
		Node oldfirst =  first;
		first = new Node();
		first.t = item;
		first.next = oldfirst;
		N++;
	}
	
	public T pop() {
		//ɾ��ջ����Ԫ��
		T item = first.t;
		first = first.next;
		N--;
		return item;
	}
	
	
}
