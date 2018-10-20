package com.algorithm4th.secondChapter.sort;


/**
 * 选择排序：
 *    思路：首先找到数组中最小的那个元素，其次，将它和数组中的第一个元素交换位置（如果第一个元素就是最小元素，那么它就和自己交换),
 *    再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。如此往复进行，直到整个数组排序
 *    
 * @author admin
 *
 */
public class Selection {
	
	public static void sort(Comparable[] a) {
		int N  = a.length;
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for(int j = i;j<a.length;j++) {	
				//一趟比较中 和最小值比较
				if(less(a[j],a[min])) min = j;  //查看Example中的less，比较元素大小
			}
			exch(a,i,min); //交换位置，查看Example中的exch
		}
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
