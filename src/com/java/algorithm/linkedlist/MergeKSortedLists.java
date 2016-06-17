package com.java.algorithm.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.java.algorithm.utility.ListNode;

//23 Merge k sorted lists Hard
//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue(lists.length,new PriorityQueueComparator());
        for(ListNode node : lists){
        	pq.add(node);
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(pq != null){
        	ListNode node = pq.poll();
        	if(node.next != null) pq.add(node.next);
        	cur.next = node;
        	cur = cur.next;
        }
        return head.next;
    }

    public class PriorityQueueComparator implements Comparator<ListNode> {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			return o1.val - o2.val;// max heap
		}
    	
    }
    
    public class IntegerComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1 - o2;
		}
    	
    }
    public ListNode mergeKListsCommon(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        ListNode l1 = lists[0];
        for(int i = 1; i<lists.length; i++){
            l1 = mergeTwoLists(l1, lists[i]);
        }
        return l1;
    }
        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null ) return l2;
        if(l2 == null ) return l1;
        ListNode head = l1.val <= l2.val ? l1 : l2;
        ListNode temp = head;
        if(head == l1){
            l1 = l1.next;
        }else{
            l2 = l2.next;
        }
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
        }
        if(l1 == null && l2 != null) temp.next = l2;
        if(l2 == null && l1 != null) temp.next = l1;
        
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l11 = new ListNode(1);
		ListNode l12 = new ListNode(5);
		l11.next = l12;
		
		ListNode l21 = new ListNode(4);
		ListNode l22 = new ListNode(7);
		l21.next = l22;
		
		ListNode l31 = new ListNode(2);
		ListNode l32 = new ListNode(3);
		l31.next = l32;
		ListNode[] lists = {l11,l21,l31};
		MergeKSortedLists merge = new MergeKSortedLists();
//		ListNode head = merge.mergeKLists(lists);
//		while(head !=  null){
//			System.out.print(head.val + "->");
//			head = head.next;
//		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(merge.new IntegerComparator());
		int[] a = {3, 2 , 5, 1, 4};
		for(int i : a){
			pq.add(i);
		}
		while(pq.size() > 0){
			System.out.println(pq.poll());
			
		}
	}

}
