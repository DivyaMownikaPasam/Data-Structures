package arrays;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class KFrequentlyOccuringelements{

	 public static class KeyValue{
		Integer key;
		Integer value;	
		
		public KeyValue(Integer key, Integer value){
			this.key = key;
			this.value = value;
		}
	}
	
	public static ArrayList<Integer>kFreqOccurringElements(int[] arr, int k){
		Map<Integer, Integer> myMap = new LinkedHashMap<Integer, Integer>();
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		
		for(int i: arr){
			if(myMap.containsKey(i)){
				int value = myMap.get(i);
				myMap.put(i,++value);				
			}
			else{ 
				myMap.put(i, 1);
			}
		}
		
		//Min Heap Implementation
		PriorityQueue<KeyValue> q = new PriorityQueue<KeyValue>(k, new Comparator<KeyValue>(){	
			public int compare(KeyValue o1, KeyValue o2) {
				//return  o1.value.compareTo(o2.value);				
				return  o1.value - (o2.value);	
			}			
		});
		
		for(Map.Entry<Integer, Integer>map: myMap.entrySet()){
			KeyValue kv = new KeyValue(map.getKey(),map.getValue());
			q.offer(kv);
			if(q.size() > k){
				q.poll();
			}			
		}
		
		for(int i=0; i<k; i++){
			resultList.add(q.poll().key);
		}
		
		 Collections.reverse(resultList);
		 return resultList;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr ={1,2,100,3,1,4,5,6,100,1};
		int k = 3;
		Iterator<Integer> itr = kFreqOccurringElements(arr,k).iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}


}
