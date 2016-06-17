package com.java.algorithm.utility;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
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
