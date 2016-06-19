package javaCollections;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueuesImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue<Integer> q = new ArrayBlockingQueue<Integer>(3);
		//It has a max of 3 items in it
		
		q.add(10);
		q.add(20);
		q.add(30);
		
		try {
			q.add(40);
		} catch (IllegalStateException e) {
			// TODO: handle exception
			System.out.println("Tries to add too many items to the queue");
		}
		
		// To get head of the queue you can use q.element()==> similar to peek()
		System.out.println("Head of queue is : "+q.element());

		System.out.println("Queue is as follows: ");
		for(Integer i:q){
			System.out.println(i);
		}
		System.out.println("The removed value is :");
		Integer val = q.remove();
		System.out.println(val);
		
		/*
		 * add- adds an element to the queue
		 * 		if the queue is full, returns a IllegalStateException if you tryto add more elements.
		 * offer- Also adds elements to the queue. it returns false if the queue is full an does not add the additional 
		 * 		elements to the queue and no exception is given.
		 *  	  But you can use it as if(q.offer(e) == true){
		 *  									q.offer	(e);	
		 * 						}
		 * 
		 * remove - removes the element from  the head of the queue. If queue is emopty and you try to remove from it, 
		 * 			you get a NoSuchElementException thrown
		 * poll - also removes the element from the head of the queue. If the queue is empty, it prints "null" 
		 * 			when we try to remove the element.
		 * 
		 * element() -- Returns the HEAD element value from the queue. If queue is empty and you try to call element()
		 * 				you would get a NoSuchElementException
		 * peek() -- Returns the HEAD element value for the queue. If queue is empty and try to peek, you get a null
		 * 			printed with no exception.
		 *  
		 */
		 
	
		
	}
}
