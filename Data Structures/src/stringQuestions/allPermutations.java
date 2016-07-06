package stringQuestions;

/*Print all permuations in a string.
 * Compexity is O(n * n!)
*/
public class allPermutations {

	
	public static void main(String[] args) {
		String str = "overlappingproblems";
		getAllPermutations(str);	
		
	}
	
	public static void getAllPermutations(String input){
		
		getPerMutations("", input);
		
	}
	
	public static void getPerMutations(String prefix, String input){
		if(input.isEmpty()){
			System.out.println(prefix);
		}
		else{
			for(int i=0; i<input.length();i++){
				getPerMutations(prefix+input.charAt(i), input.substring(0, i) + input.substring(i+1, input.length()));
			}
			
			
		}
	}
}
