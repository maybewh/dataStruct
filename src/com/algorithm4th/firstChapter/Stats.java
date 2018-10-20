package com.algorithm4th.firstChapter;

public class Stats {
	
	public static void main(String[] args) {
		
		Bag<Double> numbers = new Bag<>();
		
		double[] array = {};
		
		//背包中对象的数量
		int n = numbers.size();
		
		double sum = 0.0;
		
		for(Double d : numbers) {
			sum += d;
		}
		double mean = sum/n;
		
		sum = 0.0;
		
		for (Double d : numbers) {
			sum += (d - mean) * (d - mean);
		}
		
		double std = Math.sqrt(sum);
	}
}
