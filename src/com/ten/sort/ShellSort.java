package com.ten.sort;
/**
 *  ϣ�����򣬲��������һ��,
 *  ���ʼ�ļ��Ϊ1��ת��ΪԪ�صļ��Ϊ gapΪһ�飬�ڸ����ڽ��в�������
 *  ���ð�һ��Ԫ���ƶ����ٽ���ֻ��ÿ�αȽ�ʱ������ֱ�Ӽ�gap�����ҵ��˸����Ԫ��
 * @author ����
 *
 */
public class ShellSort {
	
	public static void shell(int[] array) {
		int length = array.length;
		int gap = length / 2;
		while(gap > 0) {
			
			for(int i = gap;i < length;i++) {
				int key = array[i];
				int j = i - gap;
				while(j >= 0 && array[j] > key) {
					array[j + gap] = array[j];
					j -= gap;
				}
				array[j + gap] = key;
			}
			gap /= 2;
		}
	}
	
	public static void main(String[] args) {
		int[] result = new int[] {5,7,5,6,1,9};
		shell(result);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
