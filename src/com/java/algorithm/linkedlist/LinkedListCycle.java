package com.java.algorithm.linkedlist;
//141. Medium

import com.java.algorithm.utility.ListNode;

//Given a linked list, determine if it has a cycle in it.
//
//Follow up:
//Can you solve it without using extra space?
public class LinkedListCycle {
	public boolean hasCycleWithoutSpace(ListNode head){
        if(head == null || head.next == null) return false;
        while(head.next != null && head.next.next !=null){
            head = head.next;
            head.next = head.next.next;
            if(head == head.next) return true;
        }
        return false;
	}
	
	//solution with O(1) space
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) return true;
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
