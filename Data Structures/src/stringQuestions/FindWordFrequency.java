package stringQuestions;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * The folowing function determines word frequency in a sentence;
 * This is done first by getting the words in a string array.
 * Put them into a HashMap by incrementing the count
 * Now add this HashMap to a linkedlist so that we can sort it using Collections framework and implement a Comparator
 * Iterating over the list will now give us the key and value in ascending/descending order based on comparator output
 * 
 */

public class FindWordFrequency {

	public static void printWordFrequencyDescendingOrder(String string){
		
		Map<String,Integer> myMap = new HashMap<String, Integer>();		
		String[] strArray = string.replaceAll("[^a-zA-Z ]","").split("\\s+");		
		
		for(String s: strArray){
			if(myMap.containsKey(s)){
				int count = myMap.get(s);
				count++;
				myMap.put(s,count);
			}
			else{
				myMap.put(s,1);
			}			
		}
		
		
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String,Integer>>(myMap.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String, Integer>>(){

			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return -(o1.getValue()).compareTo(o2.getValue());
			}
		});
		
		
		for(Map.Entry<String,Integer> map : list){			
			System.out.println(map.getKey()+ ": " + map.getValue());
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "This is a repeated sentence. This is madness. This is creepy. Why is it dark?";
		printWordFrequencyDescendingOrder(str);
		
		
	}

}
