package com.algorithm4th.secondChapter.sort;


/**
 * 优先队列，范例
 * @author admin
 *
 * @param <Key>
 */
public class MaxPQ<Key extends Comparable<Key>> {
	
	public MaxPQ() {} //创建一个优先队列
	public MaxPQ(int max) {} //创建一个最大容量为max的优先队列
	public MaxPQ(Key[] a) {} //用a中的元素创建一个优先队列
	
	void insert(Key v) {} //向优先队列中插入一个元素
	Key max() { return null;} //返回最大元素
	
	Key delMax() {return null;} //删除最大的元素并返回被删除的元素
	
	boolean isEmpty() { return false;} //返回队列是否为空
	
	int size() {return 0;}  //返回优先队列中的元素的个数
}
