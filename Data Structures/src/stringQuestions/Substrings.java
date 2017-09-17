package stringQuestions;


/*Find all substrings of a string
 * 1. Here a sorted set - TreeSet is used so that while 
 * printing all strings are printed in alphabetical order.
 * 
 * The time complexity here is O(2^n)
 * */

import java.math.BigInteger;
import java.util.Iterator;
import java.util.TreeSet;

public class Substrings {
	
	public static void main(String[] args) {
		Iterator<String> iterator = getSubstrings("wxyz").iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		/*BigInteger bi = new BigInteger("4000000");
		System.out.println(fibSum(bi));*/
		System.out.println(fibIntSum(10));
	}
	
	public static long  fibSum(BigInteger number){
		if(number.equals(0) || number.equals(1))
			return 1;
		else
			return fibSum(number.add(new BigInteger("-1"))) + fibSum(number.add(new BigInteger("-2")));
		
		
	}
	public static int  fibIntSum(int number){
		if(number==0 || number==1)
			return 1;
		else
			return fibIntSum(number-1) + fibIntSum(number - 2);
		
		
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
