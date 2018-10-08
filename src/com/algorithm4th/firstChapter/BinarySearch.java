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
}
