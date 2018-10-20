package com.algorithm4th.firstChapter;

import java.util.Iterator;

/**
 * 背包,可迭代
 * 背包--是一种不支持从中删除元素的集合类型。
 * 它的目的就是帮助用例收集元素并迭代遍历收集到的元素，迭代的顺序不确定，且与用例无关
 * @author admin
 *
 * @param <T>
 */
public class Bag<T> implements Iterable<T> {
	
	//创建一个空的背包
	public Bag() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 添加一个元素
	 * @param t
	 */
	void add(T t) {
		
	}
	
	/**
	 * 背包是否为空
	 * @return
	 */
	boolean isEmpty() {
		return false;
		
	}
	
	/**
	 * 背包中元素的数量
	 * @return
	 */
	int size() {
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
