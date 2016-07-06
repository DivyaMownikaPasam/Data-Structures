package stringQuestions;


/*Find all substrings of a string
 * 1. Here a sorted set - TreeSet is used so that while 
 * printing all strings are printed in alphabetical order.
 * 
 * The time complexity here is O(2^n)
 * */

import java.util.Iterator;
import java.util.TreeSet;

public class Substrings {
	
	public static void main(String[] args) {
		Iterator<String> iterator = getSubstrings("wxyz").iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	public static TreeSet<String> getSubstrings(String str){
		TreeSet<String> treeSet = new TreeSet<String>();
		
		if(str != null && str.length() != 0){
			getAllStrings("",str,treeSet);
		}
		return treeSet;
	}

	public static void getAllStrings(String prefix, String rest, TreeSet<String>set){
		
		if(rest.length() == 0){
			if(prefix.trim().length() != 0){
				set.add(prefix);
			}
		}
		else{
			getAllStrings(prefix + rest.charAt(0), rest.substring(1), set);
			getAllStrings(prefix, rest.substring(1), set);
		}
	}
}
