package miscCodingQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class FiveDiceProblem {
/*Implementing the following:
 * 1. Ones, Twos, ... Eights
 * 2. Small Straight -- 4 dice in sequence; score is 30 or 0
 * 3. AllDifferent -- all 5 dice have different values, score is 40 or 0
 * 4. AllSame -- all 5 dice have same value, score is 50 or 0
 * 
 */
	private  HashMap<String,Integer> categoryScoreMap = new HashMap<String, Integer>();   

	public  int scoreForParticularCategory(String category){
		if(categoryScoreMap.containsKey(category))
			return categoryScoreMap.get(category);
		else
			return 0;
	}
	
	public int highestScore(){
		int max=0;
		for(String category: categoryScoreMap.keySet()){
			if(categoryScoreMap.get(category) > max)
				max = categoryScoreMap.get(category);
		}
		return max;
	}
	
	public void calculateAllScores(int []arr){
		if(arr.length != 5)
			System.out.println("There is a missing dice value. There are only "+ arr.length +"values instead of 5");
		
		categoryScoreMap.put("Ones",calculateIndividualValues(arr, 1));
		categoryScoreMap.put("Twos",calculateIndividualValues(arr, 2));
		categoryScoreMap.put("SmallStraight",calculateSmallStraight(arr));
		categoryScoreMap.put("AllDifferent",calculateAllDifferent(arr));
		categoryScoreMap.put("AllSame",calculateAllSame(arr));
	}
		
	public int calculateIndividualValues(int []arr, int diceNumber){
		HashMap<Integer,Integer> diceNumbersToCountMap = new HashMap<Integer, Integer>();
		calculateDataValues(arr, diceNumbersToCountMap);
		if (diceNumbersToCountMap.containsKey(diceNumber))
			return diceNumbersToCountMap.get(diceNumber) * diceNumber;
		else
			return 0;
	}
private HashMap<Integer,Integer> calculateDataValues(int []arr, HashMap<Integer,Integer> diceNumbersToCountMap){
	for(int i=0; i<arr.length; i++){
		if(!diceNumbersToCountMap.containsKey(arr[i])){
			diceNumbersToCountMap.put(arr[i], 1);				
		}else{
			int value = diceNumbersToCountMap.get(arr[i]);
			diceNumbersToCountMap.put(arr[i], ++value);
		} 
	}
	return diceNumbersToCountMap;
}
	private int calculateAllDifferent(int[] arr) {
		HashSet<Integer> checkDuplicateValues = new HashSet<Integer>();
		for(int i=0; i<arr.length; i++){
			if(!checkDuplicateValues.contains(arr[i])){
				checkDuplicateValues.add(arr[i]);				
			}else{
				return 0;
			}
		}
		return 40;
	}
	
	private int calculateSmallStraight(int[] arr) {
		ArrayList<Integer> list = new ArrayList<Integer>(arr.length);
		for(int i=0; i<arr.length; i++)
			list.add(arr[i]);
		Collections.sort(list);
		int count =0;
		int j=0;
		for(int i=0; i< list.size()-1; i++){
			j=i+1;
			if((list.get(j)- list.get(i) > 1)|| (list.get(j)- list.get(i) == 0)){
				count++;
			}
			if(count >1)
				return 0;
		}
		return 30;
	}
	
	private int calculateAllSame(int[] arr) {
		HashMap<Integer,Integer> diceNumbersToCountMap = new HashMap<Integer, Integer>();
		calculateDataValues(arr, diceNumbersToCountMap);
		for(Integer i: diceNumbersToCountMap.keySet()){
			if(diceNumbersToCountMap.get(i) == 5)
				return 50;
		}
		return 0;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FiveDiceProblem problem1 = new FiveDiceProblem();
		int[] arr1= {1,2,3,4,6};
		problem1.calculateAllScores(arr1);
		System.out.println("Calculate score for Small Straight: "+  problem1.scoreForParticularCategory("SmallStraight"));
		System.out.println("Calculate highest score: "+  problem1.highestScore());
		
		FiveDiceProblem problem2 = new FiveDiceProblem();
		int[] arr2= {1,1,3,4,6};
		problem2.calculateAllScores(arr2);
		System.out.println("Calculate score for Small Straight: "+  problem2.scoreForParticularCategory("SmallStraight"));
		System.out.println("Calculate highest score: "+  problem2.highestScore());
	}

}
