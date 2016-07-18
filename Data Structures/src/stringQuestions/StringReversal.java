package stringQuestions;

public class StringReversal {

	public static char[] reversalOfString(char[] str){
		
		str = reverse(str, 0, str.length - 1);
		
		int start = 0;
		int end = 0;
		
		for(int i=0; i<str.length; i++){
			char c = str[i];
			if(c == ' '){
				str = reverse(str,start,end-1);
				end = i + 1;
				start = i + 1;				
			}else{
				end++;
				if(i == str.length -1){
					str = reverse(str,start,end-1);
				}
			}	
		}
		
		return str;
		
	}
	
	public static char[] reverse(char[] str, int start, int end){
	while(start < end){
		char temp = str[start];
		str[start++] = str[end];
		str[end--] = temp;
	}
		return str;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Pankaj ullu gadha";
		
		char[] result = reversalOfString(str.toCharArray());
		for(int i=0; i<result.length; i++){
			System.out.print(result[i]);
			
		}
	}

}
