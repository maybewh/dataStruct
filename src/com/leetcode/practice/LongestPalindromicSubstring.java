package com.leetcode.practice;

/**
 * 最长回文串--下面的代码（最长公共子串）并没有实现--需要改
 * @author admin
 *
 */
public class LongestPalindromicSubstring {
	
	char[] str = null;
	int m = 0;
	public LongestPalindromicSubstring(int length) {
		str = new char[length];
	}
	//使用最长公共子序列来求解该问题，动态规划
	//此处的Xm 与 Yn 是一个相反的顺序的字符串,m=n 
	//计算最优值,使用递归及相应的子问题，
	//用两个数组c[i][j]来保存最长公共子串的长度，b[i][j]记录c[i][j]的值是由哪一个子问题得到
	void LCSLength(char[] x,int[][] c,int[][] b) {
		
		int m = x.length;
		int n = m;
		
		char[] xc = x;
		char[] yc = new char[m];
		
		int mark = m;
		for (int i = 0; i < xc.length; i++) {
			yc[--mark] = xc[i];
		}
		//当i和j为0时，空序列是Xi和Yj的最长公共子序列
		for(int i = 0; i <= m; i ++)  c[0][i] = 0;
		for(int i = 0; i <= n; i ++)  c[i][0] = 0;
		
		for(int i = 1;i <= m;i++) {
			for(int j = 1;j <= n; j++) {
				if(xc[i - 1] == yc[j - 1]) {
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = 1;
				}else if(c[i - 1][j] > c[i][j - 1]) {
					c[i][j] = c[i - 1][j];
					b[i][j] = 2;
				}else {
					c[i][j] = c[i][j -1];
					b[i][j] = 3;
				}
			}
		}
	}
	
	
	
	char[] LCS(int i,int j,char[] xc,int[][] b) {	
		if(i == 0 || j == 0) return str;
		if(b[i][j] == 1) {
			LCS(i - 1, j - 1, xc, b);
			str[m] = xc[i - 1];
			m++;
		}
		else if(b[i][j] == 2) LCS(i - 1,j,xc,b);
		else LCS(i,j-1,xc,b);
		return str;
	}
	
	public static void main(String[] args) {
		String x = "acedfse";
		char[] xy = x.toCharArray();
		int[][] c = new int[x.length() + 1][x.length() + 1]; 
		int[][] b = new int[x.length() + 1][x.length() + 1];
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring(x.length());
		lps.LCSLength(xy, c, b);
		char[] xc = lps.LCS(x.length(), x.length(), xy, b);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < xc.length; i++) {
			char d = xc[i];
			System.out.println(d);
			sb.append(d);
		}
		System.out.println(sb.toString());
	}
}
