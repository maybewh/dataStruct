package com.algorithm4th.secondChapter.sort;


/**
 * ѡ������
 *    ˼·�������ҵ���������С���Ǹ�Ԫ�أ���Σ������������еĵ�һ��Ԫ�ؽ���λ�ã������һ��Ԫ�ؾ�����СԪ�أ���ô���ͺ��Լ�����),
 *    �ٴΣ���ʣ�µ�Ԫ�����ҵ���С��Ԫ�أ�����������ĵڶ���Ԫ�ؽ���λ�á�����������У�ֱ��������������
 *    
 * @author admin
 *
 */
public class Selection {
	
	public static void sort(Comparable[] a) {
		int N  = a.length;
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for(int j = i;j<a.length;j++) {	
				//һ�˱Ƚ��� ����Сֵ�Ƚ�
				if(less(a[j],a[min])) min = j;  //�鿴Example�е�less���Ƚ�Ԫ�ش�С
			}
			exch(a,i,min); //����λ�ã��鿴Example�е�exch
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
