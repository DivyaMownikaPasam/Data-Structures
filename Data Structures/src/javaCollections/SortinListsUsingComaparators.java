package javaCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Persons{

	int id;
	String name;
	
	public Persons(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString(){
		return  name;
	}
}
class StringLengthComparator implements Comparator<String>{

	
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1 == len2)		
			return 0;
		else if(len1 > len2)
			return 1;
		else
			return -1;
	}
	
}


class alphabeticalComparator implements Comparator<String>{

	public int compare(String s1, String s2) {
		return - s1.compareTo(s2); // First sort it in natural order
	}
	
}

public class SortinListsUsingComaparators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> names = new ArrayList<String>();
		names.add("niki");
		names.add("neeraj");
		names.add("thilak");
		names.add("sharan");
		names.add("monish");

		//Sort this list in alphabetical order using comparators
		/*
		 * The following method for using Collections.sort gives the output in a natural order 
		 * */
		Collections.sort(names);
		
		for(String name:names){
			System.out.println(name);
		}
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(56);
		numbers.add(23);
		numbers.add(4);
		numbers.add(89);
		numbers.add(1);
		
		Collections.sort(numbers);
		for(Integer number:numbers){
			System.out.println(number);
		}

		
		/*
		 * To Sort a list other than a natural order, you need to use the Comparator class*/
		
		List<String> names2 = new ArrayList<String>();
		names2.add("niki");
		names2.add("neeraj");
		names2.add("thilak");
		names2.add("sharan");
		names2.add("monish");
		Collections.sort(names2,new StringLengthComparator());
		
		System.out.println("This is after string length comparison");
		
		for(String name: names2){
			System.out.println(name);
		}
		
		/*
		 * To Sort using reverse alphabetical order
		 * */
		
		List<String> names3 = new ArrayList<String>();
		names3.add("niki");
		names3.add("neeraj");
		names3.add("thilak");
		names3.add("sharan");
		names3.add("monish");
		Collections.sort(names3,new alphabeticalComparator());
		
		System.out.println("This is reverse sorting using alphabetical order comparison");
		
		for(String name: names3){
			System.out.println(name);
		}
		
		
		/**For numbers you can just do the following:
		 * /
		 */
		
		List<Integer> numbers2 = new ArrayList<Integer>();
		numbers2.add(56);
		numbers2.add(23);
		numbers2.add(4);
		numbers2.add(89);
		numbers2.add(1);
		
		Collections.sort(numbers2, new Comparator<Integer>(){

			public int compare(Integer int1, Integer int2) {
				// TODO Auto-generated method stub
				// You can also write it using the compareTo method as well and return the negative 
				//value of that like done in the string example above
				if(int1 == int2)
					return 0;
				else if(int1 > int2)
					return -1;
				else
					return 1;
			}	
			
		});
		
		System.out.println("Print Numbers in Reverse sorted order");
		for(Integer number: numbers2){
			System.out.println(number);
		}
		
		
		///////////////////////Sorting arbitrary Objects//////////////////////////////
		Persons p1 = new Persons(1,"niki");
		Persons p2 = new Persons(6,"rohan");
		Persons p3 = new Persons(7,"neeraj");
		Persons p4 = new Persons(3,"thilak");
		Persons p5 = new Persons(4,"sharan");
		Persons p6 = new Persons(5,"monish");
		
		List<Persons> myPersonList = new ArrayList<Persons>();
		myPersonList.add(p1);
		myPersonList.add(p2);
		myPersonList.add(p3);
		myPersonList.add(p4);
		myPersonList.add(p5);
		myPersonList.add(p6);
		
		Collections.sort(myPersonList, new Comparator<Persons>() {
			public int compare(Persons p1, Persons p2) {
				// TODO Auto-generated method stub
				Integer p1Id = p1.id;
				Integer p2Id = p2.id;
				return p1Id.compareTo(p2Id);
			}		
		});
		System.out.println("Printing names from a custom object in a sorted fashion based on their Id");
		for(Persons p: myPersonList){
			System.out.println(p.name);
		}
		
	}
	

}
