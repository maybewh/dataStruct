package com.algorithm4th.secondChapter.sort;

public class Merge {
	
	/**
	 * https://www.geeksforgeeks.org/merge-sort/ 参考上面的图解来理解merge函数
	 * 思想：divide and conquer 分治法
	 * @param arr
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public static void merge(int[] arr,int lo,int mid,int hi) {
		
		int i = lo;
		int j = mid + 1;
		
		int[] aux = new int[arr.length];
		//锟斤拷arr锟斤拷锟狡碉拷aux,锟斤拷锟斤拷为锟斤拷锟斤拷锟铰憋拷
		for (int k = lo; k <= hi; k++) {
			aux[k] = arr[k];
		}
		
		for (int k = lo; k <= hi; k++) {
			if(i > mid) arr[k] = aux[j++]; //前锟诫部锟斤拷锟斤拷全锟斤拷锟脚好ｏ拷锟斤拷锟揭诧拷锟街碉拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
			else if(j > hi) arr[k] = aux[i++]; //锟斤拷氩匡拷值锟斤拷锟斤拷锟饺拷锟斤拷锟戒到锟斤拷锟斤拷
			else if(aux[i] < aux[j]) arr[k] = aux[i++];
			else arr[k] = arr[j++];
		}
	}

	public static void mergeSort(int[] arr,int lo,int hi) {
		//1.锟饺硷拷锟斤拷mid值
		int mid = lo + (hi - lo) / 2;
		//2.锟斤拷锟斤拷锟斤拷锟�
		mergeSort(arr, lo, mid);
		//3.锟揭憋拷锟斤拷锟斤拷
		mergeSort(arr, mid + 1, hi);
		//4.锟较诧拷
		merge(arr,lo,mid,hi);
	}
}
