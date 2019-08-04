package com.ten.sort;

/**
 * Ã°ÅİÅÅĞò
 * @author ÍõêÍ
 *
 */
public class BubbleSort {
	
	public static int[] bubble(int[] array) {
		if(array == null || array.length <= 0) {
			return null;
		}
		
		int length = array.length;
		for(int i = 0;i < length - 1;i++) {
			for(int j = length - 1; j > i;j--) {
				if(array[j - 1] > array[j]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] result = bubble(new int[] {5,7,5,6,1,9});
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
