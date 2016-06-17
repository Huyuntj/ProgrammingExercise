package com.java.algorithm.linkedlist;

import java.util.ArrayDeque;

import com.java.algorithm.utility.ListNode;

//234 Easy
//Given a singly linked list, determine if it is a palindrome.
//
//Follow up:
//Could you do it in O(n) time and O(1) space?
public class PalindromeLinkedList {

	//O(n) time and O(1) space solution
	public boolean isPalindrome(ListNode head) {
	       if(head == null || head.next == null) return true;
//	        if(head.next.next == null) return head.val == head.next.val; 
	        
	        ListNode slow = head;
	        ListNode fast = head;        
	        while(fast.next!=null&& fast.next.next !=null){
	            fast = fast.next.next;
	            slow = slow.next;
	        }
	        ListNode secondHead = slow.next;
	        slow.next = null;
	        
	        ListNode p1 = secondHead;
	        ListNode p2 = p1.next;

	        while(p1 != null && p2 !=null){
	            ListNode tmp = p2.next;
	            p2.next = p1;
	            p1 = p2;
	            p2 = tmp;
	        }
	        secondHead.next = null;
	        ListNode p = p1;
	        ListNode q = head;
	        //fast is the new head of the later half 
	        while(p != null){
	            if(p.val != q.val) return false;
	            p = p.next;
	            q = q.next;
	        }
	        return true;		
	}
	//O(n) time complexity and O(n) space 
	public boolean isPalindrome2(ListNode head){
		if(head == null || head.next == null) return true;
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next !=null ){
			fast = fast.next.next;
			slow = slow.next;
		}
		ArrayDeque<ListNode> queue = new ArrayDeque();
		ListNode tail = slow.next;
		while(tail != null){
			queue.push(tail);
			tail = tail.next;
		}
		while(!queue.isEmpty()){
			tail = queue.pop();
			if(tail.val != head.val) return false;
			head = head.next;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
