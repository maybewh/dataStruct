package com.algorithm4th.secondChapter.sort;

/**
 * 排序算法样板程序
 * @author admin
 *
 */
public class Example {
	
	public static void sort(Comparable[] a) {
		
	}
	
	//进行元素比较
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	//将元素交换位置
	private static void exch(Comparable[] a,int i,int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	//显示
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] +" ");
		}
		System.out.println();
	}
	
	//测试数组元素是否有序
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if(less(a[i], a[i-1]))
				return false;
		}
		return true;
	}
}
