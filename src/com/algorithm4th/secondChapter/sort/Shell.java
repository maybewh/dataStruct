package com.algorithm4th.secondChapter.sort;


/**
 * ϣ�����򣺻��ڲ�������Ŀ��������㷨�����ģ������������������������Ϊ����ֻ��������Ԫ�ء�
 *   ˼�룺ʹ������������Ϊh��Ԫ�ض�������ġ������������Ϊh��������
 *     ����������h��������ʱ����Ԫ�� �ƶ�������1��Ϊh����
 *     
 *     �Ը��㷨����Ƶͼ�⣺https://www.geeksforgeeks.org/shellsort/
 * @author admin
 *
 */
public class Shell {
	
	/**
	 * ��n/2Ϊ������ֱ������Ϊ1
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		
		int N = a.length;
		
		
		//��ʼ���� n/2
	    //1.����㣬ȷ��gap��ȡֵ��Χ
		for(int gap = N / 2; gap > 0; gap /= 2 ) {
			
			//2.����ϣ������,i��������Ƚϵĳ�ʼλ��Ϊgap�����ʼgapΪn/2����һ����м俪ʼ
			for(int i = gap; i < N; i++) {
				
				//�ȴ洢�Ƚϵ���
				Comparable temp = a[i];
			   //3.���бȽ��滻�����gap���룬�����в�������
				int j;
				for(j = i; j >= gap && less(a[j],a[j - gap]); j -= gap) {
					a[j] = a[j - gap];
				}
				//���temp�ص�����С��λ����
				a[j] = temp;
			}
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
