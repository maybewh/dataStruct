package com.algorithm4th.firstChapter;

import java.util.Iterator;

//可动态调整栈的大小
public class ResizingArrayStack<T> implements Iterable<T> {
	
	private T[] t = (T[]) new Object[1];//栈元素
	
	private int N = 0; //栈中元素的个数
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	//调整数组的大小
	private void resize(int length) {
		T[] temp = (T[])new Object[length];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = t[i];
		}
		t = temp;
	}
	
	public void push(T test) {
		if(N == t.length)
			resize(t.length * 2);
		t[++N] = test;
	}
	
	public T pop() {
		if(isEmpty())
			return null;
		T item = t[--N];
		t[N] = null;//解决游离问题，便于java虚拟机 回收内存
		if(N > 0 && N == t.length /4) resize(t.length / 2);
		return item;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	
	 private class ReverseArrayIterator implements Iterator<T>{
		 
		 //支持后进先出的迭代
		private int i = N;
		
		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public T next() {
			return t[--i];
		}
		 
	 }
}
