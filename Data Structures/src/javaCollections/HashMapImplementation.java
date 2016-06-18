package javaCollections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapImplementation {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(5, "Five");
		map.put(1, "One");
		map.put(8, "Eight");
		map.put(7, "Seven");
		map.put(2, "Two");
		map.put(6, "Six");
		map.put(3, "Three");
		// Trying to add duplicate key "3" to hash map. Results in replacing the most recent value to it 
		map.put(3, "six");
		//To get a string pass the key as an input to it
		String text = map.get(3);
		System.out.println(text);
		//Iterating through map in Java. Use EntrySet
		map.remove(text);
		for(Map.Entry<Integer,String> val: map.entrySet()){
			int key = val.getKey();
			String value = val.getValue();
			System.out.println(key + ": "+value);
			/*The output is not in a sorted order. Even though you see it for the 1st time,
			 * 	the output might randomly change.		
			*/
		}

		
		
		//To Implement Sorted Maps
		
		Map<Integer,String> hashMap = new LinkedHashMap<Integer,String>();
		Map<Integer, String> treeMap = new TreeMap<Integer,String>();
		System.out.println("Iteration through LinkedHashMap");
		testMap(hashMap);
		System.out.println("Iteration through TreeMap");

		testMap(treeMap); // TreeMap returns the map in a sorted order of a key

		
		
}
	
	public static void testMap(Map<Integer,String>map){
		map.put(19, "fox");
		map.put(20, "rohan");
		map.put(1, "niki");
		map.put(4, "dog");
		map.put(89, "cat");
		map.put(9, "lion");
		
		//Iterate through the key set of a map
		for(Integer key: map.keySet()){
			System.out.println(key+ ": " + map.get(key));
		}

	}
}
