package com.algorithm4th.secondChapter.sort;

/**
 * 插入排序,将每个元素 插入到其对应的位置
 * @author admin
 *
 */
public class Insertion {
	
	public static void sort(Comparable[] a) {
		//将a[] 按升序排序
		int N = a.length;
		
		for (int i = 1; i < a.length; i++) {
			Comparable comparable = a[i];
			//0 ~ (i-1)是有序的，若a[j] 比 a[j-1] 大，则一定比在j-1 前面的数大。故j出循环结束 
			for(int j = i;j > 0 && less(a[j],a[j-1]);j--) {
				exch(a, j, j - 1);
			}
		}
	}
	
		//插入数据改进， 在内循环中将较大的元素都向右移动，而不总是交换两个元素(这样访问数组的次数就会减少)
		/**
		 * 倒置：指的是数组中的两个顺序颠倒的元素。比如：EXAMPLE中有11对倒置：E-A、X-A、X-M
		 *   X-P、X-L。如果数组中倒置的数量小于数组大小的某个倍数。则说这个数组是部分有序的。
		 *   有序的情况如下：
		 *     1.数组中每个元素距离它的最终位置都不远
		 *     2.一个有序的大数组接一个小数组
		 *     3.数组中只有几个元素的位置不确定   ---插入排序对这样的数组比较合适，而选择排序则不然。
		 * @param a
		 */
		public static void betterSort(Comparable[] a) {
			//使较大的元素右移一位只需要访问数组一次，交换需要访问两次
			//还可以使用擦除边界法，即找出最小的元素，则不需要j>0这个条件判断
			//https://blog.csdn.net/sms15732621690/article/details/52016323 算法的动态图
			int N = a.length;
			
			for(int i = 1;i < N;i++) {
				Comparable t = a[i];
				int j = i;
				for(;j > 0 && less(t,a[j-1]);j--) {
					a[j] = a[j - 1];
				}
				a[j] = t;
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
