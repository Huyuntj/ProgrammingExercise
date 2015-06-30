package com.java.algorithm;

public class ReverseLinkedList {
	/**
	 * Definition for singly-linked list.

	 */

	public static ListNode reverseLinkedlist(ListNode head){
		ListNode p = null;
		if(head != null){
			ListNode q = head;
			while(q != null){
				ListNode r = q.next;
				q.next = p;
				p = q;
				q = r;			
			}
		}
		return p;
		
	}
	public static void main(String[] args) {
		ReverseLinkedList rll = new ReverseLinkedList();
		ListNode node1 = rll.new ListNode(1);
		ListNode node2 = rll.new ListNode(2);
		ListNode node3 = rll.new ListNode(3);
		ListNode node4 = rll.new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;
		
		ListNode head = ReverseLinkedList.reverseLinkedlist(node1);
		while(head != null){
			System.out.print(head.val +" -> ");
			head = head.next;
		}
		

	}
	 public class ListNode {
	      int val;
	      ListNode next;
	      public ListNode(int x) { val = x; }
	 }	
}
