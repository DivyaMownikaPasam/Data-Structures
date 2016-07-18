package arrays;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
/*
 * Write a function that gives the moving average of an array given a window size;
 * 
 */
	Queue<Integer> q;
	int windowSize;
	int sum;
	
	public MovingAverage(int size){
		this.windowSize = size;
		sum =0;
		q = new LinkedList<Integer>(); 
	}
	
	public double findNextaverage(int value){		
		q.offer(value);
		sum = sum+ value;
		if(q.size() > windowSize){
			sum = sum - q.poll();
		}
		return (double)sum/q.size();			
	}

	
	public static void main(String[] args){
		MovingAverage mv = new MovingAverage(2);
		
		int arr[] = {1,2,3,4,5};
		
		for(int i=0; i<arr.length; i++){
			
			System.out.println(mv.findNextaverage(arr[i]));
			
		}
	}
}
