package com.algorithm4th.firstChapter;

/**
 * ���ֲ���
 * @author admin
 *
 */
public class BinarySearch {
	
	/**
	 * ǰ�᣺�����������
	 * @return
	 */
	public static int rank(int key,int[] array) {
		int low = 0;
		int high = array.length - 1;
		
		//���� ���� ��ֹ������
		while(low <= high) {
			int mid = (high - low) / 2;
			int midValue = array[mid];
			if(key > midValue) low = mid;
			else if(key < midValue) high = mid;
			else
				return mid;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int key = 5;
		int[] array = {1,3,4,5,6,7,9};
		System.out.println(BinarySearch.rank(key, array));
	}
}
