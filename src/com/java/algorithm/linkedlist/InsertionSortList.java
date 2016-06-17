package com.java.algorithm.linkedlist;

import com.java.algorithm.utility.ListNode;

public class InsertionSortList {
//	147 Insertion Sort List Medium
//	Sort a linked list using insertion sort.
//
//	Show Tags
//	Show Similar Problems
    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode p = head;
        ListNode q = head.next;
        while(q != null){
            if(p.val <= q.val){
                p = q;
                q = q.next;
            }else{
                ListNode prevQ = q;
                q = q.next;
                p.next = q;
                ListNode pp = head; 
                ListNode prev = null;
                while(pp.val <= prevQ.val){
                    prev = pp;
                    pp = pp.next;
                }
                prevQ.next = pp;
                if(pp == head){
                    head = prevQ;
                }else{
                    prev.next = prevQ;
                }
            }
        }
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		l1.next = l2;
		System.out.println(InsertionSortList.insertionSortList(l1).val);
	}

}
