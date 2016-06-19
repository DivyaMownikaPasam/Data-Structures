package javaCollections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorsImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List <String> list = new LinkedList<String>();
		list.add("niki");
		list.add("rohan");
		list.add("bullu");

		// Modern iteration - Java 5 and later
		System.out.println("Use of for each loop:");
		for(String i: list){
			System.out.println(i);
		}
		
		System.out.println("Use of iterator:");
		Iterator<String> i = list.iterator();

		
		while(i.hasNext())
		{
			String str = i.next();
			if(str.equals("rohan")){
				i.remove();
			}
			System.out.println(str);
		}
		
		System.out.println("List after removal: ");
		 i = list.iterator();
		while(i.hasNext())
		{
			String str = i.next();			
			System.out.println(str);
		}
	}

}
