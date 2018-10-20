package com.algorithm4th.firstChapter;

//由算数表达式，计算出最后的值
/**
 * 思路：使用两个栈，一个存储运算符，一个存储操作数
 *    忽略左括号，遇到右括号，则弹出一个所需数量的操作数，并将运算的结果压入操作数栈
 *    
 *    括号并不需要存入栈中，根据字符串（算数表达式的右括号来 进行计算）
 * @author admin
 *
 */
public class Evaluate {
	
	
	//前提：表达式已按照运算要求 拆分成相应的字符串数组, 如 1，*,23，....
	public static void main(String[] args) {
		String expression = "(1+(2+3) * (4*5)))";
		
		//运算符
		Stack<String> ops = new Stack<>();
		
		//操作数
		Stack<Double> vals = new Stack<>();
		
		String[] exps = {};
		
		for (String c : exps) {
			
			if(c.equals("(")) ;
			else if( c.equals("+")) ops.push(c);
			else if(c.equals("-")) ops.push(c);
			else if(c.equals("*")) ops.push(c);
			else if(c.equals("/")) ops.push(c);
			else if(c.equals(")")) {
				String op = ops.pop();
				Double b = vals.pop();
				if(c.equals("+")) b = b + vals.pop();
				else if(c.equals("-")) b = b - vals.pop();
				else if(c.equals("*")) b = b * vals.pop();
				else if(c.equals("/")) b = b / vals.pop();
			}else {
				vals.push(Double.parseDouble(c));
			}
		}
	}
	
	
}
