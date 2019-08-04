package com.leetcode.practice;

public class MaxAnd {
	public static int getMax(int [] array) {
		if (array == null || array.length <= 0){
            return 0;
        }
        int max = 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        boolean flag = true;
        while(start < array.length && end < array.length){
            if(array[start] <= 0 && flag){
                start++;
                end = start;
            }else{
                flag = false;
                sum += array[end];
                if(sum >= 0){
                    end++;
                    if(sum > max) {
                        max = sum;
                    }
                }else{
                    start = end;
                    sum = 0;
                    flag = true;
                }
            }
        }
        return max;
	}
	
	public static void main(String[] args) {
		System.out.println(MaxAnd.getMax(new int[] {1,-2,3,10,-4,7,2,-5}));
	}
}
