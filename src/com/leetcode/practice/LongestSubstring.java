package com.leetcode.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长子串
 * @author admin
 *
 */
public class LongestSubstring {
	
	/**
	 * 滑动窗口：以左闭右开[i,j)。若索引i到j-1 之间的子字符串sij已经被检查为没有重复字符。
	 *       所以我们只需要检查s[j]对应的字符是否已经存在于子字符串sij中。这样会产生复杂度为O(n^2)的方法。
	 *  我们可以使用HashSet来进行检索，检索时间复杂度为O(1)
	 *  
	 * 时间复杂度:O(2n),i和j 均访问n次
	 * 空间复杂度：O(min(m,n))。 n字符串的大小和m:字母集的大小
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0,i = 0,j = 0;
		while(i < n && j < n) {
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j++)); //j++ 先使用j，最后再+1
				ans = Math.max(ans, j - i);
			}else {
				//包含在子串中时，除去该i指定的字符。对每个i都进行同样的操作
				set.remove(s.charAt(i++));
			}
		}
		return ans;  
    }
	
	/**
	 * 滑动窗口：使用HashMap
	 *    如果s[j]在[i,j) 范围内有与 j′重复的字符,我们不要逐渐增加i,而是直接跳过[i,j′]的范围
  重复的字符，
	 * @param s
	 * @return
	 */
    public int lengthOfLongestSubstring2(String s) {
		
		int n = s.length();
		Map<Character, Integer> map = new HashMap<>();//key:字符，value:字符对应的索引
		int ans = 0,i = 0,j = 0;
		for (j = 0; j < n; j++) {
			if(map.containsKey(s.charAt(j))) {
				//map存储的是整个字符串，其中，若存在相同的字符，则其value为：最大的索引值+1
				//其中在进行搜索时，会搜到i前面的字符。故此时i的值不变（即i指针不移动）。若是
				//在[i,j)的范围内搜索到了相同的字符，则i = j′+1。其该字符(key)对应的value（j+1）
				 i = Math.max(map.get(s.charAt(j)), i);
			}
			//由于i = j + 1 或者 i = j。则i与j之间 不重复字符的个数为 j - i + 1
			ans = Math.max(ans, j - i + 1);
			//默认直接存储 j + 1,便于 移动指针i为 j′+ 1
			map.put(s.charAt(j), j + 1);
			
		}
		return ans;  
    }
}
