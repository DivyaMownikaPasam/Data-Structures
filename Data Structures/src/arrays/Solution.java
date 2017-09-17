package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	/*The following function finds the common elements between any two arrays*/
	public static List<Integer> findCommonElements(int[] arr1, int[] arr2){
		
		List<Integer> resultList = new ArrayList<Integer>();
		Set<Integer> mySet = new HashSet<Integer>();
		
		for(int i=0; i<arr1.length;i++){
			mySet.add(arr1[i]);
		}
		
		for(int i=0; i<arr2.length; i++){
			if(mySet.contains(arr2[i])){
				resultList.add(arr2[i]);
			}else{
				continue;
			}
		}
		if(resultList.size() == 0)
			System.out.println("No Common Elements found between the 2 arrays");
		return resultList;
		
	}
	
	/*The following function finds the first unique character in a string*/
	public static Character firstUniqueCharacter(String str){
		Set<Character> repeating = new HashSet<Character>();
		List<Character> nonRepeating = new ArrayList<Character>();
		str = str.toLowerCase();
		for(int i=0; i< str.length(); i++){
			char c = str.charAt(i);
			if(repeating.contains(c)){
				continue;
			}
			if(nonRepeating.contains(c)){
				nonRepeating.remove((Character)c);
				repeating.add(c);
			}else{ 
				nonRepeating.add(c);
			}			
		}
		
		if(nonRepeating.size() == 0)
			return null;
		else{
			return nonRepeating.get(0);
		}
	}
	
	/* The following is the function that takes an array of numbers and returns the greatest difference
	 * It assumes that the the number present on the right side is greater than the one on the left*/
	public static int maxDifference(int[] arr){
		int min = arr[0];
		int maxDiff = Integer.MIN_VALUE;		
		for(int i=1; i<arr.length; i++){
			int diff = arr[i] - min;
			
			if(diff > maxDiff){
				maxDiff = diff;				
			}
			if(arr[i] < min){
				min = arr[i];				
			}			
		}
		
		return maxDiff;
	}	
	
	public static void main(String[] args) {
		
		/*Driver Program for finding common elements*/
		int[] arr1 = {1,2,3,4,5};
		int[]arr2 = {2,1,10,20};
		
		Iterator<Integer> listItr = findCommonElements(arr1,arr2).listIterator();
		System.out.println("The common elements are: ");
		while(listItr.hasNext()){
			System.out.print(listItr.next()+" ");
		}
		System.out.println(" ");
		
		/*Driver Program to find first unique character in a String*/
		System.out.println("The first unique character is: ");
		System.out.println(firstUniqueCharacter("Memory"));
		
		/*Driver Program for max difference*/
		System.out.println("The max difference is: ");
		int arr[] = {1000,10,2,100,12,500,1};
		System.out.println(maxDifference(arr));
		
	}

}
