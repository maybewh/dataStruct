package com.leetcode.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ��Ӵ�
 * @author admin
 *
 */
public class LongestSubstring {
	
	/**
	 * 最长子串
	 * �������ڣ�������ҿ�[i,j)��������i��j-1 ֮������ַ���sij�Ѿ������Ϊû���ظ��ַ���
	 *       ��������ֻ��Ҫ���s[j]��Ӧ���ַ��Ƿ��Ѿ����������ַ���sij�С�������������Ӷ�ΪO(n^2)�ķ�����
	 *  ���ǿ���ʹ��HashSet�����м���������ʱ�临�Ӷ�ΪO(1)
	 *  
	 * ʱ�临�Ӷ�:O(2n),i��j ������n��
	 * �ռ临�Ӷȣ�O(min(m,n))�� n�ַ����Ĵ�С��m:��ĸ���Ĵ�С
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0,i = 0,j = 0;
		while(i < n && j < n) {
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j++)); //j++ ��ʹ��j�������+1
				ans = Math.max(ans, j - i);
			}else {
				//�������Ӵ���ʱ����ȥ��iָ�����ַ�����ÿ��i������ͬ���Ĳ���
				set.remove(s.charAt(i++));
			}
		}
		return ans;  
    }
	
	/**
	 * �������ڣ�ʹ��HashMap
	 *    ���s[j]��[i,j) ��Χ������ j���ظ����ַ�,���ǲ�Ҫ������i,����ֱ������[i,j��]�ķ�Χ
  �ظ����ַ���
	 * @param s
	 * @return
	 */
    public int lengthOfLongestSubstring2(String s) {
		
		int n = s.length();
		Map<Character, Integer> map = new HashMap<>();//key:�ַ���value:�ַ���Ӧ������
		int ans = 0,i = 0,j = 0;
		for (j = 0; j < n; j++) {
			if(map.containsKey(s.charAt(j))) {
				//map�洢���������ַ��������У���������ͬ���ַ�������valueΪ����������ֵ+1
				//�����ڽ�������ʱ�����ѵ�iǰ����ַ����ʴ�ʱi��ֵ���䣨��iָ�벻�ƶ���������
				//��[i,j)�ķ�Χ������������ͬ���ַ�����i = j��+1������ַ�(key)��Ӧ��value��j+1��
				 i = Math.max(map.get(s.charAt(j)), i);
			}
			//����i = j + 1 ���� i = j����i��j֮�� ���ظ��ַ��ĸ���Ϊ j - i + 1
			ans = Math.max(ans, j - i + 1);
			//Ĭ��ֱ�Ӵ洢 j + 1,���� �ƶ�ָ��iΪ j��+ 1
			map.put(s.charAt(j), j + 1);
			
		}
		return ans;  
    }
}
