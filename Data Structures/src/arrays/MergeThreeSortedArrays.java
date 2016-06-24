package arrays;

public class MergeThreeSortedArrays {

	public static int[] mergeThreeSortedArrays(int []a1,int[]a2,int[]a3){
		
		
		
	int []firstMergedArr = mergeTwoSortedArrays(a1,a2);
	int []secondMergedArr = mergeTwoSortedArrays(firstMergedArr,a3);
		
		
		return secondMergedArr;
	}
	
	public static int[]mergeTwoSortedArrays(int []arr1, int[]arr2){
		int j=0;
		int k=0;
		int[]resultArr = new int[arr1.length+ arr2.length];
		for(int i=0; i< resultArr.length; i++){
			if(j<arr1.length && k<arr2.length){
				if(arr1[j] < arr2[k]){
					resultArr[i] = arr1[j];	
					 j++;
				}
				else{
					resultArr[i] = arr2[k];
					k++;
				}		
			}
			else {
				if(j == arr1.length && k < arr2.length){
					resultArr[i] = arr2[k];
					k++;
				}
				else if(k == arr2.length && j < arr1.length){
					resultArr[i] = arr1[j];
					j++;
				}
			}
			
		}
		return resultArr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a1 = {1,4,7,10,13};
		int[] a2 = {2,5,8,11,14};
		int[] a3 = {3,6,9,12,15};
		
		int [] result = mergeThreeSortedArrays(a1,a2,a3); 
		for(int i=0; i< result.length; i++){
			System.out.print(result[i] + " ");
		}
	}

}
