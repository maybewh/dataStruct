package com.algorithm4th.secondChapter.sort;

/**
 * ��������,��ÿ��Ԫ�� ���뵽���Ӧ��λ��
 * @author admin
 *
 */
public class Insertion {
	
	public static void sort(Comparable[] a) {
		//��a[] ����������
		int N = a.length;
		
		for (int i = 1; i < a.length; i++) {
			Comparable comparable = a[i];
			//0 ~ (i-1)������ģ���a[j] �� a[j-1] ����һ������j-1 ǰ������󡣹�j��ѭ������ 
			for(int j = i;j > 0 && less(a[j],a[j-1]);j--) {
				exch(a, j, j - 1);
			}
		}
	}
	
		//�������ݸĽ��� ����ѭ���н��ϴ��Ԫ�ض������ƶ����������ǽ�������Ԫ��(������������Ĵ����ͻ����)
		/**
		 * ���ã�ָ���������е�����˳��ߵ���Ԫ�ء����磺EXAMPLE����11�Ե��ã�E-A��X-A��X-M
		 *   X-P��X-L����������е��õ�����С�������С��ĳ����������˵��������ǲ�������ġ�
		 *   �����������£�
		 *     1.������ÿ��Ԫ�ؾ�����������λ�ö���Զ
		 *     2.һ������Ĵ������һ��С����
		 *     3.������ֻ�м���Ԫ�ص�λ�ò�ȷ��   ---�������������������ȽϺ��ʣ���ѡ��������Ȼ��
		 * @param a
		 */
		public static void betterSort(Comparable[] a) {
			//ʹ�ϴ��Ԫ������һλֻ��Ҫ��������һ�Σ�������Ҫ��������
			//������ʹ�ò����߽編�����ҳ���С��Ԫ�أ�����Ҫj>0��������ж�
			//https://blog.csdn.net/sms15732621690/article/details/52016323 �㷨�Ķ�̬ͼ
			int N = a.length;
			
			for(int i = 1;i < N;i++) {
				Comparable t = a[i];
				int j = i;
				for(;j > 0 && less(t,a[j-1]);j--) {
					a[j] = a[j - 1];
				}
				a[j] = t;
			}
		}
	
	//����Ԫ�رȽ�
		private static boolean less(Comparable v,Comparable w) {
			return v.compareTo(w) < 0;
		}
		
		//��Ԫ�ؽ���λ��
		private static void exch(Comparable[] a,int i,int j) {
			Comparable t = a[i];
			a[i] = a[j];
			a[j] = t;
		}
		
		
		//��ʾ
		private static void show(Comparable[] a) {
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] +" ");
			}
			System.out.println();
		}
		
		//��������Ԫ���Ƿ�����
		public static boolean isSorted(Comparable[] a) {
			for (int i = 1; i < a.length; i++) {
				if(less(a[i], a[i-1]))
					return false;
			}
			return true;
		}
		
}
