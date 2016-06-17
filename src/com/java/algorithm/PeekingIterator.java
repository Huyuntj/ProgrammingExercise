package com.java.algorithm;

import java.util.Iterator;
//284. Peeking Iterator Medium
//Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
//
//Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
//
//Call next() gets you 1, the first element in the list.
//
//Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
//
//You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
//
//Hint:
//
//Think of "looking ahead". You want to cache the next element.
//Is one variable sufficient? Why or why not?
//Test your design with call order of peek() before next() vs next() before peek().
//For a clean implementation, check out Google's guava library source code.
//Follow up: How would you extend your design to be generic and work with all types, not just integer?
public class PeekingIterator<E> implements Iterator<E> {
	private Iterator<E> iterator; 
	private boolean isPeeked;
	private E peekedElement;
	public PeekingIterator(Iterator<E> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}
	public E peek(){
		if(!isPeeked){
			peekedElement = iterator.next();
			isPeeked = true;
		}
		return peekedElement;
	}
	@Override
	public boolean hasNext() {
		return isPeeked || iterator.hasNext();
	}

	@Override
	public E next() {
		if(!isPeeked) return iterator.next();
		E element = peekedElement;
		isPeeked = false;
		peekedElement = null;
		return element;
	}

}
