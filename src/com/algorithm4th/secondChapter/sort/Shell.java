package com.algorithm4th.secondChapter.sort;


/**
 * 希尔排序：基于插入排序的快速排序算法。大规模的乱序数组插入排序很慢，因为它们只交换相邻元素。
 *   思想：使数组中任意间隔为h的元素都是有序的。这样的数组称为h有序数组
 *     插入排序处理h个子数组时，将元素 移动距离由1变为h即可
 *     
 *     对该算法的视频图解：https://www.geeksforgeeks.org/shellsort/
 * @author admin
 *
 */
public class Shell {
	
	/**
	 * 以n/2为步长，直到步长为1
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		
		int N = a.length;
		
		
		//初始步伐 n/2
	    //1.最外层，确定gap的取值范围
		for(int gap = N / 2; gap > 0; gap /= 2 ) {
			
			//2.进行希尔排序,i进行排序比较的初始位置为gap，因初始gap为n/2，故一般从中间开始
			for(int i = gap; i < N; i++) {
				
				//先存储比较的数
				Comparable temp = a[i];
			   //3.进行比较替换，相距gap距离，即进行插入排序
				int j;
				for(j = i; j >= gap && less(a[j],a[j - gap]); j -= gap) {
					a[j] = a[j - gap];
				}
				//最后temp回到其最小的位置上
				a[j] = temp;
			}
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
