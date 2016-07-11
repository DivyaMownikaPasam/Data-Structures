package heaps;

public class PriorityQueue {

	//Define a class called Task which has a job name and its priority listed.
	class Task{
		String jobName;
		int priority;
		
		public Task(String jobName, int priority){
			this.jobName = jobName;
			this.priority = priority;
		}
		
		public String toString() 
	    {
	        return "Job Name : "+ jobName +"\nPriority : "+ priority;
	    }	
	}
	// Define the elements which a priority queue will consist of:
	
			private Task[]heap;
			private int maxSize;
			private int size;
			
			public PriorityQueue(int maxSize){
				this.maxSize = maxSize + 1;
				this.heap = new Task[this.maxSize];
				this.size = 0;				
			}
			
			//Check if queue is empty
			public boolean isEmpty(){
				if(this.size == 0) 
					return true;
				else 
					return false;
			}
			
			//Function to clear a queue
			public void clear(){
				heap = new Task[this.maxSize + 1];
				size = 0;
			}
			
			//Function to check if queue is full
			public boolean isFull(){
				return (this.size == this.maxSize -1);
			}
			
			//Return size of the queue
			public int getSize(){
				return this.size;
			}
			
			//Insert into the priority Queue
			public void insertIntoQueue(String jobName, int pValue){
				Task task = new Task(jobName, pValue);
				size++;
				heap[size] = task;
				
				int current = size;
				while(current != 1 && heap[parentPosition(current)].priority < heap[current].priority){
					swap(parentPosition(current) , current);
					current = parentPosition(current);
				}
				heap[current] = task;
			}
			public int parentPosition(int pos){
				return pos/2;
			}
			public void swap(int pos1, int pos2){
				Task temp = heap[pos1];
				heap[pos1] = heap[pos2];
				heap[pos2] = temp;
			}
			
			public void printQueue(){
				for(int i=1; i<=size; i++){
					System.out.println(heap[i]);
				}				
			}
			
			public Task remove(){
				Task removedJob = heap[1];
				heap[1] = heap[size];
				size--;				
				heapify(1);
				return removedJob;
			}
			
			public void heapify(int pos){
				int leftPos = 2*pos;
				int rightPos = 2*pos + 1;
				int grt = pos;
				if(leftPos <= size && heap[leftPos].priority > heap[grt].priority)
					grt = rightPos;
				if(rightPos <= size && heap[rightPos].priority > heap[grt].priority)
					grt = rightPos;
				if(grt != pos){
					swap(pos, grt);
					heapify(grt);
				}
			}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue queue = new PriorityQueue(3);
		queue.insertIntoQueue("A", 1);
		queue.insertIntoQueue("B", 10);
		queue.insertIntoQueue("C", 15);
		queue.printQueue();
		System.out.println("*****************************************");
		queue.remove();
		queue.printQueue();
	}

}
