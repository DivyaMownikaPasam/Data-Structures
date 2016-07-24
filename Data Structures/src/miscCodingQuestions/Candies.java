package miscCodingQuestions;


import java.util.Arrays;
public class Candies {
	
	
	static boolean isNumber(String toTest){
		boolean hasNonZeroChar = false;
		
		if(toTest == null) return false;
		
		for (int i=0;i< toTest.length();i++)
		{
			char c = toTest.charAt(i);
			if(c == '.'){continue;}
			if(Character.isLetter(c)) return false;
			else if (c >= '1' && c<= '9') hasNonZeroChar = true;
			else if (c == '0'){
				
				if (!hasNonZeroChar) {
					
					 if(i < toTest.length() -1) {
						  if(toTest.charAt(i+1) == '.') continue;
						 // else if (toTest.charAt(i+1) >= '0' && toTest.charAt(i+1) <= '9' )  continue;
						  else if (toTest.charAt(i+1) == '0') return false;
						  else return false;
					 } else break;
				}
				else break;
			}
			else if (c == '-') {
				
				if (i != 0) return false;
			}
			
			
		}
		return true;
	
	}
	
    public static void main(String[] args) {
        //int []childrenRating = {9, 8, 7, 10, 11, 12, 14, 1, 5};
        int []childrenRating = {2,4,2,6,1,7,8,9,2,1};

        //int []expectedDistribution = {3, 2, 1,  2,  3,  4,  5, 1, 2};
        int []resultingDistribution = new int[childrenRating.length];
        int v = 1;
        int k, j = 0;
        while(j < childrenRating.length){
            k = j;
            if(k >0 && childrenRating[k] == childrenRating[k-1]) { v=1; } 
            resultingDistribution[k] = v;
            while(j+1 < childrenRating.length && childrenRating[j+1] < childrenRating[j]){
                j++;
            }
            v = 1;
            for(int i = j; i > k; i--){
                resultingDistribution[i] = v++; 
            }
            resultingDistribution[k] = Math.max(resultingDistribution[k], v);
            j++;
            v = resultingDistribution[j-1]+1;
        }
        int candiesTotal =0;
        for(int i=0; i<resultingDistribution.length; i++){
        	candiesTotal += resultingDistribution[i];
        }
        System.out.println(candiesTotal);

       /* if(Arrays.equals(expectedDistribution, resultingDistribution)) {
            System.out.println("Correct Distribution");
        }
        else {
            System.out.println("Wrong Distribution!");
        }*/
        
        System.out.println(isNumber("212000005"));
    }
}