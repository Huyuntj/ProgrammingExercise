package com.java.algorithm.linkedlist;

public class AddTwoNumbersWithLinkedList {

	   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	       
	        if(l1== null&& l2== null) return null;
	        if(l1 == null) return l2;
	        if(l2 == null) return l1;
           ListNode head = l1;
           ListNode pre = head;
           int count = 0;
           int val;
           while(l1!=null && l2!=null){
               val = (l1.val + l2.val + count)%10;
               count  = (l1.val + l2.val + count)/10;
               l1.val = val;
               pre = l1;
               l1 = l1.next;
               l2 = l2.next;
           }
           
           if(l2!=null){
        	   l1 = l2;
               pre.next = l1;
           }
           
           while(l1!= null && count >0){
               val =(l1.val + count)%10;
               count = (l1.val + count)/10;
               l1.val = val;
               pre = l1;
               l1 = l1.next;
           }

	        //last digit has a carry
	        if(count != 0){
	            ListNode node = new ListNode(count);
	            pre.next = node;
	        }
	        return head;
	    
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbersWithLinkedList list = new AddTwoNumbersWithLinkedList();
		ListNode l1 = new ListNode(9);		
		ListNode l12 = new ListNode(8);
//		ListNode l13 = list.new ListNode(1);
		ListNode l2 = new ListNode(1);		
		ListNode l22 = new ListNode(4);
		l1.next = l12;
//		
//		l2.next = l22;
//		l22.next = l13;
//		ListNode l = list.addTwoNumbers(l1, l2);
//		while(l!=null){
//			System.out.print(l.val +"->");
//			l = l.next;
//		}
		String s1 = "aab";
		String s2 = "aac";
		System.out.println();
	}

}
