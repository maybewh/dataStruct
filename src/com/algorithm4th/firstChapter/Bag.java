package com.algorithm4th.firstChapter;

import java.util.Iterator;

/**
 * ����,�ɵ���
 * ����--��һ�ֲ�֧�ִ���ɾ��Ԫ�صļ������͡�
 * ����Ŀ�ľ��ǰ��������ռ�Ԫ�ز����������ռ�����Ԫ�أ�������˳��ȷ�������������޹�
 * @author admin
 *
 * @param <T>
 */
public class Bag<T> implements Iterable<T> {
	
	//����һ���յı���
	public Bag() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * ���һ��Ԫ��
	 * @param t
	 */
	void add(T t) {
		
	}
	
	/**
	 * �����Ƿ�Ϊ��
	 * @return
	 */
	boolean isEmpty() {
		return false;
		
	}
	
	/**
	 * ������Ԫ�ص�����
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
