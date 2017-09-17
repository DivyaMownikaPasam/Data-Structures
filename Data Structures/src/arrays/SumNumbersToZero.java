package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Write a program to find all combinations of three numbers that sum to zero.
 * 
 * Sample input: {2, 3, 1, -2, -1, 0, 2, -3, 0};
 * 
 * Sample output: 2, -2, 0
 * 					1, -1, 0
 * 					3, -2, -1
 * 					3, 0, -3
 * 					3, 0, -3
 *  
 */
public class SumNumbersToZero {
	
	//The following solution gives the pairs of numbers array that sum to ANY given number.
	// Also known as TWOSum - This is O(N) solution.
	public static  Set<List<Integer>> sumOfTwoNumbers(int[] arr, int sum){		
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		Set<Integer> mySet = new HashSet<Integer>();
		for(int i=0; i<arr.length; i++){
			int temp = sum - arr[i];
			
			if(!mySet.contains(temp)){
				mySet.add(arr[i]);
			}
			else{
				List<Integer> list = new ArrayList<Integer>();
				list.add(arr[i]);
				list.add(temp);
				set.add(list);
			}			
		}
		return set;		
	}
	
	//The following solution returns all triplets of numbers array that sum to ZERO.
	//Also known as ThreeSum - This solution is of O(N^2)
	public static Set<List<Integer>> sumOfThreeNumbers(int [] arr){
		Set<List<Integer>> threeSumSet = new HashSet<List<Integer>>();
		
		 Map<Integer, int[]> map = new HashMap<Integer, int[]>();
	        for (int i = 0; i <arr.length;i++) {
	            map.clear();
	            for (int j = i + 1; j < arr.length; j++) {
	                if (!map.containsKey(arr[j])) {
	                	 map.put(-arr[i] - arr[j], new int[]{arr[i], arr[j]});
	                } else{
	                	 int[] pair = map.get(arr[j]);
	                     List<Integer> list = new ArrayList<Integer>();
	                     list.add(pair[0]);
	                     list.add(pair[1]);
	                     list.add(arr[j]);
	                     threeSumSet.add(list);
	                }            
	            }
	        }
	        
		return threeSumSet;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numbers[] = {2, 3, 1, -2, -1, 0, 2, -3, 0};
		System.out.println("The 2 sum pairs are as follows: ");
		Set<List<Integer>> mySet = sumOfTwoNumbers(numbers,0);
		System.out.println(mySet);
		System.out.println("The 3 sum pairs are as follows: ");
		mySet = sumOfThreeNumbers(numbers);
		System.out.println(mySet);
	}

}
