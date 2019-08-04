package com.algorithm4th.secondChapter.sort;

public class Merge {
	
	/**
	 * https://www.geeksforgeeks.org/merge-sort/ 合并排序
	 * 二分法 divide and conquer
	 * @param arr
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public static void merge(int[] arr,int lo,int mid,int hi) {
		
		int i = lo;
		int j = mid + 1;
		
		int[] aux = new int[arr.length];
		//閿熸枻鎷穉rr閿熸枻鎷烽敓鐙＄鎷穉ux,閿熸枻鎷烽敓鏂ゆ嫹涓洪敓鏂ゆ嫹閿熸枻鎷烽敓閾版唻鎷�
		for (int k = lo; k <= hi; k++) {
			aux[k] = arr[k];
		}
		
		for (int k = lo; k <= hi; k++) {
			if(i > mid) arr[k] = aux[j++]; //鍓嶉敓璇儴閿熸枻鎷烽敓鏂ゆ嫹鍏ㄩ敓鏂ゆ嫹閿熻剼濂斤綇鎷烽敓鏂ゆ嫹閿熸彮璇ф嫹閿熻纰夋嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
			else if(j > hi) arr[k] = aux[i++]; //閿熸枻鎷锋癌鍖℃嫹鍊奸敓鏂ゆ嫹閿熸枻鎷烽敓楗侯偓鎷烽敓鏂ゆ嫹閿熸垝鍒伴敓鏂ゆ嫹閿熸枻鎷�
			else if(aux[i] < aux[j]) arr[k] = aux[i++];
			else arr[k] = arr[j++];
		}
	}

	public static void mergeSort(int[] arr,int lo,int hi) {
		//1.计算中间 值
		int mid = lo + (hi - lo) / 2;
		//2.合并左侧
		mergeSort(arr, lo, mid);
		//3.合并右侧
		mergeSort(arr, mid + 1, hi);
		//4.合并两个成整个
		merge(arr,lo,mid,hi);
	}
}
