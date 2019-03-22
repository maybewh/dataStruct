package com.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumClosest {
	
	public int threeSumClosest(int[] nums, int target) {
		
		Arrays.sort(nums);
		int result = nums[0] + nums[1] + nums[2];
		
		int closet = Math.abs(nums[0] + nums[1] + nums[2] - target);
		
		for (int i = 0; i < nums.length; i++) {
			if(i > 0 && nums[i] == nums[i - 1]) continue; //去掉重复
			
			int j = nums[i];
			int ob = target - j;
			
			int m = i + 1;
			int n = nums.length - 1;
			while(m < n) {
				int compute = nums[m] + nums[n];
				int mark = ob - compute;
				int temp = Math.abs(mark);
				if(temp < closet) {
					closet = temp;
					result = nums[i] + nums[m] + nums[n];
				}			
				if(closet == 0)
					return target;
				if(compute < ob)
					m++;
				else
					n--;
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,5,10,11};
		ThreeNumClosest tn = new ThreeNumClosest();
		System.out.println(tn.threeSumClosest(arr, 12));
	}
}
