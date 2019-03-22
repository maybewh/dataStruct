package com.leetcode.practice;

/**
 * 最长回文串--中心扩展
 * @author admin
 *
 */
public class LongestPalindromicSubstring2 {
	
	public String longestPalindrome(String s) {
		
		if(s == null || s.length() < 1) {
			return "";
		}
		
		int start = 0,end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);//最长回文串为奇数个字符
			int len2 = expandAroundCenter(s, i, i + 1);//最长
			int len = Math.max(len1, len2);
			if(len > end - start) { //i是从0开始。此处的长度 大于时可能 是等于（之前的子串的长度），但不影响。
				start = i - (len - 1) / 2; //当为偶数时，取得是左边的索引，需要减一再取半(其中心本因为两个字母中间)
				end = i + len / 2; 
			}
		}
		return s.substring(start, end + 1);
		
	}
	
	
	/**
	 * 中心扩展
	 * @param s 
	 * @param left
	 * @param right
	 * @return
	 */
	public int expandAroundCenter(String s,int left,int right) {
		int L = left;
		int R = right;
		while(L >=0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L++;
			R--;
		}
		return R - L - 1;//因上面在退出循环前 多走了两步，如此处需要再减一
	}
}
