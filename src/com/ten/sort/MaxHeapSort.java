package com.ten.sort;

import sun.security.util.Length;

/**
 * ���� ����
 *  ��ȫ���������������һ�㣬ÿ�㶼����ȫ��䡣
 *  
 *  left = root * 2 + 1
 *  right = root * 2 + 2	
 * @author ����
 *
 */
public class MaxHeapSort {
	
	public static void sort(int[] array) {
		//1.�ȹ���һ������
		buildMaxHeap(array);
		
		//2.һ������һ����ȡ����Ԫ��
		for(int i = array.length - 1;i >= 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			heapfiy(array, i, 0);
		}
	}
	
	/**
	 * �������ѣ��ӵ����ڶ�������һ��Ԫ�ؿ�ʼ��һֱ�����ڵ�
	 * @param array
	 */
	public static void buildMaxHeap(int[] array) {
		for(int i = (array.length - 1) / 2; i >= 0; i--) {
			heapfiy(array, array.length - 1,i);
		}
	}
	
	/**
	 * ��Ҫ���ã�ά�����ѵ����ʣ�ʹ���ڵ��ֵ���������ӽڵ��ֵ
	 *  ������0��ʼ
	 * �����ѣ�ʹ���ڵ��ֵ���������ӽڵ��ֵ
	 * @param array
	 * @param i �����ĸ��ڵ������ֵ
	 */
	public static void heapfiy(int[] array,int n,int i) {
		
		int largest = i;
		
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if(left < n && array[left] > array[largest]) {
			largest = left;
		}
		
		if(right < n && array[right] > array[largest]) {
			largest = right;
		}
		if(largest != i) {
			swap(array,i,largest);
			heapfiy(array, n, largest);
		}
	}

	private static void swap(int[] array, int i, int largest) {
		int temp = array[i];
		array[i] = array[largest];
		array[largest] = temp;
	}
	
	public static void main(String[] args) {
		int[] result = new int[] {5,7,5,6,1,9};
		sort(result);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
