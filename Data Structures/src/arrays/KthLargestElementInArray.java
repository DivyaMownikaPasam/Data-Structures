package arrays;

import java.util.PriorityQueue;

/*
 * Given an array, find the kth largest element in the array:
 * Can be done in 3 ways:
 * 1. Sort the array in its natural order and get the num.length-k index's element
 * 2. Use Quick Select algo as discussed below --> Gives O(N) solution
 * 3. Use PriorityQueue to construct a Min Heap and get the kth value from it.Gives O(Nlog(k))solution
 * ==> log k because we need to construct a k element heap
 * */
public class KthLargestElementInArray {
	
	//Method2: Use Quick Select Algorithm:
	
	public static int findKthLargestElement(int[]arr, int start, int end, int k){
		
		if(k<1 || arr == null){
			return 0;
		}
		int pivot = arr[end];
		int left = start;
		int right = end;
		
		while(true){
			
			while(arr[left] < pivot && left < right){
				left++;
			}
			while(arr[right] >= pivot && right > left){
				right--;
			}
			if(left == right){
				break;
			}
			swap(arr, left, right);
		}
		
		swap(arr, left, end);
		
		if(k == left+1)
			return pivot;
		else if(k> left+1){
			return findKthLargestElement(arr, left+1, end, k);
		}
		else{
			return findKthLargestElement(arr, start, left-1, k);
		}
		
	}
	
	public static void swap(int []arr, int left, int right){
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	//Method 3 - Use Priority Queues
	public static int findKthLargest(int [] arr, int k){
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
		
		for(int i: arr){
			q.offer(i);
			
			if(q.size() > k){
				q.poll();
			}
		}
		return q.peek();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] num = {55,1,100,40,10,240,3};
		//int [] num = {3,2,1,5,6,4};

		int k = 6;
		
		System.out.println("*********************Method 2:*******************************");		
		int result = findKthLargestElement(num, 0, num.length-1, num.length-k+1);
		System.out.println("The kth largest element in the above array is: "+ result);
		System.out.println("");
		System.out.println("*********************Method 3:*******************************");
		result = findKthLargest(num,k);
		System.out.println("The kth largest element in the above array is: "+ result);

	}

}
