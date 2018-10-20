/*package com.algorithm4th.secondChapter.sort;

public class SortCompare {
	
	public static double time(String alg,Comparable[] a) {
		
		long start = System.currentTimeMillis();
		if(alg.equals("Insertion")) Insertion.betterSort(a);
		if(alg.equals("Selection")) Selection.sort(a);
		if(alg.equals("Shell")) Shell.sort(a);
		if(alg.equals("Merge")) Merge.sort(a);
		if(alg.equals("Quick")) Quick.sort(a);
		if(alg.equals("Heap")) Heap.sort(a);
		long now = System.currentTimeMillis();
		 double time = (now - start) / 1000;
		 return time; //��λ��s
	}
	
	//�����������ģ��.���������Doubleֵ�����������򣬲�����ָ���β��Ե���ʱ��
	//ʹ��0.0��1.0֮������Doubleֵ��������������ظ���ֵ
	public static double timeRandomInput(String alg,int N,int T) {
		//ʹ���㷨����T������ΪN����������
		double total = 0.0;
		Double[] a = new Double[N];
		for (int i = 0; i < T; i++) {
			//����һ�β���
			a[i] = StdRandom.uniform(); //?
		}
		total = total + time(alg,a);
				
		return total;
		
	}
	
	public static void main(String[] args) {
		String alg1 = args[0];
		String alg2 = args[1];
		
		int N = Integer.parseInt(args[2]); //����ΪN������
		int T = Integer.parseInt(args[3]); //��T������ΪT������
		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);
		System.out.println("��һ�������㷨��ʱ��Ϊ��" + t1);
		System.out.println("�ڶ��������㷨��ʱ��Ϊ��" + t2);
	}
	
}
*/