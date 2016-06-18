package javaCollections;

import java.util.ArrayList;

public class ArrayListImplementation {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		//Adding & retrieving the numbers in a array list
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);	
		System.out.println(numbers.get(0));
		
		//Traverse through an array list
		System.out.println("Iteration 1");
		for(int i=0;i< numbers.size();i++){
			System.out.println(numbers.get(i));
		}
		
		System.out.println("Iteration 2");
		for(Integer value:numbers){
			System.out.println(value);
		}
		
		//Removing items from list
		//Specify the index you want to remove from the list
		// Removing elements from the end of the arraylist is more faster than removing them from the beginning
		// This is becoz, removing from end just decrements the size of the list
		//But removing from beginning means the element is removed from the list and remaining elements are copied to the 
		//new location. == > Process is very slow
		
		numbers.remove(numbers.size()-1);
		System.out.println("Iteration 3");
		for(Integer value:numbers){
			System.out.println(value);
		}
		
		
	}

}
