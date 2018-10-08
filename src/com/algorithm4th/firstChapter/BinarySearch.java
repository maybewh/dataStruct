package com.algorithm4th.firstChapter;

/**
 * 二分查找
 * @author admin
 *
 */
public class BinarySearch {
	
	/**
	 * 前提：数组是有序的
	 * @return
	 */
	public static int rank(int key,int[] array) {
		int low = 0;
		int high = array.length - 1;
		
		//进行 二分 终止的条件
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
