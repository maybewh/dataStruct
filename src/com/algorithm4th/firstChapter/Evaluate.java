package com.algorithm4th.firstChapter;

//���������ʽ�����������ֵ
/**
 * ˼·��ʹ������ջ��һ���洢�������һ���洢������
 *    ���������ţ����������ţ��򵯳�һ�����������Ĳ���������������Ľ��ѹ�������ջ
 *    
 *    ���Ų�����Ҫ����ջ�У������ַ������������ʽ���������� ���м��㣩
 * @author admin
 *
 */
public class Evaluate {
	
	
	//ǰ�᣺���ʽ�Ѱ�������Ҫ�� ��ֳ���Ӧ���ַ�������, �� 1��*,23��....
	public static void main(String[] args) {
		String expression = "(1+(2+3) * (4*5)))";
		
		//�����
		Stack<String> ops = new Stack<>();
		
		//������
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
