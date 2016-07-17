package miscCodingQuestions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountOfWords {

	public static void countWordsInFile(){
		HashMap<String,Integer>map = new HashMap<String,Integer>();
		
		File file = new File("C://Nikitha Stuff/java_workspace/Data-Structures/Data Structures/src/miscCodingQuestions/countWords.txt");
		String longestWord=""; // This is the longest word with its first char and last char same;
		try {
			Scanner in = new Scanner(file);
			while(in.hasNextLine()){
				String line = in.nextLine();
				if(line.isEmpty()){
					;
				}
				else{
					String[]strArr = line.replaceAll("[^a-zA-Z ]","").split("\\s+");				
					for(String s:strArr){
						if(longestWord.length() < s.length() && s.charAt(0) == s.charAt(s.length()-1)){
							longestWord = s;							
						}
						if(map.containsKey(s)){
							int value = map.get(s);
							value++;
							map.put(s, value);
						}
						else{
							map.put(s, 1);
						}
					}
				}			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Map.Entry<String,Integer> m : map.entrySet()){
			System.out.println(m.getKey()+ " " + m.getValue());
		}
		
		System.out.println("The longest word with its first and last characters same is: " + longestWord);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countWordsInFile();
	}

}
