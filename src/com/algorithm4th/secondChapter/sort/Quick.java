package com.algorithm4th.secondChapter.sort;


/**
 * 快速排序：分治策略
 *    归并排序讲数组分成两个子数组分别排序，并将有序的子数组归并以将整个数组排序；
 * 而快速排序将数组排序的方式是：当两个子数组都有序时，整个数组也就自然有序了。
 *  
 * @author admin
 *
 */
public class Quick {
	
	public static Integer[] sort(Integer[] a) {
		Integer[] arr = a;
		sort(arr, 0, a.length - 1);
		return arr;
	}
	
	public static Integer[] sort(Integer[] a,int low,int high) {
		Integer[] arr = a;
		if(high <= low) return arr; //当变为小数组时可以用插入排序替换，提高效率。因为数组很小时也会调用递归
					     //可改为 if(high <= low + M) {Insertion.sort(a,low,high); return arr;} M一般为 5 - 15之间
			int j = partition(arr, low, high);
			sort(arr,low,j - 1);
			sort(arr,j + 1,high);
		
		return arr;
	}

	//关键点在于partition(),选定一个元素为pivot，若元素大于它，则放在它的右边，元素小于它，则放在左边
	private static int partition(Integer[] arr,int low, int high) {
		//基准的确定：三数取中：即在最多端、中间、最右端的三个数中取一个中间大小的值
		int mid = low + (high - low) / 2;
		if(less(arr[high],arr[mid])) {
			exch(arr, high, mid); //保证左端最小
		}
		if(less(arr[high],arr[low])) {
			exch(arr, low, high);
		}
		if(less(arr[mid],arr[low])) {
			exch(arr, mid, low);
		}
		
		Comparable pivot = arr[low];
		
		int i = low,j = high + 1;
		//扫描左右并交换元素
		while(true) {
			//左边指针判断与基准的大小，若小于，则左侧指针继续加一，否则，大于时跳出，等待下一步
			//的右侧指针j对应的小于基准的元素，将两个元素互换
			while(less(arr[++i],pivot)) if(i == high ) break;
			//若右侧指针对应的元素大于基准，则指针左移，否则跳出循环，等待互换
			while(less(pivot,arr[--j])) if(j == low) break;
			if(i >= j) break;
			exch(arr, i, j);
		}
		exch(arr, low, j);
		//最后情况是i指向的元素大于基准，j指向的元素小于基准，由于基准取得arr[low]，故arr[j]和基准胡换
		//由于基准已经确定其正确的位置，将基准两边的元素分成两组，再进行排序，故返回j
		return j;
	}
	
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a,int i,int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] +" ");
		}
		System.out.println();
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if(less(a[i], a[i-1]))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {10,80,30,90,40,50,70};
		Integer[] result = Quick.sort(arr);
		for (int i = 0; i < result.length; i++) {
			Integer num = (Integer)result[i];
			System.out.print(num + " ");
		}
	}
}
