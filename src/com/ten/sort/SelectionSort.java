package com.ten.sort;

/**
 *    选择排序:
 *    在数组中找到一个最小的元素放在数组前面
 * @author 王晖
 *
 */
public class SelectionSort {
	
	public static void selectSort(int[] array) {
		if(array == null || array.length <= 0) {
			return;
		}
		int minIndex = 0;
		for(int i = 0; i < array.length;i++) {
			minIndex = i;
			int temp = array[i];
			for(int j = i + 1; j < array.length;j++) {
				if(array[j] < temp) {
					temp = array[j];
					minIndex = j;
				}
			}
			swap(array,i,minIndex);
		}
	}

	private static void swap(int[] array, int i, int minIndex) {
		int temp = array[i];
		array[i] = array[minIndex];
		array[minIndex] = temp;
	}
	
	public static void main(String[] args) {
		int[] result = new int[] {5,7,5,6,1,9};
		selectSort(result);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
