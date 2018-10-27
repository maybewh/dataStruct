package com.leetcode.practice;

/**
 * 旋转链表--LeetCode第61题
 * @author admin
 *
 */
public class RotateLinkedList {
	
	
	 public ListNode rotateRight(ListNode head, int k) {
	        if(k == 0){
	            return null;
	        }
	        //1.获取到链表的长度
	        int length = 0;
	        ListNode temp = head;
	        while(temp != null){
	            length++;
	            temp = temp.next;
	        }
	        //2.k % 长度，得到开始移动元素的第一个位置，将此处的元素的next设为null，将最后一个元素的next指向head
	        ListNode tmpHead = new ListNode(0);
			tmpHead.next = head;
	        
	        ListNode fast = tmpHead;
			ListNode slow = tmpHead;
	        int m =  k % length;
	        
	        //快指针和慢指针进行操作
	        while(--m >= 0)
	            fast = fast.next; //是同一个引用，因为没有改变它的值，只进行了移动
	        while(fast.next != null){
	            fast = fast.next;
	            slow = slow.next;
	        }
	        //重新链接链表，注意置空
	        tmpHead.next = slow.next;
	        fast.next = head;
	        slow.next = null;
	        return tmpHead.next;
	    }
	 
	private class ListNode {
	  int val;
	  ListNode next;
	  ListNode(int x) { val = x; }
	} 
	
	public static void main(String[] args) {
		RotateLinkedList rll = new RotateLinkedList();
		ListNode l1 = rll.new ListNode(1);
		
		/*ListNode l2 = rll.new ListNode(2);
		l1.next = l2;
		ListNode l3 = rll.new ListNode(3);
		l2.next = l3;
		ListNode l4 = rll.new ListNode(4);
		l3.next = l4;
		ListNode l5 = rll.new ListNode(5);
		l4.next = l5;*/
		
		ListNode ll = rll.rotateRight(l1, 99);
		System.out.println(ll.val);

	}
}
