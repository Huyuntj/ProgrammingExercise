package com.java.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 341 Medium
 * Given a nested list of integers, implement an iterator to flatten it.

	Each element is either an integer, or a list -- whose elements may also be integers or other lists.
	
	Example 1:
	Given the list [[1,1],2,[1,1]],
	
	By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
	
	Example 2:
	Given the list [1,[4,[6]]],

	By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */
public class FlattenNestedListIterator implements Iterator<Integer> {
	 public interface NestedInteger {
		 
		 // @return true if this NestedInteger holds a single integer, rather than a nested list.
		 public boolean isInteger();
		 
		// @return the single integer that this NestedInteger holds, if it holds a single integer
		 // Return null if this NestedInteger holds a nested list
		public Integer getInteger();
		
		    // @return the nested list that this NestedInteger holds, if it holds a nested list
		 // Return null if this NestedInteger holds a single integer
		 public List<NestedInteger> getList();
		}
    private List<Integer> flattenedList;
    private Iterator<Integer> it; 
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        flattenedList = new ArrayList<Integer>();
        flatten(nestedList);
        it = flattenedList.iterator();
    }

    private void flatten(List<NestedInteger> nestedList) {
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                flattenedList.add(i.getInteger());
            } else {
                flatten(i.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return it.next();//pay attention to it here, do not call flattenedList.iterator() instead at here;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
