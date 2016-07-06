package stringQuestions;

import java.util.HashMap;


/*Check if two strings are anagrams*/
public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(isAnagram("abc","bce"));

	}
	
	public static boolean isAnagram(String str1, String str2){
		
		if(str1.length() != str2.length())
			return false;
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();		
		
		for(int i=0 ; i< str1.length(); i++){
			char c = str1.charAt(i);
			
			if(map.containsKey(c)){
				int val = map.get(c);
				val++;
				map.put(c,val);
			}
			else{
				map.put(c,1);
			}
		}
		
		for(int i=0 ; i< str2.length(); i++){
			char c = str2.charAt(i);
			
			if(map.containsKey(c)){
				int val = map.get(c);
				val--;
				map.put(c,val);
			}
			else{
				map.put(c,1);
			}
		}
		
		for(Character c:map.keySet()){
			
			if(map.get(c) !=0 )
				return false;
		}
		return true;
	} 
}
