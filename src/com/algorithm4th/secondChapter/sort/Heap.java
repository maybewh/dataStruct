package com.algorithm4th.secondChapter.sort;

/**
 * 维护最大堆--最大堆的创建--堆排序
 * @author admin
 *
 */
public class Heap {
	
	/**
	 * 堆：（优先队列）其中的数据按照一定的规则进行排序
	 * 可以用二叉树来表示。当一棵二叉树的每个结点都大于等于它的两个子结点，它被称为堆有序
	 *     当我们用完全二叉树来表示的时候，可以使用数组来表示，根结点的位置为1，子结点的位置为2,3
	 * 子结点的子结点位置为5,6,7,8
	 *     一个堆中，位置k的结点的父结点的位置为 k/2 向下取整,两个子结点的位置为2k和2k+1
	 * @param a
	 */
	/**
	 *  四个步骤:1.最大堆调整(MAX-HEAPIFY)--其时间复杂度为O(lgn),维护最大堆的性质
	 *  		 2.BUILD-MAX-HEAP过程：具有线性时间复杂度，功能是从无序的输入数据数组中构造一个最大堆
	 *  		 3.HEAPSORT过程：对一个数组进行 原址排序
	 *  		 4.     利用堆来实现一个优先队列
	 * @param a
	 */
	
	public static void sort(Comparable[] a) {
		
		
	}
	
	//1.最大堆调整
	public static int[] maxHeapify(int[] arr, int heapsize,int i) {
		
		int[] result = arr;
		//获取 其左子树和右子树的 数组中的索引值
		int l = 2*i + 1; // 2i(以1为根结点对应的数组索引)
		int r = 2*i + 2;// 2i + 1
		int largest = i;
		if(l < heapsize && result[l] > result[i])
			largest = l;
		else largest = i; //可以不要
		
		if(r < heapsize && result[r] > result[largest])
			largest = r;
		if(largest != i) {
			int temp = result[largest];
			result[largest] = result[i];
			result[i] = temp;
			maxHeapify(result,heapsize,largest);
		}
		return result;
		
	}
	
	//2.建堆：子数组A( n/2向下取整+1 ... n)为树的叶子结点。每个叶子结点可以看成只包含一个元素的堆
	//   故从结点 n/2向下取整 到 1 进行最大堆调整可以构造 一个最大堆
	
	public static int[] buildMaxHeap(int[] arr) {
		
		int[] temp = arr;
		for(int i = arr.length / 2 - 1; i >= 0;i--) {
			maxHeapify(temp,arr.length, i);
		}
		return temp;
	}
	
	//3.堆排序
	public static int[] sort(int[] arr) {
		
		int heapsize = arr.length;	
		//1.先建立一个最大堆
		int[] result = buildMaxHeap(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for(int i = heapsize - 1; i >= 1;i --) {
			int temp = result[i];
			result[i] = result[0];
			result[0] = temp;
			//维护最大堆之前，先删除一个元素 
			heapsize--;	
			//函数需要调整，没有用到heapsize？？？
			maxHeapify(result,heapsize, 0);
		}
		return result;
	}

	
	public static void main(String[] args) {
		int[] arr = new int[] {10,80,30,90,40,50,70};
		int[] result = Heap.sort(arr);
		for (int i = 0; i < result.length; i++) {
			int num = result[i];
			System.out.print(num + " ");
		}
	}
}
