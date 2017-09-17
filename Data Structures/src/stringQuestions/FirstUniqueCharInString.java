package stringQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/*The following code finds the first unique character in a given String*/
public class FirstUniqueCharInString {

	
	/*The following method does the required job by traversing thru string and the map*/
	public static Character findFirstUnique(String string){
		
		Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		//string = string.toLowerCase();
		for(int i=0; i<string.length();i++){
			char c = string.charAt(i);
			
			if(map.containsKey(c)){
				/*The following is one way of doing it. But when strings are large you unnecessarily 
				 * add the chars that you don't need
				 * Instead you can remove those chars*/
				
				/*int val = map.get(c);
				val++;
				map.put(c, val);*/ 
				map.remove(c);
			}
			else{
				map.put(c,1);
			}
		}
		
		
	
		
		/*for(Entry<Character, Integer> myMap:map.entrySet()){
			//System.out.println(myMap.getKey()+ " : " + myMap.getValue());
			if(myMap.getValue() == 1)
				return myMap.getKey();
		}
		*/
		
		for(char c: map.keySet()){
			return c;
		}
		
		
		return null; // If no char is repeating, then send 0;
	}
	
	/*The following method does the needed job in just one pass but we have to compromise on Space Complexity*/
	
	public static Character firstUniqueCharac2(String string){
		
		//string = string.toLowerCase();
		Set<Character> repeating = new HashSet<Character>();
		List<Character> nonRepeating = new ArrayList<Character>();
		
		
		for(int  i=0; i<string.length(); i++){
			
			char c = string.charAt(i);
			
			if(repeating.contains(c)){
				continue;				
			}
			if(nonRepeating.contains(c)){
				nonRepeating.remove((Character)c);
				repeating.add(c);
			}
			else{
				nonRepeating.add(c);
			}
		}
		
		if(nonRepeating.size() == 0)
			return null;
		else			 
			return nonRepeating.get(0);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "i ,a&m ,Nikitha Venugopal";
		System.out.println("Using Linked HashMap");
		System.out.println(findFirstUnique(input));
		System.out.println("Using Set & Array List");
		System.out.println(firstUniqueCharac2(input));
	}

}
