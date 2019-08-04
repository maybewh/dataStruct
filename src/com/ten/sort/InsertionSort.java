package com.ten.sort;

/**
 * ��������
 * ˼�룺һ������Ĭ�ϵ�һ����Ϊ���������飬��ǰ���Ԫ��Ϊ�Ѿ�����õ����飬
 * ����һ����Ϊδ����õ�����,�������Ԫ����ǰ��������õ�Ԫ�ؽ��бȽϣ���С��
 * ǰ��ĳ��Ԫ�أ���ǰ��ĳ��Ԫ�غ��ƣ�����Ԫ�ط���ĳ��Ԫ�ص�λ�á�
 * @author ����
 *
 */
public class InsertionSort {
	
	public static void insertSort(int[] array) {
		//���������Ԫ��
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
	 * geeksforgeeks��
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
