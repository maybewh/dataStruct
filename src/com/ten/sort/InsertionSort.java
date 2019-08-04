package com.ten.sort;

/**
 * 插入排序
 * 思想：一个数组默认第一个数为已排序数组，即前面的元素为已经排序好的数组，
 * 后面一部分为未排序好的数组,将后面的元素与前面已排序好的元素进行比较，若小于
 * 前面某个元素，则将前面某个元素后移，将该元素放入某个元素的位置。
 * @author 王晖
 *
 */
public class InsertionSort {
	
	public static void insertSort(int[] array) {
		//已排序完的元素
		int num = 1;
		for(int i = 1; i < array.length;i++) {
			for(int j = 0;j < num;j++) {
				if(array[j] > array[i]) {
					move(array,j,i);
					break;
				}
			}
			num++;
		}
	}
	
	public static void move(int[] array,int start,int end) {
		int temp = array[end];
		for(int i = end;i > start;i--) {
			array[i] = array[i - 1];
		}
		array[start] = temp;
	}
	
	/**
	 * geeksforgeeks的
	 * https://www.geeksforgeeks.org/insertion-sort/
	 * @param args
	 */
	public static void sort(int[] array) {
		
		int length = array.length;
		for(int i = 1;i < length;i++) {
			int num = array[i];
			int j = i - 1;
			
			while(j >= 0 && array[j] > num) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = num;
		}
	}
	
	public static void main(String[] args) {
		int[] result = new int[] {5,7,5,6,1,9};
		sort(result);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
