package com.dataStruct.tree;

import java.util.Comparator;

public class MyComparator implements Comparator<HuffmanNode>{
	
	/**
	 * ÕıĞòÅÅÁĞ
	 */
	@Override
	public int compare(HuffmanNode x, HuffmanNode y) {
		// TODO Auto-generated method stub
		return x.data - y.data;
	}

}
