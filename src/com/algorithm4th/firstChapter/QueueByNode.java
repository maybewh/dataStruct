package com.algorithm4th.firstChapter;

/**
 * ÓÃÁ´±íÊµÏÖ¶ÓÁÐ
 * @author admin
 *
 * @param <T>
 */
public class QueueByNode<T> {
	
	private Node first;
	
	private Node last;
	
	private int N;
	
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
	
	public void enqueue(T item) {
		//Ïò±íÎ²Ìí¼ÓÔªËØ
		Node oldlast = last;
		last = new Node();
		
		last.t = item;
		last.next = null;
		
		if(first == null) first = last;//Õû¸öÁ´±íÎª¿ÕÊ±£¬µÚÒ»¸ö½áµã¾ÍÊÇ×îºóÒ»¸ö½áµã
		else
			oldlast.next = last;
		
		N++;
	}
	
	public T deenqueue() {
		//´Ó±íÍ·É¾³ýÔªËØ
		T item = first.t;
		first = first.next;
		//µ±µÚÒ»¸ö½áµãÖ¸ÏònullÊ±£¬Õû¸öÁ´±íÎª¿Õ£¬´ËÊ±µÄlast»¹ÊÇÖ¸ÏòÖ®Ç°µÄÖµ£¬¹ÊÒª½«ÆäÉèÎªnull(´ËÊ±firstÒÑÎªnull)
		if(isEmpty()) last = null;
		N--;
		return item;
	}
}
