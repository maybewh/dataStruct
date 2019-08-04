package com.leetcode.practice;

public class Test {

	public int find(int[] array) {
		
		for(int i = 0, j = 1; j < array.length; i++,j++) {
			if(array[i] != array[j]) {
				return array[i];
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.find(new int[] {9,9,11,11,6,7,7}));
	}
}
