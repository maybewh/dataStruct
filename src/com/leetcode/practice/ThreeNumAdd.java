package com.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumAdd {

	public List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> outList = new ArrayList<>();
		if (nums.length < 3) {
			return null;
		}
		//1.先排序
		Arrays.sort(nums);//自己写个快排
		for (int i = 0; i < nums.length; i++) {
			//两个指针,初始位置一个指向num[i+1]，一个指向最后一个元素，由于已经排好序，故当num[i]>=0时，就不用进行计算了
			//避免重复的元素，相等的元素相邻，所以删除相等的元素，即i直接加1
			if(nums[i] >= 0) break;
			if(i > 0 && nums[i] == nums[i - 1]) continue; //去掉重复的情况
			int m = i + 1, n = nums.length - 1;
			while(m < n) {
				int target = 0 - nums[i];
				if(nums[m] + nums[n] == target) {
					List<Integer> innerList = new ArrayList<>();
					innerList.add(nums[i]);
					innerList.add(nums[m]);
					innerList.add(nums[n]);
					outList.add(innerList);
					while(m < n && nums[m] == nums[m + 1])
						m++;
					while(m < n && nums[n] == nums[n - 1])
						n--;
					m++;
					n--; //不需要重复，故m和n的组合就这一种，m和n都需要移位
				}else if(nums[m] + nums[n] < target) {
					m++;//可以去掉重复的，也可以不用，下面一样				
				}else if(nums[m] + nums[n] > target) {
					n--;				
				}
			}
		}
		
		return outList;
	}
	
	public static void main(String[] args) {
		int arr[] = new int[] {-1, 0, 1, 2, -1, -4};
		ThreeNumAdd tna = new ThreeNumAdd();
		List<List<Integer>> after = tna.threeSum(arr);
		for (List<Integer> list : after) {
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
}
