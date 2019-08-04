package com.ten.sort;
/**
 *  希尔排序，插入排序的一种,
 *  从最开始的间隔为1，转化为元素的间隔为 gap为一组，在该组内进行插入排序。
 *  不用把一组元素移动到临近，只需每次比较时，索引直接加gap，就找到了该组的元素
 * @author 王晖
 *
 */
public class ShellSort {
	
	public static void shell(int[] array) {
		int length = array.length;
		int gap = length / 2;
		while(gap > 0) {
			
			for(int i = gap;i < length;i++) {
				int key = array[i];
				int j = i - gap;
				while(j >= 0 && array[j] > key) {
					array[j + gap] = array[j];
					j -= gap;
				}
				array[j + gap] = key;
			}
			gap /= 2;
		}
	}
	
	public static void main(String[] args) {
		int[] result = new int[] {5,7,5,6,1,9};
		shell(result);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
