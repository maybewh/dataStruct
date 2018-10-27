package com.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public  class AddTwoNumber {
	
	/**
	 * 第1题，两数相加 LeetCode第一题
	 * @param l1
	 * @param l2
	 * @return ����ͷ���            50%ͨ��
	 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    	int firstNumber = 0;
    	int twoNumber = 0;
    	ListNode m = l1;
    	ListNode n = l2;
    	int i = 1;
    	while(m != null) {
    		firstNumber += m.val * i;
    		i = i * 10;
    		m = m.next;
    	}
    	int j = 1;
    	while(n != null) {
    		twoNumber += n.val * j;
    		j = j * 10;
    		n = n.next;
    	}
    	int total = firstNumber + twoNumber;
    	String t = String.valueOf(total);
    	int[] store = new int[t.length()];
    	ListNode head = new ListNode(0);
    	for (int k = 0; k < t.length(); k++) {
    		
    		int val = total % 10;
    		total = total / 10;
    		store[k] = val;
			
		}
    	
    	for (int k = store.length - 1; k >= 0 ; k--) {
    		ListNode temp = new ListNode(0);
    		temp.val = 	store[k];	
			/*if(k == 0) {
				head.val = temp.val;
				return head;
			}*/
			temp.next = head.next;
			head.next = temp;
		}
    	return head;
 
    }
    
    /**
     * sum = x + y + carry (carryΪ��λ��ֵ��0 �� 1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    	
    	ListNode head = new ListNode(0);
    	ListNode p = l1,q = l2, current = head;
    	int carry = 0;
    	while(p != null || q != null) {
    		int x = (p != null) ? p.val : 0;
    		int y = (q != null) ? q.val : 0;
    		int sum  = carry + x + y;
    		carry = sum / 10;
    		current.next = new ListNode(sum % 10);
    		current = current.next;
    		if(p != null) p = p.next;
    		if(q != null) q = q.next;
    		
    	}
    	//�Ƿ���Ҫ��һλ
    	if(carry > 0) {
    		current.next = new ListNode(carry);
    	}
    	
    	return head.next;
    }
    
    
	public static void main(String[] args) {
		
		AddTwoNumber atn = new AddTwoNumber();
		ListNode l1 = atn.new ListNode(9);
		ListNode l2 = atn.new ListNode(9);
		l1.next = l2;
		ListNode l3 = atn.new ListNode(9);
		l2.next = l3; 
		ListNode l4 = atn.new ListNode(9);
		l3.next = l4; 
		ListNode l5 = atn.new ListNode(9);
		l4.next = l5; 
		ListNode l6 = atn.new ListNode(9);
		l5.next = l6; 
		ListNode l7 = atn.new ListNode(9);
		l6.next = l7; 
		ListNode l8 = atn.new ListNode(9);
		l7.next = l8; 
		ListNode l9 = atn.new ListNode(9);
		l8.next = l9; 
		ListNode n1 = atn.new ListNode(9);
		ListNode n2 = atn.new ListNode(9);
		n1.next = n2;
		ListNode n3 = atn.new ListNode(9);
		n2.next = n3;
		ListNode n4 = atn.new ListNode(9);
		n3.next = n4;
		ListNode n5 = atn.new ListNode(9);
		n4.next = n5;
		ListNode n6 = atn.new ListNode(9);
		n5.next = n6;
		ListNode n7 = atn.new ListNode(9);
		n6.next = n7;
		ListNode n8 = atn.new ListNode(9);
		n7.next = n8;
		ListNode n9 = atn.new ListNode(9);
		n8.next = n9;
		
		ListNode ll = atn.addTwoNumbers2(l1, n1);
		ListNode lx  = ll;
		while(lx != null) {
			System.out.println(lx.val);
			lx = lx.next;
		}
	}
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	

}
