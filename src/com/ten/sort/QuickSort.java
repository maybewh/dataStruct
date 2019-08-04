package com.ten.sort;

/**
 * �����������һ�׼���������С�ڻ�׼ֵ���ұ����飬���ڻ�׼ֵ��
 * @author ����
 *
 */
public class QuickSort {
	
	public static void quickSort(int[] array,int start,int end) {
		if(start > end) {
			return;
		}
		int index = partition(array, start, end);
		if(index > start) {
			quickSort(array, start, index - 1);
		}
		if(index < end) {
			quickSort(array, index + 1, end);
		}
	}
	
	/**
	 *   ��������
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public static int partition(int[] array,int start,int end) {
		//��һ����׼������С�ķ�����ߣ�������ķ����ұ�
		int piovt = start + (end - start + 1) / 2;
		swap(array,piovt,end);
		int index = start - 1;
		for(int i = start;i < end;i++) {
			if(array[i] < array[end]) {
				index++;
				//СԪ�ص��������Ȼ�׼С����ŵ�ǰ��
				swap(array, index, i);
			}
		}
		swap(array, index + 1, end);
		return index + 1;
		
	}
	
	public static void swap(int[] array,int i,int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] result = new int[] {5,7,5,6,1,9};
		quickSort(result, 0, result.length - 1);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
