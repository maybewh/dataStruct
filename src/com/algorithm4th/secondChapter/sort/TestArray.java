package com.algorithm4th.secondChapter.sort;

public class TestArray {
	
	public static void main(String[] args) {
		TestArray ta = new TestArray();
		int arr[] = new int[]{1,3,5,7,9};
		 for (int i = 0; i < arr.length; i++) {
				int j = arr[i];
				System.out.print(j +" ");
			}
		 System.out.println();
	    int a[] = ta.test(arr);
	    for (int i = 0; i < arr.length; i++) {
			int j = arr[i];
			System.out.print(j +" ");
		}
	}
		
	
	
	int[] test(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			 arr[i] = i;
		}
		return arr;
	}
}
