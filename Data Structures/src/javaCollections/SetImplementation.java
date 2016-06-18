package javaCollections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> mySet = new HashSet<String>();
		Set <String> myTreeSet = new TreeSet<String>();
		Set <String> myLinkedHashSet = new LinkedHashSet<String>();

		mySet.add("fox");
		mySet.add("rohan");
		mySet.add("niki");
		mySet.add("dog");
		mySet.add("cat");
		mySet.add("lion");
		
		//Adding duplicate elements:
		mySet.add("dog"); // It has no effect

		//Sets can be printed through a normal syso as follows:
		System.out.println("HashSet:");
		System.out.println(mySet);
		
		
		// Add elements to tree set
		
		myTreeSet.add("fox");
		myTreeSet.add("rohan");
		myTreeSet.add("niki");
		myTreeSet.add("dog");
		myTreeSet.add("cat");
		myTreeSet.add("lion");
		
		System.out.println("TreeSet:");
		System.out.println(myTreeSet);
		
		// Add elements to linkedHashSet 
		
		myLinkedHashSet.add("fox");
		myLinkedHashSet.add("rohan");
		myLinkedHashSet.add("niki");
		myLinkedHashSet.add("dog");
		myLinkedHashSet.add("cat");
		myLinkedHashSet.add("lion");
				
		System.out.println("TreeSet:");
		System.out.println(myLinkedHashSet);
		
		// Iterate through Sets
		System.out.println("Iterate through sets");
		for(String str:myLinkedHashSet){
			System.out.print(str+ " ");
		}
		System.out.println("");
		//To check if a set has a certain element in it		
		System.out.println(myLinkedHashSet.contains("fox"));
		
		//Intersection in Sets
		Set <String> myLinkedHashSet2 = new LinkedHashSet<String>();//Set 2 here consists of some common elements with myLinkedHashSet
		myLinkedHashSet2.add("fox");
		myLinkedHashSet2.add("gorilla");
		myLinkedHashSet2.add("giraffe");
		myLinkedHashSet2.add("monkey");
		myLinkedHashSet2.add("cat");
		myLinkedHashSet2.add("lion");
		
		//To find which elements are common in both the sets:
		
		Set<String>intersection = new LinkedHashSet<String>(myLinkedHashSet);//First make a copy of first set
		intersection.retainAll(myLinkedHashSet2); // "retainAll" gives the common elements between 2 sets
		System.out.println("The common elements are:");
		System.out.println(intersection);
		
		//To find elements in set 1 that are not in set 2 
		Set<String>difference = new LinkedHashSet<String>(myLinkedHashSet);//First make a copy of first set
		difference.removeAll(myLinkedHashSet2);
		System.out.println("The unique elements are:");
		System.out.println(difference);
	}

}
