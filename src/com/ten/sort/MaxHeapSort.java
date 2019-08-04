package com.ten.sort;

import sun.security.util.Length;

/**
 * 最大堆 排序
 *  完全二叉树，除了最后一层，每层都被完全填充。
 *  
 *  left = root * 2 + 1
 *  right = root * 2 + 2	
 * @author 王晖
 *
 */
public class MaxHeapSort {
	
	public static void sort(int[] array) {
		//1.先构建一个最大堆
		buildMaxHeap(array);
		
		//2.一个接着一个抽取最大的元素
		for(int i = array.length - 1;i >= 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			heapfiy(array, i, 0);
		}
	}
	
	/**
	 * 构建最大堆，从倒数第二层的最后一个元素开始，一直到根节点
	 * @param array
	 */
	public static void buildMaxHeap(int[] array) {
		for(int i = (array.length - 1) / 2; i >= 0; i--) {
			heapfiy(array, array.length - 1,i);
		}
	}
	
	/**
	 * 主要作用：维护最大堆的性质：使父节点的值大于左右子节点的值
	 *  索引从0开始
	 * 调整堆，使父节点的值大于左右子节点的值
	 * @param array
	 * @param i 子树的根节点的索引值
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
