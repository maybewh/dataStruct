package com.ten.sort;

import java.util.Arrays;

/**
 *    归并排序
 *    递归，先拆开，再合并
 * @author 王晖
 *
 */
public class MergeSort {
	
	public static void merge(int[] array,int start,int middle,int end) {
		
		int[] left = Arrays.copyOfRange(array, start, middle + 1);
		int[] right = Arrays.copyOfRange(array, middle + 1,end + 1);
		
		int i = 0;
		int j = 0;
		
		int leftNum = middle - start + 1;
		int rightNum = end - middle;
		
		int k = start;
		while(i < leftNum && j < rightNum) {
			if(left[i] <= right[j]) {
				array[k] = left[i];
				i++;
			}else {
				array[k] = right[j];
				j++;
			}
			k++;
		}
		while(i < leftNum) {
			array[k++] = left[i++];
		}
		
		while(j < rightNum) {
			array[k++] = right[j++];
		}
	}
	
	public static void sort(int[] array,int start,int end) {
		if(start == end) {
			return;
		}
		
		int middle = (start + end) / 2;
		sort(array,start,middle);
		sort(array, middle + 1,end);
		
		merge(array,start,middle,end);
	}
	
	public static void main(String[] args) {
		int[] result = new int[] {5,7,5,6,1,9};
		sort(result,0,result.length - 1);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
