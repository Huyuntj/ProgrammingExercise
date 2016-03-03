package com.java.algorithm.linkedlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public String toString(){
  	  ListNode cur = this;
  	  StringBuilder sb = new StringBuilder();
  	  while(cur !=  null ){
  		  sb.append(val + "->");
  		  cur = cur.next;
  	  }
  	  return sb.toString();
    }
}
