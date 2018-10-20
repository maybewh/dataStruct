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
		 return time; //单位：s
	}
	
	//随机数组输入模型.生成随机的Double值，将它们排序，并返回指定次测试的总时间
	//使用0.0到1.0之间的随机Double值，几乎不会产生重复的值
	public static double timeRandomInput(String alg,int N,int T) {
		//使用算法，将T个长度为N的数组排序
		double total = 0.0;
		Double[] a = new Double[N];
		for (int i = 0; i < T; i++) {
			//进行一次测试
			a[i] = StdRandom.uniform(); //?
		}
		total = total + time(alg,a);
				
		return total;
		
	}
	
	public static void main(String[] args) {
		String alg1 = args[0];
		String alg2 = args[1];
		
		int N = Integer.parseInt(args[2]); //长度为N的数组
		int T = Integer.parseInt(args[3]); //有T个长度为T的数组
		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);
		System.out.println("第一个排序算法的时间为：" + t1);
		System.out.println("第二个排序算法的时间为：" + t2);
	}
	
}
*/