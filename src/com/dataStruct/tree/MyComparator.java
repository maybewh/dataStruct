package com.dataStruct.tree;

import java.util.Comparator;

public class MyComparator implements Comparator<HuffmanTree>{
	
	/**
	 * ÕıĞòÅÅÁĞ
	 */
	@Override
	public int compare(HuffmanTree x, HuffmanTree y) {
		// TODO Auto-generated method stub
		return x.data - y.data;
	}

}
