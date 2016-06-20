package javaCollections;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class RepresentComplexDataStructures {

	
	public static String[] vehicles = {"car","bike","cycle"};
	public static String[][] drivers = {
		{"niki","rohan","bullu"},
		{"bullu","sharan","moni","tilla"},
		{"mummy","daddy","appa"}
	};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Map<String,Set<String>> myMap = new HashMap<String,Set<String>>();
			

			for(int i=0;i<vehicles.length; i++){
				
				String vehicleName = vehicles[i];
				String[] equivalentDriver = drivers[i];
				
				Set<String> mySet = new LinkedHashSet<String>();
				
				for(int j=0;j<equivalentDriver.length; j++){
					mySet.add(equivalentDriver[j]);
				}
				
				myMap.put(vehicleName, mySet);			
			}	
			
			Set<String> myOutputSet  = myMap.get("cycle");
			
			for(String str: myOutputSet){
				System.out.println(str);
			}
			
			//Or if you want to get entire keyset and value set:
			
			for(Map.Entry<String, Set<String>> map: myMap.entrySet()){
				System.out.println("The key is: "+map.getKey()+" and value is: "+map.getValue());
			}
	}
	
	

}
