package javaCollections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListImplementation {
	
	private static void takeInAnyListInput(String type, List<Integer> myList){
		for(int i=0; i<1E5; i++){
			//1E5 ==> 100,000 items 
			// Calculating the timings necessary for add/remove into a linkedList and ans arrayList
			myList.add(i);
		}
		
		long start = System.currentTimeMillis();
		
		//Adding elements at the end of the list
		/*for(int i=0; i<1E5 ; i++){
			myList.add(i); // Here the arrayList took less time to add at the end of the list than the linked list
			//The soln for  running this was - arrayList - 2ms and linkedList- 3ms
		}*/
		
		//Add items elsewhere in a list
		for(int i=0;i <1E5; i++){
			myList.add(0,i);//// Here the arrayList took more  time to add at the beginning or anywhere in
			//the list than the linked list
			//The soln for  running this was:
			//Time taken: 1419 ms for ArrayList
			//Time taken: 3 ms for LinkedList
		}
		//Adding an element in the near end of a list in ArrayList is more fatser than adding it in linked list.
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken: "+ (end-start)+ " ms for " + type);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> myLinkedList = new LinkedList<Integer>();
		List<Integer> myArrayList = new ArrayList<Integer>();
		
		// Here we can see that List interface is defined as an argument in the method takeInAnyListInput
		// So wen either send arrayList input or linkedList input to it//
		
		takeInAnyListInput("ArrayList", myArrayList);
		takeInAnyListInput("LinkedList" , myLinkedList);
		
		
	}
 
}
